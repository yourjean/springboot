package javaExam;

public class Ex4 {

	public static void main(String[] args) {
		// random값을 발생시켜 1-6 사이의 정수 얻기
		
		double num = Math.random();
		System.out.println(num);

		int c=(int)(num*6+1); //+1의 위치 상관 없다
		System.out.println(c);
		
		int c2=(int)(num*6)+1;
		System.out.println(c);
	}

}
//클래스와 객체를 인스턴스라는 말을 사용해서 설명
//=>클래스의 인스턴스화=객체, 객체-힙영역에 생성 

//리터럴이란?
//=>값 자체. 프로그램 코드에 집어넣는것(?)

//기본 데이터타입과 참조형 데이터 타입의 근본적인 차이점?
//=>주소값을 따라가보면 방 자체에 값이 들어있음(값 자체를 저장) vs 주소 따라가면 힙영역(주소를 저장, 자스=참조형)

//데이터타입 변환이 필요한 이유는?
//=>자동형변환(방이 크면 그냥 넣어줌)vs 강제형변환(방이 좁으면 값을 잘라서 넣음-cast연산자) 
//참조형은 타입이 다르면 아예 못들어감-object에는 들어갈수 있음

//=>이유? 값 저장시 필요한 메모리 공간의 크기를 알기 위해, 값을 참조할때 한번에 읽어들일 메모리 공간의 크기를 알기위해