package game.squares;

import java.math.BigDecimal;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.MonopolySquare;

public class IncomeTaxSquare extends MonopolySquare {
	
	public IncomeTaxSquare(){
		super.setName("Income Tax");
		super.setOwnable(false);
	}
	
	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		BigDecimal netWorth = new BigDecimal(player.getNetWorth());
		BigDecimal netWorthCalc = netWorth.divide(new BigDecimal(10),0,BigDecimal.ROUND_HALF_UP);
		if(netWorthCalc.compareTo(new BigDecimal(200)) < 0){
			return netWorthCalc.intValue();
		}
		return 200;
	}

}
