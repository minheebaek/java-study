//문제 7-1  SutdaDeck 클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하시오.

1. 
메서드명 : shuffle
기 능 : 배열 에 담긴 카드의 위치를 뒤섞는다 (Math.random() 사용)
반환타입: 없음
매개변수: 없음
2.
메서드명: pick
기 능 : 배열 cards 에서 지정된 위치의 SutdaCard를 반환한다
반환타입: SutdaCard
매개변수: int index - 위치
3.
메서드명: pick 
기 능: 배열 cards에서 임의의 위치의 SutdaCard를 반환한다(Math.random() 사용)
반환타입: SutdaCard
매개변수: 없음

```java
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
  void shuffle() {
    for(int i=0; i<cards.length;i++) {
      int j = (int)(Math.random()*cards.length);
      // cards[i] cards[j] . 와 의 값을 서로 바꾼다
      SutdaCard tmp = cards[i];
      cards[i] = cards[j];
      cards[j] = tmp;
      }
    }
  SutdaCard pick(int index) {
    if(index < 0 || index >= CARD_NUM) // index . 의 유효성을 검사한다
    return null;
    return cards[index];
  }
  SutdaCard pick() {
    int index = (int)(Math.random()*cards.length);
    return pick(index); // pick(int index) . 를 호출한다
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

class Exercise7_2 {
  public static void main(String args[]) {
    SutdaDeck deck = new SutdaDeck();
    System.out.println(deck.pick(0));
    System.out.println(deck.pick());
    deck.shuffle();
    for(int i=0; i < deck.cards.length;i++)
      System.out.print(deck.cards[i]+",");
    System.out.println();
    System.out.println(deck.pick(0));
  }
}
```
