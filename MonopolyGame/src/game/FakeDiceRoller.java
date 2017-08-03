package game;

public class FakeDiceRoller implements IDiceRoller {

	int die1;
	int die2;
	public FakeDiceRoller(int die1, int die2){
		this.die1= die1;
		this.die2 = die2;
		
	}
	@Override
	public DiceResult rollDice() {
		DiceResult res = new DiceResult();
		res.die1=  this.die1;
		res.die2 = this.die2;
		return res;
	}
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

}
