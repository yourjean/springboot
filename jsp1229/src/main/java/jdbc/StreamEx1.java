package jdbc; //p799

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class StreamEx1 {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
		List<Emp> lst = ed.selectAll(0); //자료를 ArrayList에서 가져옴
//		for(Emp emp : lst) {
//			System.out.println(emp);
//		}
		IntStream.rangeClosed(1, 5).forEach(n->{
			System.out.println("*****");
			System.out.println(n+"test");
		});
		//필터링
		lst.stream().filter(n->n.getEname().startsWith("K")).forEach(n->System.out.println(n));
		System.out.println("---");
		lst.stream().filter(n->n.getSal()>=2000).forEach(n->System.out.println(n));
		//복수 개의 요소로 대체 p802
		List<String> inList = Arrays.asList("10, 20, 30", "40, 50, 60");
		inList.stream().flatMapToInt(a->{String[] strArr = a.split(",");
		int[] intArr = new int[strArr.length];
		for(int i=0; i<strArr.length;i++) {
			intArr[i] = Integer.parseInt(strArr[i].trim());
		}
		return Arrays.stream(intArr);
		}).forEach(n->System.out.println(n+11));
		//정렬 (Emp.java에서 implements Comparable<Emp>,return Integer.compare(empno,o.empno)변경
		System.out.println("--사번으로 정렬--");
		lst.stream().sorted().forEach(n->System.out.println(n));
		System.out.println("--부서별, 사변별 정렬--");
		lst.stream().sorted(Comparator.reverseOrder()).sorted((n1, n2)->n1.getDeptno() - n2.getDeptno()).forEach(n->System.out.println(n.getEmpno()+","+n.getDeptno()));
		
		//루핑 peek()-루핑(반복문) 중 peek는 (파이프라인)중간에 쓰기, forEach는 제일 마지막에
		System.out.println("루핑>>");
		List<Emp> dept10=new ArrayList<>();
		double avg = lst.stream().filter(a->a.getDeptno()==10).peek(n->dept10.add(n)).mapToInt(Emp::getSal).average().getAsDouble();
		dept10.stream().forEach(x->System.out.println(x));
		System.out.println("평균: "+avg);
		
		System.out.println("Optional>>");
		List<Integer> list = new ArrayList<>(); //list만들기
		double avg2 = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println(avg2); //자료가 없으니 에러가 남 -> orElse:(0.0)으로 찍어라 (1)
		
		list.stream().mapToInt(Integer::intValue).average().ifPresent(a->System.out.println("평균"+a)); // 프린트를 아예 안함 (2)
		
		OptionalDouble opt = list.stream().mapToInt(Integer::intValue).average();
		if(opt.isPresent()) { //있으면 값을 찍고 없으면 "없다"
			System.out.println();
		}else {
			System.out.println("없다"); //(3)
		}
		
		
	} //메인메소드 안에서 작업할것 
	
}
