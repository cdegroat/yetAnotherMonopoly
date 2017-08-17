package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.MonopolySquare;

public class VermontAve extends RegularProperty {

	public VermontAve(){
		super.setName("Vermont Avenue");
		super.setOwnable(true);
		super.setCost(100);
		super.setRegularCharge(6);
		super.setColor(2);
	}

}
