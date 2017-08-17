package game;

public class TurnResult {

	DiceResult diceResult;
	boolean forceEndTurn;
	int newPosition;
	
	public TurnResult(DiceResult result,boolean forceEndTurn,int newPosition){
		this.diceResult = result;
		this.forceEndTurn = forceEndTurn;
		this.newPosition = newPosition;
	}

	public DiceResult getDiceResult() {
		return diceResult;
	}

	public void setDiceResult(DiceResult diceResult) {
		this.diceResult = diceResult;
	}

	public boolean isForceEndTurn() {
		return forceEndTurn;
	}

	public void setForceEndTurn(boolean forceEndTurn) {
		this.forceEndTurn = forceEndTurn;
	}

	public int getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(int newPosition) {
		this.newPosition = newPosition;
	}
}
