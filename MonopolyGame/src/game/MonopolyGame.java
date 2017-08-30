package game;

import java.util.ArrayList;

import game.squares.CardDealerSquare;
import game.squares.GoToJail;

public class MonopolyGame {

	ArrayList<IMonopolyPlayer> players = new ArrayList<IMonopolyPlayer>();
	IBoard board;
	IDiceRoller roller;
	int roundsPlayed;
	
	public void playRound(){
		for(int i= 0;i < players.size();i ++){
			playTurn(players.get(i),null);
		}
		roundsPlayed++;
	}
	
	public void playTurn(IMonopolyPlayer player, ArrayList<IDiceRoller> rollers){
		player.setNumberRoundsPlayed(player.getNumberRoundsPlayed()+1);
		if(rollers != null){
			this.roller = rollers.get(0);
		}
		TurnResult result = playerRolls(player);
		if(result.isForceEndTurn()){
			return;
		}
		if(result.getDiceResult().isDoubles()){
			if(rollers != null){
				this.roller = rollers.get(1);
			}
			result = playerRolls(player);
			if(result.isForceEndTurn()){
				return;
			}
			if(result.getDiceResult().isDoubles()){
				if(rollers != null){
					this.roller = rollers.get(2);
				}
				result = playerRolls(player);
				if(result.isForceEndTurn()){
					return;
				}
				if(result.getDiceResult().isDoubles()){
					movePlayerToJail(player);
				}
			}
		}
	}
	
	public void movePlayerToJail(IMonopolyPlayer player){
		player.setJailTurn(1);
		player.setPosition(10);
	}
	
	public TurnResult playerRolls(IMonopolyPlayer player){
		DiceResult result = roller.rollDice();
		boolean moved = false;
		boolean forceEndTurn = false;
		if(player.getJailTurn() >= 1){
			if(result.isDoubles() || player.getJailTurn() == 3){
				if(!result.isDoubles()){
					player.subtractMoney(50);
				}
				forceEndTurn = true;
				if(player.getJailTurn() == 3){
					moved = true;
				}
				player.setJailTurn(0);
				player.setPosition(10);
			}else{
				player.setJailTurn(player.getJailTurn()+1);
			}
		}else{
			moved = true;
		}
		if(moved){
			forceEndTurn = movePlayer(player,result) || forceEndTurn;
		}
		return new TurnResult(result,forceEndTurn,player.getPosition());
	}
	
	public boolean movePlayer(IMonopolyPlayer player, DiceResult result){
		boolean forceEndTurn = false;
		int newPosition = board.movePlayerToSquare(result.die1+result.die2, player);
		if(newPosition < player.getPosition()){
			board.awardPassGo(player);
		}
		player.setPosition(newPosition);
		IMonopolySquare square = board.getSquares().get(newPosition);
		if(square.getOwner() != null && square.getOwner() != player){
			int charge = square.getChargeAmount(player, result,board);
			player.subtractMoney(charge);
			square.getOwner().addMoney(charge);
		}
		if(!square.isOwnable()){
			forceEndTurn = handleNonOwnableSquareLandOn(player,result,square) || forceEndTurn;
		}
		return forceEndTurn;
	}
	
	public boolean handleNonOwnableSquareLandOn(IMonopolyPlayer player, DiceResult result,IMonopolySquare square){
		boolean forceEndTurn = false;
		if(square.isGoToJail()){
			player.setJailTurn(1);
			forceEndTurn = true;
		}
		if(square instanceof CardDealerSquare){
			forceEndTurn = handleCardDealerSquareLandOn(player,result,square) || forceEndTurn;
		}
		int charge = square.getChargeAmount(player,result,board);
		player.subtractMoney(charge);
		return forceEndTurn;
	}
	
	public boolean handleCardDealerSquareLandOn(IMonopolyPlayer player, DiceResult result,IMonopolySquare square){
		CardResult cardResult = ((CardDealerSquare) square).drawCard().resolveCard(player, board);
		if(cardResult.getMoneyChange() != 0){
			player.addMoney(cardResult.getMoneyChange());
		}
		if(cardResult.getPlayerNewPosition() != null){
			if(cardResult.getPlayerNewPosition() < player.getPosition()){
				board.awardPassGo(player);
			}
			player.setPosition(cardResult.getPlayerNewPosition());
		}
		return cardResult.isForceEndTurn();
	}
	
	public String validatePlayers(){
		if(players.size() < 2 || players.size() > 8){
			return "Incorrect number of players, need between 2 and 8";
		}
		return null;
	}
	
	public void playerBuysProperty(IMonopolyPlayer player){
		IMonopolySquare square = board.getSquares().get(player.getPosition());
		player.subtractMoney(square.getCost());
		square.setOwner(player);	
		player.addProperty(square);
	}
	
	
	
	public ArrayList<IMonopolyPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<IMonopolyPlayer> players) {
		this.players = players;
	}
	public IBoard getBoard() {
		return board;
	}
	public void setBoard(IBoard board) {
		this.board = board;
	}
	public IDiceRoller getRoller() {
		return roller;
	}
	public void setRoller(IDiceRoller roller) {
		this.roller = roller;
	}

	public int getNumberRoundsPlayed() {
		return roundsPlayed;
	}

	public void setNumberRoundsPlayed(int numberRoundsPlayed) {
		this.roundsPlayed = numberRoundsPlayed;
	}
	
}
