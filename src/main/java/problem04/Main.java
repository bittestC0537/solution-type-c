package problem04;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static int num=0; //퀴즈 번호
	static String quiz[] = new String[18];
	static int anser[] = new int[18];
	static int rn[] = new int[2];
	static int count; //정답 맞춘 갯수
	
	static void makeQuiz() {
		for(int i=1;i<10;i++) {	//1단부터 9단까지
			for(int j=0;j<2;j++) {//2문제씩
				rn[j]=new Random().nextInt(9) + 1;
				quiz[num]=num+1+". "+i+" * "+rn[j]+" : ";
				anser[num]=i*rn[j];
				num++;
				for(int k=0;k<j;k++) {	//중복문제 제거
					if(rn[j]==rn[k]) {
						j--;
						num--;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int input;
		
		makeQuiz();
		for(int i=0;i<quiz.length;i++) {
			System.out.print(quiz[i]);
			input = s.nextInt();
			System.out.println(input+" "+anser[i]);
			if(input==anser[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}