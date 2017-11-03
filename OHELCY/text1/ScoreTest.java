package text1;

public class ScoreTest {
public static void main (String []args){
	int student []={29,99,29,22,22,};
	for(int i=0;i<5;i++){
		switch(student[i]/10){
		case 9 :System.out.println((i+1)+"is you");break;
		case 8 :System.out.println((i+1)+"is liang");break;
		case 7 :System.out.println((i+1)+"is zhong");break;
        default :System.out.println((i+1)+"is cha");break;
		}
	}

	for(int i=1;i<=5;i++){
		{if(i==3){
			//System.out.println(i+"tiao");
			continue;
		}
	}
		System.out.println(i);
	}
}
}

