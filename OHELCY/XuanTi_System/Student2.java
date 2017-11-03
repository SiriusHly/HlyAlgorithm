package XuanTi_System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Student2 extends Student{

	public String xx2, xy2, bj2, xm2, xh2, xt2, dh2, bh2, mc2, js2, ss2, es2, lx2, jj2;
	public static String path = "c:\\Data";
	
	public Student2(String xx2, String xy2, String bj2, String xm2, String xh2, String xt2, String dh2, String bh2,
			String mc2, String js2, String ss2, String es2, String lx2, String jj2, String path) {
		super();
		this.xx2 = xx2;
		this.xy2 = xy2;
		this.bj2 = bj2;
		this.xm2 = xm2;
		this.xh2 = xh2;
		this.xt2 = xt2;
		this.dh2 = dh2;
		this.bh2 = bh2;
		this.mc2 = mc2;
		this.js2 = js2;
		this.ss2 = ss2;
		this.es2 = es2;
		this.lx2 = lx2;
		this.jj2 = jj2;
		this.path = path;
	}
	public Student2() {
		File file = new File(path);
		file.mkdirs();
		
		
		
		
		
		btnxg2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				luru2();
			}
		});

		btntj2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				luru2();
			}
		});
		
		/*btncx2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chaxun2();
			}
		});
		*/
		
		
		btncz3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtxx3.setText("");
				//txtxx.setText(null); 
				txtxh2.setText("");
				txtxy2.setText("");
				txtbj2.setText("");
				txtxm2.setText("");
				txtxh3.setText("");
				txtxt2.setText("");
				txtdh2.setText("");
				txtbh2.setText("");
				txtmc2.setText("");
				txtjs2.setText("");
				txtss2.setText("");
				txtes2.setText("");
				txtlx2.setText("");
				txtjj2.setText("");
			}
		});
		
	
		
	}
	public String toString() {
		return xx2 + " " + xy2 + " " + bj2 + " " + xm2 + " " + xh2 + " " + xt2 + " " + dh2 + " " + bh2 + " " + mc2 + " " + js2
				+ " " + ss2 + " " + es2 + " " + lx2 + " " + jj2;
	}
	public void luru2() {
		String xx3 = txtxx3.getText();
		String xh3 = txtxh3.getText();
		FileWriter fw = null;
		File filelu = new File(path + "\\" + xx3);
		filelu.mkdirs();
		if (filelu.exists()) {
			if(xx3.length()>0&&xh3.length()>0){
			int ok = JOptionPane.showConfirmDialog(p5, "基本信息将被录入", "确定", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {
				xx2 = txtxx3.getText();
				xy2 = txtxy2.getText();
				bj2 = txtbj2.getText();
				xm2 = txtxm2.getText();
				xh2 = txtxh3.getText();
				xt2 = txtxt2.getText();
				dh2 = txtdh2.getText();
				bh2 = txtbh2.getText();
				mc2 = txtmc2.getText();
				js2 = txtjs2.getText();
				ss2 = txtss2.getText();
				es2 = txtes2.getText();
				lx2 = txtlx2.getText();
				jj2 = txtjj2.getText();
				String str = toString();
				try {
					fw = new FileWriter(filelu + "\\" + xh3 + ".txt");
					fw.write(str);
					fw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			
			
			}
		}
			else{
				JOptionPane.showMessageDialog(null, "请输入完整信息");
				if (xx3.length() <= 0 && xh3.length() <= 0) {
					txtxx.requestFocus();
				} else if (xx3.length() <= 0) {
					txtxx.requestFocus();
				} else if (xh3.length() <= 0) {
					txtxh.requestFocus();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "文件不存在");
			
		}
	}

	public static void qingchu(){
		txtxx3.setText("");
		//txtxx.setText(null); 
		//txtxh2.setText("");
		txtxy2.setText("");
		txtbj2.setText("");
		txtxm2.setText("");
		txtxh3.setText("");
		txtxt2.setText("");
		txtdh2.setText("");
		txtbh2.setText("");
		txtmc2.setText("");
		txtjs2.setText("");
		txtss2.setText("");
		txtes2.setText("");
		txtlx2.setText("");
		txtjj2.setText("");
	}
	public static  void cc(String c){
		
		FileReader fr = null;
		BufferedReader  br= null;
		
		File filecx = new File(c);
		
		if(filecx.exists()){
			
		
		try {
			fr = new FileReader(filecx);
			br = new BufferedReader(fr);
			String s=br.readLine();
			String[] s3 = s.split(" ");
		  File fx =new  File(path+"\\"+s3[2]+"\\"+s3[0]+".txt");
		  fr = new FileReader(fx);
			br = new BufferedReader(fr);
			String s4=br.readLine();
			String[] s2 = s4.split(" ");
		    txtxx3.setText(s2[0]);
		    txtxy2.setText(s2[1]);
		    txtbj2.setText(s2[2]);
		    txtxm2.setText(s2[3]);
		    txtxh3.setText(s2[4]);
		    txtxt2.setText(s2[5]);
		    txtdh2.setText(s2[6]);
		    txtbh2.setText(s2[7]);
		    txtmc2.setText(s2[8]);
		    txtjs2.setText(s2[9]);
		    txtss2.setText(s2[10]);
		    txtes2.setText(s2[11]);
		    txtlx2.setText(s2[12]);
		    txtjj2.setText(s2[13]);
		    br.close();
		    fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		}
		
	}
	
}
