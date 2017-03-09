package com.hust.jss.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hust.jss.entity.Result;

@Repository("resultService")
@Transactional
public interface ResultService {
	/**
	 * ����ɼ�
	 * @param result
	 * @return
	 */
	public int addResult(Result result);
	/**
	 * ����ѧ��idɾ����ѧ�����гɼ�
	 * @param stuId
	 * @return
	 */
	public int deleteResultByStuId(String stuId);
	/**
	 * ������ҵidɾ������ҵ�����˵ĳɼ�
	 * @param taskId
	 * @return
	 */
	public int deleteResultByTaskId(Integer taskId);
	/**
	 * ����Result����ɾ������ҵ�ɼ���¼
	 * @param result �������stuId,taskId
	 * @return
	 */
	public int deleteResultByResult(Result result);
	/**
	 * ����Result�޸ĸ���ҵ�ɼ�
	 * @param result �������stuId��taskId���Լ��޸ĺ��������Ϣ
	 * @return
	 */
	public int updateResult(Result result);
	/**
	 * ��ѯ�����˵�������ҵ�ɼ�
	 * @return
	 */
	public List<Result> findAllResult();
	/**
	 * ����ѧ��ѧ�Ų�ѯ��ѧ����������ҵ�ɼ�
	 * @param stuId
	 * @return
	 */
	public List<Result> findResultByStuId(String stuId);
	/**
	 * ������ҵ�Ų�ѯ����ҵ����ѧ���ĳɼ�
	 * @param taskId
	 * @return
	 */
	public List<Result> findResultByTaskId(Integer taskId);
	/**
	 * ����ѧ��ѧ�ź���ҵ�Ų�ѯ��ѧ������ҵ�ĳɼ�
	 * @param stuId
	 * @param taskId
	 * @return
	 */
	public Result findResult(String stuId,Integer taskId);
}
