package demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import demo.entity.UserEntity;
import demo.http.Response;
import demo.http.ResponseCode;
import demo.service.UserService;
import demo.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 前端是url传这个
     * @param req
     * @param resp
     */
    @PostMapping(value = "/registered")
    public void registered(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String str = JsonUtils.getJsonStrByQueryUrl(req.getQueryString());
            //将json字符串转化成对应的javabean
            UserEntity userEntity = JSON.parseObject(str, UserEntity.class);
            Response<UserEntity> result = null;
            registered(resp, userEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 前端传json数据用这个
     * @param jsonObject
     * @param resp
     */
    @PostMapping(value = "/registeredjson")
    public void registered(@RequestBody JSONObject jsonObject, HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("UTF-8");
            //将json字符串转化成对应的javabean
            UserEntity userEntity = JSON.parseObject(jsonObject.toString(), UserEntity.class);
            Response<UserEntity> result;
            registered(resp, userEntity);
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
