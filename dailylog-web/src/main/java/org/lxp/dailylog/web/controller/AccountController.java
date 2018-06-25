package org.lxp.dailylog.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.lxp.dailylog.dto.AccountDto;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.web.util.JsonVo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/add.json", method = POST)
    @ApiOperation(value = "添加帐号")
    public JsonVo<AccountBase> add(@RequestHeader(required = true) String sessionId,
            @ModelAttribute AccountDto accountDto) {
        return JsonVo.success(accountService.addAccount(accountDto.getUsername(), accountDto.getRemail(),
                accountDto.getFpemail(), accountDto.getPhone(), accountDto.getProductname(), accountDto.getProducturl(),
                accountDto.getJoindate()));
    }
}
