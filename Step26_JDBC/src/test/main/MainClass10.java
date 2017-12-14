package test.main;

import test.dao.MemberDao;

public class MainClass10 {
	public static void main(String[] args) {
		int num = 999;
		MemberDao dao = MemberDao.getInstance();
		boolean isSuccess = dao.delete(num);
		if(isSuccess) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
}
