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
	
	public static boolean allSameVal(int num1, int num2, int num3) {
		if (num1 == num2 && num2 == num3) {return true;} return false;
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
		if (sameVal(CardVals.get(0), CardVals.get(1)) || 
				sameVal(CardVals.get(2), CardVals.get(1)) ||
				sameVal(CardVals.get(2), CardVals.get(0))) { // pair and 3 of kind case
			if (allSameVal(CardVals.get(0), CardVals.get(1), CardVals.get(2))) {
				eval = 2;
			} else {eval = 5;}
		} else if (sameSuit(hand)) {
			eval = 4;
		} else if (inSequence(CardVals) && !sameSuit(hand)) {
//				System.out.printf("STRAIGHT INSHALLAH");
				eval = 3;
		}
		else if (!inSequence(CardVals) && !sameSuit(hand)) {
//			System.out.printf("not anything");
			eval = 0;
		}
		if (inSequence(CardVals) && sameSuit(hand)) { eval = 1;}
		return eval;
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
	
	private static int compHighCards(ArrayList<Card> player, ArrayList<Card> dealer, int topCardIndex) {
        // get highest card at index
		// top card index starts at 1, since top ind of size 3 is n-1, which is 2
		// top card ind. will increment if both highs are same at the index
        if (topCardIndex > 3) {return 0;}       // examined all cards, 
        
        ArrayList<Integer>playerVals = sortCardValues(player);
        ArrayList<Integer>dealerVals = sortCardValues(dealer);
        
		if (dealerVals.get(3-topCardIndex) < 12) {return 0;}  // dealer not have queen high
        
        // Highest card is last in list, keep going until vals not equal
        int dealerHigh = dealerVals.get(3-topCardIndex);
        int playerHigh = playerVals.get(3-topCardIndex);
        
        if (dealerHigh == playerHigh) {
            return compHighCards(dealer, player, topCardIndex++);  // Eval based on next highest card
        } 
        
        // 1, dealer has higher card, 2, player has higher card
        if (dealerHigh > playerHigh) {return 1;} else {return 2;}
    }
	
	// 0, nobody wins, 1, dealer wins, 2, player wins
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
		int playerEval = evalHand(player);
		int dealerEval = evalHand(dealer);
		ArrayList<Integer>dealerVals = sortCardValues(dealer);
		
		if (dealerEval < playerEval) {
			if (dealerEval != 0) {  // lower the eval, better the hand
				System.out.printf("went to here, dealer wins\n");
				return 1;
			} else {  // dealer has high card
					if (dealerVals.get(2) < 12) {
						return 0;
					} else {return 2;}  // player has a unique hand, therefore wins
				}
		}
		else if (playerEval < dealerEval) {
			if (playerEval != 0) {  // lower the eval, better the hand
				System.out.printf("went to here, player wins\n");
				return 2;
			} else {  // dealer has unique hand, not high card, therefore wins
					return 1; // dealer wins bc unique hand
				}
		}
		else {  // if equal
			System.out.printf("went to here, same typa hands\n");
			if (dealerEval == 5 || dealerEval == 2 || dealerEval == 3
					|| dealerEval == 1) {  // pairs, 3 of kind, straight, SF
				// a way to find which of these types of hands is more powerful, sum up card values
				int sumPlayer = 0, sumDealer = 0;
				for (Card p : player) {
					sumPlayer = sumPlayer + p.getValue();
				}
				for (Card d : dealer) {
					sumDealer = sumDealer + d.getValue();
				}
				if (sumPlayer > sumDealer) {return 2;}
				else if (sumDealer > sumPlayer) {return 1;}
				else if (sumPlayer == sumDealer) { return 0;}
			} else if (dealerEval == 0 || dealerEval == 4) {  // compare high cards
				return compHighCards(player, dealer, 1);  // start high card comparison
			}
		}
		return 0;
	}
};
