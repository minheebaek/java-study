## Object 클래스 : 모든 클래스의 최상위 조상
### 모든 클래스에서 사용 가능한 메서드를 제공함 
#### 1. toString(): 
객체의 정보를 문자열로 제공하는 목적으로 사용. 인스턴스 변수의 값을 문자열로 표현한다.
#### 2. hashCode(): 
객체 자신의 해시 코드를 반환하는 메서드로, 주로 객체의 해시 코드를 계산할 때 사용한다.
#### 3. equals(Object obj): 
두 객체의 참조 변수를 받아서 두 객체가 같은 객체를 참조하는지를 판단하는 메서드
#### 4. clone(): 
객체를 복제하여 새로운 인스턴스를 생성하는 메서드로, 얕은 복사(복사본 영향O)와 깊은 복사(복사본 영향X)로 나뉨


#### 객체 비교를 위해 equals를 오버라이딩하고, 해시코드를 다룰 때 hashCode를 수정한다. 또 객체 정보를 문자열로 표현할 때 toString을 오버라이딩한다.

### String 클래스, 문자열
#### String 클래스는 문자열을 다루는 데 사용되며, 변경할 수 없음
#### 빈 문자열("")은 크기가 0인 문자 배열을 저장하는 문자열
#### 문자열을 변경하려면 StringBuffer 클래스를 사용해야함

### Math 클래스와 Wrapper 클래스
#### Math 클래스
수학 계산에 사용되며, 모든 메서드는 static임
#### Wrapper 클래스 
기본 데이터 타입을 객체로 다루는 데 사용됨
