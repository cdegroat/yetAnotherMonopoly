package game.squares;

import java.math.BigDecimal;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.MonopolySquare;

public class LuxuryTaxSquare extends MonopolySquare {

	public LuxuryTaxSquare(){
		super.setName("Luxury Tax");
		super.setOwnable(false);
	}
	
	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		return 75;
	}
	
}
