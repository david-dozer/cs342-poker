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
}
