package game;

public class MonopolySquare implements IMonopolySquare {

	String name;
	int cost;
	int numberHouses;
	int numberHotels;
	boolean mortgaged;
	boolean ownable;
	IMonopolyPlayer owner;

	@Override
	public int getChargeAmount(IMonopolyPlayer player, DiceResult diceResult,IBoard board) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getNumberHouses() {
		return numberHouses;
	}


	public void setNumberHouses(int numberHouses) {
		this.numberHouses = numberHouses;
	}


	public int getNumberHotels() {
		return numberHotels;
	}


	public void setNumberHotels(int numberHotels) {
		this.numberHotels = numberHotels;
	}


	public boolean isMortgaged() {
		return mortgaged;
	}


	public void setMortgaged(boolean mortgaged) {
		this.mortgaged = mortgaged;
	}


	public boolean isOwnable() {
		return ownable;
	}


	public void setOwnable(boolean ownable) {
		this.ownable = ownable;
	}


	public IMonopolyPlayer getOwner() {
		return owner;
	}


	public void setOwner(IMonopolyPlayer owner) {
		this.owner = owner;
	}
	
	public boolean isGoToJail(){
		return false;
	}

}
