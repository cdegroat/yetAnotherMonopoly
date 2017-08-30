package game.squares;

import game.IMonopolyPlayer;
import game.cards.AdvanceToNearestRailroadCard;
import game.cards.AdvanceToNearestUtilityCard;
import game.cards.GenericMonopolyCard;

public class Chance extends CardDealerSquare {
/*
 Advance to Go (Collect $200) (Mr. M hops on both feet.)
Advance to Illinois Ave. - If you pass Go, collect $200 {Second sentence omitted.} (Mr. M has tied a cloth bundle onto his cane to make a bindle, carried over his right shoulder, and is smoking a cigar)
Advance to St. Charles Place – If you pass Go, collect $200 (Mr. M hurries along, hauling a little boy by the hand)
Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown. (Mr. M trudges along with a huge battleship token on his back)
Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.) (At lower left, Mr. M carries a large flatiron token with two hands; at upper right a railroad crossing is seen)
 */
	
	public Chance(){
		
		this.discardedCards.push(new GenericMonopolyCard("Advance To Go",false,0,0));
		this.discardedCards.push(new GenericMonopolyCard("Advance to Illinois Ave",false,24,0));
		this.discardedCards.push(new GenericMonopolyCard("Advance to St. Charles",false,11,0));
		this.discardedCards.push(new AdvanceToNearestUtilityCard());
		this.discardedCards.push(new AdvanceToNearestRailroadCard());
	}
	
	
	
}
