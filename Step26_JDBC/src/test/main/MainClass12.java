package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		//1번회원 한명의 정보를 불러 오려면?
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = dao.getData(999);
		
		if(dto != null) {
			int num = dto.getNum();
			String name = dto.getName();
			String addr = dto.getAddr();
			System.out.println(num + " / " + name + " / " + addr);
		} else {
			System.out.println("정보가 없음");
		}
	}

}
