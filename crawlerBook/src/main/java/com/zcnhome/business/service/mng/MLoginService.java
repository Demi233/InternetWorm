/**
 * MUserService.java 2017-8-1
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.service.mng;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zcnhome.business.commons.Constants;
import com.zcnhome.business.dao.UserMapper;
import com.zcnhome.business.models.LoginRecordsModel;
import com.zcnhome.business.models.UserModel;
import com.zcnhome.common.utils.EncryptUtil;

/**
 * MUserService
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
@Service
@Transactional
public class MLoginService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(MLoginService.class);

    /**
     * UserMapper
     */
    @Autowired
    private UserMapper userMapper;
    
    
    
    /**
     * 
     * 根据条件查询账号密码
     *
     * @author hqsun
     * @param user
     *            用户模型
     * @return 持久化操作码
     * @since 2017-8-1
     * @see
     */
    public UserModel login(UserModel user, HttpSession session, HttpServletRequest request) {
        logger.debug("UserService get begin" + user);
        String password = EncryptUtil.md5(user.getPassword());
        user.setPassword(password);

        //基本信息
        UserModel result = userMapper.getUser(user);

        //userSessionPojo.

        if (result != null) {
            if (result.getPassword().equals(user.getPassword())) {

                session.setAttribute(Constants.Commons.SESSION_STORE_USER, result);
                LoginRecordsModel loginRecordsModel = new LoginRecordsModel();
                String ip = request.getRemoteAddr();
                String agent = request.getHeader("User-Agent").toLowerCase();
                loginRecordsModel.setClientIp(ip);
                if (agent.contains("trident")) {
                    loginRecordsModel.setDevice(1);
                }
                else if (agent.contains("edge")) {
                    loginRecordsModel.setDevice(5);
                }
                else if (agent.contains("chrome") && agent.contains("windows nt") && agent.contains("safari")) {
                    loginRecordsModel.setDevice(2);
                }
                else if (agent.contains("firefox")) {
                    loginRecordsModel.setDevice(3);
                }
                else if (!agent.contains("windows nt") && agent.contains("safari")) {
                    loginRecordsModel.setDevice(4);
                }
                else {
                    loginRecordsModel.setDevice(6);
                }
                loginRecordsModel.setUserId(result.getId());
            }

        }
        logger.debug("LoginService get end" + user);
        return result;

    }

}
