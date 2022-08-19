package spring.service.dice.test;

import spring.service.dice.impl.DiceCImpl;
import spring.service.dice.impl.DiceDImpl;
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 * ㅇ Dice / Player02 Test 하는 Application 
 */
public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		Player02 player02 = new Player02();
		player02.setDice(new DiceDImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================");
		
		player02.setDice(new DiceCImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class

