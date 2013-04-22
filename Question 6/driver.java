import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class driver {

	public static void main(String[] args) {
		System.out.println("Please enter your lisp Math equation: ");
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		
		String[] arr = line.split(" ");
		//System.out.println(arr.length);
		ArrayStack<String> stack = new ArrayStack<String>(arr.length);
		
		for(String current : arr){
			//System.out.println("\"" + current + "\"");
			stack.push(current);
		}
		//System.out.println(stack.getIndex());
		int answer = process(stack);
		System.out.println("Your equation resolved to: " + answer);
		input.close();
	}
	
	public static int process(ArrayStack<String> stack){
		int matched = 0;
		int total = 0;
		String operator = "";
		ArrayStack<Integer> numbers = new ArrayStack<Integer>(stack.stackSize);
		while(stack.peek() != null){
			String current = (String) stack.pop();
			//System.out.println("Current: " + current);
			switch(current){
				case "(":
					matched++;
					total = finish(numbers, operator, total);
					break;
				case ")":
					matched--;
					break;
				case "+":
					operator = "+";
					break;
				case "-":
					operator = "-";
					break;
				case "/":
					operator = "/";
					break;
				case "*":
					operator = "*";
					break;
				default:
					numbers.push(Integer.parseInt(current));
					break;
			}
		}
		if(matched == 0){
		}
		return total;
	}
	public static boolean isOperator(String str){
		switch(str){
			case "+": case "-": case "*": case "/":
				return true;
		}
		return false;
	}
	
	public static int finish(ArrayStack<Integer> set, String operator, int total){
		//System.out.println(result);
		int result = 0;
		switch(operator){
			case "+":
				while(set.peek() != null){
					result += set.pop();
				}
				return result;
			case "-":
				result = set.pop();
				while(set.peek() != null){
					int cur = set.pop();
					result -= cur;
				}
				return result;
			case "*":
				result = 1;
				while(set.peek() != null){
					result *= set.pop();
				}
				return result;
			case "/":
				result = set.pop();
				while(set.peek() != null){
					int cur = set.pop();
					result /= cur;
				}
				return result;
		}
		return -1;
	}

}
