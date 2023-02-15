package jdbc;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDao {
	private Connection conn = getConnect();

	private static EmpDao empDao = new EmpDao();

	public static EmpDao getInstance() {
		return empDao;
	}

	private EmpDao() {
	}

	private Connection getConnect() {
		try {
			// 파일로 만들어서 정의 해놓고 불러오면 코드를 안고치고 파일 고치면 되니까 이클립스같은 프로그램 없어도 이용하기 편함.

			Properties prop = new Properties();
			String path = EmpDao.class.getResource("db.properties").getPath(); //PropEx.class 파일이 있는 곳에 
			path = URLDecoder.decode(path,"utf-8"); // 한글 문제를 해결하기 위해
			prop.load(new FileReader(path));
			
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			System.out.println(driver);
			
			String url = prop.getProperty("url");	
			System.out.println(url);
			
			String user = prop.getProperty("user");
			System.out.println(user);
			
			String pw = prop.getProperty("pw");
			System.out.println(pw);
			Connection conn = DriverManager.getConnection(url, user, pw);
			
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public Emp select(int num) {
		String sql = "select * from emp where empno = ?";
		Emp emp = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);

			}
			rs.close();
			pstm.close();
			return emp;
			
//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Emp> selectAll(int num) {
		List<Emp> lst = new ArrayList<>();
		
		String sql = null;
		switch(num) {
		case 0:  // 정렬 안함
			sql = "select * from emp";
			break;
		case 1:  // 부서별 오름차순
			sql = "select * from emp order by deptno";
			break;
		case 2:  // 부서별 내림차순
			sql = "select * from emp order by deptno desc";
			break;
		}
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				int mgr = rs.getInt("mgr");
				int comm = rs.getInt("comm");
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;
			
//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	public List<Emp> selDeptSvg() {
		List<Emp> lst = new ArrayList<>();
		
		String sql = "select deptno, job, avg(sal) as avg_sal "
				+ "  from emp"
				+ " group by deptno,job"
				+ "  order by deptno,job";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
//				int empno = rs.getInt("empno");
//				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				int sal = rs.getInt("avg_sal"); //sal 말고 별칭 여기에 써주기
//				String hiredate = rs.getString("hiredate");
//				int mgr = rs.getInt("mgr");
//				int comm = rs.getInt("comm");
				
				int empno = 0;
				String ename = null;
				String hiredate = null;
				int mgr = 0;
				int comm = 0;
				
//				System.out.printf("%d %s %s %d %d\n", empno, ename, job, deptno, sal);
				Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				lst.add(emp);
			}
			rs.close();
			pstm.close();
			return lst;
			
//			return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main (String[] args) {
////		EmpDao ed = EmpDao.getInstance();
////		for(Emp emp :ed.selDeptSvg()) {
////			System.out.println(emp);
////		}
//		
////		EmpDao ed = EmpDao.getInstance();
////		for(Emp emp :ed.selectAll(0)) {
////			System.out.println(emp);
////		}
//		// 위에랑 똑같은 결과 스트림
//		EmpDao ed = EmpDao.getInstance();
//		List<Emp> lst = ed.selectAll(0);
//		lst.stream().forEach(n->System.out.println(n)); // forEach consumer라서 매개값 있고 리턴값 없음
//		
//		// 평균 구하는
////		EmpDao ed = EmpDao.getInstance();
////		List<Emp> lst = ed.selectAll(0);
//		double avg = lst.stream().mapToInt(Emp::getSal).average().getAsDouble(); // mapToInt(Emp::getSal) 매핑 - sal로 선택?
//		System.out.println(avg);
		
		
//		EmpDao ed = EmpDao.getInstance();
//		List<Emp> lst = ed.selectAll(0);
//		double avg = lst.stream().filter(n->n.getDeptno() == 10).mapToInt(Emp::getSal).average().getAsDouble(); //n으 emp
//		System.out.println(avg); //10번 부서 평균
//		
//		lst.stream().filter(n->n.getDeptno() == 10).forEach(x->System.out.println(x)); // 10번 부서의 모든 애들을 찍음.

		
		EmpDao ed = EmpDao.getInstance(); // connect 싱글톤
		List<Emp> lst = ed.selectAll(0); //Emp 안에 selectAll로 모든 값이 들어가 있음
		for(Emp emp : lst) {
			System.out.println(emp);
		}
		
//		lst.stream().mapToInt(Emp::getSal).forEach(n->System.out.println(n));
//		// lst.stream()초기단계.mapToInt(Emp::getSal)중간단계- Emp안에 getSal메소드 사용-(mapToInt int값을 하나 꺼내겠다).forEach 최종단계
		
//		lst.stream().map(Emp::getEname).forEach(n->System.out.println(n)); // n 값 하나가 Emp::getEname 
		
		int ss = lst.stream().mapToInt(Emp::getSal).sum();
		System.out.println("합계:"+ss);
		
		long cc = lst.stream().count(); // 중간단계는 안 써도 되고 최종단계 써야 된다.
		System.out.println(cc);
		
		lst.stream().forEach(n->System.out.println(n.getEmpno()+n.getEname())); // n을 알려면 . 눌러보면 안다.
		//스트림 주요 목적 - 자료를 줄여나가는 데에 있다.
		
		
		
	}

}