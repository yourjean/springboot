package javaExam;

public class Ex1 { //x,y값 변경 문제

	public static void main(String[] ar) {
		int x = 10;
		int y = 20;
		int temp = 0;
		System.out.printf("x= %d, y=%d\n", x,y);
		
		temp = x;
		x = y;
		y = temp;
		System.out.printf("x= %d, y=%d\n", x,y);
	}
}
