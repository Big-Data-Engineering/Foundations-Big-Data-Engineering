package module3;
import java.util.*;  
class Book {  
int id;  
String name,author;  
int issueDate, returnDate;  
}

class ListOfBooks{
    List<Book> list;
    
	//declare 'list' as a linked list in the constructor using Java's built in API's
    ListOfBooks(){
    	list = new LinkedList<Book>();
    }

public void add(int id, String name, String author, int issueDate, int returnDate) {
	//Wrap all the details into an object of class Book and add it to the linked list
	// Print: 'Successfully added: book_id', where book_id is the id of the book added
	Book book = new Book();
	book.id = id;
	book.name = name;
	book.author = author;
	book.issueDate = issueDate;
	book.returnDate = returnDate;
	list.add(book);
	System.out.println("Successfully added: "+book.id);
}
public void edit(int id, String name, String author, int issueDate, int returnDate) {
	//Check if the book ID exists
	// If it doesn't print: 'No such Book ID exists'      
	//else update the item in the linked list having the given Book ID
	// Print: 'Successfully edited: book_id', where book_id is the id of the book edited
	ListIterator<Book> listItr = list.listIterator();
	while(listItr.hasNext()) {
		Book book2 = listItr.next();
		if(book2.id == id) {
			book2.name = name;
			book2.author = author;
			book2.issueDate = issueDate;
			book2.returnDate = returnDate;
			System.out.println("Successfully edited: "+id);
			return;
		}
	}
	System.out.println("No such Book ID exists");
	
}
public void delete(int id) {
	//Check if the book ID exists
	// If it doesn't print: 'No such Book ID exists'      
	//else delete the item in the linked list having the given Book ID
	// Print: 'Successfully deleted: book_id', where book_id is the id of the book deleted
	ListIterator<Book> listItr = list.listIterator();
	while(listItr.hasNext()) {
		Book book2 = listItr.next();
		if(book2.id == id) {
			listItr.remove();
			System.out.println("Successfully deleted: "+id);
			return;
		}
	}
	System.out.println("No such Book ID exists");
}
public void printDatabase() {
	System.out.println("List of books:");
	// Print the details of all the books in the list in the following format:
	//ID: 2, Name: ABC, Author: DEF, Date of Issue: 2, Date of Return: 3
	//Note that the above is just an example
	ListIterator<Book> listItr = list.listIterator();
	while(listItr.hasNext()) {
		Book book2 = listItr.next();
		System.out.println("ID: "+book2.id+", Name: "+book2.name+", Author: "+book2.author+", Date of Issue: "+book2.issueDate+", Date of Return: "+book2.returnDate);
	}
}
}  
public class BaseCode {  
public static void main(String[] args) {  
	ListOfBooks database = new ListOfBooks();
    database.add(234,"Hamlet","W. Shakespeare",27,29); 
    database.add(35,"Relativity","Albert Einstein",15,30);
    database.add(2,"Data Sciences","Shan B",1,4); 
    database.edit(2,"Data Sciences","Shan B",1,8);
    database.delete(35);
    database.printDatabase();
    database.add(120,"Crooked House","Agatha Christie",15,28);
    database.edit(235,"Hamlet","W. Shakespeare",28,29);
    database.add(121,"The final problem","Arthur Doyle",13,20);
    database.delete(234);
    database.printDatabase();      
}  
}