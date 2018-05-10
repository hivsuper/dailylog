package org.lxp.dailylog.web.controller.version;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxp.dailylog.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
public class VersionController {
    @Value("${project.version}")
    private String version;
    @Value("${project.env}")
    private String env;
    @Value("${project.buildTime}")
    private String builtAt;
    @Value("${project.format}")
    private String format;

    @ResponseBody
    @RequestMapping(value = "/version", method = GET)
    @ApiOperation(value = "查看版本信息")
    public Map<String, String> version(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("version", version);
        map.put("env", env);
        map.put("builtAt", DateUtil.format(ZonedDateTime.parse(builtAt, DateTimeFormatter.ofPattern(format))));
        return map;
    }

}