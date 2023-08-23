package com.emp.model;

import java.sql.Date;

public class EmpVO implements java.io.Serializable {
	private Integer empno;
	private String ename;
	private String job;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private byte[] upFiles;
	private Integer deptno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public byte[] getUpFiles() {
		return upFiles;
	}

	public void setUpFiles(byte[] upFiles) {
		this.upFiles = upFiles;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	// for join dname from deptno從部門的VO抓取部門資料傳回來這邊調用如果欄位有別的表格要這樣叫
	public com.dept.model.DeptVO getDeptVO() {
		com.dept.model.DeptService deptSvc = new com.dept.model.DeptService();
		com.dept.model.DeptVO deptVO = deptSvc.getOneDept(deptno);
		return deptVO;
	}

}