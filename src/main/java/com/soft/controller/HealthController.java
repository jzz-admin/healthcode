package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 这个类就是用于控制页面跳转的类
 */

@Controller // 告诉SpringBoot我是一个控制类
@RequestMapping("/health") // 指定路径，一级路径
public class HealthController {
    /**
     * 跳转到regist.html
     * 由于我们要做跳转，需要有一个带页面名称的对象
     * ModelAndView可以包含需要跳转的页面名称
     * Model：数据模型
     * And
     * View：视图
     */
    @RequestMapping("/toReg") // 二级路径
    public ModelAndView toRegist(String city, HttpServletRequest req){

        System.out.println(city);

        // 创建一个ModelAndView
        ModelAndView mav = new ModelAndView();
        // 设置要跳转的页面名称
        mav.setViewName("regist.html");
        // 把得到的数据放到Model中
        // 第一个参数就是页面获取值的标识
        // 第二个参数就是页面获取值的标识的值
        mav.addObject("city", city);

        // 为了保证第一次选择的城市能在后面所有的页面中都能正常显示
        // 需要把获取到的城市信息放到一个大家都能访问到的容器中
        // 这个容器叫做session

        // 如何获取session，需要通过HttpServletRequest这个对象来获取

        // 需要通过HttpServletRequest这个对象哪里来？
        // 在参数上添加即可

        // 获取session容器
        HttpSession session = req.getSession();
        // 把获取到的内容放到session中
        // 第一个参数就是页面获取值的标识
        // 第二个参数就是页面获取值的标识的值
        session.setAttribute("all_city",city);

        return mav;
    }

    /**
     * 由于要做跳转，需要有一个能带页面名称的对象
     * ModelAndView可以包含需要跳转的页面名称
     * @return
     */
    @RequestMapping("/toRes") // 二级路径
    public ModelAndView toResult(String q1, String q2, String q3, String q4, String q5, String q6, String q7){
        // 创建一个ModelAndView
        ModelAndView mav = new ModelAndView();
        // 设置要跳转的页面名称
        mav.setViewName("result.html");
        // mav.addObject("city", "abc");

        // q1：是否在当前城市
        // q2：是否在离开过当前所在地
        // q3-q5：是否有发热症状和接触过疑似人员
        // q6-q7：条款

        // 所有的选项都没有选中的情况：null或者是""  ==> 红码
        if(
                (q1 == null || "".equals(q1)) &&
                (q2 == null || "".equals(q2)) &&
                (q3 == null || "".equals(q3)) &&
                (q4 == null || "".equals(q4)) &&
                (q5 == null || "".equals(q5)) &&
                (q6 == null || "".equals(q6)) &&
                (q7 == null || "".equals(q7))
        ) {
            System.out.println("对不起：红码！");
            mav.addObject("qrCodeColor", "red");
            return mav;
        }

        //      是否有发热症状和接触过疑似人员 ==> 红码
        //          q3 - q5 = 1
        if(
                "1".equals(q3) && "1".equals(q4) && "1".equals(q5)
        ){
            System.out.println("对不起：红码！");
            mav.addObject("qrCodeColor", "red");
             return mav;
        }

        if(
                "1".equals(q3) || "1".equals(q4) || "1".equals(q5)
        ){
            System.out.println("对不起：黄码！");
            mav.addObject("qrCodeColor", "yellow");
            return mav;
        }

        // 全部都选择：
        //      都正常： ==> 绿码
        //          q1 = 1
        //          q2 = 0
        //          q3 - q5 = 0
        //          q6 - q7 = 1
        if(
                "1".equals(q1) && "0".equals(q2) && "0".equals(q3) &&
                        "0".equals(q4) && "0".equals(q5) && "1".equals(q6) &&
                        "1".equals(q6)

        ){
            System.out.println("对不起：绿码！");
            mav.addObject("qrCodeColor", "green");
            return mav;
        }

        // 如果部分选择：有1 有 0 ==> 黄码
        if(
                (q1 != null && !"".equals(q1)) ||
                (q2 != null && !"".equals(q2)) ||
                (q3 != null && !"".equals(q3)) ||
                (q4 != null && !"".equals(q4)) ||
                (q5 != null && !"".equals(q5)) ||
                (q6 != null && !"".equals(q6)) ||
                (q7 != null && !"".equals(q7))
        ){
            System.out.println("对不起：黄码！");
            mav.addObject("qrCodeColor", "yellow");
            return mav;
        }

        return mav;
    }

    @RequestMapping("/qrText")
    @ResponseBody
    public String qrcodeText(){
        return "haha" + new Date();
    }
}
