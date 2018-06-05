package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.PayNotify;
import com.stylefeng.guns.modular.system.service.IPayNotifyService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-06-05 14:55:19
 */
@Controller
@RequestMapping("/payNotify")
public class PayNotifyController extends BaseController {

    private String PREFIX = "/system/payNotify/";

    @Autowired
    private IPayNotifyService payNotifyService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "payNotify.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/payNotify_add")
    public String payNotifyAdd() {
        return PREFIX + "payNotify_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/payNotify_update/{payNotifyId}")
    public String payNotifyUpdate(@PathVariable Integer payNotifyId, Model model) {
        PayNotify payNotify = payNotifyService.selectById(payNotifyId);
        model.addAttribute("item",payNotify);
        LogObjectHolder.me().set(payNotify);
        return PREFIX + "payNotify_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return payNotifyService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(PayNotify payNotify) {
        payNotifyService.insert(payNotify);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer payNotifyId) {
        payNotifyService.deleteById(payNotifyId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(PayNotify payNotify) {
        payNotifyService.updateById(payNotify);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{payNotifyId}")
    @ResponseBody
    public Object detail(@PathVariable("payNotifyId") Integer payNotifyId) {
        return payNotifyService.selectById(payNotifyId);
    }
}
