package ÊµÑé°Ë;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Addtest extends JFrame{
	private JButton btn=new JButton("=");
	private JLabel ad=new JLabel("+");
	private TextField tf1=new TextField(30);
	private TextField tf2=new TextField(30);
	private TextField tf3=new TextField(30);
	public void add(){
		setSize(1000, 200); setLayout(new FlowLayout(FlowLayout.LEFT));
	setLocationRelativeTo(null);
	setVisible(true);
	add(tf1);
	add(ad);
	add(tf2);
	add(btn);
	add(tf3);
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			double a= Double.valueOf(tf1.getText());
			double b= Double.valueOf(tf1.getText());
			double c=a+b;
			tf3.setText(String.valueOf(c));
		}
	});	
	tf1.addFocusListener(new FocusListener(){
		public void focusLost(FocusEvent e){
			if(!isNumber(tf1.getText()))
				{tf1.setText("");
			tf1.requestFocus();}
			
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	});



tf2.addFocusListener(new FocusListener(){
	public void focusLost(FocusEvent e){
		if(!isNumber(tf2.getText()))
			{tf2.setText("");
		tf2.requestFocus();}
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
});
	}
	


public boolean isNumber(String s){
	int count=0,i,a=s.length();
	char []str=s.toCharArray();
	if (str[0]=='.'||str[0]==' '){
		return false;}
	else {for(i=0;i<a;i++){
	   if(str[i]=='.')
		   count++;	
	if(count>1){
		return false;}
	else{
		for(i=0;i<a;i++){
			   if((int)str[i]>57||(int)str[i]<48)
				   return false;
				   
			}
	}
	}
	return true;
}
}
/*public boolean isNumber(String s){
	if(s.length()==0)
		return false;
	char c = s.charAt(0);
	if(c=='.')
		return false;
	int dot=0;
	for(int i=0;i<s.length();i++){
		c=s.charAt(i);
		if(c=='.')
			dot++;
		if(dot>1){
			return false;
		}
		else if(c>57||c<48){
			return false;
		}
	}
	return true;
}*/





		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addtest a=new Addtest();
		a.add();

	}



}
		
