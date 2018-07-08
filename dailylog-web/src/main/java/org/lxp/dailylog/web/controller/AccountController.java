package org.lxp.dailylog.web.controller;

import io.swagger.annotations.ApiOperation;
import org.lxp.dailylog.dto.AccountDto;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.web.util.JsonVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/add.json", method = POST)
    @ApiOperation(value = "添加帐号")
    public JsonVo<AccountBase> add(@RequestHeader String sessionId,
                                   @ModelAttribute AccountDto accountDto) {
        return JsonVo.success(accountService.addAccount(accountDto.getUsername(), accountDto.getEmail(),
                accountDto.getForgetPasswordEmail(), accountDto.getPhone(), accountDto.getProductName(), accountDto.getProductUrl(),
                accountDto.getJoinDate()));
    }
}
