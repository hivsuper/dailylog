package org.lxp.dailylog.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private LoginService loginService;
    @Resource
    private HttpSession session;

    @ResponseBody
    @RequestMapping(value = "/login.json", method = POST, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "登录")
    public JsonVo<UserVo> login(@ApiParam(value = "账号", required = true) @RequestParam String account,
                                @ApiParam(value = "密码", required = true) @RequestParam String password,
                                @ApiParam(value = "验证码", required = true) @RequestParam String verifyCode)
            throws VerificationCodeNotMatchException, CredentialNotMatchException {
        JsonVo<UserVo> jsonVo;
        if (hasText(verifyCode) && !verifyCode.equals(SessionHelper.getVerify(session))) {
            throw new VerificationCodeNotMatchException();
        } else {
            UserVo user = new UserVo(loginService.login(account, password));
            SessionHelper.addUser(session, user);
            jsonVo = JsonVo.success(user);
            SessionHelper.removeVerify(session);
            LOG.info("{} login successfully.", user.getId());
        }
        return jsonVo;
    }

    @RequestMapping(value = "/logout.json", method = GET)
    @ApiOperation(value = "登出")
    public JsonVo<Void> logout() {
        SessionHelper.removeUser(session);
        return JsonVo.success();
    }

    @ResponseBody
    @RequestMapping(value = "/verifyCode.json", method = GET)
    @ApiOperation(value = "生成验证码")
    public void getVerifyCode(HttpServletResponse response) throws IOException {
        Verify verify = VerifyCodeUtils.generateVerify();
        SessionHelper.setVerify(session, verify);
        VerifyCodeUtils.outputImage(120, 40, response.getOutputStream(), verify.getCode());
    }

    @RequestMapping(value = "/heartBeat.json", method = GET)
    public JsonVo<Void> heartBeat() {
        return JsonVo.success();
    }
}
