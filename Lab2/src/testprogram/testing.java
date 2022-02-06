package testprogram;
import myutil.*;
import java.util.LinkedList;
public class testing {
	
	
	
	public static Node<Integer> node = new Node<>();
	public static Mystack<Integer> stack = new Mystack<>();
	

public static void testNode(Node <Integer> node) {
	
	System.out.println("Matar in data (5) ");
	node.setData(5);
	System.out.println("Printar ut insatt data:  "+ node.getData());

	//lägger till pekar och dta
	System.out.println("lägger till en node");
	node.setNext(new Node <Integer>(7));
	System.out.println("Printar ut de samtliga noder som har värden (5) och (7)   = " + node.getData() + " .. " + node.getNext().getData());
	
	System.out.println("kollar om vi kan komma åt bara den andra noden");
	System.out.println( node.getNext().getData());
	System.out.println("långsamt att komma åt..... men funkar");
	System.out.println("dags att loopa");
	
	//lägger till mer data
	node.setNext(new Node <Integer>(8));
	node.setNext(new Node <Integer>(9));
	node.setNext(new Node <Integer>(10));
	node.setNext(new Node <Integer>(11));
	
	
	
//	Node<Integer> p1 = new Node <Integer>(5);
//	   Node<Integer> head = p1;
//	   
	
		
	//hur kommer man åt första index i singellänkadlista?
    
	//while(node.getNext()!=null) {
		System.out.println(node.getData() +""  +  node.getNext().getData());
	//	node = node.getNext();
		

	
}

public static void testStack(Mystack<Integer> stack) {
	
	System.out.println("lägger till i stacken    2 , 3");
	stack.push(2);
	stack.push(3);
    System.out.println(stack.size());	
	
	

	
	System.out.println(stack.getNode().getData());
	


  
	System.out.println("hur stor då  " + stack.size());
    System.out.println("Tar en titt  " + stack.peek());
    System.out.println("poppa 3 va?  " + stack.pop());
    System.out.println("Tar en titt  " + stack.peek());
    stack.pop();
    // testar exception
  
    try {
   
          System.out.println("Tar en titt  " + stack.peek());
          
    } catch (RuntimeException EmptyStackException) {
    	
    	System.out.println("fångade emptystackexception");
    }
	
   System.out.println(stack.size()); 
   
   
}

	
	
	
	
	
	
	
	
	


      public static void main(String[] args) {
    	  
    	 // testNode(node);
    	  testStack(stack);
    	  
	





      }


}

