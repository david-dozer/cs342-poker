import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> hand;
	int anteBet;
	int playBet;
	int pairPlusBet;
	int totalWinnings;
	
	Player() {
		this.hand = new ArrayList<Card>();
		this.anteBet = 5;
		this.playBet = 5;
		this.pairPlusBet = 0;
		this.totalWinnings = 1000;
	}
	
	public int getTotalWinnings(){
		return this.totalWinnings;
	}
	
}
