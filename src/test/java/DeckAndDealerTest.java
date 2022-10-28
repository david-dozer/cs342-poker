import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class DeckandDealerTests {
	
	// temp url, real ones put in in the pokerMain
	public static void urlArray(String[] urls) {
		for (int i = 0; i < 52; i++) {
			urls[i] = "url";
		}
	}
	
	
	@Test
	void testDeckConstructor() {
		String urls[] = new String[52];
		urlArray(urls);
		Deck deck = new Deck(urls);
		Assertions.assertEquals(52, deck.size);
	}
	
	@Test
	void urlsInCards() {
		String urls[] = new String[52];
		urlArray(urls);
		Deck deck = new Deck(urls);
		for (int i = 0; i < 52; i++) {
			Assertions.assertEquals("url", deck.get(i).url);
		}
	}
//	
	@Test
	void newDeckTest( ) {
		String urls[] = new String[52];
		urlArray(urls);
		Deck deck = new Deck(urls);
		deck.NewDeck(urls);
		Assertions.assertEquals(52, deck.size);
		for (int i = 0; i < 52; i++) {
			Assertions.assertEquals("url", deck.get(i).url);
		}
	}
//	
	@Test
	void DealerConstructor( ) {
		String urls[] = new String[52];
		urlArray(urls);
		Dealer dealer = new Dealer();
		dealer.urls = urls;
		Assertions.assertEquals(52, dealer.theDeck.size);
		Assertions.assertEquals(0, dealer.dealersHand.size());
	}
	

};

