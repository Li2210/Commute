package com.elec5620.commute.Controller;

import cn.hutool.crypto.SecureUtil;
import com.elec5620.commute.Service.TimetableService;
import com.elec5620.commute.Service.UserService;
import com.elec5620.commute.Utils.JwtUtils;
import com.elec5620.commute.pojo.Result;
import com.elec5620.commute.pojo.Timetable;
import com.elec5620.commute.pojo.User;
import com.elec5620.commute.pojo.returnUtils.TimetableReturn;
import com.elec5620.commute.pojo.returnUtils.UserProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 6/11/20 15:12
 **/
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private TimetableService timetableService;

    @Autowired
    JwtUtils jwtUtils;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/loadAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        List<User> allUserInfo = userService.getAllUserInfo();
        return allUserInfo;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public Result register(@RequestBody User requestUser) {
        Result result = new Result();
        String username = requestUser.getUsername();
        String address = requestUser.getAddress();
        String phoneNumber = requestUser.getPhoneNumber();
        String password = requestUser.getPassword();

        boolean flag = userService.userRegistered(username);
        if (!flag) {
            result.setResult(null);
            result.setStatus("username has been used, sorry");
            return result;
        }

        int i = userService.addUser(username, password, address, phoneNumber);
        result.setStatus("Correct");
        result.setResult(i);
        return result;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public Result login(@RequestBody User requestUser, HttpServletResponse response) {
        Result result = new Result();
        String username = requestUser.getUsername();
        User user = userService.getUserByUsername(username);
        if (user == null) {
            result.setStatus("username do not exists");
            result.setResult(null);
            return result;
        }

        if (!user.getPassword().equals(requestUser.getPassword())){
            result.setStatus("password wrong");
            result.setResult(null);
            return result;
        } else {
            String jwtToken = jwtUtils.generateToken(user.getId());

            response.setHeader("Authorization", jwtToken);
            response.setHeader("Access-control-Expose-Headers", "Authorization");

            UserProfile userProfile = new UserProfile();
            userProfile.setId(user.getId());
            userProfile.setUsername(user.getUsername());
            userProfile.setAddress(user.getAddress());
            userProfile.setPhoneNumber(user.getPhoneNumber());

            result.setResult(userProfile);
            result.setStatus("Correct");
            return result;
        }

    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/api/logout")
    public Result logout() {
        Result result = new Result();
        SecurityUtils.getSubject().logout();
        result.setStatus("successfully log out");
        result.setResult(null);
        return result;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/getTimetable/{fk_user_id}", method = RequestMethod.GET)
    public List<TimetableReturn> getTimetable(@PathVariable("fk_user_id")int fk_user_id) {

        List<Timetable> list = timetableService.getTimetableByUserId(fk_user_id);
        List<TimetableReturn> results = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TimetableReturn timetableReturn = new TimetableReturn();
            int time_id = list.get(i).getTimetable_id();
            int userId = list.get(i).getFk_user_id();
            String date = list.get(i).getDatetime();
            String things = list.get(i).getThings();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            timetableReturn.setTimetable_id(time_id);
            timetableReturn.setFk_user_id(userId);
            timetableReturn.setThings(things);
            timetableReturn.setTime(date);
            results.add(timetableReturn);
        }
        return results;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/addEvents", method = RequestMethod.POST)
    public Result addEvents(@RequestParam("user_id") int fk_user_id,
                            @RequestParam("date") String date, @RequestParam("things") String things)
    {
        Result result = new Result();
        int i = timetableService.addEvents(fk_user_id, date, things);
        result.setStatus("Correct");
        result.setResult(i);
        return result;
    }

}
