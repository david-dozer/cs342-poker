import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class DeckandDealerTests {
	
	// temp url, real ones put in in the pokerMain
	@BeforeAll
	public String[] urlArray() {
		String urls[] = new String[52];
		for (int i = 0; i < 52; i++) {
			urls[i] = "url";
		}
		return urls;
	}
	
	String urls[] = urlArray();
	Deck deck = new Deck(urls);
	
	@Test
	void testDeckConstructor() {
		Assertions.assertEquals(52, deck.size);
	}
	
	@Test
	void urlsInCards() {
		for (int i = 0; i < 52; i++) {
			Assertions.assertEquals("url", deck.get(i));
		}
	}
	
	@Test
	void newDeckTest( ) {
		deck.NewDeck(urls);
		Assertions.assertEquals(52, deck.size);
		for (int i = 0; i < 52; i++) {
			Assertions.assertEquals("url", deck.get(i));
		}
	}
	
	@Test
	void DealerConstructor( ) {
		Dealer dealer = new Dealer ();
		dealer.urls = urls;
		Assertions.assertEquals(52, dealer.theDeck.size);
		Assertions.assertEquals(0, dealer.dealersHand.size());
	}
	

};

