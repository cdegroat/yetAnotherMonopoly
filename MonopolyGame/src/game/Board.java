package game;

import java.util.ArrayList;

import game.squares.Chance;
import game.squares.CommunityChest;
import game.squares.ConnecticutAve;
import game.squares.ElectricCompany;
import game.squares.GoToJail;
import game.squares.IncomeTaxSquare;
import game.squares.LuxuryTaxSquare;
import game.squares.OrientalAve;
import game.squares.VermontAve;
import game.squares.WaterWorks;

public class Board implements IBoard {

	ArrayList<IMonopolySquare> squares = new ArrayList<IMonopolySquare>();
	
	public Board(){
		for(int i= 0;i < 40;i ++){
			IMonopolySquare square = new MonopolySquare();
			if(i == 2){
				square = new CommunityChest();
			}
			if(i == 4){
				square = new IncomeTaxSquare();
			}
			if(i == 6){
				square = new OrientalAve();
			}
			if(i == 7){
				square = new Chance();
			}
			if(i == 8){
				square = new VermontAve();
			}
			if(i == 9){
				square = new ConnecticutAve();
			}
			if(i == 12){
				square = new ElectricCompany();
			}
			if(i == 17){
				square = squares.get(2);
			}
			if(i == 22){
				square = squares.get(7);
			}
			if(i == 28){
				square = new WaterWorks();
			}
			if(i == 30){
				square = new GoToJail();
			}
			if(i == 33){
				square = squares.get(2);
			}
			if(i == 36){
				square = squares.get(7);
			}
			if(i == 38){
				square = new LuxuryTaxSquare();
			}
			squares.add(square);
		}
	}
	@Override
	public ArrayList<IMonopolySquare> getSquares() {
		return squares;
	}
	public void setSquares(ArrayList<IMonopolySquare> squares) {
		this.squares = squares;
	}
	public int movePlayerToSquare(int roll, IMonopolyPlayer player){
		int newPosition = (player.getPosition()+roll) % 40;		
		return newPosition;
	}
	
	public void awardPassGo(IMonopolyPlayer player){
		player.addMoney(200);
	}

}
