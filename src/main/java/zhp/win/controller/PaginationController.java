package zhp.win.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhp.win.entity.PageData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
//当先的controll是用来分页的
//利用http的session来存放当前页的信息

@Controller
public class PaginationController {
    private Logger L= LoggerFactory.getLogger(PaginationController.class);
//  private int count=0;
    public void init(){

    }
    public Map nextPage(){
        return null;
    }
    @GetMapping("/list")
    public String PageList(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("count",0);
        return "xss";
    }
    @GetMapping("/next")
    @ResponseBody
    public PageData NextPage(HttpServletRequest request, HttpServletResponse response){
        int temp=(int)request.getSession().getAttribute("count");
        L.info("当前页为"+temp);
        temp++;
        request.getSession().setAttribute("count",temp);
        L.info("下一页为"+temp);
        return null;
    }
    @ResponseBody
    @GetMapping("/pre")
    public PageData Previous(HttpServletRequest request, HttpServletResponse response){
        int temp=(int)request.getSession().getAttribute("count");
        L.info("当前页为"+temp);
        temp--;
        if(!(temp<0)) request.getSession().setAttribute("count",temp);
        L.info("上一页为"+temp);
        return null;
    }
}
