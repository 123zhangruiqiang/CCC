package POJO;

public class OrderCustom extends Orders {

		private String username;
		private String sex;
		private String address;
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
	
		@Override
		public String toString() {
			return this.getId()+","+this.getUserid()+","+this.getUsername()+","+
		this.getSex()+","+this.getCreatetime()+","+this.getAddress();
		}
		
		
		
		
}
