##java.lang 패키지
### Object 클래스
- 모든 클래스의 최고 조상
- Object 클래스의 멤버들은 모든 클래스에서 바로 사용 가능
- equals(Object obj): 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean 값으로 알려줌
- hashCode(): 해싱 기법에 사용되는 '해시함수'를 구현한 것
- toString(): 인스턴스에 대한 정보를 문자열로 제공
- clone(): 자신을 복제하여 새로운 인스턴스를 생성
- 공변 타입반환: 오버라이딩을 할 때 조상메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것
- 얕은 복사: 원본을 변경하면 복사본도 영향받음
- 깊은 복사: 원본이 참조하고 있는 객체까지 복사하는 것, 원본의 변경이 복사본에 영향을 미치지 않음
- getClass(): 자신이 속한 클래스의 Class 객체를 반환하는 메서드
### String 클래스
- 변경 불가능한 클래스: 한 번 생성된 String 인스턴스는 갖고 있는 문자열을 읽어 올 수만 있고, 변경할 수 없다
- equals(): 두 문자열의 내용 비교
- 문자열 리터럴
- 빈 문자열: 길이가 0인 배열도 존재할 수 있다
- join(): 여러 문자열 사이에 구분자를 넣어서 결합
- String.format(): 형식화된 문자열을 만들어냄
- valueOf(): 기본형을 String으로 반환
- parseInt(): String을 int로 변환
### StringBuffer 클래스와 StringBuilder 클래스
- StringBuffer 클래스는 지정된 문자열을 변경할 수 있다
- append(): 문자열 추가
- equals(): 문자열 비교
- StringBuilder: StringBuffer에서 쓰레드 동기화만 뺀 것
### Math 클래스
- 기본적인 수학 계산에 유용한 메서드로 구성
- random(): 임의의 수 생성
- round(): 반올림
- rint(): round()와 달리 반환값이 double, 두 정수의 정가운데 있는 가장 가까운 짝수 정수 반환
- Exact(): 오버플로우가 발생하면 예외(ArithmeticException) 발생
- sqrt(): 제곱근 계산
- pow(): n제곱 계산
### Wrapper 클래스
- 기본형 변수를 객체로 다뤄야할 때 사용
- equals(): 주소값이 아닌 객체가 가지고 있는 값을 비교ㅓ
- Number: BigInteger->long으로도 다룰 수 없는 큰 범위의 정수, BigDecimal->double로도 다룰 수 없는 큰 범위의 부동 소수정수
- 타입.parse타입(String s): 문자열을 숫자로 변환 시 사용
- 오토박싱: 기본형 값을 래퍼 클래스의 객체로 자동 변환해 주는 것
- 언박싱: 반대로 변환하는 것
---
## 유용한 클래스
### java.util.Objects
- 객체의 비교나 null check에 유용
- isNull(): 해당 객체가 null인지 확인해서 null이면 true를 반환하고 아니면 false를 반환
- nonNull(): 위와 반대
- requireNonNull(): 해당 객체가 null이 아니어야 하는 경우에 사용, 만약 null이면 NullPointerException 발생
- compare(): 두 비교대상이 같으면 0, 크면 양수, 작으면 음수 반환
### java.util.Random
- seed값 설정 가능
- int[] fillRand(int[] arr, int from, int to): 배열 arr을 from과 to 범위의 값들로 채워서 반환
- int[] fillRand(int[] arr, int[] data): 배열 arr을 배열 data에 있는 값들로 채워서 반환
- int getRand(int from, int to): from과 to 범위의 정수 값을 반환
### 정규식
- 텍스트 데이터 중에서 원하는 조건(패턴)과 일치하는 문자열을 찾기위해 사용
### java.util.Scanner
- 화면, 파일, 문자열과 같은 입력소스로부터 문자데이터를 읽어올 때 사용
### java.util.StringTokenizer
- 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 문자열로 잘라내는 데 사용