package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Student;


public interface StudentService {
	/**
	 * ��������ѧ����Ϣ�������������ѧ����Ϣ��
	 * @param list
	 * @return
	 */
	public int addStuList(List<Student> list) throws Exception;
	/**
	 * ���뵥��ѧ����Ϣ
	 * @param stu
	 * @return
	 */
	public int addStu(Student stu) throws Exception;
	/**
	 * ����ѧ��idɾ��ѧ����Ϣ
	 * @param stuId
	 * @return
	 */
	public int deleteStuByStuId(String stuId) throws Exception;
	/**
	 * ����idɾ��list������ѧ����Ϣ
	 * @return
	 */
	public int deleteAll(List<String> list) throws Exception;
	/**
	 * ����ѧ��ѧ���޸�����
	 * @param stuId
	 * @param password
	 * @return
	 */
	public int updatePasswordByStuId(String stuId ,String password) throws Exception;
	/**
	 * ����ѧ��ѧ���޸�����
	 * @param stuId
	 * @param name
	 * @return
	 */
	public int updateStuNameByStuId(String stuId,String name) throws Exception;
	/**
	 * ����ѧ�������޸�ѧ����Ϣ
	 * @param stu �������ѧ��ѧ��
	 * @return
	 */
	public int updateStudentInfo(Student stu) throws Exception;
	/**
	 * ����ѧ�Ż�ȡѧ������
	 * @param stuId
	 * @return
	 * @throws Exception 
	 */
	public String findStudentPwdByStuId(String stuId) throws Exception;
	/**
	 * ����ѧ�Ż�ȡѧ����Ϣ
	 * @param stuId
	 * @return
	 */
	public Student findStudentInfoByStuId(String stuId) throws Exception;
	/**
	 * ��ȡ����ѧ����Ϣ
	 * @return
	 */
	public List<Student> findAllStudent() throws Exception;
	/**
	 * �жϵ�¼�Ƿ�ɹ����ɹ�����1�����򷵻�0,id�����ڷ���-1
	 * @param stuId
	 * @param pwd
	 * @return
	 */
	public int login(String stuId,String pwd);
}
