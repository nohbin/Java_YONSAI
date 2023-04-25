package nohbin.member;

public class MemberVo {
	private String memberNum;
	private String memberName;
	private int memberHeight;
	private int memberWeight;
	private int memberAge;

	public MemberVo() {
		super();
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberHeight() {
		return memberHeight;
	}

	public void setMemberHeight(int memberHeight) {
		this.memberHeight = memberHeight;
	}

	public int getMemberWeight() {
		return memberWeight;
	}

	public void setMemberWeight(int memberWeight) {
		this.memberWeight = memberWeight;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public MemberVo(String memberNum, String memberName, int memberHeight, int memberWeight, int memberAge) {
		super();
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberHeight = memberHeight;
		this.memberWeight = memberWeight;
		this.memberAge = memberAge;
	}

}