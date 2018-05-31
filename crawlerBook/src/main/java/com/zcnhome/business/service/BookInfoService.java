/**
 * MUserService.java 2017-8-1
 * 
 * Copyright 2001-2016 All rights reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zcnhome.business.dao.BookinfoMapper;
import com.zcnhome.business.dao.UserMapper;
import com.zcnhome.business.models.BoolInfoModel;
import com.zcnhome.business.models.UserModel;
import com.zcnhome.common.pojo.Page;
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
public class BookInfoService {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(BookInfoService.class);

  
    @Autowired
    private BookinfoMapper bookinfoMapper;
    
   

   public  int deleteByPrimaryKey(Long id) {
	return bookinfoMapper.deleteByPrimaryKey(id);
    	
    };

    public int insert(BoolInfoModel record) {
		return bookinfoMapper.insert(record);
    	
    };



    public BoolInfoModel selectByPrimaryKey(Long id) {
		return bookinfoMapper.selectByPrimaryKey(id);
    	
    };



    public int update(BoolInfoModel record) {
    	
		return bookinfoMapper.update(record);
    };
    
    public  List<String> selectTag() {
    	
 		return bookinfoMapper.selectTag();
     };
     public  List<String> selectTitle() {
     	
  		return bookinfoMapper.selectTitle();
      };
//查询数据
     public List<BoolInfoModel> find(Page page){
    	 return bookinfoMapper.find(page);
     }
   
}
