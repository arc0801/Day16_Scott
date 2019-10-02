package com.arc.input;

import java.util.Scanner;

import com.arc.emp.EmpDTO;

public class EmpInput {
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}

	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		
		System.out.println("추가할 사원번호를 입력하세요.");
		empDTO.setEmpno(sc.nextInt());
		System.out.println("추가할 사원명을 입력하세요.");
		empDTO.setEname(sc.next());
		System.out.println("추가할 사원의 직종을 입력하세요.");
		empDTO.setJob(sc.next());
		System.out.println("추가할 사원의 상사번호를 입력하세요.");
		empDTO.setMgr(sc.nextInt());
		
		System.out.println("추가할  사원의 급여를 입력하세요.");
		empDTO.setSal(sc.nextInt());
		System.out.println("추가할 사원의 커미션을 입력하세요.");
		empDTO.setComm(sc.nextInt());
		System.out.println("추가할 사원의 부서번호를 입력하세요.");
		empDTO.setDeptno(sc.nextInt());
		
		return empDTO;
	}
	
	//empnoInput
	//사원번호를 입력하세요 출력
	public int empnoInput() {
		
		System.out.println("사원번호를 입력하세요");
		int empno = sc.nextInt();
		
		return empno;
	}
	
	public String enameInput() {
		
		System.out.println("사원이름을 입력하세요");
		String ename = sc.next();
		
		return ename;
	}
}
