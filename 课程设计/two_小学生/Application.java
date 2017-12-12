package two_Сѧ��;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
 
public class Application {
 
    public static void main(String[] args) throws Exception {
//        Object rval = Eval.eval("System.out.println(\"555\");return 5;");
//        System.out.println(rval);
        Application app = new Application();
        System.out.println(app.eval("1+(3-1)*2+(6/5)"));
    }
    public String eval(String exp) throws Exception {
        List list = infixExpToPostExp(exp);// ת���ɺ�׺���ʽ
        return doEval(list);// ������ֵ
    }
 
    // ����������ѹջ���������ʽ�Ӻ�׺���ʽ�е���������������������ѹ���ջ
    private String doEval(List list) throws Exception {
        Stack stack = new Stack();
        String element;
        double n1, n2, result;
        try {
            for (int i = 0; i < list.size(); i++) {
                element = list.get(i).toString();
                if (isOperator(element)) {
                    n1 = Double.parseDouble(stack.pop() + "");
                    n2 = Double.parseDouble(stack.pop() + "");
                    result = doOperate(n2, n1, element);
                    stack.push(result + "");
                } else {
                    stack.push(element);
                }
            }
            return "" + stack.pop();
        } catch (RuntimeException e) {
            throw new Exception("���ʽ���Ϸ�");
        	
        }
    }
 
    private double doOperate(double n1, double n2, String operator) {
        if (operator.equals("+"))
            return n1 + n2;
        else if (operator.equals("-"))
            return n1 - n2;
        else if (operator.equals("*"))
            return n1 * n2;
        else
            return n1 / n2;
    }
 
    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/");
    }
 
    private List infixExpToPostExp(String exp) throws Exception {// ����׺���ʽת����Ϊ��׺���ʽ
        exp = exp + "#";
        List postExp = new ArrayList();// ���ת���ĺ�׺���ʽ������
        StringBuffer numBuffer = new StringBuffer();// ��������һ������
        Stack opStack = new Stack();// ������ջ
        char ch;
        String preChar;
        opStack.push("#");
        try {
            for (int i = 0; i < exp.length();) {
                ch = exp.charAt(i);
                switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    preChar = opStack.peek().toString();
                    // ���ջ����Ĳ��������ȼ��ȵ�ǰ�Ĵ����ջ�����ȼ���Ķ���ӵ���׺���ʽ�б���
                    while (priority(preChar.charAt(0)) >= priority(ch)) {
                        postExp.add("" + preChar);
                        opStack.pop();
                        preChar = opStack.peek().toString();
                    }
                    opStack.push("" + ch);
                    i++;
                    break;
                case '(':
                    // ������ֱ��ѹջ
                    opStack.push("" + ch);
                    i++;
                    break;
                case ')':
                    // ��������ֱ�Ӱ�ջ��������ǰ��ĵ������������׺���ʽ������
                    String c = opStack.pop().toString();
                    while (c.charAt(0) != '(') {
                        postExp.add("" + c);
                        c = opStack.pop().toString();
                    }
                    i++;
                    break;
                // #�ţ�������ʽ����������ֱ�ӰѲ�����ջ��ʣ��Ĳ�����ȫ���������������׺���ʽ������
                case '#':
                    String c1;
                    while (!opStack.isEmpty()) {
                        c1 = opStack.pop().toString();
                        if (c1.charAt(0) != '#')
                            postExp.add("" + c1);
                    }
                    i++;
                    break;
                // ���˿հ׷�
                case ' ':
                case '\t':
                    i++;
                    break;
                // ������ճ�һ�������������׺���ʽ������
                default:
                    if (Character.isDigit(ch) || ch == '.') {
                        while (Character.isDigit(ch) || ch == '.') {
                            numBuffer.append(ch);
                            ch = exp.charAt(++i);
                        }
                        postExp.add(numBuffer.toString());
                        numBuffer = new StringBuffer();
                    } else {
                        throw new Exception("illegal operator");
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new Exception(e.getMessage());
        }
        return postExp;
    }
 
    private int priority(char op) throws Exception {// �������ȼ�
        switch (op) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '(':
        case '#':
            return 0;
        }
        throw new Exception("Illegal operator");
    }
}
