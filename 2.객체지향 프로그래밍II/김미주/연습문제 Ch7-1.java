class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];
    SutdaDeck() {
        for(int i=0;i<20;i++){
            int num = i%10+1;
            boolean isKwang = false;
            if(num<10 && num==1 || num==3 || num==8 ){
                isKwang = true;
            }
            cards[i] = new SutdaCard(num,isKwang);
        }
    /*
        (1) 배열 SutdaCard를 적절히 초기화 하시오
     */
    }
}
class SutdaCard {
    int num;
    boolean isKwang;
    SutdaCard() {
        this(1, true);
    }
    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    // info()대신 Object 클래스의 toString()을 오버라이딩했다
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
class Exercise7_1 {
    public static void main(String args[]) {
        SutdaDeck deck = new SutdaDeck();
        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
    }
}