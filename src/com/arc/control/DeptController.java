package com.arc.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.dept.DeptDAO;
import com.arc.dept.DeptDTO;
import com.arc.input.DeptInput;
import com.arc.view.DeptView;

public class DeptController {

	private Scanner sc;
	private DeptDAO deptDAO;
	private DeptView deptView;
	private DeptInput deptInput;

	public DeptController() {
		sc = new Scanner(System.in);
		deptDAO = new DeptDAO();
		deptView = new DeptView();
		deptInput = new DeptInput();
	}

	public void start() {
		boolean check = true;
		int select = 0;
		
		while(check) {
			System.out.println("+++++++++++++++++");
			System.out.println("1. 부서 전체 정보 출력");
			System.out.println("2. 부서 검색 출력");
			System.out.println("3. 부서 정보 추가");
			System.out.println("4. 종료");
			System.out.println("+++++++++++++++++");
			select = sc.nextInt();

			switch(select) {
			case 1:
				ArrayList<DeptDTO> ar = deptDAO.deptSelectList();
				deptView.view(ar);
				break;

			case 2:
				select = deptInput.deptnoInput();
				DeptDTO deptDTO = deptDAO.getSelectOne(select);

				if(deptDTO != null) {
					deptView.view(deptDTO);
				}else {
					deptView.view("존재하지 않는 부서입니다.");
				}
				break;
				
			case 3:
				deptDTO = deptInput.insert();
				select = deptDAO.deptInsert(deptDTO);
				
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				break;
				
			default:
				check = !check;
			}//switch
		}//while
	}
}
