import java.util.ArrayList;

public class Dealer {
	// the dealer possesses the card and the deck
	Deck theDeck;
	ArrayList<Card> dealersHand;
	String urls[];

	Dealer() {
		theDeck = new Deck(urls);
		dealersHand = new ArrayList<Card> ();
	}
	
	// getters for deck and dealer hand?
	
	public void setURLImages(String urls[]) {
		this.urls = urls;
	}
	
	public ArrayList<Card> dealHand() {
		if (theDeck.size < 34) { theDeck.NewDeck(urls);}  // new deck
		ArrayList<Card> h = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			h.add(theDeck.remove(0));  // remove returns element removed from collection
			theDeck.size--;
		}
		return h;
	}
	
};
