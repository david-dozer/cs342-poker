import java.util.Random;
import java.util.ArrayList;


public class Deck extends ArrayList<Card> {
	int size;
	Card[] deckOfCards = new Card[size];
	Deck(String urls[]) {
		size = 52;
		int count = 0;
        char[] suits = {'D', 'C', 'H', 'S'};
        int[] vals ={2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // cards 2-10, 11-13 are Jack Queen King, respectively, 14 is Ace, highest card

        for (char s : suits) {
            for (int v : vals) {
                Card card = new Card(s, v); card.setURL(urls[count]);       
                this.deckOfCards[count] = card;
                count++;
            }
        }
        this.shuffle();
    }
	
	public void shuffle() {
        Random rand = new Random();
        int j;
        for(int i = 0; i < size; i++) {
            j = rand.nextInt(size);
            Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = temp;
        }
    }
	
	void NewDeck(String urls[]) {
		size = 52;
		this.deckOfCards = deckOfCards = new Card[size];
		int count = 0;
        char[] suits = {'D', 'C', 'H', 'S'};
        int[] vals ={2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // cards 2-10, 11-13 are Jack Queen King, respectively, 14 is Ace, highest card

        for (char s : suits) {
            for (int v : vals) {
            	Card card = new Card(s, v); card.setURL(urls[count]);  
                this.deckOfCards[count] = card;
                count++;
            }
        }
        this.shuffle();
	}
	
};