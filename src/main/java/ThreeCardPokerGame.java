public class ThreeCardPokerGame{
	Player playerOne;
	Player playerTwo;
	Dealer theDealer;
	public ThreeCardPokerGame()
	{
		playerOne = new Player();
		playerTwo = new Player();
		theDealer = new Dealer();
	}
	
	public void playerOneGetCards(){
		playerOne.hand = theDealer.dealHand();
	}
	
	public void playerTwoGetCards(){
		playerTwo.hand = theDealer.dealHand();
	}
	
	public void dealerGetCards(){
		theDealer.dealersHand = theDealer.dealHand();
	}
	
	public void playerOneFolds(){
		playerOne.totalWinnings = playerOne.totalWinnings - playerOne.anteBet - playerOne.pairPlusBet;
	}
	
	public void playerTwoFolds(){
		playerTwo.totalWinnings = playerTwo.totalWinnings - playerTwo.anteBet - playerTwo.pairPlusBet;
	}
}
