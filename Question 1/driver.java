
public class driver {

	public static void main(String[] args) {
		
		ArrayStack<String> jerry = new ArrayStack<String>(3);
		jerry.push("s");
		jerry.push("h");
		jerry.push("i");
		jerry.push("t");
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		
		jerry.push("J");
		jerry.push("a");
		jerry.push("v");
		jerry.push("a");
		
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		System.out.println(jerry.peek());
		jerry.pop();
		

	}

}
