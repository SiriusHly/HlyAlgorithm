package compile;
public class Rectangle {
private int length;
private int width;
	public Rectangle(int l,int w) {
		length = l;
		width = w;
	}
	public Rectangle() {
        length = 4;
		width = 5;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public void setLength(int l) {
		if(l>0&&l<30){
		length = l;
		}
		else{
			System.out.println("invalid length");
		}
	}
	public void setWidth(int w) {
		if(w>0&&w<30){
		width = w;
		}
		else{
			System.out.println("invalid width");
		}
	}
	public int getArea(){
		return length*width;
	}
	public int getPerimeter(){
		return 2*(length*width);
	}
	public void draw(int length,int width){
		for(int i =0;i<length;i++){
			for(int j=0;j<width;j++){
				if(i==0||(i==length-1)||j==0||(j==width-1)){
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}	
			}System.out.println();		
		}
	}
}
