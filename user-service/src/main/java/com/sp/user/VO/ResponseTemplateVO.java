package com.sp.user.VO;




import com.sp.user.entity.User;
public class ResponseTemplateVO {

    public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private User user;
    private Department department;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public ResponseTemplateVO(User user, Department department) {
		super();
		this.user = user;
		this.department = department;
	}
}
