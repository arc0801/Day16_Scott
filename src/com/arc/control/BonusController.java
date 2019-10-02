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
			System.out.println("1. 급여등급 전체 정보 출력");
			System.out.println("2. 급여등급 검색 출력");
			System.out.println("3. 급여등급 정보 추가");
			System.out.println("4. 급여등급 정보 삭제");
			System.out.println("5. 종료");
			System.out.println("++++++++++++++++++++");
			select = sc.nextInt();

			switch(select) {
			case 1:
				ArrayList<BonusDTO> ar = bonusDAO.getSelectList();
				
				break;

			case 2:
				
				break;

			case 3:

				break;

			case 4:

				break;

			default :
				check = !check;
			}

		}
	}

}
