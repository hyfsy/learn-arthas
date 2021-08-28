package com.hyf.arthas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baB_hyf
 * @date 2021/08/01
 */
@RestController
@RequestMapping("test")
public class HelloController {
    
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    
    public static AtomicInteger i = new AtomicInteger(0);
    
    public AtomicInteger inner = new AtomicInteger(10);
    
    @RequestMapping("1")
    public String _1() {
        
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(HelloController.class.getClassLoader());
        
        if (log.isDebugEnabled()) {
            log.debug("this is debug level");
        }
        if (log.isTraceEnabled()) {
            log.trace("this is trace level");
        }
        
        i.incrementAndGet();
        inner.addAndGet(10);
        return "success";
    }
    
    @RequestMapping("2")
    public String _2(@RequestParam(required = false) String s, @RequestParam(required = false) Integer i) {
        if (s == null) {
            i = 1 / 0;
        }
        return s;
    }
    
    @RequestMapping("3")
    public String _3(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        
        System.out.println(request);
        System.out.println(response);
        System.out.println(httpSession);
        
        return "success";
    }
}
