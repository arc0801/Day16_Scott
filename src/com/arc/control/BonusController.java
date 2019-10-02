package com.arc.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.bonus.BonusDAO;
import com.arc.bonus.BonusDTO;
import com.arc.input.BonusInput;
import com.arc.view.BonusView;

public class BonusController {

	private Scanner sc;
	private BonusDAO bonusDAO;
	private BonusView bonusView;
	private BonusInput bonusInput;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDAO = new BonusDAO();
		bonusView = new BonusView();
		bonusInput = new BonusInput();
	}


	public void start() {
		boolean check = true;
		int select = 0;

		while(check) {
			System.out.println("++++++++++++++++++++");
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 검색 출력");
			System.out.println("3. 정보 추가");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 종료");
			System.out.println("++++++++++++++++++++");
			select = sc.nextInt();

			switch(select) {
			case 1:
				ArrayList<BonusDTO> ar = bonusDAO.getSelectList();
				bonusView.view(ar);
				break;

			case 2:
				String ename = bonusInput.input();
				BonusDTO bonusDTO = bonusDAO.getSelectOne(ename);
				
				if(bonusDTO != null) {
					bonusView.view(bonusDTO);
				}else {
					bonusView.view("존재하지 않습니다.");
				}
				break;

			case 3:
				bonusDTO = bonusInput.insert();
				select = bonusDAO.bonusInsert(bonusDTO);
				
				if(select>0) {
					System.out.println("Insert Success");
				}else {
					System.out.println("Insert Fail");
				}
				break;

			case 4:
				bonusDAO.delete(bonusInput.delete());
				break;

			default :
				check = !check;
			}

		}
	}

}
