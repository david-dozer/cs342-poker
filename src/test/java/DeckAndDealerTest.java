import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.*;
import java.util.Collections;

import java.util.ArrayList;

class DeckandDealerTests {
		
	static Deck deck = new Deck();
	
	@Test
	void testDeckConstructor() {
		Deck deck = new Deck();
		for (Card d : deck) {
			System.out.printf(d.suit + " " + d.value + '\n');
		}
		Assertions.assertEquals(52, deck.size);
	}
	
//	
	@Test
	void newDeckTest() {
		deck.NewDeck();
		Assertions.assertEquals(52, deck.size);
	}
	
	@Test
	void shuffled() {  // will sometimes fail based on shuffling, making sure its not same card on top
		Deck deck = new Deck();
		Assertions.assertEquals(52, deck.size);
		Card top = deck.remove(0);
		Assertions.assertNotEquals(2, top.getValue());  // 2 is first val of val array
	}
//	
	@Test
	void DealerConstructor() {
		Dealer dealer = new Dealer();
		Assertions.assertEquals(52, dealer.theDeck.size);
		Assertions.assertEquals(0, dealer.dealersHand.size());
	}	
	
	@Test
	void DealHand1() {
		Dealer dealer = new Dealer();
		ArrayList<Card> hand = dealer.dealHand();
		Assertions.assertEquals(3, hand.size());
	}
	
	@Test
	void DealHandCheckSize() {
		Dealer dealer = new Dealer();
		ArrayList<Card> h = dealer.dealHand();
		Assertions.assertEquals(49, dealer.theDeck.size);
	}
	
	@Test
	void DealersHandCheckSize() {
		Dealer dealer = new Dealer();
		dealer.dealersHand = dealer.dealHand();
		Assertions.assertEquals(49, dealer.theDeck.size);
		Assertions.assertEquals(3, dealer.dealersHand.size());
	}
	
	@Test
	void Deal2Hands() {
		Dealer dealer = new Dealer();
		ArrayList<Card> hand = dealer.dealHand();
		ArrayList<Card> hand2 = dealer.dealHand();
		Assertions.assertEquals(46, dealer.theDeck.size);
		Assertions.assertEquals(3, hand.size());
		Assertions.assertEquals(3, hand2.size());
	}
	
	@Test
	void Deal3Hands() {
		Dealer dealer = new Dealer();
		ArrayList<Card> hand = dealer.dealHand();
		ArrayList<Card> hand2 = dealer.dealHand();
		ArrayList<Card> hand3 = dealer.dealHand();
		Assertions.assertEquals(43, dealer.theDeck.size);
		Assertions.assertEquals(3, hand.size());
		Assertions.assertEquals(3, hand2.size());
		Assertions.assertEquals(3, hand3.size());
	}
	
	void DealerDeckSizeCheckNotDecrease() {
		Dealer dealer = new Dealer();
		// somewhere in here, the card should refill, at hand7
		ArrayList<Card> hand = dealer.dealHand();  // 49
		ArrayList<Card> hand2 = dealer.dealHand();  // 46
		ArrayList<Card> hand3 = dealer.dealHand();  // 43
		ArrayList<Card> hand4 = dealer.dealHand();  //40
		ArrayList<Card> hand5 = dealer.dealHand();  //37
		ArrayList<Card> hand6 = dealer.dealHand();  //34
		ArrayList<Card> hand7 = dealer.dealHand();  // goes down to 33, refill to 52
		// ^^ 52-2 = 50
		Assertions.assertNotEquals(31, dealer.theDeck.size);
	}
//	
	@Test
	void DealerDeckCorrectSizeCheck() {
		Dealer dealer = new Dealer();
		// somewhere in here, the card should refill, at hand7
		ArrayList<Card> hand = dealer.dealHand();  // 49
		ArrayList<Card> hand2 = dealer.dealHand();  // 46
		ArrayList<Card> hand3 = dealer.dealHand();  // 43
		ArrayList<Card> hand4 = dealer.dealHand();  //40
		ArrayList<Card> hand5 = dealer.dealHand();  //37
		ArrayList<Card> hand6 = dealer.dealHand();  //34
		ArrayList<Card> hand7 = dealer.dealHand();  // goes down to 33, refill to 52
		// ^^ 52-2 = 50
		Assertions.assertEquals(3, hand.size());
		Assertions.assertEquals(3, hand2.size());
		Assertions.assertEquals(3, hand3.size());
		Assertions.assertEquals(3, hand4.size());
		Assertions.assertEquals(3, hand5.size());
		Assertions.assertEquals(3, hand6.size());
		Assertions.assertEquals(3, hand7.size());
		Assertions.assertEquals(50, dealer.theDeck.size);
	}
	
};
