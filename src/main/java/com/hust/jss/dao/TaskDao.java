package com.hust.jss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.jss.entity.Task;

@Repository("taskDao")
public interface TaskDao {
	
	/**
	 * ����һ����ҵ��¼
	 * @param task
	 * @return �ɹ���������
	 */
	int insert(Task task);

	/**
	 * ����һ����ҵ��¼
	 * ����ʱ�ж�����ֵ�Ƿ�Ϊ��
	 * @param task
	 * @return
	 */
	int insertSelective(Task task);

	/**
	 * ͨ��taskIdɾ����ҵ��¼
	 * @param taskId
	 * @return
	 */
	int deleteByTaskId(Integer taskId);

	/**
	 * ͨ��taskId��ѯ��ҵ
	 * @param taskId
	 * @return
	 */
	Task selectByTaskId(Integer taskId);

	/**
	 * ��ѯ������ҵ
	 * @return
	 */
	List<Task> selectAllTask();
	
	/**
	 * ������ҵ
	 * ����ʱ�������ֵ�ǿ�
	 * @param task
	 * @return
	 */
	int updateByTaskIdSelective(Task task);

	/**
	 * ������ҵ
	 * @param task
	 * @return
	 */
	int updateByTaskId(Task task);
}