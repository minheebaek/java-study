class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM]; // 하나의 카드덱
    SutdaDeck(){
        for (int i = 0; i < cards.length; i++) {
            int num = i%10+1;

            boolean Kwang = (10 > i) && (num == 1 || num == 3 || num == 8);
            cards[i] =new SutdaCard(num, Kwang); // 하나의 카드덱에 새로운 카드20개를 생성

        }
    }
}

class SutdaCard{
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

class Exercise7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();
        System.out.println(deck.cards.hashCode());
        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i].hashCode() + ",");

        }
        System.out.println(0/10);
    }
}