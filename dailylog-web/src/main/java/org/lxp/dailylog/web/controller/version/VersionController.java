package org.lxp.dailylog.web.controller.version;

import io.swagger.annotations.ApiOperation;
import org.lxp.dailylog.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    public Map<String, String> version() {
        Map<String, String> map = new HashMap<>();
        map.put("version", version);
        map.put("env", env);
        map.put("builtAt", DateUtil.zonedDateTimeToString(ZonedDateTime.parse(builtAt, DateTimeFormatter.ofPattern(format))));
        return map;
    }

}