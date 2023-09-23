//SutdaDeck 클래스 : 섯다카드 20장을 포함하는 섯다카드 한 벌을 정의하는 클래스
//섯다카드 20장을 담는 SutdaCard 배열을 초기화하라
//단, 섯다카드는 1~ 10까지의 숫자가 적힌 카드가 한 쌍씩 있고 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광 (Kwang) 이어야 한다 
// 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.

class SutdaDeck {
  //final 상수값 20
  final int CARD_NUM = 20;
  
  //SutdaCard 배열 초기화 크기가 20인 배열
  SutdaCard[] cards = new SutdaCard[CARD_NUM];

  //생성자 -> 반복문을 통해 배열에 숫자를 대입해준다.
  SutdaDeck() {
    
    for(int i = 0; i < cards.length; i++) {
      //나머지에 1을 더해줌 = 각 숫자가 2개씩 나온다 
      int num = i % 10 + 1;
      //i가 10보다 작고, num이 1, 3, 8중에 하나면 true
      boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
      //toString문을 통해 배열에 대입
      cards[i] = new SutdaCard(num, isKwang);
    }
  }
}


class SutdaCard {
  int num;
  boolean isKwang;
  
  //기본생성자
  SutdaCard() {
    this(1, true);
  }

  //생성자
  SutdaCard(int num, boolean isKwang) {
    this.num = num;
    this.isKwang = isKwang;
  }
  
  // info() 대신 Object클래스의 toString()을 오버라이딩했다
  public String toString() {
    //isKwang이 true면 K 아니면 공백
    return num + ( isKwang ? "K":"");
  }
}

class Exercise7_1 {
  
  public static void main(String args[]) {
  //생성자로 인해 sutdaCard 배열 생성
  SutdaDeck deck = new SutdaDeck();
    
  for(int i=0; i < deck.cards.length;i++)
    
    System.out.print(deck.cards[i]+",");
    
  }
}
