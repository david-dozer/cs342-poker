public class Card {
	char suit;
	int value;
	String url; // each card retrieved image
	
	public Card(char suit, int value, String url) {
		this.suit = suit;
		this.value = value;
		this.url = url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
};
