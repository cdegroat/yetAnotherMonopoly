package game;

import java.util.ArrayList;

public interface IBoard {

	public ArrayList<IMonopolySquare> getSquares();
	
	public int movePlayerToSquare(int roll, IMonopolyPlayer player);
	
	public void awardPassGo(IMonopolyPlayer player);

}
