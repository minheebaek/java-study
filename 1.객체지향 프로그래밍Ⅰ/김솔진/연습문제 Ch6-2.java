class Exercise6_2 {
public static void main(String args[]) {
  
  SutdaCard card1 = new SutdaCard(3, false);
  SutdaCard card2 = new SutdaCard();
  
  System.out.println(card1.info()); // 3 . 이 출력된다
  System.out.println(card2.info()); // 1K . 가 출력된다
  
}
}


class SutdaCard{

int num;
boolean isKwang;


//생성자
SutdaCard(int num, boolean isKwang){

  this.num = num;
  this.isKwang = isKwang;
  
}
//기본생성자
SutdaCard(){

  this(1, true);
  
}

//info()메서드. 리턴 = 문자열
public String info(){
    
    if(isKwang){
      
      return num + "K";
      
    }else{
      
      return num;
      
    }
      
}


}
