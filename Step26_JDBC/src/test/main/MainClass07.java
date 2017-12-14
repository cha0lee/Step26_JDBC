package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		/*member 테이블에 있는 모든 내용을 List<MemberDto> 형태로 담아보세요
		 * 
		 */
		
		List<MemberDto> memberDtoList = new ArrayList<MemberDto>();
		
			
		Connection conn = new DBConnect().getConn();		
				
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT num, name, addr FROM member";
			
			pstmt = conn.prepareStatement(sql);
						
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				MemberDto tmpDto = new MemberDto();
				tmpDto.setNum(num);
				tmpDto.setName(name);
				tmpDto.setAddr(addr);
				
				memberDtoList.add(tmpDto);				
			}
			
			/*
			 * for(MemberDto tmp:memberDtoList) {
				System.out.println(tmp.getNum() + "/ " + tmp.getName() + "/ " + tmp.getAddr());
			}
			*/
			
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
