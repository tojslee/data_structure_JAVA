public class calculate {
	
	public static int inStack(char ch) {
		if(ch =='+' || ch =='-') {return 0;}
		else if(ch == '(') {return -1;}
		else {return 1;}
	}
	
	public static int outStack(char ch) {
		if(ch =='+' || ch =='-') {return 0;}
		else if(ch == '*' || ch == '/') {return 1;}
		else {return 2;}
	}
	
	public static void main(String[] args) {
		stack checker = new stack();
		String infix = "1+2-(3-4)*5";
		int length = infix.length();
		for(int i=0;i<length;i++) {
			char ch = infix.charAt(i);
			if (ch == ')') {
				while(checker.top() != '(') {
					System.out.print(checker.pop());
				}
				checker.pop();
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				boolean flag = true;
				while(flag) {
					if(!checker.isEmpty()) {
						int x1 = inStack(checker.top());
						int x2 = outStack(ch);
						if(x1 < x2) {flag = false;}
						else {System.out.print(checker.pop());}
					}
					else {flag = false;}
				}
				checker.push(ch);
			}
			else if (ch == '(') {
				checker.push(ch);
			}
			else {
				System.out.print(Character.getNumericValue(ch));
			}
		}
		while(!checker.isEmpty()) {
			System.out.print(checker.pop());
		}
	}

}
