package me.dennis.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Produces;

@Controller
@RequestMapping("/test")
@Produces({"application/json;charset=UTF-8"})
public class TestController {

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public String getById(){

        return "testController";
    }
}
