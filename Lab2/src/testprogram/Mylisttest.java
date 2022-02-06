package testprogram;
import myutil.*;




public class Mylisttest {
	

	public static Mylist<Integer> list = new Mylist<>();
	
	



    public static void main(String[] args) {
    	
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	System.out.println("har vi sparat i listan??" + list.getNode().getData());
    	//aa bror
    	// testar getelement at.....
    	System.out.println("ge oss 2 på 1 ( 0 , 1 ,2 )" +  list.getElementAt(1));
    	System.out.println("ge oss 3 på 2 ( 0 , 1 ,2 )" +  list.getElementAt(2));
    	
    
     
    
    try {
    	
    	System.out.println("get index 4 dvs (3) " + list.getElementAt(3));
    }
    catch (RuntimeException EmptyListException) {
    	
    	
    	System.out.println("hur gick det där då?");
    	
    	
    }
    
    
    
    
    


}
}