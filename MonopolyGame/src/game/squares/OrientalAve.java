package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.MonopolySquare;

public class OrientalAve extends MonopolySquare {

	public OrientalAve(){
		super.setName("Oriental Avenue");
		super.setOwnable(true);
		super.setCost(100);
	}
	
	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		return 6;
	}
	
}
