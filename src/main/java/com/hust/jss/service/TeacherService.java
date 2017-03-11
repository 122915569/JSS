package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Teacher;


public interface TeacherService {
	/**
	 * ��ӽ�ʦ
	 * 
	 * @param teacher
	 * @return
	 */
	public int addTeacher(Teacher teacher) throws Exception;

	/**
	 * ����idɾ����ʦ
	 * 
	 * @param teaId
	 * @return
	 */
	public int deleteTeacherByTeaId(String teaId) throws Exception;

	/**
	 * ɾ�����н�ʦ
	 * 
	 * @return
	 */
	public int deleteAll() throws Exception;

	/**
	 * ����id����name
	 * 
	 * @param teaId
	 * @param name
	 * @return
	 */
	public int updateTeacherNameByTeaId(String teaId, String name) throws Exception;

	/**
	 * ����id��������
	 * 
	 * @param teaId
	 * @param pwd
	 * @return
	 * @throws Exception 
	 */
	public int updatePasswordByTeaId(String teaId, String pwd) throws Exception;

	/**
	 * ����id�ҽ�ʦ
	 * 
	 * @param teaId
	 * @return
	 * @throws Exception 
	 */
	public Teacher findTeacherByTeaId(String teaId) throws Exception;

	/**
	 * ��ѯ���н�ʦ
	 * 
	 * @return
	 */
	public List<Teacher> findAll() throws Exception;

	/**
	 * ����id������
	 * 
	 * @param teaId
	 * @return
	 * @throws Exception 
	 */
	public String findPwdByTeaId(String teaId) throws Exception;

	/**
	 * ��ʦ��¼���ɹ�����1�����򷵻�0
	 * 
	 * @param teaId
	 * @param pwd
	 * @return
	 */
	public int login(String teaId, String pwd);
}
