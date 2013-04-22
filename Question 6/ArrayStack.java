
public class ArrayStack<R> {

	private R[] stack;
	private int index;
	public int stackSize;
	
	public ArrayStack(int initialCapacity) {
	
		stack = (R[]) new Object[initialCapacity];
		index = 0;
		stackSize = initialCapacity;
	}
	public int getIndex(){
		return index;
	}
	public void push(R newEntry){
		if(index < stackSize){
		 	stack[index] = newEntry;
			//System.out.println("Index: " + index);
		}else{
			doubleArray();
			stack[index] = newEntry;
			//System.out.println(index);
		}
		index++;
	}

	private void doubleArray() {
		
		R[] temp = (R[]) new Object[stackSize*2];
		int tindex = (stackSize*2) - 1;
		for(int i = 0; i < stackSize; i++){
			temp[tindex] = stack[i]; 
			tindex++;
		}
		stackSize *= 2;
		stack = (R[]) new Object[stackSize];
		
		for(int i = 0; i <stackSize; i++){
			
			stack[i] = temp[i];
			if(stack[i] != null){
				index = i;
			}
			//System.out.println(i + ": " + stack[i]);
			
		}
		index++;
		return;
	}
	
	public R pop(){
		if((index >= 0) && (index <= stackSize)){
			R top = null;
			try{
				if(stack[index - 1] != null){
					top = stack[index - 1];
					stack[index - 1] = null;
					index--;
					return top;
				}
			}catch(Exception e){
				//System.out.println("Index Out Of Bounds: " + index);
				return null;
			}
		}
		return null;
	}
	
	public R peek(){
		if((index >= 0) && (index <= stackSize)){
			R top = null;
			try{
				if(stack[index - 1] != null){
					top = stack[index - 1];
					return top;
				}
			}catch(Exception e){
				//System.out.println("Index Out Of Bounds: " + index);
				return null;
			}
		}else{
			System.out.println("Index: " + index);
		}
		return null;
	}

}
