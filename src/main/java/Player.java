import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> hand;
	int anteBet;
	int playBet;
	int pairPlusBet;
	int totalWinnings;
	boolean playCurrentRound;
	
	Player() {
		this.hand = new ArrayList<Card>();
		this.anteBet = 5;
		this.playBet = 5;
		this.pairPlusBet = 0;
		this.totalWinnings = 1000;
	}
	
	public boolean getPlayCurrentRound(){return this.playCurrentRound;}
	
	public void setPlayCurrentRound(boolean val){this.playCurrentRound = val;}
	
	public int getTotalWinnings(){
		return this.totalWinnings;
	}
	
}
