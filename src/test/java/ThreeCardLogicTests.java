import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ThreeCardLogicTests {

	@BeforeEach
	public String[] urlArray() {
		String urls[] = new String[52];
		for (int i = 0; i < 52; i++) {
			urls[i] = "url";
		}
		return urls;
	}
	
	@Test
	void testEvalHandHighCard() {
		ArrayList<Card> hand = new ArrayList<Card> ();
		hand.add(new Card('C', 14)); hand.get(0).setURL("url");
		System.out.printf(hand.get(0).suit + " " + hand.get(0).value, " ");
		hand.add(new Card('D', 2)); hand.get(1).setURL("url");
		hand.add(new Card('S', 3)); hand.get(2).setURL("url"); 
		Assertions.assertEquals(0, ThreeCardLogic.evalHand(hand));
	}

}
