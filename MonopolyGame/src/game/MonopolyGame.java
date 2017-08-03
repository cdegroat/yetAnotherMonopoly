package game;

import java.util.ArrayList;

public class MonopolyGame {

	ArrayList<IMonopolyPlayer> players = new ArrayList<IMonopolyPlayer>();
	IBoard board;
	IDiceRoller roller;
	int roundsPlayed;
	
	public void playRound(){
		for(int i= 0;i < players.size();i ++){
			playTurn(players.get(i));
		}
		roundsPlayed++;
	}
	
	public void playTurn(IMonopolyPlayer player){
		player.setNumberRoundsPlayed(player.getNumberRoundsPlayed()+1);
	}
	
	public void playerRolls(IMonopolyPlayer player){
		DiceResult result = roller.rollDice();
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
			int charge = square.getChargeAmount(player,result,board);
			player.subtractMoney(charge);
		}
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