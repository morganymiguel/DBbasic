package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//db 접속 정보
		//드라이버 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		//dbms 주소
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		//사용자 계정
	
		String user ="ddit";
		//사용자 계정
		String password = "java";
		//사용자 비밀번호
//		ResultSet rs = null; // 결과를 보관할 객체
//		Statement stmt = null; // 정적sql명령 객체
//		PreparedStatement pstmt = null; // 동적쿼리 명령 
//		Connection conn = null; // 연결객체
		
		Class.forName(driver);//Driver 세팅
		
		Connection conn = DriverManager.getConnection(url, user, password);
		//DBMS 선택 -> 담당자(Connection)
//		String sql ="SELECT * FROM MEMBER";
		Scanner sc = new Scanner(System.in);
		String sql = sc.nextLine();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//PreparedStatement 통해서 sql 세팅
		
		ResultSet rs = pstmt.executeQuery();
		//조회 결고가 있는 경우
//		pstmt.executeUpdate(); //조회 결과가 없는 경우
//		rs.next(); //true or false
//		String mem_id = rs.getString("MEM_ID");
//		System.out.println(mem_id);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCnt = rsmd.getColumnCount();
		
		if(rs.next()) {
			for(int i = 1; i<=columnCnt; i++	) {
				System.out.println(rsmd.getColumnName(i)+", "+rs.getString(rsmd.getColumnName(i)));
			}
		}
		
		
	}

}
