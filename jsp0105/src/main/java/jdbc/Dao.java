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

public class Dao {
	//싱클턴 패턴~
	private static Dao dao = new Dao(); //private이니까 다른애들이 접근못함-자기자신의 객체 생성(나빼고 다른애들은 객체생성 못함)(이상한 코딩)
	private Dao() {} //public class Dao { -의 Dao 생성자
	public static Dao getInstance() {
		return dao;
	} //~싱글턴 패턴  

	
	private Connection conn = getConnect();//private->외부(이 클래스 밖의 모든것)에서 접속 못하게 함 (connection이 여러개 못생기게 하려는 목적)
	private Connection getConnect() {
		try {
			Properties prop = new Properties();
			String path = Dao.class //Dao.class ->이 페이지의 클래스 이름과 같아야함(?)
					.getResource("db.properties").getPath(); //DB와의 연결을 DAO에서 해줌
			path = URLDecoder.decode(path, "utf-8");
			prop.load(new FileReader(path));
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertEmpTemp(Emp emp){
		String sql = "insert into emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno) " +
					"values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, emp.getEmpno());
			pstm.setString(2, emp.getEname());
			pstm.setString(3, emp.getJob());
			pstm.setInt(4, emp.getMgr());
			pstm.setString(5, emp.getHiredate());
			pstm.setInt(6, emp.getSal());
			pstm.setInt(7, emp.getComm());
			pstm.setInt(8, emp.getDeptno());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Dept> selectDept() {
		List<Dept> dlst = new ArrayList<>();

		String sql = "select * from dept_temp order by deptno";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept dept = new Dept(deptno, dname, loc);
				dlst.add(dept);
			}
			rs.close();
			pstm.close();
			return dlst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Emp selectEmpTemp(int num) {
		String sql = "select empno, ename, job, deptno, sal, "
				+ "to_char(hiredate, 'YYYY/MM/DD') as hiredate, mgr, comm"
				+ " from emp_temp where empno = ?";
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
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
			rs.close();
			pstm.close();
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Emp> selectEmpTempAll() {
		List<Emp> elst = new ArrayList<>();
		String sql = "select * from emp_temp order by empno";
		Emp emp = null;
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
				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				elst.add(emp);
			}
			rs.close();
			pstm.close();
			return elst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int updateEmpTemp(Emp emp){
		String sql = "update emp_temp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? " +
					"where empno = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, emp.getEname());
			pstm.setString(2, emp.getJob());
			pstm.setInt(3, emp.getMgr());
			pstm.setString(4, emp.getHiredate());
			pstm.setInt(5, emp.getSal());
			pstm.setInt(6, emp.getComm());
			pstm.setInt(7, emp.getDeptno());
			pstm.setInt(8, emp.getEmpno());
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public Dept selectDeptTemp(int num) {
		String sql = "select * from dept_temp where deptno = ?";
		Dept dept = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dept = new Dept(deptno, dname, loc);

			}
			rs.close();
			pstm.close();
			return dept;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int deleteEmpTemp(int empno){
		String sql = "delete from emp_temp where empno = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, empno);
			int res = pstm.executeUpdate();
			pstm.close();
			return res;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
public String selectEmpJson() { //return=List 제네릭:String 사용
	String str="[";
	String sql = "select json_object( 'empno' value empno,"
			+ "                    'ename' value ename,"
			+ "                    'job' value job,"
			+ "                    'mgr' value mgr,"
			+ "                    'hiredate' value to_char(hiredate, 'YYYY/MM/DD'),"
			+ "                    'sal' value sal,"
			+ "                    'comm' value comm,"
			+ "                    'deptno' value deptno"
			+ "                    )"
			+ "  from emp_temp";
	try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			str += rs.getString(1);
			str += ",";
		}
		String ss = str.substring(0, str.length() - 1);
		ss += "]";
		pstm.close();
		return ss;
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
	
}
}


