package seven;

public class Exercise7_2 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
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
	
	void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int rand = (int)(Math.random()*CARD_NUM);
			SutdaCard temp = cards[rand];
			cards[rand] = cards[i];
			cards[i] = temp;
		}
	}
	
	SutdaCard pick(int index) {
		return cards[index];
	}
	
	SutdaCard pick() {
		return cards[(int)(Math.random()*CARD_NUM)];
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
