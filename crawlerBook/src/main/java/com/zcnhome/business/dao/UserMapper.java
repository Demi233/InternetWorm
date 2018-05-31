/**
 * BannerMapper.java 2017-8-1
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.dao;

import java.util.List;
import java.util.Map;

import com.zcnhome.business.models.UserModel;
import com.zcnhome.common.pojo.Page;

/**
 * UserMapper
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
public interface UserMapper {

    
  
   
    
    /**
     * 
     * 根据用户ID获取密码
     *
     * @author mike
     * @param id
     * @return
     * @since 2017年8月23日
     * @see
     */
    public String getPassword(long id);
    
    /**
     * 查询单个用户信息
     *
     * @author hqsun
     * @param id
     *            用户标识符
     * @return 用户Model对象
     * @since 2017-8-1
     */
    public UserModel getUser(UserModel userModel);
    
    /**
     * 
     * 根据unionId获取用户
     *
     * @author mike
     * @param userModel
     * @return
     * @since 2017年8月15日
     * @see
     */
    public UserModel getWixinUser(UserModel userModel);
    
    /**
     * 
     * 重置密码
     *
     * @author hqsun
     * @param userModel
     * @return
     * @since 2017-8-1
     * @see
     */
    public int updatePwd(UserModel userModel);

    
    /**
     * 校验用户唯一性
     * 
     * @author hqsun
     * @param param
     * @return
     * @since 2017-8-1
     * @see
     */
    public UserModel checkUserOnly(Map<String, Object> param);
}
