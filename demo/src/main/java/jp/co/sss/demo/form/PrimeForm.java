package jp.co.sss.demo.form;

public class PrimeForm {

	private long num = 0;
	private String a;

	public long getNum(){
		return num;
	}

	public void setNum(long num){
		this.num = num;
	}
	public String getA(){
		return a;
	}

	public void setA(String a){
		this.a = a;
	}
	public void hantei(){
		long n=this.num;

		if(n==57) {
			a=this.num+"はグロタンディーク素数!!　だけど素数ではない";
		}else if(n<2) {
			a=this.num+"は素数じゃない";
		}else if(n==2){
			a=this.num+"は素数";
		}else  if(n%2==0){
			a=this.num+"は素数じゃない→2で割り切れる";
		}else {
			for(long i=3;i<=Math.sqrt(n);i=i+2) {
				System.out.println(i);
				if(n%i==0) {
					a=this.num+"は素数じゃない→"+i+"で割り切れる";
					return;
				}
			}
			a=this.num+"は素数";
			setA(a);
		}
	}
}