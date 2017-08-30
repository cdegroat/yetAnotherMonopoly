package game;

public class CardResult {

	int moneyChange;
	Integer playerNewPosition;
	boolean forceEndTurn;
	
	public int getMoneyChange() {
		return moneyChange;
	}
	public void setMoneyChange(int moneyChange) {
		this.moneyChange = moneyChange;
	}
	public Integer getPlayerNewPosition() {
		return playerNewPosition;
	}
	public void setPlayerNewPosition(Integer playerNewPosition) {
		this.playerNewPosition = playerNewPosition;
	}
	public boolean isForceEndTurn() {
		return forceEndTurn;
	}
	public void setForceEndTurn(boolean forceEndTurn) {
		this.forceEndTurn = forceEndTurn;
	} 
}
