package org.lxp.dailylog.web.controller;

import javax.annotation.Resource;

import org.lxp.dailylog.dto.AccountDto;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.Page;
import org.lxp.dailylog.web.util.JsonVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @ResponseBody
    @PostMapping(value = "/add.json")
    @ApiOperation(value = "添加帐号")
    public JsonVo<AccountBase> add(@ModelAttribute AccountDto accountDto) {
        return JsonVo.success(accountService.addAccount(accountDto.getUsername(), accountDto.getEmail(),
                accountDto.getForgetPasswordEmail(), accountDto.getPhone(), accountDto.getProductName(),
                accountDto.getProductUrl(), accountDto.getJoinDate()));
    }

    @ResponseBody
    @GetMapping(value = "/list.json")
    @ApiOperation(value = "分页查询")
    public Page<AccountBase> list(@ApiParam(value = "关键字") @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = Page.DEFAULT_START) int start,
            @RequestParam(required = false, defaultValue = Page.DEFAULT_PAGE_SIZE) int length,
            @RequestParam(required = false) String draw) {
        return accountService.queryAccountPage(keyword, draw, start, length);
    }
}
