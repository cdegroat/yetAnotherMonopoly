package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.IMonopolySquare;
import game.MonopolySquare;

public class Railroad extends MonopolySquare {
	
	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		int cost = 25;
		for(IMonopolySquare square:this.getOwner().getOwned()){
			if(square instanceof Railroad && square != this){
				cost = cost * 2;
			}
		}
		return cost;
	}

}
