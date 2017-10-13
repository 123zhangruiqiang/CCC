package POJO;

public class SourceFile {
	private String text_name;
	private String userid;
	private String date;
	private String time;
	private String money;
	private String token1="D2IDLknWzGmoH41aJEsAdGA";
	private String token2="a8f986fde5a24e1589733ca25cedb53d";

	public SourceFile(){

	}

	public String getText_name() {
		return text_name;
	}

	public void setText_name(String text_name) {
		this.text_name = text_name;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getToken1() {
		return token1;
	}
	public void setToken1(String token1) {
		this.token1 = token1;
	}
	public String getToken2() {
		return token2;
	}
	public void setToken2(String token2) {
		this.token2 = token2;
	}
	@Override
	public String toString() {
		
		return "\""+this.getUserid()+"\""+","+"\""+this.getDate()+" "+this.getTime()+":00"+"\",\""+this.getMoney()+"\",\""+this.getToken1()+"\",\""+this.getToken2()+"\"";
	}
	
	
	
}
