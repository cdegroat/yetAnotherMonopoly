package game.squares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import game.IMonopolyPlayer;
import game.MonopolySquare;
import game.cards.IMonopolyCard;

public class CardDealerSquare extends MonopolySquare {

	Stack<IMonopolyCard> cards = new Stack<IMonopolyCard>();
	Stack<IMonopolyCard> discardedCards = new Stack<IMonopolyCard>();
	
	public CardDealerSquare(){
		this.setOwnable(false);
	}
	
	public IMonopolyCard drawCard(){
		if(cards.isEmpty()){
			shuffleDiscardedCardsBackIn();
		}
		if(cards.isEmpty()){
			throw new RuntimeException("This deck is completely empty, WTF man?");
		}
		IMonopolyCard card = cards.pop();
		discardedCards.push(card);
		return card;
	}
	
	public void shuffleDiscardedCardsBackIn(){
		Collections.shuffle(discardedCards);
		cards.addAll(discardedCards);
		discardedCards.clear();
	}

	public Stack<IMonopolyCard> getCards() {
		return cards;
	}

	public void setCards(Stack<IMonopolyCard> cards) {
		this.cards = cards;
	}

	public Stack<IMonopolyCard> getDiscardedCards() {
		return discardedCards;
	}

	public void setDiscardedCards(Stack<IMonopolyCard> discardedCards) {
		this.discardedCards = discardedCards;
	}
}
