package javaExam;

public class Student {
	
	String hakbun;
	String name;
	int kor;
	int math;
	int eng;
	
	public Student(String hakbun, String name) { //source
		this.hakbun=hakbun;
		this.name=name;
	}

	public Student(String hakbun, String name, int kor, int math, int eng) { //source
		this(hakbun,name);
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
}
//Getter Setter사용이유
//필드가 private으로 강제정의-직접접근을 못하게하고 메소드로 접근하게 하기위해

//로컬변수(지역변수)vs멤버변수(필드=전역변수)
//메소드 블록 내에서만 존재 vs 객체값을 저장하고있는것.

//static(정적)메소드 vs 메소드
//객체생성하지않아도 사용가능(객체지향언어의 의미가 사라짐) vs 변수이름.메소드<-객체생성해야함 

//생성자 vs 다른 메소드
//클래스 이름과같음,객체생성할때만 한번 사용(재사용ㄴ) vs return있음,재사용 가능

//protected접근 제한자의 범위

//객체 타입 확인(instanceof)는 언제 사용? (1권 p326)
//다형성(부모이름으로 변수선언-자식객체로 객체생성)

//추상 클래스와 인터페이스의 공통점,차이점?
//공:추상메소드를 사용, 객체생성x, 재정의
//다:추상클래스는 필드,메소드 가질수있음/ 

//추상메소드 선언이유?
//인터페이스내에 추상메소드 두는이유는 강제적으로 걔를 구현하게 만들게 하기위해 

//자바8에 추가된 인터페이스 기능(1권 p346)

//