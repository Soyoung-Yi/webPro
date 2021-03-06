package com.lec.ex4_object;
// ♠ ◆ ♣ ♥ 모양에  1-13 숫자
public class Card {
	private char kind;  // ♠ ◆ ♣ ♥
	private int  num;   // 1~13
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드는 " + kind + ", " + num;
	}
	// c1.equals(c2) => c1의 kind와 c2의 kind, c1의 num와 c2의 num을 비교
	@Override
	public boolean equals(Object obj) {
		// c1.equals(c2) => c1은 내객체, c2는 obj. 
		if(obj!=null && obj instanceof Card) {//내객체의 kind와 obj.kind비교, 내객체의 num과 obj.num을 비교
			boolean kindChk =  ( kind == ((Card)obj).kind );
			boolean numChk  =  (num   == ((Card)obj).num);
			return kindChk && numChk ;
			//return ( kind == ((Card)obj).kind ) && (num   == ((Card)obj).num);
		}
		return false;
	}
}








