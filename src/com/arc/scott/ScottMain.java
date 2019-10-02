package com.arc.scott;

import java.sql.Connection;

import com.arc.control.DeptController;
import com.arc.control.EmpController;
import com.arc.control.FrontController;
import com.arc.dept.DeptDAO;
import com.arc.dept.DeptDTO;
import com.arc.emp.EmpDAO;
import com.arc.emp.EmpDTO;
import com.arc.input.EmpInput;
import com.arc.util.DBConnector;
import com.arc.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.start();
		
		/*
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDeptno(12);
		deptDTO.setDname("b");
		deptDTO.setDname("c");		
		*/
		
	}
}