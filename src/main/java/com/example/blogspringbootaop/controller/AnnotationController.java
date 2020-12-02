package com.example.blogspringbootaop.controller;

import com.example.blogspringbootaop.annotation.HasPermissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tenpaper
 * @date 2020/12/2 16:33
 */
@RestController
@Slf4j
public class AnnotationController {

    @HasPermissions
    @GetMapping("/aa")
    public void aa(){
        log.info("今天不吃面了");
    }

    @HasPermissions("小兄弟今天吃点啥")
    @GetMapping("/bb")
    public void bb(){
        log.info("今天继续吃面");
    }
}
