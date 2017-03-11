package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Result;

public interface ResultService {
	/**
	 * ����ɼ�
	 * @param result
	 * @return
	 */
	public int addResult(Result result) throws Exception;
	/**
	 * ����ѧ��idɾ����ѧ�����гɼ�
	 * @param stuId
	 * @return
	 */
	public int deleteResultByStuId(String stuId) throws Exception;
	/**
	 * ������ҵidɾ������ҵ�����˵ĳɼ�
	 * @param taskId
	 * @return
	 */
	public int deleteResultByTaskId(Integer taskId) throws Exception;
	/**
	 * ����Result����ɾ������ҵ�ɼ���¼
	 * @param result �������stuId,taskId
	 * @return
	 */
	public int deleteResultByResult(Result result) throws Exception;
	/**
	 * ����Result�޸ĸ���ҵ�ɼ�
	 * @param result �������stuId��taskId���Լ��޸ĺ��������Ϣ
	 * @return
	 */
	public int updateResult(Result result) throws Exception;
	/**
	 * ��ѯ�����˵�������ҵ�ɼ�
	 * @return
	 */
	public List<Result> findAllResult() throws Exception;
	/**
	 * ����ѧ��ѧ�Ų�ѯ��ѧ����������ҵ�ɼ�
	 * @param stuId
	 * @return
	 */
	public List<Result> findResultByStuId(String stuId) throws Exception;
	/**
	 * ������ҵ�Ų�ѯ����ҵ����ѧ���ĳɼ�
	 * @param taskId
	 * @return
	 */
	public List<Result> findResultByTaskId(Integer taskId) throws Exception;
	/**
	 * ����ѧ��ѧ�ź���ҵ�Ų�ѯ��ѧ������ҵ�ĳɼ�
	 * @param stuId
	 * @param taskId
	 * @return
	 */
	public Result findResult(String stuId,Integer taskId) throws Exception;
}
