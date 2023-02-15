package javaExam;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
//		// 구구단
//		for(int i=2; i<=9; i++) {
//			for(int j=1; j<=9; j++) {
////				System.out.println(i+"x"+j+"="+i*j);
//				System.out.printf("%d X %d = %d\n", i,j, i*j); // \n->한줄 내림
//			}
//		}
		
		//구구단중에 단을 입력 받아 출력하는 프로그램 (p1017)
		Scanner sc= new Scanner(System.in);
		System.out.println("단 입력>");
		int dan = sc.nextInt();
		System.out.println(dan+"단");
		for(int i=2; i<=9; i++) {
				System.out.printf("%d X %d = %d\n", dan, i, dan*i);
		}
	}
}

// while문과 do while문의 차이
//do while은 한번은 실행하고 빠져나감 vs while은 한번도 실행 안할수도 있는것 

//자바 데이터 타입 중 char vs String의 차이
//고정형 방이 생김 '한 글자'vs 참조형 데이터타입 "여러 글자"
