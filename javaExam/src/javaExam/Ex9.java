package javaExam;

public class Ex9 {

	public static void main(String[] args) {
		// 변수 이름은 arr이고, 정수배열로 7개의 방을 만드려고함. new명령어로 배열을 생성하는 문장
		int[] arr=new int[7];
		
		//실험
		for( int i=0; i<arr.length; i++) {
			arr[i] =100+i;
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
