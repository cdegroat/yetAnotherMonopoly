package game;

public class FakeMonopolyPlayer extends MonopolyPlayer {

	int netWorth = 0;
	public FakeMonopolyPlayer(int netWorth){
		this.netWorth = netWorth;
	}
	@Override
	public int getNetWorth() {
		return netWorth;
	}
}
