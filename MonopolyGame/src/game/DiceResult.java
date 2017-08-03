package game;

public class DiceResult {
	
	int die1;
	int die2;
	
	public int getDie1() {
		return die1;
	}
	public void setDie1(int die1) {
		this.die1 = die1;
	}
	public int getDie2() {
		return die2;
	}
	public void setDie2(int die2) {
		this.die2 = die2;
	}
	public boolean isDoubles() {
		return die1==die2;
	}
}
