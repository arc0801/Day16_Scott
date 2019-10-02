package com.arc.view;

import java.util.ArrayList;

import com.arc.emp.EmpDTO;

public class EmpView {
	
	public void view(ArrayList<EmpDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			System.out.println("EMPNO : "+ar.get(i).getEmpno());
			System.out.println("ENAME : "+ar.get(i).getEname());
			System.out.println("JOB : "+ar.get(i).getJob());
			System.out.println("MGR : "+ar.get(i).getMgr());
			System.out.println("HIREDATE : "+ar.get(i).getHiredate());
			System.out.println("SAL : "+ar.get(i).getSal());
			System.out.println("COMM : "+ar.get(i).getComm());
			System.out.println("DEPTNO : "+ar.get(i).getDeptno());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

	
	public void view(String str) {
		System.out.println(str);
	}
	
	
	public void view(EmpDTO empDTO) {
		System.out.println("EMPNO : "+empDTO.getEmpno());
		System.out.println("ENAME : "+empDTO.getEname());
		System.out.println("JOB : "+empDTO.getJob());
		System.out.println("MGR : "+empDTO.getMgr());
		System.out.println("HIREDATE : "+empDTO.getHiredate());
		System.out.println("SAL : "+empDTO.getSal());
		System.out.println("COMM : "+empDTO.getComm());
		System.out.println("DEPTNO : "+empDTO.getDeptno());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
	}
}
