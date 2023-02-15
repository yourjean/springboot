package javaExam;

public class Ex5 {

	public static void main(String[] args) {
		// 실행결과가 다른 이유

		//1
		int i=0;
		int ret=100+ i++; //1
		System.out.println(ret); //100
		System.out.println(i); //1
		
		//2
		int j=0;
		int ret2=100+ ++j; //1
		System.out.println(ret2); //101
		System.out.println(j);
		
		//1: i값을 먼저 100에 더해주고 증가
		//2: 증가시킨 후 에 더함(??)
	}

}
