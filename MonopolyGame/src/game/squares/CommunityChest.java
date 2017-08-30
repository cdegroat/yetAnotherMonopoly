package game.squares;

import game.cards.GenericMonopolyCard;

public class CommunityChest extends CardDealerSquare {

	/*
	 * Advance to Go (Collect $200) <Mr. M strides in 7-league boots>
Bank error in your favor – Collect $200 <Mr. M falls back in astonishment as an arm presents a sheaf of cash out of a bank teller's window>
Doctor's fees {fee} – Pay $50 <Mr. M angrily brandishes crutches as he stomps with a leg cast>
From sale of stock you get $50 {$45} <Mr. M, happily entangled in the tape of a stock ticker, waves cash (with no $ sign this time)>
	 */
	
	public CommunityChest(){
		this.discardedCards.push(new GenericMonopolyCard("Advance To Go",false,0,0));
		this.discardedCards.push(new GenericMonopolyCard("Bank Error",false,null,200));
		this.discardedCards.push(new GenericMonopolyCard("Doctor's Fees",false,null,-50));
		this.discardedCards.push(new GenericMonopolyCard("Sale of Stock",false,null,50));
	}
	
}
