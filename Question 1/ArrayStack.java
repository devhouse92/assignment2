
public class ArrayStack<R> {

	private R[] stack;
	private int index;
	private int stackSize;
	
	public ArrayStack(int initialCapacity) {
	
		stack = (R[]) new Object[initialCapacity];
		index = initialCapacity - 1;
		stackSize = initialCapacity;
	}
	
	public void push(R newEntry){
		
		if((index >= 0) && (index < stackSize)){
		 	stack[index] = newEntry;
			//System.out.println(index);
		}else{
			doubleArray();
			stack[index] = newEntry;
			//System.out.println(index + ": " + stack[index]);
		}
		index--;
	}

	private void doubleArray() {
		
		R[] temp = (R[]) new Object[stackSize*2];
		int tindex = (stackSize*2) - 1;
		for(int i = stackSize - 1; i >= 0; i--){
			temp[tindex] = stack[i]; 
			tindex--;
		}
		stackSize *= 2;
		stack = (R[]) new Object[stackSize];
		
		for(int i = stackSize -1; i >= 0; i--){
			
			stack[i] = temp[i];
			//System.out.println(i + ": " + stack[i]);
			if(temp[i] != null){
				index = i;
			}
		}
		index--;
		return;
	}
	
	public R pop(){
		R top = null; 
		//System.out.println("Index: " + index);
	     if (!(stack[index] == null)) { 
	    	top = stack[index]; 
	       	stack[index] = null; 
	     }
	    index++; 	
	     
	     return top;
		
		
	}
	
	public R peek(){
		
		R top = null;
		//System.out.println("Index: " + index);
		if(!(stack[index] == null)){
			top = stack[index];
		}
		
		return top;
		
	}

	private boolean isEmpty(int index) {
		if(stack[index] == null){
			return true;
		}else{
			//System.out.println("Empty.");
			return false;
		
		}
	}

}
