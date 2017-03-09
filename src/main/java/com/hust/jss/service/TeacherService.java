package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Teacher;

@Repository("teacherService")
@Transactional
public interface TeacherService {
	/**
	 * ��ӽ�ʦ
	 * 
	 * @param teacher
	 * @return
	 */
	public int addTeacher(Teacher teacher);

	/**
	 * ����idɾ����ʦ
	 * 
	 * @param teaId
	 * @return
	 */
	public int deleteTeacherByTeaId(String teaId);

	/**
	 * ɾ�����н�ʦ
	 * 
	 * @return
	 */
	public int deleteAll();

	/**
	 * ����id����name
	 * 
	 * @param teaId
	 * @param name
	 * @return
	 */
	public int updateTeacherNameByTeaId(String teaId, String name);

	/**
	 * ����id��������
	 * 
	 * @param teaId
	 * @param pwd
	 * @return
	 */
	public int updatePasswordByTeaId(String teaId, String pwd);

	/**
	 * ����id�ҽ�ʦ
	 * 
	 * @param teaId
	 * @return
	 */
	public Teacher findTeacherByTeaId(String teaId);

	/**
	 * ��ѯ���н�ʦ
	 * 
	 * @return
	 */
	public List<Teacher> findAll();

	/**
	 * ����id������
	 * 
	 * @param teaId
	 * @return
	 */
	public String findPwdByTeaId(String teaId);

	/**
	 * ��ʦ��¼���ɹ�����1�����򷵻�0
	 * 
	 * @param teaId
	 * @param pwd
	 * @return
	 */
	public int login(String teaId, String pwd);
}
