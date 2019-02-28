package problem04;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
	
	static int num=0; //퀴즈 번호
	static String quiz[] = new String[18];
	static int anser[] = new int[18];
	static int rn[] = new int[2];
	static int count; //정답 맞춘 갯수
	static double time; //정답 맞추는데 걸린 시간
	
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
	
	static void makeFile() {
		try {
			FileOutputStream out = new FileOutputStream("rank.txt");
			FileInputStream in = new FileInputStream("rank.txt");

			String str = count+" / "+time;

			byte[] b = str.getBytes();	// 문자를 바이트로 변환
			out.write(b);	//파일 쓰기
			out.close();
			
			int c;

			while((c=in.read()) != -1){	//wile문으로 파일 읽기

	                    System.out.print((char)c);

	                }
			in.close();
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int input;

		makeQuiz();
		long start = System.currentTimeMillis();
		for(int i=0;i<quiz.length;i++) {
			System.out.print(quiz[i]);
			input = s.nextInt();
			if(input==anser[i]) {
				count++;
			}
		}
		long end = System.currentTimeMillis();
		time = (double) (( end - start )/1000.0);


		makeFile();
		
		
	}
}