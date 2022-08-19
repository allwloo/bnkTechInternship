package spring.service.dice;

import java.util.Random;

/*
 * FileName : DiceC.java
 * ㅇ 주사위 Object Modeling
 * ㅇ 1 ~ 6 수를 랜덤하게  리턴
 */
public class DiceD {
	
	///Field
	private int value;

	///Constructor
	public DiceD() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}

	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//==> 주사위를 던저 선택되는 숫자를 생산하는 행위(무작위로 숫자 생산)
	public void selectedNumber(){
		value = new Random().nextInt(24) + 1;
	}
	
}//end of class