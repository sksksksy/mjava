package zhp.win.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhp.win.config.SSOConfig;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class URLMapping {
    Logger logger= LoggerFactory.getLogger(URLMapping.class);
    private static String t;
    @Autowired
    SSOConfig ssoConfig;

    @GetMapping("/hel")
    public @ResponseBody String Hello(HttpServletRequest request, HttpServletResponse response){
        logger.info("zhe shi yi ge test");
        String u= UUID.randomUUID().toString();
        response.setHeader("x-Header-token",u);
        logger.info("hel:"+u);
        System.out.println(ssoConfig);
        return "hello<a href=\"http://127.0.0.1/test\">dianwo</a>:"+u;
    }
    @GetMapping("/test")
    @ResponseBody
    public String Test(HttpServletResponse response,HttpServletRequest request){
        String u=request.getHeader("x-Header-token");
        logger.info("test:"+u);
        return "helloa:"+u;
    }
    @GetMapping("/xss")
    public String xss(HttpServletResponse response,HttpServletRequest request){
        //URLEncoder.encode("","utf8");
        t=UUID.randomUUID().toString();
        Cookie cookie=new Cookie("cookieid",t);
        response.addCookie(cookie);
        return "xss";
    }
    @PostMapping("/getdata")
    public String data(HttpServletRequest request){
            //
        return "";
    }
    public boolean isRight(HttpServletRequest request){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        if(name!=null&&password!=null){

        }else {
            Cookie cookies[]=request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName()=="cookieid"){
                }
            }
        }
        return false;
    }
}
