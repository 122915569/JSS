package com.hust.jss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hust.jss.entity.Result;

@Repository("resultDao")
public interface ResultDao {
	
	/**
	 * ��ɼ����������
	 * @param result
	 * @return
	 */
    int insert(Result result);

    /**
     * ��ѡ�����ɼ���
     * @param result
     * @return
     */
    int insertSelective(Result result);
   
    /**
     * ͨ��������stuId,taskId��ɾ���ɼ�
     * @param result
     * @return
     */
    int deleteByPrimaryKey(Result result);
	
    /**
     * ͨ��stuIdɾ���ɼ�
     * @param stuId
     * @return
     */
	int deleteByStuId(Integer stuId);
    
	/**
	 * ͨ��taskIdɾ���ɼ�
	 * @param taskId
	 * @return
	 */
    int deleteByTaskId(Integer taskId);
    
    /**
     * ͨ��������stuId��taskId�����ҳɼ�
     * @param result
     * @return
     */
    Result selectByPrimaryKey(Result result);

    /**
     * ͨ��stuId���ҳɼ�
     * @param stuId
     * @return
     */
    List<Result> selectByStuId(Integer stuId);
   
    /**
     * ͨ������taskId���ҳɼ�
     * @param taskId
     * @return
     */
    List<Result> selectByTaskId(Integer taskId);
    
    /**
     * ͨ��������stuId��taskId�����³ɼ�
     * ����Ϊ���򲻸���
     * @param result
     * @return
     */
    int updateByPrimaryKeySelective(Result result);

    /**
     * ͨ��������stuId��taskId�����³ɼ�
     * @param result
     * @return
     */
    int updateByPrimaryKey(Result result);
}