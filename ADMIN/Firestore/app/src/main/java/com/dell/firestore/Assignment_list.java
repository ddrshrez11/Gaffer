package com.dell.firestore;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Assignment_list {
    private String Title;
    private String Desc;
    private @ServerTimestamp
    Date timestamp;
    private String Deadline;
    private String Subject;
    private String Teacher;
    private String Assignment_id;

    public Assignment_list(){

    }

    public Assignment_list(String title, String desc, Date timestamp, String deadline, String subject, String teacher, String assignment_id) {
        Title = title;
        Desc = desc;
        this.timestamp = timestamp;
        Deadline = deadline;
        Subject = subject;
        Teacher = teacher;
        Assignment_id = assignment_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getAssignment_id() {
        return Assignment_id;
    }

    public void setAssignment_id(String assignment_id) {
        Assignment_id = assignment_id;
    }


}
