package com.hust.jss.entity;

public class Teacher {
	//	��ʦID
    private String teaId;
    //��ʦ����
    private String teaName;
    //��ʦ��¼����
    private String teaPwd;

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId == null ? null : teaId.trim();
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd == null ? null : teaPwd.trim();
    }
}