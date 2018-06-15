package org.lxp.dailylog.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.exception.CredentialNotMatchException;
import org.lxp.dailylog.exception.VerificationCodeNotMatchException;
import org.lxp.dailylog.service.LoginService;
import org.lxp.dailylog.vo.UserVo;
import org.lxp.dailylog.web.util.JsonVo;
import org.lxp.dailylog.web.util.SessionHelper;
import org.lxp.dailylog.web.util.Verify;
import org.lxp.dailylog.web.util.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;
    @Resource
    private HttpSession session;

    @ResponseBody
    @RequestMapping(value = "/", method = GET)
    @ApiOperation(value = "主页")
    public String index(HttpServletRequest request) {
        return request.getSession().getId();
    }

    @ResponseBody
    @RequestMapping(value = "/login.json", method = POST, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "登录")
    public JsonVo<UserVo> login(@ApiParam(value = "账号") @RequestParam(required = true) String account,
            @ApiParam(value = "密码") @RequestParam(required = true) String password,
            @ApiParam(value = "验证码") @RequestParam(required = false) String verifycode)
            throws VerificationCodeNotMatchException, CredentialNotMatchException {
        JsonVo<UserVo> jsonVo;
        if (hasText(verifycode) && !verifycode.equals(SessionHelper.getVerify(session))) {
            throw new VerificationCodeNotMatchException(verifycode);
        } else {
            UserVo user = new UserVo(loginService.login(account, password));
            SessionHelper.addUser(session, user);
            jsonVo = JsonVo.success(user);
            LOG.info("{} login successfully.", user.getSeqid());
        }
        return jsonVo;
    }

    @RequestMapping(value = "/logout", method = GET)
    @ApiOperation(value = "登出")
    public String logout() {
        SessionHelper.removeUser(session);
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/verifyCode.json", method = GET)
    @ApiOperation(value = "生成验证码")
    public void getVerifyCode(HttpServletResponse response) throws IOException {
        Verify verify = VerifyCodeUtils.generateVerify();
        SessionHelper.setVerify(session, verify);
        VerifyCodeUtils.outputImage(120, 40, response.getOutputStream(), verify.getCode());
    }
}
