package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Student;

@Repository("studentService")
@Transactional
public interface StudentService {
	/**
	 * ��������ѧ����Ϣ�������������ѧ����Ϣ��
	 * @param list
	 * @return
	 */
	public int addStuList(List<Student> list);
	/**
	 * ���뵥��ѧ����Ϣ
	 * @param stu
	 * @return
	 */
	public int addStu(Student stu);
	/**
	 * ����ѧ��idɾ��ѧ����Ϣ
	 * @param stuId
	 * @return
	 */
	public int deleteStuByStuId(String stuId);
	/**
	 * ����idɾ��list������ѧ����Ϣ
	 * @return
	 */
	public int deleteAll(List<String> list);
	/**
	 * ����ѧ��ѧ���޸�����
	 * @param stuId
	 * @param password
	 * @return
	 */
	public int updatePasswordByStuId(String stuId ,String password);
	/**
	 * ����ѧ��ѧ���޸�����
	 * @param stuId
	 * @param name
	 * @return
	 */
	public int updateStuNameByStuId(String stuId,String name);
	/**
	 * ����ѧ�������޸�ѧ����Ϣ
	 * @param stu �������ѧ��ѧ��
	 * @return
	 */
	public int updateStudentInfo(Student stu);
	/**
	 * ����ѧ�Ż�ȡѧ������
	 * @param stuId
	 * @return
	 */
	public String findStudentPwdByStuId(String stuId);
	/**
	 * ����ѧ�Ż�ȡѧ����Ϣ
	 * @param stuId
	 * @return
	 */
	public Student findStudentInfoByStuId(String stuId);
	/**
	 * ��ȡ����ѧ����Ϣ
	 * @return
	 */
	public List<Student> findAllStudent();
	/**
	 * �жϵ�¼�Ƿ�ɹ����ɹ�����1�����򷵻�0
	 * @param stuId
	 * @param pwd
	 * @return
	 */
	public int login(String stuId,String pwd);
}
