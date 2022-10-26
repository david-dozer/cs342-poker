import java.util.ArrayList;

public class Dealer {
	// the dealer possesses the card and the deck
	Deck theDeck;
	ArrayList<Card> dealersHand;
	String urls[];

	Dealer() {
		theDeck.NewDeck(urls);
		dealersHand = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			dealersHand.add(theDeck.deckOfCards[i]);
			theDeck.size--;
		}
	}
	
	public ArrayList<Card> dealHand() {
		if (theDeck.size < 34) { theDeck.NewDeck(urls);}  // new deck
		ArrayList<Card> h = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			h.add(theDeck.deckOfCards[i]);
			theDeck.size--;
		}
		return h;
	}
	
};