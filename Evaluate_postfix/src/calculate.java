public class calculate {

	public static void main(String[] args) {
		stack checker = new stack();
		String postfix = "123*+4+93/-";
		for(int i=0;i<postfix.length();i++){
			char th = postfix.charAt(i);
			if(th =='+' || th =='-' || th =='*' || th == '/') {
				int x1 = checker.pop();
				int x2 = checker.pop();
				switch(th) {
				case '+':
					checker.push(x1+x2);
					break;
				case '-':
					checker.push(x2-x1);
					break;
				case '*':
					checker.push(x2*x1);
					break;
				case '/':
					checker.push(x2/x1);
					break;
				}
			}
			else {
				checker.push(Character.getNumericValue(th));
			}
		}
		System.out.println(checker.pop());
	}

}
