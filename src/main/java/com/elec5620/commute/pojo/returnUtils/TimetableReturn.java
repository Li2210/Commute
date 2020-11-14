package com.elec5620.commute.pojo.returnUtils;

import java.util.Date;

/**
 * @Description TODO
 * @Author lishen
 * @Date 11/11/20 20:16
 **/
public class TimetableReturn {

    private int timetable_id;
    private int fk_user_id;
    private String time;
    private String things;

    public int getTimetable_id() {
        return timetable_id;
    }

    public void setTimetable_id(int timetable_id) {
        this.timetable_id = timetable_id;
    }

    public int getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(int fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }
}
