package com.hyf.arthas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baB_hyf
 * @date 2021/08/01
 */
@RestController
public class StatController {
    
    private final static Logger logger = LoggerFactory.getLogger(StatController.class);
    
    @RequestMapping("api/stat")
    //    public String stat(@RequestBody(required = false) String body, HttpServletRequest request) {
    //
    //        Map<String, String[]> parameterMap = request.getParameterMap();
    //        System.out.println(parameterMap);
    //
    //        System.out.println(body);
    //
    //        return "success";
    //    }
    
    public Map<String, Object> execute(@RequestParam(value = "ip", required = true) String ip,
            @RequestParam(value = "version", required = true) String version,
            @RequestParam(value = "command", required = true) String command,
            @RequestParam(value = "arguments", required = false, defaultValue = "") String arguments) {
        
        logger.info("arthas stat, ip: {}, version: {}, command: {}, arguments: {}", ip, version, command, arguments);
        
        Map<String, Object> result = new HashMap<>();
        
        result.put("success", true);
        
        return result;
    }
}
