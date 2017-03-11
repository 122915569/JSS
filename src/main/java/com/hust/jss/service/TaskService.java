package com.hust.jss.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Task;


public interface TaskService {
	/**
	 * �����ҵ
	 * @param task
	 * @return
	 */
	public int addTask(Task task) throws Exception;
	/**
	 * ������ҵidɾ����ҵ
	 * @param taskId
	 * @return
	 */
	public int deleteTaskByTaskId(Integer taskId) throws Exception;
	/**
	 * ɾ��������ҵ
	 * @return
	 */
	public int deleteAll() throws Exception;
	/**
	 * ������ҵid������ҵ����·����Ϣ
	 * @param taskId
	 * @param taskRule
	 * @return
	 */
	public int updateTaskRuleByTaskId(Integer taskId, String taskRule) throws Exception;
	/**
	 * ������ҵid������ҵ��ֹʱ��
	 * @param taskId
	 * @param taskExpiry
	 * @return
	 */
	public int updatetaskExpiryByTaskId(Integer taskId, Date taskExpiry) throws Exception;
	/**
	 * ������ҵid������ҵ��С��С
	 * @param taskId
	 * @param minsize
	 * @return
	 */
	public int updateMinsizeByTaskId(Integer taskId, Integer minsize) throws Exception;
	/**
	 * ������ҵid������ҵ
	 * @param taskId
	 * @return
	 */
	public Task findTaskByTaskId(Integer taskId) throws Exception;
	/**
	 * ����������ҵ
	 * @return
	 */
	public List<Task> findAllTasks() throws Exception;
}
