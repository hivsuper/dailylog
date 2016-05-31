package org.lxp.dailylog.web.controller.version;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

/**
 * @author Super.Li
 * @since 2015年7月19日
 */
@Controller
public class VersionController {
  @Value("${project.version}")
  private String version;
  @Value("${project.env}")
  private String env;
  @Value("${project.built.time}")
  private String builtAt;

  @ResponseBody
  @RequestMapping(value = "version", method = GET)
  @ApiOperation(value = "查看版本信息")
  public Map<String, String> version() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("version", version);
    map.put("env", env);
    map.put("builtAt", builtAt);
    return map;
  }

}
