package demo.controller;

import com.alibaba.fastjson.JSON;
import demo.entity.UserEntity;
import demo.http.Response;
import demo.http.ResponseCode;
import demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Controller
@RequestMapping("")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 前端是url传这个
     * @param resp
     */
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public void registered(@RequestBody HashMap<String,String> map, HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("UTF-8");
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(map.get("username"));
            userEntity.setPassword(map.get("password"));
            registered(resp, userEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void userLogin(@RequestBody HashMap<String,String> map, HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("UTF-8");
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(map.get("username"));
            userEntity.setPassword(map.get("password"));
            Response<UserEntity> result = null;
            if(this.userService.userLogin(userEntity) != null){
                result = Response.build(ResponseCode.SUCCESS, "登录成功", new UserEntity());
            }else {
                result = Response.build(ResponseCode.ERROR, "用户名或密码错误", new UserEntity());
            }
            //转化成json字符串
            String jsonStr = JSON.toJSONString(result);
            PrintWriter pw = resp.getWriter();
            pw.println(jsonStr);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注冊
     * @param resp
     * @param userEntity
     * @throws IOException
     */
    private void registered(HttpServletResponse resp, UserEntity userEntity) throws IOException {
        Response<UserEntity> result;
        if (this.userService.selectUser(userEntity) != null) {//该用户存在
            result = Response.build(ResponseCode.ERROR, "该手机已注册", new UserEntity());
        } else {
            int flag = this.userService.registered(userEntity);
            if (flag == 1) {
                result = Response.build(ResponseCode.SUCCESS, "注册成功", new UserEntity());
            } else {
                result = Response.build(ResponseCode.ERROR, "注册失败", new UserEntity());
            }
        }
        //转化成json字符串
        String jsonStr = JSON.toJSONString(result);
        PrintWriter pw = resp.getWriter();
        pw.println(jsonStr);
        pw.flush();
    }
}
