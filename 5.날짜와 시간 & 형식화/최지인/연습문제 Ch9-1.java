//[9-1] 다음과 같은 실행결과를 얻도록 SutdaCard클래스의 equal( )를 멤버변수인 num, isKwang의 값을 비교하도록 오버라이딩하고 테스트하시오.

class Exercise9_1 {

	public static void main(String[] args) {

		SutdaCard c1 = new SutdaCard(3, true);

		SutdaCard c2 = new SutdaCard(3, true);

		System.out.println("c1=" + c1);

		System.out.println("c2=" + c2);

		System.out.println("c1.equals(c2):" + c1.equals(c2));

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



	public boolean equals(Object obj) { 

		/*

		 * (1)매개변수로 넘겨진 객체의  num, isKwang과 

		 * 멤버변수 num, isKwang을 비교하도록 오버라이딩 하시오. 

		 */

		SutdaCard tempCard = (SutdaCard)obj;
		if (tempCard.num == num  && tempCard.isKwang == isKwang){
			return true;
		} else {
			return false;
		}

	}



	public String toString() {

		return num + (isKwang ? "K" : "");

	}

}



// [실행결과]

// c1=3K

// c2=3K

// c1.equals(c2):true

// 다른 풀이도 찾아 보았습니다.
// obj (참조 변수) instanceof SutdaCard (피연산자/타입/클래스 명)
// 연산 결과가 true라면 참조 변수가 검사한 타입으로 형변환이 가능하다.

// 조상타입의 참조변수(obj)로는 실제 인스턴스의 멤버들을 모두 사용할 수 없기 때문에 
// "instanceof" 연산자를 이용해서 참조변수 obj가 가리키는 인스턴스 타입을 체크하고,
// 실제 인스턴스와 같은 타입의 참조변수로 형변환을 해야만 인스턴스의 모든 멤버를 사용할 수 있다.