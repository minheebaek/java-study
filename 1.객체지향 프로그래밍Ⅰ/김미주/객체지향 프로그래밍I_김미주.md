## 객체지향언어
### 객체지향언어의 장점

- 코드의 재사용성이 높다
- 코드의 관리가 용이하다
- 신뢰성이 높은 프로그래밍을 가능하게 한다

---
## 클래스와 객체
### 클래스

- 정의: 객체를 정의해 놓은 것
- 용도: 객체를 생성하는데 사용

### 객체

- 정의: 실제로 존재하는 것. 사물 또는 개념
- 용도: 객체가 가지고 있는 기능과 속성에 따라 다름

### 인스턴스

- 인스턴스화: 클래스로부터 객체를 만드는 과정
- 인스턴스: 어떤 클래스로부터 만들어진 객체

### 객체의 구성요소

- 속성(property): <b>멤버 변수(member variable)</b>, 특성(attribute), 필드(field) ,상태(state)
- 기능(function): <b>메서드(method)</b>, 함수(function), 행위(behavior)
- 클래스에는 객체의 모든 속성과 기능이 정의되어 있다

```
클래스명 변수명; //클래스의 객체를 참조하기 위한 참조변수를 선언
변수명 = new 클래스명(); //클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장
```
- 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야한다
- 같은 클래스로부터 생성되었을지라도 각 인스턴스의 속성(멤버변수)은 서로 다른 값을 유지할 수 있으며, 메서드의 내용은 모든 인스턴스에 대해 동일하다
- 참조변수에는 하나의 값(주소)만이 저장될 수 있으므로 둘 이상의 참조변수가 하나의 인스턴스를 가리키는(참조하는) 것은 가능하지만 하나의 참조변수로 여러 개의 인스턴스를 가리키는 것은 가능하지 않다

### 객체 배열

- 참조변수들을 하나로 묶은 참조 변수 배열

---
## 변수와 메서드
### 변수의 종류

#### 1) 클래스 변수(class variable)
- 선언위치: 클래스 영역
- 생성시기: 클래스가 메모리에 올라갈 때
- 인스턴스 변수 앞에 **static** 을 붙어준다
- 모든 인스턴스가 공통된 저장공간을 공유한다
- 인스턴스를 생성하지 않고도 언제라도 바로 사용할 수 있다
#### 2) 인스턴스 변수(instance variable)
- 선언위치: 클래스 영역
- 생성시기: 인스턴스가 생성되었을 때
- 인스턴스 변수의 값을 읽어 오거나 저장하기 위해서는 먼저 인스턴스를 생성해야한다
- 독립적인 저장공간을 가지므로 서로 다른 값을 가질 수 있다
- 인스턴스마다 고유한 상태를 유지해야하는 속성의 경우 인스턴스 변수로 선언
#### 3) 지역변수(local variable)
- 선언위치: 클래스 영역 이외의 영역(메서드, 생성자, 초기화 블럭 내부)
- 생성시기: 변수 선언문이 수행되었을 때

### 메서드

- 메서드: 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
- 사용하는 이유
  - 높은 재사용성
  - 중복된 코드 제거
  - 프로그램의 구조화

```
반환타입 메서드이름 (타입 변수명, 타입 변수명, ...) //선언부
{
    //메서드 호툴 시 수행될 코드    
}
```
- 메서드의 반환타입이 'void'가 아닌 경우, 구현부{} 안에 'return 반환값'이 반드시 포함되어야 한다
- 인자: 메서드를 호출할 때 괄호()안에 지정해준 값들

### JVM의 메모리 구조
1) 메서드 영역(method area)
- 프로그램 실행 중 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스파일(*.class)을 읽어서 분석하여 클래스에 대한 정보를 이곳에 저장한다
2) 힙(heap)
- 인스턴스가 생성되는 공간
3) 호출스택(call stack 또는 execution stack)
- 메서드의 작업에 필요한 메모리 공간을 제공한다

### 기본형 매개변수와 참조형 매개변수
- 기본형 매개변수: 변수의 값을 읽기만 할 수 있다(read only)
- 참조형 매개변수: 변수의 값을 읽고 변경할 수 있다(read & write)

### 참조형 반환타입
- 매개변수뿐만 아니라 반환타입도 참조형이 될 수 있다
- 바환타입이 참조형이라느 것은 반환하는 값의 타입이 참조형이라는 얘긴데, 모든 참조형 타입의 값은 '객체의 주소'이므로 그저 정수값이 반환되는 것일 뿐 특별할 것이 없다

### 재귀호출
- 메서드의 내부에서 메서드 자신을 다시 호출하는 것
```
void method(){
  mehtod(); //재귀호출. 메서드 자신을 호출한다
}
```
- 논리적 간결함
- 스택의 저장한계를 넘게 되면 '스택오버플로우 에러'가 발생한다

### 클래스 메서드와 인스턴스 메서드
- 인스턴스 메서드: 인스턴스 변수와 관련된 작업을 하는, 즉 메서드 작업을 수행하는데 인스턴스 변수를 필요로 하는 메서드
- 클래스 메서드: 인스턴스와 관계없는 (인스턴스 변수나 인스턴스 메서드를 사용하지 않는) 메서드
- 클래스를 설계할 때, 멤버 변수 중 모든 인스턴스에 공통으로 사용하느 것에 static을 붙인다
- 클래스 변수(static 변수)는 인스턴스를 생성하지 않아도 사용할 수 있다
- 클래스 메서드(static 메서드)는 인스턴스 변수를 사용할 수 있다
- 메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다

---
## 오버로딩
### 오버로딩
- 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것

### 오버로딩 조건
- 메서드 이름이 같아야 한다
- 매개변수의 개수 또는 타입이 달라야한다
```
long add(int a, long b) { return a+b;}
long add(long a, int b) { return a+b;}
```

### 오버로딩 장점
- 메서드의 이름만 보고도 '이 메서드들은 이름이 같으니, 같은 기능을 하겠구나'라고 쉽계 예측 가능
- 메서드의 이름을 절약 가능

### 가변인자
- 동적으로 지정해 줄 수 있는 매개변수
- 타입... 변수명

---

## 생성자
### 생성자
- 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'
- 생성자의 이름은 클래스의 이름과 같아야 한다
- 생성자는 리턴 값이 없다
```
클래스이름(타입 변수명, 타입 변수명, ...){
  //인스턴스 생성 시 수행될 코드
  //주로 인스턴스 변수의 초기화 코드
  클래스이름() { ... } //매개변수가 없는 생성자
  클래스이름(타입 변수명, 타입 변수명, ...) { ... } //매개변수가 있는 생성자
}
```

### this(), this
- 생성자의 이름으로 클래스이름 대신 this를 사용한다
- 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다
- 유지보수가 쉬어진다

---

## 변수의 초기화
### 변수의 초기화
- 변수를 선언하고 처음으로 값을 저장하는 것
- 지역변수는 사용하기 전에 반드시 초기화해야한다

### 명시적 초기화
- 변수를 선언과 동시에 초기화하는 것

### 초기화 블럭
- 클래스 초기화 블럭: 클래스 변수의 복잡한 초기화에 사용, 클래스가 메모리에 처음 로딩될 때 한 번만 수행
- 인스턴스 초기화 블럭: 인스턴스 변수의 복잡한 초기화에 사용, 생성자와 같이 인스턴스를 생성할 때마다 수행