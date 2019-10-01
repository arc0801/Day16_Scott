package com.arc.control;

import java.util.Scanner;

import com.arc.emp.EmpDAO;
import com.arc.emp.EmpDTO;
import com.arc.input.EmpInput;
import com.arc.view.EmpView;

public class EmpController {

	private Scanner sc;

	public EmpController() {
		sc = new Scanner(System.in);
	}
	//start
	//1. 사원 전체 정보 출력
	//2. 사원 검색 출력
	//3. 종료

	public void start() {
		boolean check = true;
		EmpDAO empDAO = new EmpDAO();
		EmpView empView = new EmpView();
		EmpInput empInput = new EmpInput();

		while(check) {
			System.out.println("+++++++++++++++++");
			System.out.println("1. 사원 전체 정보 출력");
			System.out.println("2. 사원 검색 출력");
			System.out.println("3. 종료");
			System.out.println("+++++++++++++++++");
			int select = sc.nextInt();

			switch(select) {
			case 1:
				empView.view(empDAO.getSelectList());
				break;

			case 2:
				int empno = empInput.empnoInput();
				EmpDTO empDTO = empDAO.getSelectOne(empno);

				if(empDTO != null) {
					empView.view(empDTO);
				}else {
					empView.view("존재하지 않는 사원입니다");
				}
				break;

			case 3:
				check = !check;
				break;

			default :
				break;
			}//switch

		}//while



	}




}
