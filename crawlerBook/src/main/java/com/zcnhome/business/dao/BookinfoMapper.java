package com.zcnhome.business.dao;


import java.util.List;

import com.zcnhome.business.models.BoolInfoModel;
import com.zcnhome.common.pojo.Page;

public interface BookinfoMapper {


    int deleteByPrimaryKey(Long id);

    int insert(BoolInfoModel record);
    
    BoolInfoModel selectByPrimaryKey(Long id);

    int update(BoolInfoModel record);
    
    List<String> selectTag();
    List<String> selectTitle();
    List<BoolInfoModel> find(Page page);
}