package com.arc.scott;

import java.sql.Connection;

import com.arc.control.EmpController;
import com.arc.emp.EmpDAO;
import com.arc.emp.EmpDTO;
import com.arc.input.EmpInput;
import com.arc.util.DBConnector;
import com.arc.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		
		EmpController empController = new EmpController();
		empController.start();
		
	}
}