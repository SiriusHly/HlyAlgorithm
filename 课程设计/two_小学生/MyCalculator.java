package two_小学生;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 作者：黄良运
 * time：12.14
 * 加减乘除运算
 */

public class MyCalculator {

	private int priority(char c) throws Exception {
		switch (c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case '#':
			return 0;

		}
		throw new Exception("错误的运算符");
	}

	private double doOperate(double n, double m, String c) throws Exception {
		switch (c) {
		case "+":
			return n + m;
		case "-":
			return n - m;
		case "*":
			return n * m;
		case "/":
			return n / m;
		}
		throw new Exception("错误的运算符");
	}

	private boolean isOperator(String c) {
		if ("+".equals(c) || "-".equals(c) || "*".equals(c) || "/".equals(c))
			return true;
		return false;
	}

	/*
	 * 中缀表达式转化为后缀表达式 1.操作数，送往后缀表达式 2.op>栈顶op，压栈 3.op=栈顶op,弹出栈顶op送往后缀,把当前op压栈
	 * 4.op<栈顶op,重复弹出优先级更高的栈顶运算符送往后缀表达式
	 */
	private List convertToPostfix(String exp) throws Exception {
		exp += "#";
		List<String> postfix = new ArrayList<String>();
		// String postfix = new String();//存放转化后的后缀表达式
		StringBuffer numBuffer = new StringBuffer();// 保存一个数
		Stack opstack = new Stack();// 操作符栈
		char ch;
		String preChar;
		opstack.push("#");
		for (int i = 0; i < exp.length();) {
			ch = exp.charAt(i);
			switch (ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				preChar = opstack.peek().toString();
				// 如果栈里面的操作符优先级比当前大，把栈中优先级大的都添加到后缀表达式中
				while (priority(preChar.charAt(0)) >= priority(ch)) {
					postfix.add(preChar);
					opstack.pop();
					preChar = opstack.peek().toString();
				}
				opstack.push(ch);
				i++;
				break;
			case '(':
				// 左括号直接压栈
				opstack.push(ch);
				i++;
				break;
			// 右括号直接把左括号前面的弹出，加入后缀表达式中
			case ')':
				String c = opstack.pop().toString();
				while (c.charAt(0) != '(') {
					postfix.add(c);
					c = opstack.pop().toString();
				}
				i++;
				break;
			// #号结束，操作符栈全部弹出，加入后缀表达式
			case '#':
				String x;
				while (!opstack.isEmpty()) {
					x = opstack.pop().toString();
					if (x.charAt(0) != '#')
						postfix.add(x);
				}
				i++;
				break;
			case ' ':
			case '\t':
				i++;
				break;
			default:
				if (Character.isDigit(ch) || ch == '.') {
					while (Character.isDigit(ch) || ch == '.') {
						numBuffer.append(ch);
						ch = exp.charAt(++i);
					}
					postfix.add(numBuffer.toString());
					numBuffer = new StringBuffer();
				} else {
					throw new Exception("错误的表达式");
				}
			}
		}
		return postfix;
	}

	// 对后缀表达式进行计算
	private String Calculate(List<String> postfix) throws Exception {
		Stack<String> st = new Stack<String>();
		String element;
		double n, m, result;
		for (String i :postfix) {
			if (isOperator(i)) {
				n = Double.parseDouble(st.pop());
				m = Double.parseDouble(st.pop());
				result = doOperate(m, n, i);
				st.push(String.valueOf(result));
			} else {
				st.push(i);
			}
		}
		return st.pop();
	}

	
	public static void main(String[]hly) throws Exception{
		
		
		System.out.println(new MyCalculator().convertToPostfix("5*3/4+1"));
		System.out.println(new MyCalculator().Calculate(new MyCalculator().convertToPostfix("5*3/4+1")));
		
		
	}
	
	
	
}
