package com.hust.jss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.jss.entity.Teacher;

@Repository("teacherDao")
public interface TeacherDao {

	/**
	 * ����һ����ʦ��¼
	 * @param teacher
	 * @return
	 */
    int insert(Teacher teacher);

    /**
     * ����һ����ʦ��¼
     * ����ʱ�ж��Ƿ�����ֵΪ��
     * @param teacher
     * @return
     */
    int insertSelective(Teacher teacher);

	/**
	 * ͨ��teaIdɾ����ʦ
	 * @param teaId
	 * @return
	 */
    int deleteByTeaId(String teaId);

    /**
     * ͨ��teaId��ѯ��ʦ
     * @param teaId
     * @return
     */
    Teacher selectByTeaId(String teaId);

    /**
     * ��ѯ���н�ʦ��¼
     * @return
     */
    List<Teacher> selectAllTeacher();
    
    /**
     * ���½�ʦ��Ϣ
     * �жϷǿ�
     * @param teacher
     * @return
     */
    int updateByTeaIdSelective(Teacher teacher);

    /**
     * ���½�ʦ��Ϣ 
     * @param teacher
     * @return
     */
    int updateByTeaId(Teacher teacher);
}