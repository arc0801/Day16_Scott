package com.arc.input;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.dept.DeptDTO;

public class DeptInput {

	private Scanner sc;
	
	public DeptInput() {
		sc = new Scanner(System.in);
	}
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		
		System.out.println("추가할 부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		deptDTO.setDeptno(deptno);
		System.out.println("추가할 부서명을 입력하세요.");
		String dname = sc.next();
		deptDTO.setDname(dname);
		System.out.println("추가할 부서의 지역을 입력하세요.");
		String loc = sc.next();
		deptDTO.setLoc(loc);
		
		return deptDTO;
	}
	 
	
	public int deptnoInput() {
		
		System.out.println("부서번호를 입력하세요");
		int deptno = sc.nextInt();
		
		return deptno;
	}
}
