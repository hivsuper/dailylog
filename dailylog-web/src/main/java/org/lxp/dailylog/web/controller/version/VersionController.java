package org.lxp.dailylog.web.controller.version;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxp.dailylog.web.util.VerifyCodeUtils;
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
    public void version(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // VCodeGenerator v = new VCodeGenerator(4);
        // ImageIO.write(v.generatorRotateVCodeImage(v.generatorVCode(), true), "GIF",
        // response.getOutputStream());

//        ValidateCode vCode = new ValidateCode(120, 40, 5, 50);
//        vCode.getCode();
//        vCode.write(response.getOutputStream());
        
        VerifyCodeUtils.outputImage(120, 40, response.getOutputStream(), VerifyCodeUtils.generateVerify().getCode());
    }

}
