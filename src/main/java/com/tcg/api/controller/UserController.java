package com.tcg.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.tcg.userprovider.entity.ReturnData;
import com.tcg.userprovider.service.MailService;
import com.tcg.userprovider.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 14861
 */
@Controller
@Api(tags = "用户操作接口")
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @Reference(version = "1.0.0")
    MailService mailService;

    @ResponseBody
    @PostMapping("/login")
    @ApiOperation(value = "用户登录",
        notes = "(code,message)\n(0,\"login success\")\n(1,\"login failed\")\ndata数据为用户token,可放在请求header中进行用户验证")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)})
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ReturnData returnData = userService.login(username, password);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/register")
    @ApiOperation(value = "用户注册",
        notes = "(code,message)\n(0,\"register success\")\n(1,\"register failed\")\n(2,\"user already exist\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true),
        @ApiImplicitParam(name = "email", value = "邮箱", required = true),
        @ApiImplicitParam(name = "verifyCode", value = "验证码", required = true)})
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,
        @RequestParam("email") String email, @RequestParam("verifyCode") String verifyCode) {
        ReturnData returnData = userService.register(username, password, email, verifyCode);
        return JSON.toJSONString(returnData);
    }

    @ResponseBody
    @PostMapping("/sendMail")
    @ApiOperation(value = "发送验证码至指定邮箱", notes = "(code,message)\n(0,\"send success\")\n(1,\"send failed\")")
    @ApiImplicitParams({@ApiImplicitParam(name = "email", value = "邮箱地址", required = true)})
    public String sendMail(@RequestParam("email") String email) {
        ReturnData returnData = mailService.sendCode(email);
        return JSON.toJSONString(returnData);
    }

}
