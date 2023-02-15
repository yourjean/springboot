package javaExam;

public class Ex11 {

	public static void main(String[] args) {
		//다음은 main메소드 내에 코드 부분이다 다음코드를 완성해라
		int[]sc= {95,71,84};
		int sum=0;
		for(int nn: sc) {
			sum=sum+nn;
		}
		System.out.println(sum);
		double avg=(double)sum/3;
		System.out.println(avg);
	}

}
