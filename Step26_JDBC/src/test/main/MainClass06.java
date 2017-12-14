package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 번호: 20
		 * 이름: 누구게
		 * 주소: 어디게
		 * 위의 정보를 MemberDto 객체에 담은 다음 MemberDto객체가 담긴 변수를 참조해서 해당 정보를 DB에 저장해 보세요.
		 */
		//MemberDto dto1 = new MemberDto(20, "누구게", "어디게");
		MemberDto dto1 = new MemberDto();
		dto1.setNum(20);
		dto1.setName("누구게");
		dto1.setAddr("어디게");
		
		//Connection 객체의 참조값 얻어오기
		Connection conn = new DBConnect().getConn();		
				
		//필요한 객체를 담을 변수 만들기
		PreparedStatement pstmt = null;
				
		int num = dto1.getNum();
		String name = dto1.getName();
		String addr = dto1.getAddr();
		
		try {
			//실행할 SQL문의 뼈대 구성하기
			String sql = "INSERT INTO member (num, name, addr) " + "VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();//insert, update, delete문은 이 메소드를 호출해서 수정한다.
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
