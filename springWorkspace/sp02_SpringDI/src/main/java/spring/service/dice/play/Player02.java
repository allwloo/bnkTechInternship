package spring.service.dice.play;

import spring.service.dice.Dice;
import spring.service.dice.DiceA;

/*
 *	FileName : Player01.java
 *	ㅇ Player 01에서는 DiceA 을 직접 가져서 타이트한 커플링의 코드...
 *  해결책으로 dice라는 인터페이스를 추가...
 *  player02가 dice를 가지는 관계를 작성
 */
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}
	
	public Player02(Dice dice) {
		this.dice = dice;
	}

	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class