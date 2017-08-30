package game.cards;

import game.CardResult;
import game.IBoard;
import game.IMonopolyPlayer;
import game.IMonopolySquare;
import game.squares.Railroad;
import game.squares.Utility;

public class AdvanceToNearestRailroadCard implements IMonopolyCard {

	//Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice 
		//and pay owner a total ten times the amount thrown. (Mr. M trudges along with a huge battleship token on his back)
		public String getDescription(){
			return "Advance to Nearest Railroad";
		}
		
		public CardResult resolveCard(IMonopolyPlayer player, IBoard board){
			CardResult result = new CardResult();
			for(int i = player.getPosition() + 1; i < board.getSquares().size();i ++){
				IMonopolySquare square = board.getSquares().get(i);
				if(square instanceof Railroad){
					result.setPlayerNewPosition(i);
					if(square.getOwner() != null){
						int chargeAmount = square.getChargeAmount(player, null, board) * 10;
						result.setMoneyChange(chargeAmount * -1);
						square.getOwner().addMoney(chargeAmount);
					}
				}
			}
			return result;
		}
}
