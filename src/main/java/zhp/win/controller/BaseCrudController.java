package zhp.win.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseCrudController {


    //基本的查
    @ResponseBody
    @GetMapping("/crud")
    public String query(String name){
        return name+":query";
    }
    //基本的增
    @ResponseBody
    @PostMapping("/crud")
    public String insert(String name){
        return name+":insert";
    }
    //基本的改
    @ResponseBody
    @PutMapping("/crud")
    public String update(String name){
        return name+":update";
    }
    //基本的删
    @ResponseBody
    @DeleteMapping("/crud")
    public String delete(String name){
        return name+":delete";
    }

}
