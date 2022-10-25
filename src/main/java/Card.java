public class Card {
	char suit;
	int value;
	String url; // each card retrieved image
	
	public Card(char suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
};
