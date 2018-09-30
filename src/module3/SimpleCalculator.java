package module3;
class Item{
	public int number1;
	public int number2;
	public int result;
	public char operation;
}

class Stack {
   private int maxSize;
   private Item[] stackArray;
   private int top;
 
   public Stack(int s) {
       //Assign s to the maxSize, declare the stack of array elements, initialize top
	   maxSize = s;
	   stackArray = new Item[maxSize];
	   top = -1;
   }
   public void push(Item j) {
      //Push the whole operation item at the top of the stack
	   if(top>maxSize-1) {
		   System.out.println("Cannot push more!!");
		   return;
	   }
	   else {
		   stackArray[++top] = j;
	   }
   }
   public void displayOperationTop5() {
	  //Print the last 5 (or  all elements if the size of stack is less than or equal to 5) operations in the following format:
	  //'number1' 'operation' 'number2' = 'result'
	  int tempTop = top, tempCounter=0;
	  while(tempCounter<5 && tempTop>-1) {
		  System.out.println(stackArray[tempTop].number1+" "+stackArray[tempTop].operation+" "+stackArray[tempTop].number2+" = "+stackArray[tempTop].result);
		  tempCounter++;
		  tempTop--;
	  }
	  
	  
   }
   public int peek() {
	   //return the result of last operation. 
	   //Hint: Top of the stack holds information for the last operation
	   return stackArray[top].result;
   }
   public void add(int number1, int number2) {
	   //Print the result (e.g. If number1 is 2 and number2 is 3 then print 'Result: 5') and push the item into the stack
	   int result = number1 + number2;
	   System.out.println("Result: "+result);
	   pushItem(number1, number2, result, '+');
   }
   public void subtract(int number1, int number2) {
	   //Print the result (e.g. If number1 is 3 and number2 is 2 then print 'Result: 1') and push the item into the stack
	   int result = number1 - number2;
	   System.out.println("Result: "+result);
	   pushItem(number1, number2, result, '-');
   }
   public void multiply(int number1, int number2) {
	   //Print the result (e.g.  If number1 is 3 and number2 is 2 then print 'Result: 6') and push the item into the stack
	   int result = number1 * number2;
	   System.out.println("Result: "+result);
	   pushItem(number1, number2, result, '*');
	   
   }
   public void divide(int number1, int number2) {
	   //Print the result (e.g. If number1 is 6 and number2 is 3 then print 'Result: 2') and push the item into the stack
	   int result = number1 / number2;
	   System.out.println("Result: "+result);
	   pushItem(number1, number2, result, '/');
   }
   
   public void pushItem(int number1, int number2, int result, char operation) {
	   Item it = new Item();
	   it.number1 = number1;
	   it.number2 = number2;
	   it.result = result;
	   it.operation = operation;
	   push(it);
   }
}

public class SimpleCalculator{
	public static void main(String[] args) {
	      Stack newStack = new Stack(10); 
	      newStack.add(2,3);
	      newStack.multiply(8,9);
	      newStack.displayOperationTop5();
	      newStack.divide(6,3);
	      newStack.subtract(45,44);
	      newStack.add(18,0);
	      newStack.multiply(6,newStack.peek());
	      newStack.displayOperationTop5();
	      newStack.divide(2,3);
	      newStack.subtract(3,newStack.peek());
	   }
}
