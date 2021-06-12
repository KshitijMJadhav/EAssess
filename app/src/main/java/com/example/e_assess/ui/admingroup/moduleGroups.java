package com.example.e_assess.ui.admingroup;

public class moduleGroups {
    String Student1,Student2,Student3,TopicName, uerid,GuideName,GroupNo;

    public moduleGroups(String student1, String student2, String student3, String topicName, String uerid, String guideName, String groupNo) {
        Student1 = student1;
        Student2 = student2;
        Student3 = student3;
        TopicName = topicName;
        this.uerid = uerid;
        GuideName = guideName;
        GroupNo = groupNo;
    }

    public moduleGroups() {
    }

    public String getUerid() {
        return uerid;
    }

    public void setUerid(String uerid) {
        this.uerid = uerid;
    }

    public String getGuideName() {
        return GuideName;
    }

    public void setGuideName(String guideName) {
        GuideName = guideName;
    }

    public String getGroupNo() {
        return GroupNo;
    }

    public void setGroupNo(String groupNo) {
        GroupNo = groupNo;
    }

    public moduleGroups(String student2) {
        Student2 = student2;
    }

    public String getStudent1() {
        return Student1;
    }

    public void setStudent1(String student1) {
        Student1 = student1;
    }

    public String getStudent2() {
        return Student2;
    }

    public void setStudent2(String student2) {
        Student2 = student2;
    }

    public String getStudent3() {
        return Student3;
    }

    public void setStudent3(String student3) {
        Student3 = student3;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }
}