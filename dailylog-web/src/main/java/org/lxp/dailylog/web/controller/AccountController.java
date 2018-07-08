package org.lxp.dailylog.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.lxp.dailylog.dto.AccountDto;
import org.lxp.dailylog.model.AccountBase;
import org.lxp.dailylog.service.AccountService;
import org.lxp.dailylog.util.Page;
import org.lxp.dailylog.web.util.JsonVo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
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

    @ResponseBody
    @RequestMapping(value = "/list.json", method = GET)
    @ApiOperation(value = "分页查询")
    public JsonVo<Page<AccountBase>> list(@RequestHeader String sessionId,
                                          @ApiParam(value = "关键字") @RequestParam(required = false) String keyword,
                                          @RequestParam(required = false, defaultValue = Page.DEFAULT_CURRENT_PAGE) int page,
                                          @RequestParam(required = false, defaultValue = Page.DEFAULT_PAGE_SIZE) int pageSize) {
        return JsonVo.success(accountService.queryAccountPage(keyword, page, pageSize));
    }
}
