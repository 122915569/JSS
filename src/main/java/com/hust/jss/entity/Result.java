package com.hust.jss.entity;

public class Result {
	//ѧ��ID
	private String stuId;
	//��ҵID
    private Integer taskId;
	//��ҵ�ύ״̬ 
    private Boolean submit;
    //��ҵ����
    private Integer score;

    public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Boolean getSubmit() {
        return submit;
    }

    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}