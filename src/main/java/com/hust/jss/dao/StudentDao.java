package com.hust.jss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.jss.entity.Student;

@Repository("studentDao")
public interface StudentDao {
	/**
	 * ��ѧ�������һ����¼
	 * @param student
	 * @return
	 */
	int insert(Student student);	

	/**
	 * ��ѧ�������ѧ����¼
	 * ���ԷǿղŲ��������
	 * @param student
	 * @return
	 */
	int insertSelective(Student student);
	
	/**
	 * ��������ѧ����¼
	 * @param stuList
	 * @return
	 */
	int insertBatch(List<Student> stuList);

	/**
	 * ͨ��stuIdɾ��ѧ����¼
	 * @param stuId
	 * @return
	 */
    int deleteByStuId(String stuId);

    /**
     * ͨ��stuId����ɾ��ѧ����¼
     * @param stuIdList
     * @return
     */
    int deleteBatch(List<String> stuIdList);
    
    /**
     * ͨ��stuId��ѯѧ����¼
     * @param stuId
     * @return
     */
    Student selectByStuId(String stuId);

    /**
     * ��ѯ����ѧ����Ϣ
     * @return
     */
    List<Student> selectAllStu();
    
    /**
     * �޸�ѧ����Ϣ
     * ������Էǿ�
     * @param student
     * @return
     */
    int updateByStuIdSelective(Student student);

    /**
     * �޸�ѧ����Ϣ
     * @param student
     * @return
     */
    int updateByStuId(Student student);
}