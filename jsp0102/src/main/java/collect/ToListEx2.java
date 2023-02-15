package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import collect.Student.City;

public class ToListEx2 {

	public static void main(String[] args) {
		List<Student> tt2 = new ArrayList<>();
		tt2.add(new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul)); //add4번 반복하면 아래 4줄과 같음-리터럴처럼 값을 넣고싶어서 아래처럼 만든것
		
		List<Student> totalList = Arrays.asList(
				new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("신", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("박", 6, Student.Sex.FEMALE, Student.City.Seoul)
				);
//		List<Student> maleList = totalList.stream().filter(s->s.getSex()==Student.Sex.FEMALE)// s=student))student의 성별정보가 male이면 걔를 가져가다 list에 만들겟다
//		.collect(Collectors.toList());
//		maleList.stream().forEach(s->System.out.println(s.getName()));

		Map<Student.Sex, List<Student>> ms = totalList.stream().collect(Collectors.groupingBy(Student::getSex));
		ms.get(Student.Sex.MALE).stream().forEach(s->System.out.println(s.getName())); //s:아무 변수
		
		Map<Student.City, List<String>> ms2 = totalList.stream()
				.collect(Collectors.groupingBy(Student::getCity,Collectors.mapping(Student::getName,Collectors.toList())));
		ms2.get(Student.City.Seoul).stream().forEach(s->System.out.println(s));
		
		Map<Student.Sex, Double> ms3 = totalList.stream().collect(Collectors.groupingBy(
				Student::getSex, Collectors.averagingDouble(Student::getScore)));
		System.out.println(ms3.get(Student.Sex.MALE));
		
		Map<Student.City, String> ms4 = totalList.stream().collect(Collectors.groupingBy(
				Student::getCity, Collectors.mapping(Student::getName,Collectors.joining(", "))));
		System.out.println(ms4.get(Student.City.Seoul));
	}

}
