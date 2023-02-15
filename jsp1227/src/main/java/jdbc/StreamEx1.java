package jdbc; //p799

import java.util.Arrays;
import java.util.List;
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
		System.out.println("--부서별 정렬--");
		lst.stream().sorted((n1, n2)->n1.getDeptno()-n2.getDeptno()).forEach(n->System.out.println(n));
	}
}
