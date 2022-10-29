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
	
	public void getURL(){
		return this.url;
	}
	
	public void setImage(){
		switch(value){
			case 2:
				switch(suit){
					case 'C':
						setURL("/2/poker-playing-card-2-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/2/poker-playing-card-2-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/2/poker-playing-card-2-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/2/poker-playing-card-2-spade-miroslav-nemecek.jpg");break();
				}break();
			case 3:
				switch(suit){
					case 'C':
						setURL("/3/poker-playing-card-3-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/3/poker-playing-card-3-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/3/poker-playing-card-3-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/3/poker-playing-card-3-spade-miroslav-nemecek.jpg");break();
				}break();
			case 4:
				switch(suit){
					case 'C':
						setURL("/4/poker-playing-card-4-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/4/poker-playing-card-4-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/4/poker-playing-card-4-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/4/poker-playing-card-4-spade-miroslav-nemecek.jpg");break();
				}break();
			case 5:
				switch(suit){
					case 'C':
						setURL("/5/poker-playing-card-5-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/5/poker-playing-card-5-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/5/poker-playing-card-5-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/5/poker-playing-card-5-spade-miroslav-nemecek.jpg");break();
				}break();
			case 6:
				switch(suit){
					case 'C':
						setURL("/6/poker-playing-card-6-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/6/poker-playing-card-6-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/6/poker-playing-card-6-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/6/poker-playing-card-6-spade-miroslav-nemecek.jpg");break();
				}break();
			case 7:
				switch(suit){
					case 'C':
						setURL("/7/poker-playing-card-7-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/7/poker-playing-card-7-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/7/poker-playing-card-7-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/7/poker-playing-card-7-spade-miroslav-nemecek.jpg");break();
				}break();
			case 8:
				switch(suit){
					case 'C':
						setURL("/8/poker-playing-card-8-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/8/poker-playing-card-8-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/8/poker-playing-card-8-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/8/poker-playing-card-8-spade-miroslav-nemecek.jpg");break();
				}break();
			case 9:
				switch(suit){
					case 'C':
						setURL("/9/poker-playing-card-9-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/9/poker-playing-card-9-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/9/poker-playing-card-9-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/9/poker-playing-card-9-spade-miroslav-nemecek.jpg");break();
				}break();
			case 10:
				switch(suit){
					case 'C':
						setURL("/10/poker-playing-card-10-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/10/poker-playing-card-10-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/10/poker-playing-card-10-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/10/poker-playing-card-10-spade-miroslav-nemecek.jpg");break();
				}break();
			case 11:
				switch(suit){
					case 'C':
						setURL("/jack/poker-playing-card-jack-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/jack/poker-playing-card-jack-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/jack/poker-playing-card-jack-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/jack/poker-playing-card-jack-spade-miroslav-nemecek.jpg");break();
				}break();
			case 12:
				switch(suit){
					case 'C':
						setURL("/queen/poker-playing-card-queen-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/queen/poker-playing-card-queen-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/queen/poker-playing-card-queen-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/queen/poker-playing-card-queen-spade-miroslav-nemecek.jpg");break();
				}break();
			case 13:
				switch(suit){
					case 'C':
						setURL("/king/poker-playing-card-king-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/king/poker-playing-card-king-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/king/poker-playing-card-king-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/king/poker-playing-card-king-spade-miroslav-nemecek.jpg");break();
				}break();
			case 14:
				switch(suit){
					case 'C':
						setURL("/ace/poker-playing-card-ace-club-miroslav-nemecek.jpg");break();
					case 'D':
						setURL("/ace/poker-playing-card-ace-diamond-miroslav-nemecek.jpg");break();
					case 'H':
						setURL("/ace/poker-playing-card-ace-heart-miroslav-nemecek.jpg");break();
					case 'S':
						setURL("/ace/poker-playing-card-ace-spade-miroslav-nemecek.jpg");break();
				}break();
		}
	}
};
