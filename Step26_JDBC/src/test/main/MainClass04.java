﻿package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass04 {
	public static void main(String[] args) {
		//필요한 객체를 담을 변수 만들기
		Connection conn=null;
		try{
			//오라클 드라이버 로딩하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 oracle DB url 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공!");
		}catch(Exception e){
			e.printStackTrace();
		}
		//1번 회원정보를 삭제해 보세요. 
		int num=1;
		
		//필요한 객체를 담을 변수 만들기
		PreparedStatement pstmt = null;
		
		
		try {
			//실행할 SQL문의 뼈대 구성하기
			String sql = "DELETE from member WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}//try
		
			
	}

}
