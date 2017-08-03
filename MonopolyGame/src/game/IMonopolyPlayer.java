package game;

import java.util.ArrayList;

public interface IMonopolyPlayer {

	public int getMoney();
	public void setMoney(int val);
	public int subtractMoney(int val);
	public int addMoney(int val);
	public int getPosition();
	public void setPosition(int position);
	public String getName();
	int getNumberRoundsPlayed();
	void setNumberRoundsPlayed(int val);
	public int getNetWorth();
	public ArrayList<IMonopolySquare> getOwned();
	public void addProperty(IMonopolySquare square);
	
}
