
## 6장 객체지향개념(48강) 

### 1강 객체지향 언어

80년대 초 소프트웨어의 위기-세상이 너무 빨리 변함. → 객체지향언어 도입(절차적 →객체지향), 코드의 재사용성(다른 곳에서도 사용 가능)이 높고 유지보수가 쉬움, 코드 중복도 제거함 프로그래밍 언어 + 객체지향 개념과 규칙 객체지향 언어의 OOP(Object-Oriented Programing)-핵심개념 
(1)캡슐화 
(2)상속 
(3)추상화 
(4)다형성★★ 
공부하는 법 6장 객체지향개념~7장 다형성부분까지 확실히 하고 넘어갈 것. 반복학습을 할 수록 이해도가 올라감. 규칙이기 때문에 암기가 필요함. 규칙을 a4용지에 쓰면 2장정도 나오는데 그것을 매일 볼 것. 

### 2강 클래스와 객체

클래스 : 객체를 정의해 놓은 것, 객체를 생성함(설계도와 비슷한 개념) 
ex) 제품설계도(클래스)를 보고 제품(객체)을 만듦. 객체의 구성요소-속성, 기능 -하드웨어를 가상의 소프트웨어화 시켜서 컴퓨터 안에서 체험가능하게 해줌 -그러기 위해서는 하드웨어의 속성과 기능을 잘 알아야 함 객체와 인스턴스
(1) 객체 : 모든 인스턴스를 대표하는 일반적 용어 
(2)인스턴스 : 특정 클래스로부터 생성된 객체 둘이 거의 같음 

### 3강 한 파일에 여러 클래스 작성

하나의 소스파일에 여러 클래스도 작성할 수도 있다. (단 public class는 유일해야함) -public class가 있는 경우 소스파일의 이름은 반드시 이것과 일치해야 함. -public class가 없는 경우 소스파일과 이름이 동일하지 않아도 됨. 
ex) 소스파일 이름 _Babo
```
public class Babo{} // class 이름은 대문자로 시작하는게 좋음
class Chunjae{} class Baborim{}
//또는
class babo{ 	public static void main(String[]args) }
// main 매서드가 들어있는 class만큼은 소스파일과 일치해야 함. 대소문자도 class Babomong{} class Chunjae{} //가능 ```
```
### 4강 객체의 생성과 사용


#### 객체의 생성 
```
Tv t; // 참조변수t 선언. Tv가 기본형이 아니니 참조형임 
Tv t = new Tv(); // 객체를 연결하여 Tv 객체를 하나 생성한다는 뜻. 객체의 사용(참조변수로만 사용할 수 있다.) 
t.channer = 7; // 참조변수t의 멤버변수 channel의 값을 7로 지정함(변수 사용) 
t.channelDown(); // t의 메서드 channelDown()을 호출함(메서드 사용) 
System.out.println(”현재 채널은 “+t.channel+” 입니다.”); 
```

-맴버 : 하나의 클래스 내에 있는 속성과 메서드(실행)

객체의 생성과 사용 : 객체마다 별도의 저장공간이 생성된다.
``` Tv t1 = new Tv();
Tv t2 = new Tv();
t1.channel = 7;
t2.channel = 5;
System.out.println("t1의 channel값은 " + t1.channel + 입니다."); // 7 출력
System.out.println("t2의 channel값은 " + t2.channel + 입니다."); // 5 출력 ```
```
-하나의 인스턴스를 여러개의 참조변수가 가르키는 경우 (O)

-여러 인스턴스를 하나의 참조변수가 가리키는 경우(X)

### 5강 객체 배열=참조변수 배열
```
Tv tv1, tv2, tv3; //여러개의 참조변수를 배열로 바꿀 수 있음
Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv타입의 참조변수 배열
tvArr tvArr[0] = new Tv(); 
tvArr[1] = new Tv(); 
tvArr[2] = new Tv(); 
//위 코드는 아래와 같다. 
Tv[] tvArr = {new Tv(), new Tv(), new Tv()}; 
```
반드시 배열을 만든 뒤 객체들을 일일이 넣어주어야 한다.

### 6강 클래스의 정의

(1) 설계도

(2) 데이터+함수

변수 → 배열(같은 형끼리만 묶음) → 구조체(다른 형끼리도 묶음) → 클래스(구조체+함수:명령문 묶음)

(3) 사용자정의 타입: 원하는 타입을 직접 만들 수 있다.
```
int hour; // 시간을 다룰 수 있는 클래스를 만들고 그 밑에 함수로 가능하게 함 
int minute; 
int second; 
int hour1, hour2, hour3; 
int minute1, minute2, minute3; 
int second1, second2, second3; 
//이것을 아래와 같이 묶을 수도 있겠지만.. 
int[] hour = new int[3]; 
int[] minute = new int[3]; 
int[] second = new int[3]; 
//전체 시각을 알기 보다는 시/분/초 각각 따로 묶이게 됨. 
//그래서 필요한 것이 class를 만들어 주는 것. 사용자가 원하는 타입으로 만들어줄 수 있다. 
int hour; int minute; 
int second;
class Time{ //Time 이라는 class를 하나 만들어서 	
int hour; 	
int minute; 	
int second; } 
// ↓ 
Time t = new Time(); //변수를 생성해줄 수 있음 
int hour1, hour2, hour3; 
int minute1, minute2, minute3; 
int second1, second2, second3; 
// ↓ 이런 경우도 시분초를 묶어서 
Time t1 = new Time(); //생성된 클래스 Time 에 변수t1 지정 
Time t2 = new Time(); 
Time t3 = new Time(); 
int[] hour = new int[3]; 
int[] minute = new int[3]; 
int[] second = new int[3]; // ↓ 이런 경우도 시분초를 묶어서 
t[0] = new Time(); //시간 배열로 만들어줄 수 있다. 
t[1] = new Time(); t[2] = new Time(); 
```
### 7강 선언위치 변수종류

<aside> 🚉 iv : 인스턴스 변수( 인스턴스가 생성되었을 때 생성됨.)

→객체 : iv를 묶어놓은 것. →객체 생성이 필요하다.

cv : 클래스 변수(클래스가 메모리에 올라갈 때 생성)_앞에 static이 붙으면 cv 안붙으면 iv

→즉, 설계도가 필요할때 자동으로 만들어진다.

→객체생성이 필요없어서 아무때나 사용할 수 있다.

lv : 지역(local)변수 ( 변수 선언문이 수행되었을때)

//클래스 영역 
class AA{ 	
int iv; //인스턴스 변수. iv(변수)를 모으면 객체가 된다. 	
static int cv; //static이 붙으면 클래스변수 
//메소드 영역 	
void method(){ 	
int lv=0; //로컬변수=지역변수 	} 

</aside>

### 8강 클래스 변수와 인스턴스 변수

<aside> 🚉 속성중에 1. 각 객체마다 개별적인 값을 가져야 하는 경우 2. 객체마다 공통적인 값을 가져야 하는 경우가 있는데, 개별속성은 iv, 공통속성은 cv로 설정한다.

</aside>

```
class Card{ 	//개별 속성=iv 	
String kind; //카드의 무늬 	
int num; //카드의 숫자 	
//공통 속성=cv 	
static int width=100; //폭 	
static int heigth=200; //높이 } 
public class{ 	
main메소드(){ 		//객체 생성 		
Card c =new Card(); 		//iv는 객체의 참조변수가 필요함. => 객체가 반드시 만들어진 후 생성 		
c.kind="Heart"; 		
c.num=5; 		//cv는 객체의 참조변수가 필요 없음=>class명을 호출하면 		Card.wigth=200; 		Card.heigt=300; 	} } 
```
### 9강 메소드1(~선언부와 구현부까지)

→문장들을 묶어놓은 것.(작업단위로)

→하나의 작업을 작성해주고 메소드 이름을 만들어주면 된다.

<aside> 📣 메소드를 사용하는 이유

코드의 중복을 제거하기 위해서 사용자가 사용을 편하게 하게하려고 표면적으로 보여지는 객체를 간결하게 하려고 

</aside>

<aside> 📝 메소드의 장점

코드의 중복을 줄일 수 있음 작업단위로 나뉘어져 있기 때문에 관리하기가 쉽다. 코드를 재사용 할 수 있다. 코드가 간결해져서 이해하기 쉬워진다. 

</aside>

→메소드 = 선언부+구현
```
//선언부(매개변수의 개수는 0 - n개까지) 
반환타입(작업결과의 자료형) 
메소드 이름(타입 변수명, 타입 변수명, .../*매개변수*/) 
//구현부 {
//메소드 호출시 실행될 코드 } //출력값은 0~1개 밖에 없기 때문에 객체 배열을 활용해준다.
//출력값(반환값)이 없을땐 반환타입을 void라고 해주면 된다. 
```
→메소드의 구현부

<aside> 📝 지역변수(lv): 메소드 내에 선언된 변수.

→한 메소드 영역에서만 유효하기 때문에 다른 메소드영역이나 외부의 변수들과 겹쳐도 상관 없다.
```
//메소드영역1 
int add(int x, int y){ // 매개변수1,2
int result=x+y;
return result; 				//반환값 }
//메소드영역2
int multiply(int x,int y){
int result=x*y;
return result; } 
```
</aside>

### 10강 메소드2(메소드의 호출~)
```
메서드이름(값1, 값2); 
print(); //void print()를 호출. void라 작업결과가 없어서 반환값이 X 
int result = add(3,5);
int add(int x, int y) 를 호출하고 결과를 result에 저장 
//변수에 저장해서 사용 
```
매개변수 : 호출까지의 중간 매개체가 된다고 해서 매개변수임

→메소드는 클래스영역에서만 정의가 가능하다.

### 11강 return문

→반환타입이 void가 아닌 경우 반드시 return문 필요

→참/거짓 둘다 return값이 출력되도록 해야함

### 12강 호출스택(Stack)

→메소드 수행에 필요한 메모리가 제공되는 공간

→메소드가 호출되면 호출스택에 메모리 할당. 메소드 종료되면 해제.

<aside> 📝 스택 : 밑이 막힌 상자. 점차 차곡차곡 쌓이는 걸 상상해봐라 이러한 상자는 위에 뚫린 공간으로만 넣고 뺄 수 있다. 스택도 마찬가지

</aside>

### 13강 기본형/참조형 매개변수

<aside> 📝 기본형 매개변수: 메인메소드에 영향 , 읽기만 가능 참조형 매개변수 : 객체를 다룰 수 있는 리모콘을 줌. 메인메소드의 객체의 주소를 불러오는 것.→ 영향O, 읽고 쓰기 가능 참조형 반환타입:

</aside>

### 14강 static 메소드

→속성(멤버변수) 중에서 공통 속성에 static 붙인다.
```
class AA{ 	//iv 변수 	
int x, y; 	//인스턴스 메서드, iv 사용 	
int add(){ resturn a+b; }	 	//클래스 메소드(static 메소드), lv 변수 	
static void add(int a, int b){return a+b} 	// 매개변수: lv변수 } 
```
→클래스 메서드: 객체 생성 없이 호출이 가능
```
class AA2{ 	//메인 메서드
public static void main(String[]args){ 		//클래스메소드 호출
System.out.println(AA.add(200,200); 		//위 클래스의 인스턴스(객체) 생성
AA a = new AA(); 		//객체를 생성했으니 iv 변수, 값 생성
a.a=200;
a.b=200; 		//인스턴스 메소드 호출
System.out.println(a.add()); 		// 참조변수.메소드이름() 
```
→static 메소드: 인스턴스멤버(iv,im)를 사용하지 않을때 static을 붙임

→static 변수는 공통변수이기 때문에 객체생성 안하고 아무때나 쓸 수 있다.
```
class AA{
  int iv; //인스턴스 변수
  static int cv; // 어디에서나 쓰일 수 있는 클래스변수
  //
  //인스턴스 메소드
  void instanceMethod(){
    System.out.println(iv); // O
    System.out.println(cv); // O
  }
  //static 메소드: 객체 생성 없이 호출 가능. 객체생성과 상관없이 공유할때 사용
  static void instanceMethod(){
    System.out.println(iv); // X static메소드는 인스턴스 변수 사용불가
    System.out.println(cv); // O 클래스변수는 사용 가능
  }
}
class AA{
  void instanceMethod(){} //인스턴스 메소드
  static void staticMethod(){} // static 메소드
  //인스턴스 메소드
  void instanceMethod2(){
    instanceMethod(); //O: 다른 인스턴스를 호출
    staticMethod(); //O: static메소드를 호출
  }
  static void staticMethod2(){
  instanceMethod(); //X static메소드에서 im을 출력할 수 있다.
  staticMethod(); //O static메소드 안에서도 출력 가능.
  }
} 
```
### 15강 오버로딩: Overloading((같은 메소드를)과적하다.)

→한 클래스 안에 같은 이름의 메소드를 여러 개 정의 하는 것

→왜해? 매개변수는 다르지만 의미상 같은 일을 할때 사용해줌

→대표적인 예 void println()

<aside> 🤭 오버로딩 작성 조건

메소드 이름은 같게 매개변수의 개수 또는 타입이 달라야 함 반환 타입(return)은 영향X int add(int a, int b){return a+b;} // 같게 개수/타입 다르게 상관X 

</aside>

### 16강 생성자(constructor)

→인스턴스가 생성될 때마다 호출되는 ‘인스턴스(iv) 초기화 메소드’
```
Time t = new Time();
t.hour =12;
t.minute = 34;
t.second = 56; //위의 복잡함을 아래처럼 간결하게 표현해주기 위해 생성자를 쓴다.
Time t = new Time(12,34,56); 
```
<aside> 🐟 규칙

생성자명=클래스명 리턴값X(+void 안붙임) 모든 클래스는 반드시 하나 이상의 생성자를 가짐 

</aside>

기본 생성자 : 매개변수가 없는 생성자 클래스이름(){ } →생성자가 하나도 없을때, 컴파일러가 자동으로 추가해줌 매개변수가 있는 생성자 ⇒ 객체 만들때 꼭 값을 넣어주어야 함. 

### 17강 생성자 this()

→생성자에서 다른 생성자 호출할때 사용(코드의 중복을 제거하기 위해서)

→다른 생성자 호출시 첫 줄에서만 사용 가능
```
class Car{
  String color;
  String gearType;
  int door;
  //기본생성자
  Car(){ //디폴트값
  color ="Mint";
  gearType = "Auto";
  door=4; 	}

  //생성자
  Car(String a, String b, int c){
    color =a;
    gearType = b;
    door=c;
  }
```
### 17-1강 참조변수 this(≠생성자 this)

→인스턴스 자신을 가리키는 참조변수. 인스턴스의 주소가 저장되어 있음 →iv의 진짜 이름 this.변수. this.이 생략되어 있었을 뿐

→ 인스턴스 메소드(생성자포함)에서만 사용가능

→lv(그냥 변수)와 iv(this.변를 구분해주기 위해 사용함

//this를 안붙여주면 얘로 받는다. ↓ Car(String color, String gearType, int door){ // iv lv 	this.color=color; 	this.gearType = gearType; 	this.door=door; } 

→같은 클래스 안에서는 this 생략이 가능하나..

→생성자의 매개변수가 있으면 생략X iv가 아니라 lv가 되어버림

### 18강 변수의 초기화, 멤버변수의 초기화

