package com.hust.jss.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Task;

@Repository("taskService")
@Transactional
public interface TaskService {
	/**
	 * �����ҵ
	 * @param task
	 * @return
	 */
	public int addTask(Task task);
	/**
	 * ������ҵidɾ����ҵ
	 * @param taskId
	 * @return
	 */
	public int deleteTaskByTaskId(Integer taskId);
	/**
	 * ɾ��������ҵ
	 * @return
	 */
	public int deleteAll();
	/**
	 * ������ҵid������ҵ����·����Ϣ
	 * @param taskId
	 * @param taskRule
	 * @return
	 */
	public int updateTaskRuleByTaskId(Integer taskId, String taskRule);
	/**
	 * ������ҵid������ҵ��ֹʱ��
	 * @param taskId
	 * @param taskExpiry
	 * @return
	 */
	public int updatetaskExpiryByTaskId(Integer taskId, Date taskExpiry);
	/**
	 * ������ҵid������ҵ��С��С
	 * @param taskId
	 * @param minsize
	 * @return
	 */
	public int updateMinsizeByTaskId(Integer taskId, Integer minsize);
	/**
	 * ������ҵid������ҵ
	 * @param taskId
	 * @return
	 */
	public Task findTaskByTaskId(Integer taskId);
	/**
	 * ����������ҵ
	 * @return
	 */
	public List<Task> findAllTasks();
}
