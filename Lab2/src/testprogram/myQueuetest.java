package testprogram;
import myutil.*;


public class myQueuetest {
	
	
	
	public static MyQueue<Integer> queue= new MyQueue<>();
	
	
	


    public static void main(String[] args) {
    	
    	
    	System.out.println("lägger till (1) (3) (4) dvs 3 element ");
    	queue.enqueue(1);
    	queue.enqueue(3);
    	queue.enqueue(4);
  	    System.out.println(queue.size());
  	    System.out.println(queue.getNode().getData() +"  " + queue.getNode().getNext().getData());
  	    
  	    queue.dequeue();
  	    queue.dequeue();
  	    queue.dequeue();
  	    System.out.println(queue.isEmpty());
  	    //true
  	    
  	    
  	    
  	    System.out.println( queue.size());
  	    
  	     queue.enqueue(3);
  	     queue.enqueue(4);
  	     queue.enqueue(4);
  	     System.out.println(queue.peek());   //varför peakar man alltid 3???
  	     
  	  
  	    queue.dequeue();
 	    queue.dequeue();
 	    queue.dequeue();
 	    
 	    
 	    try {
 	    queue.dequeue();
 	    
 	    
 	    }
       catch (RuntimeException EmptyQueueException) {
    	   
    	   System.out.println("fick dig din jävel");
    	   
    	   
       }
       
 	   System.out.println(queue.size()); 


    }


	
	

}
