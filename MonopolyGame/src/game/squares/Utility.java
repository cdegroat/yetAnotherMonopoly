package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.IMonopolySquare;
import game.MonopolySquare;

public class Utility extends MonopolySquare {

	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		int chargeMultiplier = 4;
		for(IMonopolySquare square:board.getSquares()){
			if(square instanceof Utility && square != this && square.getOwner() != null){
				chargeMultiplier = 10;
			}
		}
		return (diceResult.getDie1()+diceResult.getDie2()) * chargeMultiplier;
	}
	
}
