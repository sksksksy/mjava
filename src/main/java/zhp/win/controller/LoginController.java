package zhp.win.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhp.win.cache.RedisOperation;

import java.util.UUID;

@Controller
public class LoginController {
    private Logger l= LoggerFactory.getLogger(this.getClass());
    //private static Map<String,Object> temp= new HashMap<String,Object>();
    @Autowired
    private RedisOperation redisOperation;
    @PostMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password){
        if(name!=null&&"123456".equals(password)){
            String userId=UUID.randomUUID().toString().replace("-","");
            //put(userId,"ok");
            redisOperation.loginSet(userId,"ok");
            return "redirect:/user/"+ userId+".html";
        }
        return "redirect:login.html";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "redirect:login.html";
    }
    @GetMapping("/login.html")
    public ModelAndView page(ModelAndView model){
      //  model.addObject("welcome","Hi,Welcome to login this website.");
        model.setViewName("login");
        return model;
    }
    @RequestMapping(value = "/user/{userId}.html")
    public String redirectToMain(@PathVariable String userId, Model model){
        String returnResult;
        String satus=redisOperation.loginGet(userId);
        System.out.println("status is :"+satus);
        if(null!=satus&&satus.equals("ok")){
            returnResult="main";
        }else {
         //   model.addAttribute("welcome","Hi,Welcome to login this website.");
            model.addAttribute("loginStatus","用户未登录");
            returnResult="login.html";
        }
        return returnResult;
    }
    /**------------------------------------下面的暂时删除-----------------------------------------*/
    /**
     * 将k,v存入redis数据库
     * @param k
     * @param v
     */
   /* public void put(String k,Object v){
        temp.put(k,v);
    }*/

    /**
     * 根据K值从redis中取出数据
     * @param <T>
     * @param k
     * @return
     */
    /*public Object get(String k){
        Object t = temp.get(k);
        return t;
    }*/
}
