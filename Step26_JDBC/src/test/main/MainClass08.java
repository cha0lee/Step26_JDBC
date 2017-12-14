package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		
		int num = 999;
		String name="누구게";
		String addr="어디게";
		
		//저장할 회원정보를 MemberDto 객체에 담고 
		MemberDto dto = new MemberDto(num, name, addr);
		MemberDao dao = MemberDao.getInstance();
		
		boolean isSuccess = dao.insert(dto);
		
		if(isSuccess) {
			System.out.println("저장성공");
		}else {
			System.out.println("저장실패");
		}	
	}
}
