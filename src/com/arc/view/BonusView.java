package com.arc.view;

import java.util.ArrayList;
import java.util.List;

import com.arc.bonus.BonusDTO;

public class BonusView {

	//한명만
		public void view(BonusDTO bonusDTO) {
			System.out.println("EMAME : "+bonusDTO.getEname());
			System.out.println("J O B : "+bonusDTO.getJob());
			System.out.println("S A L : "+bonusDTO.getSal());
			System.out.println("COMM  : "+bonusDTO.getComm());
		}
		
		
		//전체
		public void view(List<BonusDTO> ar) {
			for(BonusDTO bonusDTO : ar) {
				this.view(bonusDTO);
			}
		}
		
		
		
		//못찾았을 시
		public void view(String str) {
			System.out.println("정보를 못 찾았습니다.");
		}
}
