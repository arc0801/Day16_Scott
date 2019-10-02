package com.arc.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.input.SalgradeInput;
import com.arc.salgrade.SalgradeDAO;
import com.arc.salgrade.SalgradeDTO;
import com.arc.view.SalgradeView;

public class SalgradeController {

	private Scanner sc;
	private SalgradeDAO salDAO;
	private SalgradeDTO salDTO;
	private SalgradeView sv;
	private SalgradeInput si;
	
	public SalgradeController() {
		sc = new Scanner(System.in);
		salDAO = new SalgradeDAO();
		salDTO = new SalgradeDTO();
		sv = new SalgradeView();
		si = new SalgradeInput();
	}
	
	
	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 전체출력");
			System.out.println("2. 검색출력");
			System.out.println("3. 등급삽입");
			System.out.println("4. 등급삭제");
			System.out.println("5. 종     료");
			int select = sc.nextInt();
		
			switch(select) {
			
				case 1:
					ArrayList<SalgradeDTO> ar = salDAO.getSelectList();
					if(ar.size()>0) {
						sv.view(ar);
					}else {
						sv.view("데이터가 없습니다");
					}
					break;
					
				case 2:
					int num = si.salgradeInput();
					salDTO = salDAO.getSelectOne(num);
					
					if(salDTO!=null) {
						sv.view(salDTO);
					}else {
						sv.view("없습니다");
					}
					
					break;
				case 3:
					SalgradeDTO salgradeDTO = si.insert();
					select = salDAO.salInsert(salgradeDTO);
					if(select >0) {
						System.out.println("입력성공");
					}else {
						System.out.println("입력실패");
					}
					break;
				case 4:
					num = si.salgradeInput();
					select = salDAO.delete(num);
					
					if(select >0) {
						System.out.println("삭제성공");
					}else {
						System.out.println("삭제실패");
					}
					break;
					
				default :
					check = false;
					break;
		
			}
	

		}
		
	}
}
