package prj.member;

public class  MemberVo{  //TO클래스의 용도는 레코드 정보를 저장한다.
	
	String id;  //멤버 변수
	String name;  
	int height;
	int  weight;
	int age;
	
	//getter, setter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}//end class