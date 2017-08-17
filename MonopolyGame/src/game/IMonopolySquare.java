package game;

public interface IMonopolySquare {

	public String getName();
	public void setName(String name);
	public void setCost(int val);
	public int getCost();
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult, IBoard board);
	public int getNumberHouses();
	public void setNumberHouses(int numberHouses);
	public int getNumberHotels();
	public void setNumberHotels(int numberHotels);
	public boolean isMortgaged();
	public void setMortgaged(boolean mortgaged);
	public boolean isOwnable();
	public IMonopolyPlayer getOwner();
	public void setOwner(IMonopolyPlayer player);
	public boolean isGoToJail();
	
}
