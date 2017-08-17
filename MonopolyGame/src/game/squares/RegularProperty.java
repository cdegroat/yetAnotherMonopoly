package game.squares;

import game.DiceResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.IMonopolySquare;
import game.MonopolySquare;

public class RegularProperty extends MonopolySquare {

	int regularCharge = 0;
	int color = 0;
	
	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		int cost = this.getRegularCharge();
		if(hasMonopoly(board)){
			cost = cost * 2;
		}
		return cost;
	}
	
	public boolean hasMonopoly(IBoard board){
		boolean monopoly = true;
		for(IMonopolySquare square: board.getSquares()){
			if(square instanceof RegularProperty && ((RegularProperty) square).getColor() == this.color && square.getOwner() != this.getOwner()){
				monopoly = false;
			}
		}
		return monopoly;
	}
	
	public int getRegularCharge() {
		return regularCharge;
	}
	public void setRegularCharge(int regularCharge) {
		this.regularCharge = regularCharge;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}
