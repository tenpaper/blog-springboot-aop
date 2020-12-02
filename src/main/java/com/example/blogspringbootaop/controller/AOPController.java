package com.example.blogspringbootaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 付疆疆
 * @date 2020/12/2 8:20
 */
@RestController
@Slf4j
public class AOPController {

    @GetMapping("/a")
    public void a(){
        log.info("来一箱方便面");
    }

    @GetMapping("/b")
    public void b(){
        log.info("来一盆酸菜面");
    }

    @GetMapping("/c")
    public void c(){
        log.info("来一桶卤蛋面");
    }

    @GetMapping("/d")
    public void d(){
        log.info("来一碗炸酱面");
    }

    @GetMapping("/e")
    public void e(){
        log.info("来一包干脆面");
    }

}
