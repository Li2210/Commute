package com.elec5620.commute.Service.Impl;

import com.elec5620.commute.Dao.TimetableDao;
import com.elec5620.commute.Service.TimetableService;
import com.elec5620.commute.pojo.Timetable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 11/11/20 19:31
 **/

@Service("timetableService")
public class TimetableServiceImpl implements TimetableService {

    @Resource
    private TimetableDao timetableDao;

    @Override
    public List<Timetable> getTimetableByUserId(int fk_user_id) {
        List<Timetable> list = this.timetableDao.getTimetableByUserId(fk_user_id);
        return list;
    }

    @Override
    public int addEvents(int fk_user_id, String datetime, String things) {
        Timetable timetable = new Timetable();
        timetable.setFk_user_id(fk_user_id);
        timetable.setDatetime(datetime);
        timetable.setThings(things);
        return this.timetableDao.addEvents(timetable);
    }

}
