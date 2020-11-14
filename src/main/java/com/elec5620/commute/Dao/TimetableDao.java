package com.elec5620.commute.Dao;

import com.elec5620.commute.pojo.Timetable;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 11/11/20 19:22
 **/
public interface TimetableDao {

    List<Timetable> getTimetableByUserId(int fk_user_id);

    int addEvents(Timetable timetable);

    int removeEvents();

}
