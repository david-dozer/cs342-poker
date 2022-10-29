import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	
	public static boolean sameSuit(ArrayList<Card> hand) {
		if (hand.get(0).getSuit() == hand.get(1).getSuit() &&
				(hand.get(1).getSuit() == hand.get(2).getSuit()) &&
				(hand.get(2).getSuit() == hand.get(0).getSuit())) {
			return true;
		}
		return false;
	}
	
	public static boolean sameVal(int num1, int num2) {
		if (num1 == num2) {return true;} return false;
	}
	
	public static boolean inSequence(ArrayList<Card> hand) {
		if (hand.get(0).getValue() + 1 == hand.get(1).getValue()
				&& hand.get(1).getValue() + 1 == hand.get(2).getValue()) {
			return true;
		}
		return false;
	}
	
	public static int evalHand(ArrayList<Card> hand) {
		/* hand = new ArrayList<Card>(3); */
//		Dealer d = new Dealer ();
//		hand = d.dealHand();
		int eval = 0; // 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
				  // 4 is flush, 5 is pair
		if (sameVal(hand.get(0).value, hand.get(1).value) || // pair case
				sameVal(hand.get(2).value, hand.get(1).value)  ||
				sameVal(hand.get(2).value, hand.get(0).value)) {
			eval = 5;
		} else if (sameSuit(hand)) {
			eval = 4;
		} else if (sameVal(hand.get(0).value, hand.get(1).value) && // 3 of kind
				sameVal(hand.get(2).value, hand.get(1).value)  &&
				sameVal(hand.get(2).value, hand.get(0).value)) {
			eval = 2;
		} else if (inSequence(hand) && !sameSuit(hand)) {
			// evaluate for straight flush, the best hand in the game, inside
				eval = 3;
		} else if (inSequence(hand) && sameSuit(hand)) { eval = 1;}
		else if (!inSequence(hand) && !sameSuit(hand)) {
			System.out.printf("not anything");
			eval = 0;}
		return eval;
		// 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
	    // 4 is flush, 5 is pair
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
//		hand = new ArrayList<Card>(3);
//		Dealer d = new Dealer ();
		int factor = 0;
		int typeHand = evalHand(hand);
		if (typeHand == 5) {  // 
			factor = 1;  // 1 to 1
		} else if (typeHand == 4) {
			factor = 3;  // 3 to 1
		} else if (typeHand == 3) {
			factor = 6;  // 6 to 1
		} else if (typeHand == 2) {
			factor = 30;  // 30 to 1
		} else if (typeHand == 1) {
			factor = 40;  // 40 to 1
		}
		return (factor * bet) + bet;
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
