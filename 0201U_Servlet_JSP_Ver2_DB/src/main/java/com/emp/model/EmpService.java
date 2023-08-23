package com.emp.model;

import java.util.List;
import java.util.Map;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpDAO();
	}

	public EmpVO addEmp(String ename, String job, java.sql.Date hiredate,
			Double sal, Double comm, byte[] upFiles, Integer deptno) {

		EmpVO empVO = new EmpVO();

		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setUpFiles(upFiles);
		empVO.setDeptno(deptno);
		dao.insert(empVO);

		return empVO;
	}

	//預留給 Struts 2 或 Spring MVC 用
	public void addEmp(EmpVO empVO) {
		dao.insert(empVO);
	}
	
	public EmpVO updateEmp(Integer empno, String ename, String job,	java.sql.Date hiredate, 
			Double sal, Double comm, byte[] upFiles, Integer deptno) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpno(empno);
		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setUpFiles(upFiles);
		empVO.setDeptno(deptno);
		dao.update(empVO);

		return dao.findByPrimaryKey(empno);
	}
	
	//預留給 Struts 2 或 Spring MVC 用
	public void updateEmp(EmpVO empVO) {
		dao.update(empVO);
	}

	public void deleteEmp(Integer empno) {
		dao.delete(empno);
	}

	public EmpVO getOneEmp(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
	
	public List<EmpVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}