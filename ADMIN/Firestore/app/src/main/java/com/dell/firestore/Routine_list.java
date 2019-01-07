package com.dell.firestore;

public class Routine_list {
    private String Day;
    private int SN;
    private String Subject1;
    private String Subject2;
    private String Subject3;
    private String Subject4;
    private String Subject5;
    private String Time1, Time2,Time3, Time4, Time5;


    public int getSN() {return SN;}

    public void setSN(int SN) {this.SN = SN;}


    public void setDay(String day) {
        Day = day;
    }

    public void setSubject1(String subject1) {
        Subject1 = subject1;
    }

    public void setSubject2(String subject2) {
        Subject2 = subject2;
    }

    public void setSubject3(String subject3) {
        Subject3 = subject3;
    }

    public void setSubject4(String subject4) {
        Subject4 = subject4;
    }

    public void setSubject5(String subject5) {
        Subject5 = subject5;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }

    public void setTime3(String time3) {
        Time3 = time3;
    }

    public void setTime4(String time4) {
        Time4 = time4;
    }

    public void setTime5(String time5) {
        Time5 = time5;
    }

    public Routine_list(){

    }

    public Routine_list(String day,int SN ,String subject1, String subject2, String subject3, String subject4, String subject5, String time1, String time2, String time3, String time4, String time5) {

    }

    public String getDay() {
        return Day;
    }

    public String getSubject1() {
        return Subject1;
    }

    public String getSubject2() {
        return Subject2;
    }

    public String getSubject3() {
        return Subject3;
    }

    public String getSubject4() {
        return Subject4;
    }

    public String getSubject5() {
        return Subject5;
    }

    public String getTime1() {
        return Time1;
    }

    public String getTime2() {
        return Time2;
    }

    public String getTime3() {
        return Time3;
    }

    public String getTime4() {
        return Time4;
    }

    public String getTime5() {
        return Time5;
    }
}
