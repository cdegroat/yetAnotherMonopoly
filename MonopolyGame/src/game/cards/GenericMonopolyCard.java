package game.cards;

import game.CardResult;
import game.IBoard;
import game.IMonopolyPlayer;

public class GenericMonopolyCard implements IMonopolyCard {

	Integer newPlayerPosition;
	
	int changePlayerMoney;
	
	boolean endsTurn;
	
	public String description;

	public String getDescription() {
		return description;
	}

	public GenericMonopolyCard(String name, boolean endsTurn, Integer newPlayerPosition, int changePlayerMoney){
		this.description = name;
		this.endsTurn = endsTurn;
		this.newPlayerPosition = newPlayerPosition;
		this.changePlayerMoney = changePlayerMoney;
	}
	
	
	public CardResult resolveCard(IMonopolyPlayer player, IBoard board){
		CardResult result = new CardResult();
		result.setForceEndTurn(endsTurn);
		result.setMoneyChange(changePlayerMoney);
		result.setPlayerNewPosition(newPlayerPosition);
		return result;
	}
}
