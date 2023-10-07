package seven;

public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
			
		}
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new SutdaCard(i + 1, false);
			if (i == 1 || i == 3 || i == 8) {
				cards[i - 1] = new SutdaCard(i, true);
			}
			if (i > 9) {
				cards[i] = new SutdaCard((i+1)%11+1, false);
			}
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	SutdaCard() {
		this(1, true);
	}
	
	public String toString() {
		return num + (isKwang ? "K":"");
	}
}
