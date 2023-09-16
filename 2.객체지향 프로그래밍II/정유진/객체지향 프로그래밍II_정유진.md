## 1. 상속(inheritance)

### 상속

: **기존의 클래스를 재사용**해서 새로운 클래스 작성
: 자손은 조상의 모든 멤버(생성자, 초기화블럭 제외)를 상속받음
: 자손의 멤버개수 >= 조상의 멤버개수
: Java는 단일상속만 허용
: '**~은 ~이다.**'를 가지고 문장을 만들었을 때 말이 되면 상속관계 ex) 원은 도형이다

> class 자손클래스 extends 조상클래스 {
> 

```java
class Parent {}class Child extends Parent {}class Child2 extends Parent {}class GrandChild extends Child {}
```

!https://blog.kakaocdn.net/dn/bg5rio/btsufX0JxBC/36HM8pcmVqlQkPhDmgtQ50/img.png

### 포함(composite)

: 한 클래스의 **멤버변수**로 다른 클래스 선언
: 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 함
: '**~은 ~을 가지고 있다.**'를 가지고 문장을 만들었을 때 말이 되면 포함관계 ex) 원은 점을 가지고 있다

```java
class Point {	int x;	int y;}class Circle {	Point c = new Point();	int r;}
```

### Object 클래스

: 모든 클래스의 최고 조상
: 모든 클래스 Object 클래스에 정의된 11개의 메서드 상속받음

## 2. 오버라이딩(overriding)

### 오버라이딩

: 조상클래스로부터 상속받은 메서드의 내용을 상속받는 클래스에 맞게 변경
: 선언부 변경 불가. 구현부만 변경 가능

```java
class MyPoint {	int x;	int y;	public MyPoint(int x, int y) {		this.x = x;		this.y = y;	}// Object 클래스의 toString()을 오버라이딩	public String toString() {		return "x:"+x+" y:"+y;	}}class MyPoint3D extends MyPoint {	int z;	MyPoint3D(int x, int y, int z) {		super(x, y);		this.z = z;	}// Point 클래스의 toString()을 오버라이딩	public String toString() {		return "x:"+x+" y:"+y+" z:"+z;	}}
```

### 오버라이딩 조건

1. 선언부가 조상클래스의 메서드와 일치(이름, 매개변수, 반환타입)
2. 접근제어자를 좁은 범위로 변경할 수 없음
3. 조상클래스의 메서드보다 많은 수의 예외 선언 불가

### 오버로딩 vs 오버라이딩

- 오버로딩(overloading) : 기존에 없는 새로운(new) 메서드 정의
- 오버라이딩(overriding) : 상속받은 메서드의 내용 변경(change)

```java
class Parent {	void parentMethod() {}}class Child extends Parent {	void parentMethod() {}// 오버라이딩	void parentMethod(int i) {}// 오버로딩	void childMethod() {}	void childMethod(int i) {}// 오버로딩	void childMethod() {}// 에러. 중복정의 }
```

### 조상클래스의 생성자 - super()

: 모든 클래스의 생성자 첫 줄에 생성자 this() 또는 super() 를 호출해야 함

```java
public class PointTest {	public static void main(String[] args) {		Point3d p = new Point3d(1, 2, 3);	}}class Point3 {	int x, y;	public Point3() {	}	public Point3(int x, int y) {		this.x = x;		this.y = y;	}	String getLocation() {		return "x:"+x+", y:"+y;	}}class Point3d extends Point3 {	int z;	public Point3d(int x, int y, int z) {		super(x, y);		this.z = z;	}	String getLocation() {		return super.getLocation()+", z:"+z;	}}
```

### 참조변수 - super

: 조상의 멤버와 자신의 멤버를 구별하는 데 사용
: 인스턴스 메서드에서만 사용

```java
public class SuperTest {	public static void main(String[] args) {		Child c = new Child();		c.method();	}}class Parent {	int x = 10;}class Child extends Parent {	int x = 20;	void method() {		System.out.println("x="+x);		System.out.println("this.x="+this.x);		System.out.println("super.x="+super.x);	}}
```

> x=20
> 

## 3. package와 import

### 패키지(package)

: 서로 관련된 클래스와 인터페이스의 묶음
: 하나의 소스파일에는 첫 번째 문장으로 단 한 번의 패키지 선언만을 허용
: 모든 클래스는 반드시 하나의 패키지에 속해야 함(default 패키지 포함)
: 점(.)을 구분자로 하여 계층구조로 구성

> package 패키지명;
> 

```java
package com.coding.book;public class PackageTest {	public static void main(String[] args) {		System.out.println("Hello World");		System.out.println(Math.floor(1.8));	}}
```

### import문

: 사용할 클래스가 속한 패키지를 지정하는 데 사용
: 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보 제공
: import문을 사용하면 소스코드에 사용되는 클래스이름에서 **패키지명 생략** 가능
: 이클립스에서는 'ctrl+shift+o' 단축키 사용해서 자동으로 import문 생성
: import static을 사용하면 static멤버를 호출할 때 클래스 이름 생략 가능

> import 패키지명.클래스명;
> 
- import문에서 클래스 이름 대신 '*' 사용하는 것이 하위 패키지의 클래스까지 포함하는 건 아님

```java
package com.coding.book;import static java.lang.System.out;import static java.lang.Math.*;public class PackageTest {	public static void main(String[] args) {		out.println("Hello World");		System.out.println(floor(1.8));	}}
```

> ① package문
> 

## 4. 제어자(modifiers)

: 클래스, 변수, 메서드의 선언부에 사용되어 부가적인 의미 부여

### static - 클래스의, 공통적인

: static 변수는 인스턴스에 관계없이 공통적인 값 가짐
: static 멤버변수, 메서드, 초기화 블럭은 인스턴스 생성하지 않고도 사용 가능

> static이 사용될 수 있는 곳 : 멤버변수, 메서드, 초기화 블럭
> 

```java
class StaticTest {	static int width = 200;// static 변수	static int height = 120;// static 변수	static {// static 변수의 복잡한 초기화 수행	}	static int max(int a, int b) {// static 메서드		return a > b ? a : b;	}}
```

### final - 마지막의, 변경될 수 없는

: 변수에 사용되면 값을 변경할 수 없는 상수가 됨
: 메서드에 사용되면 오버라이딩 불가
: 클래스에 사용되면 자손클래스 정의 불가

> final이 사용될 수 있는 곳 : 클래스, 메서드, 멤버변수, 지역변수
> 

```java
class FinalTest {// 조상이 될 수 없는 클래스	final int MAX_SIZE = 10;// 상수 멤버변수	final int getMaxSize() {// 오버라이딩할 수 없는 메서드		final int LV = MAX_SIZE;// 상수 지역변수		return LV;	}}
```

### abstract - 추상의, 미완성의

: 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드 선언에 사용됨
: 추상클래스에 사용됨

> abstract이 사용될 수 있는 곳 : 클래스, 메서드
> 

```java
abstract class AbstractTest {	abstract void move();}
```

### 접근 제어자(aceess modifier)

: 멤버 또는 클래스에 사용되어, 외부로부터의 접근 제한

: 접근 제어자는 최대한 좁히고 필요할 때 넓힌다

> 접근 제어자가 사용될 수 있는 곳 : 클래스, 메서드, 멤버변수, 생성자
> 

| public | 접근 제한 전혀 없음 |
| --- | --- |
| protected | 같은 패키지 내에서, 다른 패키지의 자손 클래스에서 접근 |
| (default) | 같은 패키지 내에서만 접근 |
| private | 같은 클래스 내에서만 접근 |

!https://blog.kakaocdn.net/dn/bG77iB/btsudiLoT0s/DmExB3ZcmN3XQRXMmnvY60/img.png

```java
class Time {	private int hour;// 0~23 사이의 값으로 제한	private int minute;	private int second;	Time() {}	Time(int hour, int minute, int second) {		this.hour = hour;		this.minute = minute;		this.second = second;	}	public int getHour() {return hour;}	public void setHour(int hour) {		if (!isValidHour(hour)) {			return;		}		this.hour = hour;	}	private boolean isValidHour(int hour) {		return hour >= 0 && hour <= 23;	}	public int getMinute() {return minute;}	public void setMinute(int minute) {		if(!isValidMinute(minute)) {			return;		}		this.minute = minute;	}	private boolean isValidMinute(int minute) {		return isValidSecond(minute);	}	public int getSecond() {return second;}	public void setSecond(int second) {		if (!isValidSecond(second)) {			return;		}		this.second = second;	}	public boolean isValidSecond(int second) {		return second >= 0 && second <= 59;	}	public String toString() {		return hour+":"+minute+":"+second;	}}public class TimeTest {	public static void main(String[] args) {		Time t = new Time(12, 35, 30);		System.out.println(t);		t.setHour(t.getHour()+1);		System.out.println(t);	}}
```

### 제어자의 조합

1. 메서드에 static과 abstract 함께 사용 불가
2. 클래스에 abstract와 final 동시 사용 불가
3. abstract 메서드의 접근 제어자로 private 불가
4. 메서드에 private와 final 같이 사용할 필요 없음

| 대상 | 사용 가능한 제어 |
| --- | --- |
| 클래스 | public, (default), final, abstract |
| 메서드 | 모든 접근 제어자, final, abstract, static |
| 멤버변수 | 모든 접근 제어자, final, static |
| 지역변수 | final |

## 5. 다형성(polymorphism)

### 다형성

: 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있게 함
: **참조변수의 타입**이 참조변수가 참조하고 있는 인스턴스에서 사용할 수 있는 **멤버의 개수** 결정
: 조상타입의 참조변수로 자손타입의 인스턴스 참조 가능(반대는 불가)

```java
class Tv {	boolean power;	int channel;	void power() {power = !power;}	void channelUp() {++channel;}	void channelDown() {--channel;}}class CaptionTv extends Tv {	boolean caption;	void displayCaption(String text) {		if (caption) {			System.out.println(text);		}	}}class CaptionTvTest {	public static void main(String[] args) {    	CaptionTv ctv = new CaptionTv();        Tv t = new CaptionTv();        }}
```

!https://blog.kakaocdn.net/dn/LlPko/btsufYFnS8U/B7MWHV4IMuEktdk2Ch3SaK/img.png

둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버 개수 달라짐

### 참조변수의 형변환

: 사용할 수 있는 멤버의 개수 조절
: 조상-자손 관계에서만 가능

> 자손타입 -> 조상타입 : 형변환 생략가능
> 

```java
public class CastingTest1 {	public static void main(String[] args) {		Car car = null;		FireEngine fe = new FireEngine();		FireEngine fe2 = null;		fe.water();		car = (FireEngine)fe;//		car.water(); // 에러		fe2 = (FireEngine)car;		fe2.water();	}}class Car {	String color;	int door;	void drive() {		System.out.println("drive");	}	void stop() {		System.out.println("stop");	}}class FireEngine extends Car {	void water() {		System.out.println("water");	}}
```

### instanceof 연산자

: 참조변수가 참조하는 인스턴스의 실제 타입을 체크하는 데 사용
: 연산결과가 true이면, 해당 타입으로 형변환 가능

```java
public class InstanceofTest {	public static void main(String[] args) {		FireEngine fe = new FireEngine();		if (fe instanceof FireEngine) {			System.out.println("This is FireEngine instance.");		}		if (fe instanceof Car) {			System.out.println("This is Car instance.");		}		if (fe instanceof Object) {			System.out.println("This is Object instance.");		}		System.out.println(fe.getClass().getName());	}}
```

> This is FireEngine instance.
> 

### 참조변수와 인스턴스변수의 연결

: 메서드가 중복정의된 경우, 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드) 호출
: 멤버변수가 중복정의된 경우, 참조변수의 타입에 따라 달라짐

```java
public class BindingTest3 {	public static void main(String[] args) {		Parent2 p = new Child4();		Child4 c = new Child4();		System.out.println("p.x = "+p.x);		p.method();		System.out.println();		System.out.println("c.x = "+c.x);		c.method();	}}class Child4 extends Parent2 {	int x = 200;	void method() {		System.out.println("x="+x);		System.out.println("super.x="+super.x);		System.out.println("this.x="+this.x);	}}
```

### 매개변수의 다형성

: 참조형 매개변수는 메서드 호출 시, 자신과 같은 타입 또는 자손타입의 인스턴스 넘겨줄 수 있음

```java
public class PolyArgumentTest {	public static void main(String[] args) {		Buyer b = new Buyer();		b.buy(new Tv2());		b.buy(new Computer());		System.out.println("현재 남은 돈은 "+b.money+"만원입니다.");		System.out.println("현재 보너스점수는 "+b.bonusPoint+"점입니다.");	}}class Product {	int price;	int bonusPoint;	Product(int price) {		this.price = price;		bonusPoint = (int)(price / 10.0);	}	Product() {}}class Tv2 extends Product {	Tv2() {		super(100);	}	public String toString() {		return "Tv";	}}
```

> Tv을/를 구입하셨습니다.
> 

### 여러 종류의 객체를 배열로 다루기

: 조상타입의 배열에 자손들의 객체를 담을 수 있음

```java
import java.util.Vector;public class PolyArgumentTest3 {	public static void main(String[] args) {		Buyer2 b = new Buyer2();		Tv2 tv = new Tv2();		Computer com = new Computer();		Audio audio = new Audio();		b.buy(tv);		b.buy(com);		b.buy(audio);		b.summary();		b.refund(com);		b.summary();	}}class Buyer2 {	int money = 1000;	int bonusPoint = 0;	Vector item = new Vector();	void buy(Product p) {		if (money < p.price) {			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");			return;		}		money -= p.price;		bonusPoint += p.bonusPoint;		item.add(p);		System.out.println(p+"을/를 구입하셨습니다.");	}	void refund(Product p) {		if (item.remove(p)) {			money += p.price;			bonusPoint -= p.bonusPoint;			System.out.println(p+"을/를 반품하셨습니다.");		}		else {			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");		}	}	void summary() {		int sum = 0;		String itemList = "";		if (item.isEmpty()) {			System.out.println("구입하신 제품이 없습니다.");			return;		}		for (int i = 0; i < item.size(); i++) {			Product p = (Product)item.get(i);			sum += p.price;			itemList += (i == 0) ? ""+p : ", "+p;		}		System.out.println("구입하신 물품의 총 금액은 "+sum+"만원입니다.");		System.out.println("구입하신 제품은 "+itemList+"입니다.");	}}
```

> Tv을/를 구입하셨습니다.
> 

## 6. 추상클래스(abstract class)

### 추상메서드

: 선언부만 있고 구현부가 없는 메서드
: 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우에 사용

> abstract 반환타입 메서드이름();
> 

### 추상클래스

: 미완성 메서드(추상메서드)를 포함하고 있는 클래스
: 인스턴스 생성 불가
: 상속을 통해 **자손클래스에 의해서만 완성**

> abstract class 클래스이름 {
> 

```java
abstract class Player3 {// 추상클래스	boolean pause;	int currentPos;	Player3() {		pause = false;		currentPos = 0;	}	abstract void play(int pos);// 추상메서드	abstract void stop();// 추상메서드}class CDPlayer extends Player3 {	void play(int pos) {...}// 추상메서드 구현	void stop() {...}// 추상메서드 구현}
```

## 7. 인터페이스(interface)

### 인터페이스

> 추상메서드의 집합
> 

: 실제 구현된 것이 전혀 없는 기본 설계도
: **추상메서드와 상수만을 멤버로 가짐** vs 추상클래스 : 추상메서드를 가진 일반 클래스
: 인스턴스 변수 가질 수 없음
: jdk 1.8부터 static 메서드와 디폴트 메서드 가능

> ]interface 인터페이스이름 {
> 
- 인터페이스 조건
- 모든 멤버변수는 public static final이어야 하며 생략 가능
- 모든 메서드는 public abstract이어야 하며 생략 가능
- 인터페이스는 인터페이스로부터만 상속받을 수 있음(Object가 최고 조상 아님)
- 다중상속 가능하나 그런 경우는 거의 없음

```java
interface Movable {	void move(int x, int y);}interface Attackable {	void attack(Unit u);}interface Fightable extends Moveable, Attackable {}
```

### 인터페이스의 구현

: 추상클래스의 완성과 동일. but, 사용하는 키워드(implements)만 다름
: 일부만 구현한다면 abstract 붙여서 추상클래스로 선언해야 함

> class 클래스이름 implements 인터페이스이름 {
> 

```java
class UnitState {	int currentHP;	int x;	int y;}interface Moveable {	void move(int x, int y);// public abstract 생략}interface Attackable {	void attack(UnitState u);// public abstract 생략}interface Fightable2 extends Moveable, Attackable {}class Fighter2 extends UnitState implements Fightable2 {// 인터페이스 구현	public void move(int x, int y) {}	public void attack(UnitState u) {}}public class FighterTest2 {	public static void main(String[] args) {		Fighter2 f = new Fighter2();		if (f instanceof UnitState) {			System.out.println("f는 UnitState의 자손입니다.");		}		if (f instanceof Fightable2) {			System.out.println("f는 Fightable 인터페이스를 구현했습니다.");		}		if (f instanceof Moveable) {			System.out.println("f는 Moveable 인터페이스를 구현했습니다.");		}		if (f instanceof Attackable) {			System.out.println("f는 Attackable 인터페이스를 구현했습니다.");		}		if (f instanceof Object) {			System.out.println("f는 Object의 자손입니다.");		}	}}
```

> f는 UnitState의 자손입니다.
> 

### 인터페이스를 이용한 다형성

: 인터페이스도 이를 구현한 클래스의 조상이라 할 수 있으므로 다형성 적용 가능
: 인터페이스를 매개변수와 반환타입으로 지정 가능
: 인터페이스 **매개변수**는 메서드 호출 시 해당 인터페이스 **구현한 클래스의 인스턴스를 매개변수로 제공**
: 인터페이스 **반환타입**은 메서드가 해당 인터페이스 **구현한 클래스의 인스턴스를 반환**

```java
interface Parseable {	public abstract void parse(String filename);}class XMLParser implements Parseable {	public void parse(String filename) {		System.out.println(filename+"- XML parsing completed.");	}}class HTMLParser implements Parseable {	public void parse(String filename) {		System.out.println(filename + "- HTML parsing completed.");	}}class ParserManager {// 리턴타입이 Parseable 인터페이스인 메서드	public static Parseable getParser(String type) {		if (type.equals("XML")) {//XMLParser x = new XMLParser();//return x;			return new XMLParser();		}		else {			return new HTMLParser();		}	}}public class ParserTest {	public static void main(String[] args) {		Parseable parser = ParserManager.getParser("XML");		parser.parse("document.xml");		parser = ParserManager.getParser("HTML");		parser.parse("document2.html");	}}
```

### 인터페이스의 이해

: 두 대상(객체) 간의 중간 역할
: 선언(설계)와 구현을 분리시키는 것을 가능하게 함

```java
class A {	void autoPlay(I i) {		i.play();	}}interface I {	void play();}class B implements I {	public void play() {		System.out.println("play in B class");	}}class C implements I {	public void play() {		System.out.println("play in C class");	}}public class InterfaceTest {	public static void main(String[] args) {		A a = new A();		a.autoPlay(new B());		a.autoPlay(new C());	}}
```

> play in B class
> 

### 디폴트 메서드(default method) - jdk 1.8부터

: 추상 메서드의 기본적인 구현 제공
: 디폴트 메서드가 추가되어도 해당 인터페이스를 구현한 클래스는 변경 필요 없음

- 디폴트 메서드와 기존 메서드 이름 충돌 해결 규칙
1. 여러 인터페이스의 디폴트 메서드 간의 충돌 - 구현 클래스에서 디폴트 메서드 오버라이딩
2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌 - 조상 클래스의 메서드 우선적으로 상속
- > 헷갈리면 직접 오버라이딩할 것!

```java
interface MyInterface {	default void method1() {		System.out.println("method1() in MyInterface");	}	default void method2() {		System.out.println("method2() in MyInterface");	}	static void staticMethod() {		System.out.println("staticMethod() in MyInterface");	}}interface MyInterface2 {	default void method1() {		System.out.println("method1() in MyInterface2");	}	static void staticMethod() {		System.out.println("staticMethod() in MyInterface2");	}}class Parent5 {	public void method2() {		System.out.println("method2() in Parent");	}}class Child5 extends Parent5 implements MyInterface, MyInterface2 {	public void method1() {		System.out.println("method1() in Child");	}}public class DefaultMethodTest {	public static void main(String[] args) {		Child5 c = new Child5();		c.method1();		c.method2();		MyInterface.staticMethod();		MyInterface2.staticMethod();	}}
```

## 8. 내부 클래스(inner class)

### 내부 클래스

: 클래스 안에 선언된 클래스
: 내부 클래스에서 외부 클래스의 멤버들 쉽게 접근 가능
: 코드의 복잡성 줄임(캡슐화)

```java
class A {// 외부 클래스    class B {// 내부 클래스// 객체 생성 없이도 A의 멤버 접근 가능    }}
```

| 내부 클래스 | 특징 |
| --- | --- |
| 인스턴스 클래스 | 외부 클래스의 멤버변수 선언위치에 선언. 외부 클래스의 인스턴스 멤버처럼 다뤄짐 |
| static 클래스 | 외부 클래스의 멤버변수 선언위치에 선언. 외부 클래스의 static 멤버처럼 다뤄짐 |
| 지역 클래스 | 외부 클래스의 메서드나 초기화 블럭 안에 선언 |
| 익명 클래스 | 클래스 선언과 객체 생성을 동시에 하는 일회용 클래스 |
- 내부 클래스 특징
- 모든 접근 제어자 사용 가능
- static 내부 클래스에서는 외부 클래스의 인스턴스 멤버 접근 불가
- 외부 클래스의 private 멤버 접근 가능
- 외부 클래스의 지역변수는 상수만 접근 가능(jdk 1.8부터는 변수여도 값이 바뀌지 않으면 상수 취급)
- 인스턴스클래스의 인스턴스 생성하려면 외부 클래스의 인스턴스 먼저 생성해야 함

```java
public class InnerEx3 {	private int outerIv = 0;	static int outerCv = 0;	class InstanceInner {		int iiv = outerIv;// 외부 클래스의 private 멤버도 접근 가능		int iiv2 = outerCv;	}	static class StaticInner {// static 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다//		int siv = outerIv;		static int scv = outerCv;	}	void myMethod() {		int lv = 0;		final int LV = 0;		class LocalInner {			int liv1 = outerIv;			int lcv = outerCv;// 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근 가능//			int liv2 = lv;			int liv3 = LV;		}	}}
```

### 익명 클래스(anonymous class)

: 클래스의 선언과 객체 생성을 동시에 하는 일회용 클래스
: 하나의 객체만 생성 가능

> new 조상클래스이름() {
> 

```java
public class InnerEx6 {	Object iv = new Object() {void method(){}};// 익명 클래스	static Object cv = new Object() {void method(){}};// 익명 클래스	void myMethod() {		Object lv = new Object() {void method(){}};// 익명 클래스	}}
```
