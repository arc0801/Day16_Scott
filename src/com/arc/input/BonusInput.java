package com.arc.input;

import java.util.Scanner;

import com.arc.bonus.BonusDTO;

public class BonusInput {

private Scanner sc;
	
	public BonusInput() {
		sc = new Scanner(System.in);
	}
	
	
	//검색할 번호 받기
	public String input() {
		System.out.println("검색할 이름을 입력해 주세요");
		String ename = sc.next();
		
		return ename;
	}
	
	
	
	//정보집어넣기
	public BonusDTO insert() {
		BonusDTO bonusDto = new BonusDTO();
		
		System.out.println("ENAME을 입력해주세요.");
		String ename = sc.next();
		bonusDto.setEname(ename);
		System.out.println("JOB을 입력해주세요.");
		bonusDto.setJob(sc.next());
		System.out.println("SAL을 입력해주세요.");
		bonusDto.setSal(sc.nextInt());
		System.out.println("COMM을 입력해주세요.");
		bonusDto.setComm(sc.nextInt());
		
		return bonusDto;
	}
	
	
	
	//삭제할애 받기
	public String delete() {
		sc = new Scanner(System.in);
		System.out.println("삭제할 직원의 이름입력");
		String name = sc.next();
		
		return name;
	}
}
