package two_Сѧ��;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * ���ߣ�������
 * time��12.14
 * �Ӽ��˳�����
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
		throw new Exception("����������");
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
		throw new Exception("����������");
	}

	private boolean isOperator(String c) {
		if ("+".equals(c) || "-".equals(c) || "*".equals(c) || "/".equals(c))
			return true;
		return false;
	}

	/*
	 * ��׺���ʽת��Ϊ��׺���ʽ 1.��������������׺���ʽ 2.op>ջ��op��ѹջ 3.op=ջ��op,����ջ��op������׺,�ѵ�ǰopѹջ
	 * 4.op<ջ��op,�ظ��������ȼ����ߵ�ջ�������������׺���ʽ
	 */
	private List convertToPostfix(String exp) throws Exception {
		exp += "#";
		List<String> postfix = new ArrayList<String>();
		// String postfix = new String();//���ת����ĺ�׺���ʽ
		StringBuffer numBuffer = new StringBuffer();// ����һ����
		Stack opstack = new Stack();// ������ջ
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
				// ���ջ����Ĳ��������ȼ��ȵ�ǰ�󣬰�ջ�����ȼ���Ķ���ӵ���׺���ʽ��
				while (priority(preChar.charAt(0)) >= priority(ch)) {
					postfix.add(preChar);
					opstack.pop();
					preChar = opstack.peek().toString();
				}
				opstack.push(ch);
				i++;
				break;
			case '(':
				// ������ֱ��ѹջ
				opstack.push(ch);
				i++;
				break;
			// ������ֱ�Ӱ�������ǰ��ĵ����������׺���ʽ��
			case ')':
				String c = opstack.pop().toString();
				while (c.charAt(0) != '(') {
					postfix.add(c);
					c = opstack.pop().toString();
				}
				i++;
				break;
			// #�Ž�����������ջȫ�������������׺���ʽ
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
					throw new Exception("����ı��ʽ");
				}
			}
		}
		return postfix;
	}

	// �Ժ�׺���ʽ���м���
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
