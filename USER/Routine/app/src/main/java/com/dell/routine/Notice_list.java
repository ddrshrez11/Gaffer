package com.dell.routine;

import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

@IgnoreExtraProperties
public class Notice_list{
    private String Title;
    private String Desc;
    private @ServerTimestamp Date timestamp;
    private String Notice_id;

    public Notice_list(){

    }

    public Notice_list(String title, String desc, Date timestamp, String notice_id) {
        this.Title = title;
        this.Desc = desc;
        this.timestamp = timestamp;
        this.Notice_id = notice_id;
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

    public String getNotice_id() {
        return Notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.Notice_id = notice_id;
    }
}
