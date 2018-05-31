/**
 * MMainController.java 2017-8-1
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.controller.mng;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.zcnhome.business.commons.Constants;
import com.zcnhome.business.models.UserModel;
import com.zcnhome.business.service.mng.MLoginService;
import com.zcnhome.common.pojo.AjaxResponse;

/**
 * MMainController
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
@Controller
@RequestMapping("/m")
public class MMainController {

    private Log logger = LogFactory.getLog(MMainController.class);

    @Autowired
    private MLoginService mLoginService;
    
    
    /**
     * 
     * 后台登录页
     * <p>
     * GET /mng/auth/index
     * 
     * @author hqsun
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public ModelAndView index(HttpServletRequest request) {
        return new ModelAndView("mng/login").addObject("redirect", "");
    }

    /**
     * 
     * 后台登录页（隐藏导航）
     * <p>
     * POST /mng/auth/index
     * 
     * @author hqsun
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/index")
    public ModelAndView indexNav(HttpServletRequest request, @RequestParam("redirect") String redirect) {
        return new ModelAndView("mng/login").addObject("redirect", request.getParameter("redirect"));
    }

    /**
     * 
     * 登录信息验证
     * <p>
     * post /mng/login
     * 
     * @author hqsun
     * @param user
     *            用户模型
     * @param session
     *            会话模型
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    @ResponseBody
    public String login(UserModel user, HttpSession session, HttpServletRequest request, HttpServletResponse response,
            @RequestParam("redirect") String redirect) {
        logger.debug("MngLoginCtrl login begin" + user + ", redirect=" + redirect);
        AjaxResponse ajax = new AjaxResponse(true);
        UserModel result = mLoginService.login(user, session, request);
        if (null != result) {
            session.setAttribute("userModel", result);
        }
        else {
            ajax.toError();
        }
        logger.debug("MngLoginCtrl login end" + user);
        return AjaxResponse.fromData(ajax).toJSONString();
    }
    
    /**
     * 后台管理主页
     * <p>
     * GET /mng/auth/main
     * 
     * @author hqsun
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.GET, path = "/main")
    public ModelAndView main(HttpServletRequest request) {
        return new ModelAndView("mng/index").addObject("nav", "");
    }

    /**
     * 后台管理主页（允许导航）
     * <p>
     * GET /mng/auth/main
     * 
     * @author hqsun
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.GET, path = "/main/{nav:[a-zA-Z\\-]+}")
    public ModelAndView mainNav(HttpServletRequest request, @PathVariable("nav") String nav) {
        return new ModelAndView("mng/index").addObject("nav", nav);
    }
    
    /**
     * 
     * 后端mng用户登出
     *
     * @author hqsun
     * @param session
     * @param request
     * @param sessionStatus
     * @return
     * @since 2017-8-1
     * @see
     */
    @RequestMapping(method = RequestMethod.GET, path = "/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request, SessionStatus sessionStatus) {
        String redirect = request.getParameter("redirect");
        String flag = request.getParameter("flag");

        ModelAndView mv = new ModelAndView("/mng/logout").addObject("redirect", redirect);

        if (flag != null && !"".equals(flag)) {
            mv.addObject("msg", "系统已经超时，请重新登录！");
        }

        //清空session
        session.removeAttribute(Constants.Commons.SESSION_STORE_USER);
        session.invalidate();
        sessionStatus.setComplete();

        return mv;
    }
}
