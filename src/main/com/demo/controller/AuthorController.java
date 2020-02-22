package demo.controller;

import com.alibaba.fastjson.JSON;
import demo.entity.Author;
import demo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("")
public class AuthorController {
    @Resource
    private AuthorService authorService;

    @RequestMapping(value = "/findAuthorName", method = RequestMethod.POST)
    public void findAuthor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String _id = req.getParameter("_id");
        Author author = this.authorService.findAuthorById(_id);
        //将javabean转化成json字符串
        String jsonStr = JSON.toJSONString(author);
        //将json字符串转化成对应的javabean
        //Bean bean = JSON.parseObject(jsonStr, Bean.class);
        PrintWriter pw = resp.getWriter();
        pw.println(jsonStr);
        pw.flush();
    }
}
