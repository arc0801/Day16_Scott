package com.arc.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.emp.EmpDAO;
import com.arc.emp.EmpDTO;
import com.arc.input.EmpInput;
import com.arc.view.EmpView;

public class EmpController {

	private Scanner sc;
	private EmpDAO empDAO;
	private EmpView empView;
	private EmpInput empInput;
	
	public EmpController() {
		sc = new Scanner(System.in);
		empDAO = new EmpDAO();
		empView = new EmpView();
		empInput = new EmpInput();
	}
	//start
	//1. 사원 전체 정보 출력
	//2. 사원 검색 출력
	//3. 종료

	public void start() {
		boolean check = true;
		int select = 0;
		
		while(check) {
			System.out.println("+++++++++++++++++");
			System.out.println("1. 사원 전체 정보 출력");
			System.out.println("2. 사원 검색 출력");
			System.out.println("3. 사원 정보 추가");
			System.out.println("4. 종료");
			System.out.println("+++++++++++++++++");
			select = sc.nextInt();

			switch(select) {
			case 1:
				ArrayList<EmpDTO> ar = empDAO.getSelectList();
				empView.view(ar);
				break;

			case 2:
				select = empInput.empnoInput();
				EmpDTO empDTO = empDAO.getSelectOne(select);

				if(empDTO != null) {
					empView.view(empDTO);
				}else {
					empView.view("존재하지 않는 사원입니다");
				}
				
				break;
				
			case 3:
				empDTO = empInput.insert();
				select = empDAO.empInsert(empDTO);
				
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				break;
				
			default :
				check = !check;
			}//switch
		}//while
	}
}
