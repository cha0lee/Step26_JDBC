package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass05 {
	public static void main(String[] args) {
		
		//Connection 객체의 참조값 얻어오기
		Connection conn = new DBConnect().getConn();		
				
		//필요한 객체를 담을 변수 만들기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 10;
		String name = "준발이";
		String addr = "노량진";
		
		try {
			//실행할 SQL문의 뼈대 구성하기
			String sql = "INSERT INTO member (num, name, addr) " + "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}//try
		
		
			
	}

}
