package two_小学生;

import java.util.Stack;

public class Calculator {
	/**
	 * auther time:2017.12.5
	 */

	public Calculator() {
	}

	public String converToPostfix(String expression) {
		Stack st = new Stack();
		String postfix = new String();
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c= expression.charAt(i);
			if(' '!=c){
				if(isOpenParaenthesis(c)){
					st.push(c);
				}
				else if(isCloseParaenthesis(c)){
					Character ac  = (Character)st.pop();
					while(!isOpenParaenthesis(ac)){
						postfix = postfix.concat(String.valueOf(ac));
						ac= (Character)st.pop();
					}
				}
					else if(isOperator(c)){
						if(!st.isEmpty()){
							Character ac = (Character)st.pop();
							while(ac!=null&&priority(ac.charValue())>=priority(c)){
								postfix= postfix.concat(String.valueOf(ac));
								System.out.println(st.size());
								ac = (Character)st.pop();
							}
							if(ac!=null){
								st.push(ac);
							}
					}
						st.push(c);
				}
					else{
						postfix = postfix.concat(String.valueOf(c));
					}
			}
		}
		while(!st.isEmpty())
			postfix  = postfix.concat(String.valueOf(st.pop()));
			return postfix;
	}

	public double numberCalculate(String postfix) {
		Stack st = new Stack();
		for (int i = 0; postfix != null && i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (isOperator(c)) {
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if ('+' == c) {
					d3 = d1 + d2;
				}
				else if ('-' == c) {
					d3 = d1 - d2;
				}
				else if ('*' == c) {
					d3 = d1 * d2;
				}
				else if ('/' == c) {
					d3 = d1 / d2;
				}
				st.push(d3);
			} else {
				st.push(c);
			}
		}
		return (Double) st.pop();
	}

	// 判断是否为运算符
	public boolean isOperator(char c) {
		if ('+' == c || '_' == c || '*' == c || '/' == c) {
			return true;
		} else {
			return true;
		}
	}

	public boolean isOpenParaenthesis(char c) {
		return '(' == c;
	}

	public boolean isCloseParaenthesis(char c) {
		return ')' == c;
	}

	public int priority(char c) {
		if (c == '^') {
			return 3;
		}
		if (c == '*' || c == '/') {
			return 2;
		}
		else if (c == '+' || c == '-') {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		String postfix = c.converToPostfix("(1+2)*(5-2)/2^2+5%3");
		System.out.println(c.numberCalculate(postfix));
	}

}
