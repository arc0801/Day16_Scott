package com.arc.view;

import java.util.ArrayList;

import com.arc.salgrade.SalgradeDTO;

public class SalgradeView {

	public void view(ArrayList<SalgradeDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			System.out.println("GRADE : "+ar.get(i).getGrade());
			System.out.println("LOSAL : "+ar.get(i).getLosal());
			System.out.println("HISAL : "+ar.get(i).getHisal());
			System.out.println("~~~~~~~~~~");
		}
	}
	
	
	public void view(String str) {
		System.out.println(str);
	}
	
	
	public void view(SalgradeDTO salgradeDTO) {
		System.out.println("GRADE : "+salgradeDTO.getGrade());
		System.out.println("LOSAL : "+salgradeDTO.getLosal());
		System.out.println("HISAL : "+salgradeDTO.getHisal());
		System.out.println("~~~~~~~~~~");
	}
}
