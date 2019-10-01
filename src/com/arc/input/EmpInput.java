package com.arc.input;

import java.util.Scanner;

public class EmpInput {
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}

	//empnoInput
	//사원번호를 입력하세요 출력
	public int empnoInput() {
		
		System.out.println("사원번호를 입력하세요");
		int empno = sc.nextInt();
		
		return empno;
	}
	
	
}
