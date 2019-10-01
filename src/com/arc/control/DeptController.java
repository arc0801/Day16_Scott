package com.arc.control;

import java.util.Scanner;

import com.arc.dept.DeptDAO;
import com.arc.dept.DeptDTO;
import com.arc.input.DeptInput;
import com.arc.view.DeptView;

public class DeptController {

	private Scanner sc;
	
	public DeptController() {
		sc = new Scanner(System.in);
	}
	
	public void start() {
		boolean check = true;
		DeptDAO deptDAO = new DeptDAO();
		DeptView deptView = new DeptView();
		DeptInput deptInput = new DeptInput();
		
		while(check) {
			System.out.println("+++++++++++++++++");
			System.out.println("1. 부서 전체 정보 출력");
			System.out.println("2. 부서 검색 출력");
			System.out.println("3. 종료");
			System.out.println("+++++++++++++++++");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				deptView.view(deptDAO.getSelectList());
				break;
				
			case 2:
				int deptno = deptInput.deptnoInput();
			DeptDTO deptDTO = deptDAO.getSelectOne(deptno);
			
			if(deptDTO != null) {
				deptView.view(deptDTO);
			}else {
				deptView.view("존재하지 않는 부서입니다.");
			}
			break;
			case 3:
				check = !check;
				break;
			default:
				break;
			}//switch
		}//while
	}
}
