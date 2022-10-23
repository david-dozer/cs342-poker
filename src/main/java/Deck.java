import java.util.Random;
import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
	
	Card[] deckOfCards = new Card[52];
	Deck(String urls[]) {
		int count=0;

        char[] suits = {'D', 'C', 'H', 'S'};
        int[] vals ={2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // cards 2-10, 11-13 are Jack Queen King, respectively, 14 is Ace, highest card

        for (char s : suits) {
            for (int v : vals) {
                Card card = new Card(s, v, urls[count]);
                this.deckOfCards[count] = card;
                count++;
            }
        }
        this.shuffle();
    }
	
	public void shuffle() {
        Random rand = new Random();
        int j;
        for(int i = 0; i < 52; i++) {
            j = rand.nextInt(52);
            Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = temp;
        }
    }
	
	void NewDeck(String urls[]) {
//		this.shuffle();
	}
	
}
