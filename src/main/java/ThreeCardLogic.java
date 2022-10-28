import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	public static int evalHand(ArrayList<Card> hand) {
		/* hand = new ArrayList<Card>(3); */
//		Dealer d = new Dealer ();
//		hand = d.dealHand();
		int eval; // 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
				  // 4 is flush, 5 is pair
		if (hand.get(0).getValue() == hand.get(1).getValue() || // pair case
				hand.get(1).getValue() == hand.get(2).getValue() ||
				hand.get(2).getValue() == hand.get(0).getValue()) {
			eval = 5;
			// program flush and straight and straight flush all in one case?
		} else if (hand.get(0).getSuit() == hand.get(1).getSuit() && // flush case
				hand.get(1).getSuit() == hand.get(2).getSuit() &&
				hand.get(2).getSuit() == hand.get(0).getSuit()) {
			// evaluate for straight flush, the best hand in the game, inside
			if ((hand.get(1).getValue() - hand.get(0).getValue()) == 1 &&
				(hand.get(2).getValue() - hand.get(1).getValue()) == 1) {
					eval = 1;
				} else {
					eval = 4;
			}
		} else if (hand.get(0).getValue() == hand.get(1).getValue() && // three of a kind case
				hand.get(1).getValue() == hand.get(2).getValue() &&
				hand.get(2).getValue() == hand.get(0).getValue()) {
			eval = 2;
		} else if ((hand.get(1).getValue() - hand.get(0).getValue()) == 1 &&
				(hand.get(2).getValue() - hand.get(1).getValue()) == 1) {
			// evaluate for straight flush, the best hand in the game, inside
			if (hand.get(0).getSuit() == hand.get(1).getSuit() && // flush case
					hand.get(1).getSuit() == hand.get(2).getSuit() &&
					hand.get(2).getSuit() == hand.get(0).getSuit()) {
					eval = 1;
				} else {
					eval = 3;
			}
		} else { eval = 0; }  // no combo at all, just a high card
		return eval;
		// 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
	    // 4 is flush, 5 is pair
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
//		hand = new ArrayList<Card>(3);
//		Dealer d = new Dealer ();
		int winnings = 0;
		int typeHand = evalHand(hand);
		if (typeHand == 5) {  // 
			winnings = bet * 2;  // 1 to 1
		} else if (typeHand == 4) {
			winnings = bet * 4;  // 3 to 1
		} else if (typeHand == 3) {
			winnings = bet * 7;  // 6 to 1
		} else if (typeHand == 2) {
			winnings = bet * 31;  // 30 to 1
		} else if (typeHand == 1) {
			winnings = bet * 41;  // 40 to 1
		}
		return winnings;
	}
	
	public static int maxCardVal(ArrayList<Card> hand) {
		int max = 0;
		for (Card c : hand) {
			if (c.getValue() > max) { max = c.getValue();}
		}
		return max;
	}
	
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
//		0 if neither hand won
//		• 1 if the dealer hand won
//		• 2 if the player hand won
		int comp = 0;  // to be returned
		int playerEval = evalHand(player);
		int dealerEval = evalHand(dealer);
		int maxPlayerCard = maxCardVal(player);
		int maxDealerCard = maxCardVal(dealer);
		if (playerEval != 0 && dealerEval != 0) {  // types of hands are found not high card
			if (playerEval < dealerEval) {comp = 2;} 
			else if (dealerEval < playerEval) {comp = 1;} 
			else if (playerEval == dealerEval) {  // program high card for flush, 
				// in same type of hand
				if (playerEval != 2 && dealerEval != 2) { 
					int sumPlayer = 0, sumDealer = 0;
					for (Card p : player) {
						sumPlayer = sumPlayer + p.getValue();
					}
					for (Card d : dealer) {
						sumDealer = sumDealer + d.getValue();
					}
					if (sumPlayer > sumDealer) {comp = 2;}
					else if (sumDealer > sumPlayer) {comp = 1;}
					else if (sumPlayer == sumDealer) { comp = 0;}
				} else { // flushes, so highest card wins
					if (maxPlayerCard > maxDealerCard) {comp = 2;}
					else if (maxDealerCard > maxPlayerCard) {comp = 1;}
					else {comp = 0;}
				}
			}
		} else if (playerEval == 0 && dealerEval == 0) {  // high card scenario
			// find high, or max card of each hand, then compare. The sums won't matter here.
			if (maxPlayerCard > maxDealerCard) {comp = 2;}
			else if (maxDealerCard > maxPlayerCard) {comp = 1;}
			else {comp = 0;}
		} else if (playerEval != 0 && dealerEval == 0) {comp = 1;}
		  else if (playerEval != 0 && dealerEval == 0) {comp = 1;}
		
		return comp;
	}
};
