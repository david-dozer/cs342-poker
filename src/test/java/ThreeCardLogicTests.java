import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ThreeCardLogicTests {

//	@BeforeEach
//	public String[] urlArray() {
//		String urls[] = new String[52];
//		for (int i = 0; i < 52; i++) {
//			urls[i] = "url";
//		}
//		return urls;
//	}
//	
	@Test
	void testEvalHandHighCard() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('C', 14));
		hand.add(new Card('D', 4));
		hand.add(new Card('S', 3)); 
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testEvalPair() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('C', 14));
		hand.add(new Card('D', 14));
		hand.add(new Card('S', 3));
		Assertions.assertEquals(5, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testEvalFlush() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 14)); // hand.get(0).setURL("url");
		//System.out.printf(hand.get(0).suit + " " + hand.get(0).value, " ");
		hand.add(new Card('S', 4)); // hand.get(1).setURL("url");
		hand.add(new Card('S', 9)); // hand.get(2).setURL("url"); 
		Assertions.assertEquals(4, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testEvalStraight() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 12)); // hand.get(0).setURL("url");
		hand.add(new Card('D', 13)); // hand.get(1).setURL("url");
		hand.add(new Card('C', 14)); // hand.get(2).setURL("url");
//		for (Card h : hand) {
//			System.out.printf("\n" + h.suit + " " + h.value);
//		}
		Assertions.assertEquals(3, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testEvalStraightOutOfOrder() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 14)); // hand.get(0).setURL("url");
		hand.add(new Card('D', 12)); // hand.get(1).setURL("url");
		hand.add(new Card('C', 13)); // hand.get(2).setURL("url");
//		for (Card h : hand) {
//			System.out.printf("\n" + h.suit + " " + h.value);
//		}
		Assertions.assertEquals(3, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testEvalStraightSpecialCase() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 2)); // hand.get(0).setURL("url");
		hand.add(new Card('D', 3)); // hand.get(1).setURL("url");
		hand.add(new Card('C', 14)); // hand.get(2).setURL("url");
//		for (Card h : hand) {
//			System.out.printf("\n" + h.suit + " " + h.value);
//		}
		Assertions.assertEquals(3, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testThreeOfAKind() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 12)); // hand.get(0).setURL("url");
		//System.out.printf(hand.get(0).suit + " " + hand.get(0).value, " ");
		hand.add(new Card('D', 12)); // hand.get(1).setURL("url");
		hand.add(new Card('C', 12)); // hand.get(2).setURL("url"); 
		Assertions.assertEquals(2, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testStraightFlush() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 12)); // hand.get(0).setURL("url");
		//System.out.printf(hand.get(0).suit + " " + hand.get(0).value, " ");
		hand.add(new Card('S', 10)); // hand.get(1).setURL("url");
		hand.add(new Card('S', 11)); // hand.get(2).setURL("url"); 
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testSpecialStraightFlush() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('S', 14)); // hand.get(0).setURL("url");
		//System.out.printf(hand.get(0).suit + " " + hand.get(0).value, " ");
		hand.add(new Card('S', 3)); // hand.get(1).setURL("url");
		hand.add(new Card('S', 2)); // hand.get(2).setURL("url"); 
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(hand));
	}
	
	//
	// compareHands tests, h1 is dealer, h2 is player
	// 0 neither won, 1 dealer won, 2 player won
	//
	@Test
	void compHands1() {  // if normal, and a unique hand, unique hand wins
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('C', 14));
		h1.add(new Card('D', 4));
		h1.add(new Card('S', 3)); 
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 3));
		h2.add(new Card('D', 14));
		h2.add(new Card('C', 3));
		Assertions.assertEquals(5, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands2() {  // if unique, and a unique hand, lower val unique hand wins
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('C', 14));
		h1.add(new Card('D', 14));
		h1.add(new Card('S', 3)); 
		Assertions.assertEquals(5, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 9));
		h2.add(new Card('H', 10));
		h2.add(new Card('H', 3));
		Assertions.assertEquals(4, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands3() {  // if unique, and a unique hand, lower val unique hand wins
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('S', 10));
		h1.add(new Card('S', 14));
		h1.add(new Card('S', 4));
		Assertions.assertEquals(4, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 9));
		h2.add(new Card('H', 10));
		h2.add(new Card('H', 11));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands4() {  // test both high cards, dealer no queen high
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('S', 8));
		h1.add(new Card('C', 5));
		h1.add(new Card('D', 4));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 7));
		h2.add(new Card('S', 2));
		h2.add(new Card('D', 5));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h2));
		// no one wins, dealer not have queen high
		Assertions.assertEquals(0, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands5() {  // test both high cards, dealer queen high
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('S', 12));
		h1.add(new Card('C', 4));
		h1.add(new Card('D', 5));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 7));
		h2.add(new Card('S', 2));
		h2.add(new Card('D', 8));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h2));
		// h1, or, the dealer wins, so return 1
		Assertions.assertEquals(1, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands6() {  // test both high cards, dealer queen high, player higher
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('S', 12));
		h1.add(new Card('C', 4));
		h1.add(new Card('D', 5));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h1));
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 7));
		h2.add(new Card('S', 14));
		h2.add(new Card('D', 8));
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands7() {  // test both 3 of a kind
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('S', 12));
		h1.add(new Card('C', 12));
		h1.add(new Card('D', 12));
		Assertions.assertEquals(2, ThreeCardLogic.evalHand(h1));
//		for (Card h : h1) {
//			System.out.println(h.suit + " " + h.value);
//		}
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 13));
		h2.add(new Card('S', 13));
		h2.add(new Card('D', 13));
		Assertions.assertEquals(2, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands8() {  // test straight flush beats straight
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('D', 3));
		h1.add(new Card('D', 4));
		h1.add(new Card('D', 2));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h1));
//		for (Card h : h1) {
//			System.out.println(h.suit + " " + h.value);
//		}
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 13));
		h2.add(new Card('S', 12));
		h2.add(new Card('C', 11));
		Assertions.assertEquals(3, ThreeCardLogic.evalHand(h2));
		// h1, or, the dealer wins, so return 1
		Assertions.assertEquals(1, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands9() {  // test tied hands
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('D', 3));
		h1.add(new Card('D', 4));
		h1.add(new Card('D', 2));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h1));
//		for (Card h : h1) {
//			System.out.println(h.suit + " " + h.value);
//		}
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 2));
		h2.add(new Card('H', 3));
		h2.add(new Card('H', 4));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h2));
		// no one wins, it is a tie
		Assertions.assertEquals(0, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands10() {  // test straight flush beats straight flush
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('D', 3));
		h1.add(new Card('D', 4));
		h1.add(new Card('D', 2));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h1));
//		for (Card h : h1) {
//			System.out.println(h.suit + " " + h.value);
//		}
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('H', 12));
		h2.add(new Card('H', 13));
		h2.add(new Card('H', 14));
		Assertions.assertEquals(1, ThreeCardLogic.evalHand(h2));
		// h2, or, the player wins, so return 2
		Assertions.assertEquals(2, ThreeCardLogic.compareHands(h1, h2));
	}
	
	@Test
	void compHands11() {  // test straight beats pair
		ArrayList<Card> h1 = new ArrayList<Card> ();
		h1.add(new Card('C', 13));
		h1.add(new Card('C', 14));
		h1.add(new Card('S', 12));
		Assertions.assertEquals(3, ThreeCardLogic.evalHand(h1));
//		for (Card h : h1) {
//			System.out.println(h.suit + " " + h.value);
//		}
		ArrayList<Card> h2 = new ArrayList<Card> ();
		h2.add(new Card('D', 12));
		h2.add(new Card('H', 12));
		h2.add(new Card('H', 3));
		Assertions.assertEquals(5, ThreeCardLogic.evalHand(h2));
		// h1, or, the dealer wins, so return 1
		Assertions.assertEquals(1, ThreeCardLogic.compareHands(h1, h2));
	}


};
