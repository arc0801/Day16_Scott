package com.arc.view;

import java.util.ArrayList;
import java.util.List;

import com.arc.dept.DeptDTO;

public class DeptView {

	public void view(List<DeptDTO> ar) {//List가 부모형이라 이걸로 받아줘도 됨
		for(int i=0;i<ar.size();i++) {
			System.out.println("DEPTNO : "+ar.get(i).getDeptno());
			System.out.println("DNAME : "+ar.get(i).getDname());
			System.out.println("LOC : "+ar.get(i).getLoc());
			System.out.println("~~~~~~~~~~~~~");
		}
	}
	
	
	public void view(String str) {
		System.out.println(str);
	}
	
	
	public void view(DeptDTO deptDTO) {
		System.out.println("DEPTNO : "+deptDTO.getDeptno());
		System.out.println("DNAME : "+deptDTO.getDname());
		System.out.println("LOC : "+deptDTO.getLoc());
		System.out.println("~~~~~~~~~~~~~");
	}
}
