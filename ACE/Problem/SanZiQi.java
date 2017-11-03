package Problem;
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
	/**
	 * 三子棋游戏，用一个个的JPanel作为棋子显示在棋盘上
	 * Cell类继承自JPanel，他的对象代表棋盘上一个棋子位置，单击时，根据是红、黑方来画出棋子形状
	 * 同时调用主程序的判断输赢和是否下满棋盘的方法来做判断，所以要添加单击事件
	 * 主类SanZiQi负责添加9个Cell类对象画出一个棋盘，负责扫描棋盘的各个棋子位置的状态，
	 * 具有判断判断是否下满或是否有输赢的方法
	 * @param args
	 */
	private String whoseTurn="red";//记录该谁下了，取值为：red，该红方下；black，该黑方下
	private Cell[][] cells=new Cell[3][3];//9个棋子位置，即9个单元格，每个单元格是一个JPanel
	private JLabel lblStatus=new JLabel("请red下...");//显示当前的状态：该red下，该black下，red|black赢，平局
	private JPanel qiPan=new JPanel();//棋盘，是个JPanel
	public SanZiQi(){
		JPanel p=new JPanel();//用于放置棋盘qiPan
		p.setLayout(new FlowLayout());
		qiPan.setLayout(new GridLayout(3,3,2,2));
		qiPan.setPreferredSize(new Dimension(300,280));
		qiPan.setBorder(new LineBorder(Color.BLUE,3));
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				cells[i][j]=new Cell();
				qiPan.add(cells[i][j]);
			}
		Font font=new Font("黑体",Font.BOLD,40);
		lblStatus.setFont(font);
		this.add(lblStatus,BorderLayout.NORTH);
		this.add(p,BorderLayout.CENTER);
		p.add(qiPan);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//判断是否下满了
	public boolean isFull(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if(cells[i][j].getQiZiColor().equals("empty"))
					return false;
			}
		return true;
	}
	//判断是否赢了
	public boolean isWon(String qiZi){
		//三个同样颜色的一排
		for(int i=0;i<3;i++){
			if(cells[i][0].getQiZiColor().equals(qiZi)&&cells[i][1].getQiZiColor().equals(qiZi)&&cells[i][2].getQiZiColor().equals(qiZi))
				return true;
		}
		//三个同样颜色的一列
		for(int j=0;j<3;j++){
			if(cells[0][j].getQiZiColor().equals(qiZi)&&cells[1][j].getQiZiColor().equals(qiZi)&&cells[2][j].getQiZiColor().equals(qiZi))
				return true;
		}
		//三个同样颜色的主对角
		if(cells[0][0].getQiZiColor().equals(qiZi)&&cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][2].getQiZiColor().equals(qiZi))
			return true;
		//三个同样颜色的次对角
		if(cells[0][2].getQiZiColor().equals(qiZi)&&cells[1][1].getQiZiColor().equals(qiZi)&&cells[2][0].getQiZiColor().equals(qiZi))
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SanZiQi game=new SanZiQi();
		game.setSize(500,400);
		game.setVisible(true);
		game.setResizable(false);
		game.setLocationRelativeTo(null);
	}
	public class Cell extends JPanel{
		String qiZiColor="empty";//初始为empty,如果红方下了，则为red，黑方下了为black
		public String getQiZiColor(){return qiZiColor;}
		public void setQiZiColor(String qiZiColor){
			//设置棋子颜色时，要重画
			this.qiZiColor=qiZiColor;
			repaint();
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			if(qiZiColor.equals("red")){//是红方下的
				g.setColor(Color.RED);
				//public abstract void fillOval(int x,int y,int width,int height)使用当前颜色填充外接指定矩形框的椭圆。 
				//参数：x - 要填充椭圆的左上角的 x 坐标。y - 要填充椭圆的左上角的 y 坐标。
				//width - 要填充椭圆的宽度。height - 要填充椭圆的高度。
				g.fillOval(10,10,getWidth()-20,getHeight()-20);
				//g.drawOval(10,10,getWidth()-20,getHeight()-10);
			}
			else if(qiZiColor.equals("black")){//是黑方下的
				g.setColor(Color.BLACK);
				g.fillOval(10,10,getWidth()-20,getHeight()-20);
			}
		}
		public Cell(){
			setBorder(new LineBorder(Color.BLACK,2));//设置单元格的边框为黑色、2个像素宽
			this.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me){
					if(!Cell.this.getQiZiColor().equals("empty")){
						return;
					}
						
					if(whoseTurn.equals("")){//为空，表示双方都不能下了
						lblStatus.setText("游戏结束");
						return;
					}
					if(!whoseTurn.equals("")){
						setQiZiColor(whoseTurn);
					}
					if(isWon(whoseTurn)){
						lblStatus.setText(whoseTurn+" 赢了，游戏结束");
						whoseTurn="";
					}else if(isFull()){
						lblStatus.setText("游戏结束！平局！");
						whoseTurn="";
					}else{
						whoseTurn=(whoseTurn.equals("red"))?"black":"red";
						lblStatus.setText("该"+whoseTurn+"下...");
					}
				}
			});
		}
	}

}
