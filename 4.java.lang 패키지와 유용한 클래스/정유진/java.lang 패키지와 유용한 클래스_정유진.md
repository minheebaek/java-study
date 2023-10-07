## java.lang 패키지

: java 프로그래밍에 가장 기본이 되는 클래스 포함

: import문 없이도 사용 가능

### Object 클래스

!https://blog.kakaocdn.net/dn/CQQdK/btsxh9rwCEE/TsbqKueuJfT3pFRJMMg4n0/img.png

접근제어자가 protected인 메서드는 public으 오버라이딩 필요

- equals(Object obj)

: 객체의 **주소값**이 같은지 비교하여 그 결과를 boolean값으로 알려줌

: 일반적으로 주소값 대신 iv값 비교하도록 오버라이딩함

```
class Person {
	long id;

	public boolean equals(Object obj) {//Object클래스의 equals 오버라이딩if (!(obj instanceof Person)) {
			return false;
		}

		Person p = (Person)obj;
		return this.id == p.id;
	}

	Person(long id) {
		this.id = id;
	}
}

public class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(123456123456L);
		Person p2 = new Person(123456123456L);

		if (p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		}
		else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
}
```

> p1과 p2는 같은 사람입니다.
> 
- hashCode()

: 찾고자하는 값이 저장된 객체의 주소를 int로 변환해서 반환

: equals()를 오버라이딩하면, hashCode()도 오버라이딩 필요

: equals()의 결과가 true인 두 객체의 해시코드는 같아야 함

: System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일

```
public class HashCodeEx1 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
}
```

> true
> 
- toString()

: 객체를 문자열로 변환

: 일반적으로 오버라이딩하여 사용

```
import java.util.Objects;

class Card {
	String kind;
	int number;

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	Card() {
		this("SPADE", 1);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}

		Card c = (Card)obj;
		return this.kind.equals(c.kind) && this.number == c.number;
	}

	public int hashCode() {// equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야 함return Objects.hash(kind, number);
	}

	public String toString() {// Object클래스의 toString()을 오버라이딩return "kind:"+kind+", number:"+number;
	}
}

public class CardToString2 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1.equals(c2));

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
```

> true
> 
- getClass()

: 자신이 속한 클래스의 Class객체 반환

: Class객체는 클래스의 모든 정보를 담고 있으며, 클래스당 1개씩만 존재

- Class객체를 얻는 방법

① 생성된 객체로부터 얻는 방법

```
Class cObj = new Card().getClass();
```

② 클래스 리터럴(*.class)로부터 얻는 방법

```
Class cObj = Card.class;
```

③ 클래스 이름으로부터 얻는 방법

```
Class cObj = Class.forName("Card");
```

### String 클래스

: 문자열을 다루기 위한 클래스

: 내용을 변경할 수 없는 **불변(immutable) 클래스**

: 문자열의 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer를 사용

- 문자열 비교

```
// 문자열 리터럴 지정
String str1 = "abc";
String str2 = "abc";

// String클래스의 생성자 사용
String str3 = new String("abc");
String str4 = new String("abc");
```

!https://blog.kakaocdn.net/dn/bEiL6O/btsxsn25OD6/mVETCyuk78ZhljpbPwJlSK/img.png

- 빈 문자열(empty string)

: 길이가 0인 char형 배열을 저장하는 문자열

: String str = ""; 가능해도 char c = ''; 불가능

: String은 빈 문자열로 초기화 / char형은 공백으로 초기화

- 기본형 값 -> 문자열

```
int i = 100;

String str1 = i + "";// 100을 "100"으로 변환하는 방법1
String str2 = String.valueOf(i);// 100을 "100"으로 변환하는 방법2
```

- 문자열 -> 기본형 값

```
int i = Integer.parseInt("100");// "100"을 100으로 변환하는 방법1int i2 = Integer.valueOf("100");// "100"을 100으로 변환하는 방법2char c = "A".charAt(0);// 문자열 "A"를 문자 'A'로 변환하는 방법
```

### StringBuffer 클래스

: String처럼 문자형 배열(char[])을 내부적으로 가짐

: **내용 변경** **가능**(mutable)

: 인스턴스 생성 시 버퍼(배열)의 크기를 충분히 지정해야 함

: equals() 오버라이딩하지 않음

```
public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));

// StringBuffer -> String
		String s = sb.toString();
		String s2 = new String(sb2);

		System.out.println("s.equals(s2) ? " + s.equals(s2));
	}
}
```

> sb == sb2 ? false
> 

### Math 클래스

: 수학계산에 유용한 메서드로 구성

: 모두 static메서드

### wrapper 클래스

: 기본형을 클래스로 정의

: 내부적으로 기본형 변수 가짐

: equals() 오버라이딩

```
public class WrapperEx1 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println("i == i2 ? " + (i == i2));
		System.out.println("i.equals(i2) ? " + i.equals(i2));
		System.out.println("i.compareTo(i2) ? " + i.compareTo(i2));
		System.out.println("i.toString() ? " + i.toString());

		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("SIZE = " + Integer.SIZE + "bits");
		System.out.println("BYTES = " + Integer.BYTES + "bytes");
		System.out.println("TYPE = " + Integer.TYPE);
	}
}
```

> i == i2 ? false
> 
- Number 클래스

: 숫자를 멤버변수로 갖는 wrapper 클래스의 조상(추상클래스)
