import java.util.ArrayList;
import java.util.Collections;


public class Deck extends ArrayList<Card> {
	int size;
	// Card[] deckOfCards = new Card[size];
	
	Deck(String urls[]) {
		size = 52;
		int count = 0;
        char[] suits = {'D', 'C', 'H', 'S'};
        int[] vals ={2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // cards 2-10, 11-13 are Jack Queen King, respectively, 14 is Ace, highest card

        for (char s : suits) {
            for (int v : vals) {  // in arrayList, not bracket operator, but get
            	Card card = new Card(s, v);
            	this.add(card); this.get(count).setURL(urls[count]);  
                count++;
            }
        }
        Collections.shuffle(this);
    }
	
	
	void NewDeck(String urls[]) {
		this.clear();
		size = 52;
		int count = 0;
        char[] suits = {'D', 'C', 'H', 'S'};
        int[] vals ={2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // cards 2-10, 11-13 are Jack Queen King, respectively, 14 is Ace, highest card

        for (char s : suits) {
        	for (int v : vals) {  // in arrayList, not bracket operator, but get
            	Card card = new Card(s, v);
            	this.add(card); this.get(count).setURL(urls[count]);  
                count++;
            }
        }
        Collections.shuffle(this);
	}
	
};
