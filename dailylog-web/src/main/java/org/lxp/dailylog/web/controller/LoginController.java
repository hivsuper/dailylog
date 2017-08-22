package org.lxp.dailylog.web.controller;

import static org.lxp.dailylog.web.util.StringHolder.USER;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.exception.DailylogException;
import org.lxp.dailylog.exception.VerificationCodeNotMatchException;
import org.lxp.dailylog.model.UserBase;
import org.lxp.dailylog.service.LoginService;
import org.lxp.dailylog.web.util.JsonVo;
import org.lxp.dailylog.web.util.Verify;
import org.lxp.dailylog.web.util.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author super
 * @since 2012-10-20 下午05:49:06
 * @version 1.0
 */
@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private static final String KAPTCHA_SESSION_KEY = "kaptcha_session_key";
    @Resource
    private LoginService loginService;
    @Resource
    private HttpSession session;

    @RequestMapping(value = "/", method = GET)
    @ApiOperation(value = "主页")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/WEB-INF/page/index/index.jsp");
        return mav;
    }

    @RequestMapping(value = "/login", method = GET)
    @ApiOperation(value = "登录页")
    public ModelAndView toLogin() {
        ModelAndView mav = new ModelAndView("/WEB-INF/page/login/login.jsp");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/login.json", method = POST, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "登录")
    public JsonVo<Void> login(@ApiParam(value = "账号") @RequestParam(required = true) String account,
            @ApiParam(value = "密码") @RequestParam(required = true) String password,
            @ApiParam(value = "验证码") @RequestParam(required = false) String verifycode) {
        JsonVo<Void> jsonVo = new JsonVo<>();
        try {
            if (hasText(verifycode) && !verifycode.equals(session.getAttribute(KAPTCHA_SESSION_KEY))) {
                throw new VerificationCodeNotMatchException(verifycode);
            } else {
                UserBase user = loginService.login(account, password);
                session.setAttribute(USER, user);
            }
        } catch (DailylogException e) {
            jsonVo.setRtn(e);
            LOG.error(e.getMessage(), e);
        }
        return jsonVo;
    }

    @RequestMapping(value = "/logout", method = GET)
    @ApiOperation(value = "登出")
    public String logout() {
        session.removeAttribute(USER);
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/verifyCode.json", method = GET)
    @ApiOperation(value = "生成验证码")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Verify verify = VerifyCodeUtils.generateVerify();
        session.setAttribute(KAPTCHA_SESSION_KEY, verify.getValue());
        VerifyCodeUtils.outputImage(120, 40, response.getOutputStream(), verify.getCode());
    }
}
