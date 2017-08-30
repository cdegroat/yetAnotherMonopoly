package game.cards;

import game.CardResult;
import game.IBoard;
import game.IMonopolyPlayer;

public interface IMonopolyCard {

	public String getDescription();
	
	public CardResult resolveCard(IMonopolyPlayer player, IBoard board);
	
}
