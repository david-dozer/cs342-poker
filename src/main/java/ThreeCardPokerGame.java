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

	public void playerOneSetPlayWager(){
		playerOne.playBet = playerOne.anteBet;
	}
	public void playerTwoSetPlayWager(){
		playerTwo.playBet = playerTwo.anteBet;
	}
	public void playerOneFolds(){
		playerOne.totalWinnings = playerOne.totalWinnings
				- playerOne.anteBet - playerOne.pairPlusBet;
	}
	public void playerTwoFolds(){
		playerTwo.totalWinnings = playerTwo.totalWinnings
				- playerTwo.anteBet - playerTwo.pairPlusBet;
	}
	public void dealerWinsPlayer1Loses(){
		playerOne.totalWinnings = playerOne.totalWinnings - playerOne.anteBet - playerOne.playBet;
	}
	public void dealerLosesPlayer1Wins(){
		playerOne.totalWinnings = playerOne.totalWinnings + 2 * (playerOne.anteBet + playerOne.playBet);
	}

	public void dealerWinsPlayer2Loses(){
		playerTwo.totalWinnings = playerTwo.totalWinnings - playerTwo.anteBet - playerTwo.playBet;
	}
	public void dealerLosesPlayer2Wins(){
		playerTwo.totalWinnings = playerTwo.totalWinnings + 2 * (playerTwo.anteBet + playerTwo.playBet);
	}
	public void player1EvaluatePairPlus()
	{
		playerOne.totalWinnings = playerOne.totalWinnings - playerOne.pairPlusBet;
		int hasWin = ThreeCardLogic.evalPPWinnings(playerOne.hand, playerOne.pairPlusBet);
		playerOne.totalWinnings = playerOne.totalWinnings + hasWin;
	}

	public void player2EvaluatePairPlus()
	{
		playerTwo.totalWinnings = playerTwo.totalWinnings - playerTwo.pairPlusBet;
		int hasWin = ThreeCardLogic.evalPPWinnings(playerTwo.hand, playerTwo.pairPlusBet);
		playerTwo.totalWinnings = playerTwo.totalWinnings + hasWin;

	}



	public void reset(){
		playerOne = new Player();
		playerTwo = new Player();
		theDealer = new Dealer();
	}
}
