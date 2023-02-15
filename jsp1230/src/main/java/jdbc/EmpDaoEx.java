package jdbc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
		ed.realSelectAll();
		List<Emp> lst = ed.selectAll(0);
		//lst.stream().forEach(n->System.out.println(n)); //잘 나오는지 확인
		Map<Integer, List<Emp>> md1 = lst.stream().collect(Collectors.groupingBy(Emp::getDeptno));
		md1.get(30).stream().forEach(n->System.out.println(n)); //get을 써서 10번 부서 출력
		//Emp에 부서별 직원 정보 넣으려는것

		//위의것 복사-변수 바꾸기
		Map<Integer, Double> md2 = lst.stream() //평균 구하기
				.collect(Collectors.groupingBy(Emp::getDeptno,Collectors.averagingDouble(Emp::getSal)));
		System.out.println(md2.get(10));
		
		//복사
		Map<Integer, String> md3 = lst.stream() //stream으로 해서 mapping하니까 반복문 안돌려도 된다-
				.collect(Collectors.groupingBy(Emp::getDeptno,Collectors
						.mapping(Emp::getEname,Collectors.joining(", "))));
		System.out.println(md3.get(10));
	}

}
