package MYFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SanZiQi extends JFrame {
private String whoseTurn  = "red";
private Cell[][] cells = new Cell[3][3];
private JLabel lblStatus=new JLabel("please red");

private JPanel qiPan = new JPanel();
public SanZiQi(){
	JPanel p = new JPanel();
	p.setLayout(new FlowLayout());//?
	qiPan.setLayout(new GridLayout(3,3,2,2));
	qiPan.setPreferredSize(new Dimension(300,280));
	qiPan.setBorder(new LineBorder(Color.blue,3));
	for(int i=0;i<3;i++)
		for(int j = 0;j<3;j++){
			cells[i][j] = new Cell();
			qiPan.add(cells[i][j]);
		}
	
	Font font  = new Font ("black",Font.BOLD,40);
	lblStatus.setFont(font);
	this.add(lblStatus,BorderLayout.NORTH);
	this.add(p,BorderLayout.CENTER);
	p.add(qiPan);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public boolean isFull(){
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++){
			if(cells[i][j].getQiZiColor().equals("empty"))
				return false;
		}

		return true;
	
}
public boolean isWon(String qiZi){
	for(int i=0;i<3;i++){
		if(cells[i][0].getQiZiColor().equals(qiZi)&&cells[i][1].getQiZiColor().equals(qiZi)&&cells[i][2].
				getQiZiColor().equals(qiZi));
		return true;
}
for(int j=0;j<3;j++){
	if(cells[0][j].getQiZiColor().equals(qiZi)&&cells[1][j].getQiZiColor().equals(qiZi)&&cells[2][j].getQiZiColor().equals(qiZi))
return true;
}
if(cells[0][0].getQiZiColor().equals(qiZi)&&cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][2].getQiZiColor().equals(qiZi))
	return true;

if(cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][0].getQiZiColor().equals(qiZi))
	return true;
return false;
}
public static void main(String []yun)
{
	SanZiQi game = new SanZiQi();
	game.setSize(500,400);
	game.setVisible(true);
	game.setResizable(false);
	game.setLocationRelativeTo(null);
}
public class Cell extends JPanel{
	String qiZiColor = "empty";
	public String getQiZiColor(){
		return qiZiColor;
	}
	public void setQiZiColor(String whoseTurn){
		this.qiZiColor = qiZiColor;
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(qiZiColor.equals("red")){
			g.setColor(Color.RED);
			g.drawOval(10, 10, getWidth()-20, getHeight()-20);
		}
		else if(qiZiColor.equals("black")){
			g.setColor(Color.BLACK);
			g.fillOval(10, 10, getWidth()-20, getHeight()-20);
			
		}
	}
	public Cell (){
		setBorder(new LineBorder(Color.BLACK,3));
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				if(!Cell.this.getQiZiColor().equals("empty")){
					return;
				}
				if(whoseTurn.equals("")){
					lblStatus.setText("game over ");
					return ;
				}
				if(!whoseTurn.equals("")){
					setQiZiColor(whoseTurn);
				}
				if(isWon(whoseTurn)){
					lblStatus.setText("you are winner");
					whoseTurn= "";
				}
				else if(isFull()){
					lblStatus.setText("game over draw");
					whoseTurn="";}
					else{
						whoseTurn= (whoseTurn.equals("red"))?"black":"red";
						lblStatus.setText("should"+whoseTurn+"go...");
							
					}
				}
								
			});
		}
	}
	
}


