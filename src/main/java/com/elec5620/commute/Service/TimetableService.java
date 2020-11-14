package com.elec5620.commute.Service;

import com.elec5620.commute.pojo.Timetable;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 11/11/20 19:30
 **/
public interface TimetableService {

    List<Timetable> getTimetableByUserId(int fk_user_id);

    int addEvents(int fk_user_id, String datetime, String things);

}
