package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.MonopolySquare;

public class OrientalAve extends RegularProperty {

	public OrientalAve(){
		super.setName("Oriental Avenue");
		super.setOwnable(true);
		super.setCost(100);
		super.setRegularCharge(6);
		super.setColor(2);
	}

}
