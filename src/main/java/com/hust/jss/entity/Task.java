package com.hust.jss.entity;

import java.util.Date;

public class Task {
	
	//��ҵID
    private Integer taskId;
    
    //��ҵ���� 
    private String taskName;
    
    //��ҵ·��
    private String taskPath;
    
    //��ҵ���ֹ�����·��
    private String taskRule;
    
    //��ҵ��ֹ����
    private Date taskExpiry;
    
    //��ҵ�ļ���С��Сֵ
    private Integer taskMinsize;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskPath() {
        return taskPath;
    }

    public void setTaskPath(String taskPath) {
        this.taskPath = taskPath == null ? null : taskPath.trim();
    }

    public String getTaskRule() {
        return taskRule;
    }

    public void setTaskRule(String taskRule) {
        this.taskRule = taskRule == null ? null : taskRule.trim();
    }

    public Date getTaskExpiry() {
        return taskExpiry;
    }

    public void setTaskExpiry(Date taskExpiry) {
        this.taskExpiry = taskExpiry;
    }

    public Integer getTaskMinsize() {
        return taskMinsize;
    }

    public void setTaskMinsize(Integer taskMinsize) {
        this.taskMinsize = taskMinsize;
    }
}