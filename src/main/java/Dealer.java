import java.util.ArrayList;

public class Dealer {
	// the dealer possesses the card and the deck
	Deck theDeck;
	ArrayList<Card> dealersHand;

	Dealer() {
		theDeck = new Deck();
		dealersHand = new ArrayList<Card> ();
	}
	
	// getters for deck and dealer hand?
	
	
	public ArrayList<Card> dealHand() {
		ArrayList<Card> h = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			if (theDeck.size < 34) { theDeck.NewDeck();}  // new deck
			h.add(theDeck.remove(0));  // remove returns element removed from collection
			theDeck.size = theDeck.size - 1;
		}
		return h;
	}
	
};
