## 1. 클래스와 객체

### 클래스

: 객체를 정의한 것 ≒ 설계도, 틀

: 변수와 메서드의 결합

: 사용자 정의 타입

```
class TV {
// 멤버변수
	String color;
	boolean power;
	int channel;

// 메서드void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}
```

### 객체

: 실제로 존재하는 것 ≒ 제품

: 속성(멤버변수)과 기능(메서드)으로 구성됨

: 인스턴스 변수들을 묶어놓은 것

### 인스턴스

: 어떤 클래스로부터 생성된 객체

: 참조변수를 통해서만 다룰 수 있으며, 참조변수 타입은 인스턴스와 일치해야 함

: 하나의 참조변수가 여러 개의 인스턴스 가리키는 건 불가능

- 생성 방법

```
클래스 참조변수;// 참조변수 선언
참조변수 = new 클래스();// 생성된 객체의 주소를 참조변수에 저장

-> 클래스 참조변수 = new 클래스();
```

```
TV t;
t = new TV();

-> TV t = new TV();
```

### 객체 배열

: 많은 수의 객체를 다룰 때 사용

: 객체의 주소 저장

: 인스턴스의 참조변수들을 하나로 묶은 참조변수의 배열

- 생성 방법

1) 객체를 다루기 위한 참조변수 배열 생성 -> 객체 생성하여 각 요소에 저장

```
클래스[] 참조변수 = new 클래스[길이];// 참조변수 배열(객체 배열) 생성// 객체를 생성해서 배열의 각 요소에 저장
참조변수[0] = new 클래스();
참조변수[1] = new 클래스();
. . .
참조변수[n] = new 클래스();
```

```
TV[] tvarr = new TV[3];

tvarr[0] = new TV();
tvarr[1] = new TV();
tvarr[2] = new TV();
```

2) 배열의 초기화 블록 사용

```
클래스[] 참조변수 = { new 클래스(),  new 클래스(), ... ,  new 클래스() };
```

```
TV[] tvarr = { new TV(), new TV(), new TV() };
```

3) for문 사용

```
클래스[] 참조변수 = new 클래스[길이];

for (int i = 0; i < 참조변수.length; i++) {
	참조변수[i] = new 클래스();
}
```

```
TV[] tvarr = new TV[100];

for (int i = 0; i < tvarr.length; i++) {
	tvarr[i] = new TV();
}
```

## 2. 변수와 메서드

> 변수의 선언위치가 변수의 종류와 범위를 결정한다.
> 

### 선언위치에 따른 변수의 종류

| 변수 종류 | 선언 위치 | 생성 시기 |
| --- | --- | --- |
| 인스턴스변수(instance variable, iv) | 클래스 영역 | 인스턴스가 생성되었을 때 |
| 클래스변수(class variable, cv) |  | 클래스가 메모리에 올라갈 때 |
| 지역변수(local variable, lv) | 클래스 이외의 영역(메서드, 생성자, 초기화 블럭 내부) | 변수 선언문이 수행되었을 때 |

```
class Variables {
	int iv;
	static int cv;

	void method() {
		int lv = 0;
	}
}
```

### 인스턴스변수(instance variable)

: 클래스의 인스턴스를 생성할 때 만들어짐

: 각 인스턴스마다 다른 값 저장 가능

: **인스턴스 생성 후 사용 가능**

: 인스턴스마다 고유한 상태를 유지해야 할 때 사용

: 인스턴스 생성 후, '참조변수.인스턴스변수명' 으로 접근

```
class Card {
// 인스턴스변수. 각 Card 인스턴스마다 다른 값 가짐
	String kind;
	int number;

	static int width = 100;
	static int height = 250;
}
```

### 클래스변수(class variable)

: 인스턴스변수 앞에 static 붙임

: **인스턴스 생성하지 않고도 사용 가능**

: 모든 인스턴스들이 공통적인 값을 유지해야 할 때 사용

: 클래스가 로딩될 때 생성되어 프로그램이 종료될 때까지 유지

: public을 앞에 붙이면 전역변수의 성격을 가짐

: 인스턴스 생성 없이 '클래스이름.클래스변수' 으로 접근

```
class Card {
	String kind;
	int number;

// 클래스변수. 모든 Card 인스턴스는 같은 값 가짐static int width = 100;
	static int height = 250;
}
```

### 지역변수(local variable)

: 클래스 이외의 영역에서 생성되어 그 안에서만 사용 가능

: 메서드의 경우, 메서드가 종료되면 소멸되어 사용 불가

### 메서드(Method)

: 특정한 작업을 수행하기 위한 명령문의 집합

: 클래스 영역에서만 정의 가능

- 선언 방법

```
반환타입 메서드이름 (타입 변수명, 타입 변수명, ...) {
// 메서드 호출 시 수행될 코드
}
```

```
int add(int x, int y) {
		return x + y;
}
```

### 메서드 호출

: 메서드 호출 시 인자의 개수와 순서는 매개변수와 일치해야 함

: 인자의 타입은 매개변수와 일치하거나 자동 형변환 가능한 것이어야 함

: static 메서드는 같은 클래스 내에 있는 인스턴스 메서드를 호출할 수 없음

```
메서드이름();// 매개변수가 없는 경우
메서드이름(인자1, 인자2, ...);// 매개변수가 있는 경우
```

```
int result = add(1, 3);
```

### return문

: 현재 실행 중인 메서드를 종료하고 호출한 메서드로 되돌아감

: 반환타입이 void인 경우, 컴파일러가 자동으로 'return;**'** 생성

: 반환타입이 void가 아닌 경우, 반드시 return문이 있어야 함

```
int max(int x, int y) {
	if (x > y) {
		return x;
	}

// if문 안에만 return문 있으면 오류 발생.return y;
}
```

### JVM의 메모리 구조

!https://blog.kakaocdn.net/dn/mYLuV/btstxpjMH4K/S8kNnwqEvsJ5aefYzZLPR0/img.png

- 메서드 영역(Method Area)

: 클래스에 대한 정보와 클래스변수 저장

- 호출스택(Call stack or execution stack)

: 메서드 작업공간

: 메서드가 호출되면 메서드 수행에 필요한 메모리 공간 할당

: 메서드가 종료되면 사용한 메모리 반환

: 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드

- 힙(heap)

: 인스턴스가 생성되는 공간

: 인스턴스변수 생성

### 매개변수 - 기본형, 참조형

- 기본형 매개변수

: 변수의 값을 읽기만 할 수 있다(read only)

: 변수의 복사본을 전송하므로 원본에는 아무런 영향을 미치지 못함

```
class Data {int x;}

public class PrimitiveParamEx {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;

		System.out.println("main() : x = "+d.x);
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = "+d.x);

	}

	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = "+x);
	}
}
```

> main() : x = 10
> 
- 참조형 매개변수

: 변수의 값을 읽고 변경할 수 있다(read & write)

: 값이 저장된 주소를 넘겨줌

```
public class ReferenceParamEx {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;

		System.out.println("main() : x = "+d.x);
		change(d);
		System.out.println("After change(d)");
		System.out.println("main() : x = "+d.x);

	}

	static void change(Data d) {
		d.x = 1000;
		System.out.println("change() : x = "+d.x);
	}
}
```

> main() : x = 10
> 

### 반환타입 - 참조형

: 메서드가 객체의 주소를 반환

```
public class ReferenceReturnEx {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;

		Data d2 = copy(d);
		System.out.println("d.x = "+d.x);
		System.out.println("d2.x = "+d2.x);

	}

	static Data copy(Data d) {
		Data tmp = new Data();
		tmp.x = d.x;
		return tmp;
	}
}
```

### 재귀호출(recursive call)

: 메서드 내에서 메서드 자신을 다시 호출

: 반복문으로 변경 가능하며 반복문보다 성능 나쁜 경우 많음

```
public class FactorialTest {
	public static void main(String[] args) {
		int result = factorial(4);

		System.out.println(result);

	}

	static int factorial(int x) {
		int result;

		if (x <= 0 || x > 12) {
			return -1;
		}
		if (x == 1) {
			result = 1;
		}
		result = x * factorial(x -1);

		return result;
	}
}
```

### 메서드 - 클래스(static), 인스턴스

> 클래스 메서드와 인스턴스 메서드의 차이는 인스턴스변수(iv)의 사용 여부다.
> 
- 클래스 메서드(static 메서드)

: 인스턴스변수나 인스턴스메서드와 관련없는 작업을 함

: 메서드 내에서 인스턴스 사용 불가

: 객체 생성 없이 '클래스이름.메서드이름()' 으로 호출

- 인스턴스 메서드

: 인스턴스변수나 인스턴스 메서드와 관련된 작업을 함

: 인스턴스변수나 인스턴스 메서드를 사용하지 않는다면 static 붙이는 거 고

: 메서드 내에서 인스턴스 사용 가능

: 인스턴스 생성 후, '참조변수.메서드이름()' 으로 호출

```
public class MyMathTest2 {
	public static void main(String[] args) {
		System.out.println(MyMath2.sum(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200L, 100L));

		MyMath2 mm = new MyMath2();
		mm.a = 200L;
		mm.b = 100L;

		System.out.println(mm.sum());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}
}

class MyMath2{
	long a, b;

// 인스턴스 메서드long sum() {return a + b;}
	long subtract() {return a - b;}
	long multiply() {return a *b;}
	double divide() {return a / b;}

// 클래스 메서드static long sum(long a, long b) {return a + b;}
	static long subtract(long a, long b) {return a - b;}
	static long multiply(long a, long b) {return a * b;}
	static double divide(double a, double b) {return a / b;}
}
```

### 참조와 호출 - 클래스 멤버, 인스턴스 멤버

> 같은 클래스의 멤버 간에는 객체 생성이나 참조 변수 없이 참조할 수 있다.
> 

: 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수 있음

: 클래스 멤버는 언제나 참조, 호출 가능

: 인스턴스 멤버 간의 호출에는 아무런 문제 없음

```
class MemberCall {
	int iv =10;
	static int cv = 20;

	int iv2 = cv;
// static int cv2 = iv; // 에러. 클래스변수는 인스턴스변수 사용 불가static int cv2 = new MemberCall().iv;// 객체 생성해야 사용 가능

	static void staticMethod1() {
		System.out.println(cv);
//System.out.println(iv); // 에러. 클래스메서드는 인스턴스변수 사용 불가
		MemberCall c = new MemberCall();// 객체를 생성해야 참조 가능
		System.out.println(c.iv);
	}

	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);// 인스턴스메서드에서는 인스턴스변수 사용 가능
	}

	static void staticMethod2() {
		staticMethod1();
//instanceMethod1(); // 에러. 클래스메서드에서는 인스턴스메서드 호출 불가
		MemberCall c = new MemberCall();
		c.instanceMethod1();// 인스턴스 생성해야 호출 가능
	}

	void instanceMethod2() {
		staticMethod1();// 인스턴스메서드에서는 모두 인스턴스 생성 없이 호출 가능
		instanceMethod1();
	}
}
```

※ 인스턴스 생성과 동시에 메서드 호출

: 참조변수 선언을 하지 않았으므로 생성된 인스턴스는 더 이상 사용 불가

```
MemberCall c = new MemberCall();
int result = c.instanceMethod();

-> int result = new MemberCall().instanceMethod();
```

## 3. 메서드 오버로딩(method overloading)

### 메서드 오버로딩

: 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것

: 같은 기능을 하는 메서드를 하나로 통칭하여 오류 가능성 낮춤

: 간단히 오버로딩(overloading)이라고 함

### 오버로딩의 조건

1. 메서드 이름이 같아야 함
2. 매개변수의 개수 또는 타입이 달라야 함
3. 매개변수는 같고 반환 타입이 다른 경우는 오버로딩 성립 X

```
int add(int a, int b) {return a+b;}
long add(long a, long b) {return a+b;}
long add(int[] a) {
	long result = 0;

	for (int i = 0; i < a.length; i++) {
		result += a[i];
	}
	return result;
}
```

### 가변인자(variable arguments)

: 메서드의 매개변수를 동적으로 지정

: 매개변수 중에서 제일 마지막에 선언해야 함

: 가변인자만 있는 경우 인자가 아예 없어도 됨

: 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋음

: '타입... 변수명' 으로 선언

<-> 매개변수의 타입을 배열로 하면, 반드시 인자를 지정해줘야 하므로 인자 생략 불가

```
public PrintStream printf(String format, Object... args) {...}
```

## 4. 생성자(Constructor)

### 생성자

> 모든 클래스에는 반드시 하나 이상의 생성자가 있어야 한다.
> 

: 인스턴스가 생성될 때마다 호출되는 **인스턴스 초기화 메서드**

: 인스턴스 변수 초기화 or 인스턴스 생성 시 수행될 작업에 사용

- 정의 방법

```
클래스이름(타입 변수명, 타입 변수명, ...) {
// 인스턴스 생성 시 수행될 코드
}
```

- 인스턴스 생성 과정

```
Card c = new Card();
```

1. 연산자 new에 의해서 메모리(heap)에 Card클래스의 인스턴스 생성
2. 생성자 Card()가 호출되어 수행
3. 연산자 new의 겨로가고, 생성된 Card인스턴스의 주소가 반환되어 참조변수 c에 저장

### 생성자의 조건

1. 생성자의 이름은 클래스 이름과 같아야 함
2. 생성자는 리턴 값이 없음

### 기본 생성자(default constructor)

: 매개변수가 없는 생성자

: 클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자 추가(생성자가 하나라도 있으면 생성 X)

```
클래스이름() {}
```

### 매개변수가 있는 생성자

: 매개변수를 선언하여 호출 시 값을 넘겨받아 인스턴스의 초기화에 사용

```
class Car {
	String color;
	String gearType;
	int door;

	Car() {
		this("white", "auto", 4);
	}
	Car(String color) {
		this(color, "auto", 4);
	}
	Car(Car c) {
		this(c.color, c.gearType, c.door);
	}
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
```

### 생성자에서 다른 생성자 호출 - this()

: 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용

: 다른 생성자 호출은 생성자의 첫 문장에서만 가능

### 참조변수 this

: 인스턴스 자신을 가리키는 참조변수

: 인스턴스의 주소가 저장되어 있음

: 인스턴스변수와 지역변수를 구별하기 위해 사용

## 5. 변수의 초기화

: 지역변수는 사용 전에 반드시 초기화해야 함

: 멤버변수와 배열은 기본값으로 자동초기화되므로 초기화 생략 가능

### 멤버변수의 초기화 방법

1. 명시적 초기화
2. 생성자
3. 초기화 블럭
- 인스턴스 초기화 블럭 : { }

생성자에서 공통적으로 수행되는 작업에 사용

인스턴스가 생성될 때마다 생성자보다 먼저 실행

- 클래스 초기화 블럭 : static { }

클래스가 로딩될 때 실행

### 멤버변수의 초기화 시기와 순서

- 클래스변수

: 클래스가 처음 로딩될 때 단 한 번

- 인스턴스변수

: 인스턴스가 생성될 때마다
