package com.arc.control;

import java.util.Scanner;

public class FrontController {

	private Scanner sc;
	private EmpController empController;
	private DeptController deptController;
	private SalgradeController salgradeController;
	private BonusController bonusController;

	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		deptController = new DeptController();
		salgradeController = new SalgradeController();
		bonusController = new BonusController();
	}


	public void start() {
		boolean check = true;
		int select = 0;

		while(check) {
			System.out.println("1. 사원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. 급여관리");
			System.out.println("4. 보너스관리");
			System.out.println("5. 종         료");
			select = sc.nextInt();

			switch(select) {
			case 1:
				empController.start();
				break;

			case 2:
				deptController.start();
				break;

			case 3:
				salgradeController.start();
				break;
				
			case 4:
				bonusController.start();
				break;
				
			default :
				check = !check;
			}//while
		}//start
	}
}
