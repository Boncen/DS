package StackTest;

import java.util.Stack;

/*
 * 利用stack解决balanced括号问题
 * '[','(',')','[',']','(','{','(',')','}',']'  
 *  分别压入栈,将其中成对的括号及时弹出.
 */
public class stack_test {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		int size = 0;
		char[] arr =new char[] {'[','(',')','[',']','(','{','(',')','}',']'};
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
			size = stack.size();
			if (size>1) {
				if (stack.get(size-1)==')'&&stack.get(size-2)=='(') {
					stack.pop();
					stack.pop();
					continue;
				}
				if (stack.get(size-1)=='}'&&stack.get(size-2)=='{') {
					stack.pop();
					stack.pop();
					continue;
				}
				if (stack.get(size-1)==']'&&stack.get(size-2)=='[') {
					stack.pop();
					stack.pop();
					continue;
				}
			}
		}
		if (stack.size()!=0) {
			System.out.println("it is no balanced!");
		}else {
			System.out.println("it is  balanced!");
		}
	}

}
