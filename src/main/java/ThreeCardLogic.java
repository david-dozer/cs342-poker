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
	
	public static boolean inSequence(ArrayList<Integer> hand) {
		if (hand.get(0) == 2 && hand.get(1) == 3 && hand.get(2) == 14) { return true;}
		// ^^ wrap around straight, ace can be used as low card one
		if (hand.get(0) + 1 == hand.get(1) && hand.get(1) + 1 == hand.get(2)) {
			return true;
		}
		return false;
	}
	
	public static ArrayList<Integer> sortCardValues(ArrayList<Card> hand) {
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		temp.add(hand.get(0).getValue()); temp.add(hand.get(1).getValue());
		temp.add(hand.get(2).getValue());
		Collections.sort(temp);
		return temp;
	}
	
	public static int evalHand(ArrayList<Card> hand) {
		ArrayList<Integer> CardVals = sortCardValues(hand);
		int eval = 0; // 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
				  // 4 is flush, 5 is pair
		if (sameVal(hand.get(0).value, hand.get(1).value) || // pair case
				sameVal(hand.get(2).value, hand.get(1).value)  ||
				sameVal(hand.get(2).value, hand.get(0).value)) {
			eval = 5;
		} else if (sameSuit(hand)) {
			eval = 4;
		} else if (inSequence(CardVals) && !sameSuit(hand)) {
//				System.out.printf("STRAIGHT INSHALLAH");
				eval = 3;
		} else if (sameVal(hand.get(0).value, hand.get(1).value) && // 3 of kind
				sameVal(hand.get(2).value, hand.get(1).value)  &&
				sameVal(hand.get(2).value, hand.get(0).value)) {
			eval = 2;
		} else if (inSequence(CardVals) && sameSuit(hand)) { eval = 1;}
		else if (!inSequence(CardVals) && !sameSuit(hand)) {
//			System.out.printf("not anything");
			eval = 0;}
		return eval;
		// 0 is high card, 1 is SF, 2 is 3 O Kind, 3 is straight,
	    // 4 is flush, 5 is pair
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
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
	
	public static int compHighCards(ArrayList<Card> player, ArrayList<Card> dealer) {
		int comp = 0;
		ArrayList<Integer> p1Val = sortCardValues(player);
		ArrayList<Integer> p2Val = sortCardValues(dealer);
		for (int i = 0; i < 3; i++) {
			if (p1Val.get(i) == p2Val.get(i)) {  // if high cards equal, move on to next
				player.remove(i); dealer.remove(i);  // remove from deck
			} else { break;}  // not equal, stop
		}
		if (p1Val.isEmpty() && p2Val.isEmpty()) {return 0;}
		
		if (p1Val.get(0) > p2Val.get(0)) { 
			comp = 2;
		} else {comp = 1;}  // dealer won
		return comp;
	}
	
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
//		0 if neither hand won
//		• 1 if the dealer hand won
//		• 2 if the player hand won
		int comp = 0;  // to be returned
		int playerEval = evalHand(player);
		int dealerEval = evalHand(dealer);
		
		if (playerEval != 0 && dealerEval != 0) {  // types of hands are found not high card
			if (playerEval < dealerEval) {comp = 2;} 
			else if (dealerEval < playerEval) {comp = 1;} 
			else if (playerEval == dealerEval) {  // program high card for flush, 
				// in same type of hand
				if (playerEval != 2 && dealerEval != 2) { // 3, 4, or 1
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
					comp = compHighCards(player, dealer);
				}
			}
		} else if (playerEval == 0 && dealerEval == 0) {  // high card scenario
			comp = compHighCards(player, dealer);
		}
		return comp;
	}
};
