package com.hanains.mysite.vo;

public class BoardVo {

	private int no;
	private String title;
	private String contents;
	private int view_cnt;
	private int member_no;
	private String member_name;
	private UserVo userVo;
	private String reg_date;
	
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	
	public int getMember_no() {
		return userVo.getNo();
	}
	
	public String getMember_name() {
		return member_name;
	}
	
	public UserVo getUserVo() {
		return userVo;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	
	
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", contents=" + contents + ", view_cnt=" + view_cnt
				+ ", member_no=" + member_no + ", member_name=" + member_name + ", userVo=" + userVo + ", reg_date="
				+ reg_date + "]";
	}
	
	
	
}
