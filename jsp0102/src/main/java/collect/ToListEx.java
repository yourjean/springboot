package collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToListEx {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("홍", 10, Student.Sex.MALE),
				new Student("김", 6, Student.Sex.FEMALE),
				new Student("신", 10, Student.Sex.MALE),
				new Student("박", 6, Student.Sex.FEMALE)
				);
		List<Student> maleList = totalList.stream().filter(s->s.getSex()==Student.Sex.FEMALE)// s=student))student의 성별정보가 male이면 걔를 가져가다 list에 만들겟다
		.collect(Collectors.toList());
		maleList.stream().forEach(s->System.out.println(s.getName()));

	}

}
