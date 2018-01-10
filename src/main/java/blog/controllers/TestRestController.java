package blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fanzhe on 2018/1/4.
 */
@Controller
@RequestMapping("/test")
public class TestRestController {

    private Logger log = LoggerFactory.getLogger(TestRestController.class);

    @RequestMapping("/")
    public String test(){
        return "test/index";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String test1(@RequestParam(required = true,name = "first") String first,
                        @RequestParam(required = true,name = "second")String second,
                        @RequestParam(name = "third",required = false)String third){
        log.info(first);
        log.info(second);
        log.info(third);
        log.info("test1");
        return "test/test1";
    }


    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    public String test2(String first,
                        String second,
                        String third){
        log.info("test2");
        return "test/test2";
    }

    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    public String test3(@RequestBody(required = true) String first,
                        @RequestBody(required = true)String second,
                        @RequestBody(required = false)String third){
        log.info(first);
        log.info(second);
        log.info(third);
        log.info("test3");
        return "test/test3";
    }

}
