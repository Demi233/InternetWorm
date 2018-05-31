/**
 * MUserController.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.zcnhome.business.controller.mng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.zcnhome.business.commons.Constants;
import com.zcnhome.business.commons.FileUploadSupport;
import com.zcnhome.business.models.BoolInfoModel;
import com.zcnhome.business.models.RawFileModel;
import com.zcnhome.business.models.UserModel;
import com.zcnhome.business.service.BookInfoService;
import com.zcnhome.common.pojo.AjaxResponse;
import com.zcnhome.common.pojo.Page;

/**
 * 用户 Controller
 *
 * 
 * @author hqsun
 * @since 2017-8-1
 * @see [Class/Method]
 *
 */
@Controller
@RequestMapping("m/bookInfo")
public class MBookInfoController {
    /**
     * 日志系统
     */
    private Log logger = LogFactory.getLog(MBookInfoController.class);
    @Autowired
    BookInfoService bookInfoService;
    //跳转到获取图书的页面
    @RequestMapping(method = RequestMethod.GET, path = "/getBookInfoHtml")
    public ModelAndView list() {
    	
        logger.debug("MbookInfoController list begin");

        ModelAndView mv = new ModelAndView("mng/bookInfo/bookInfo");
        return mv;
    }

    
    /**
     * 
     * 将查询到的图书信息存储数据库，然后进行展示
     * */
    @RequestMapping(method = RequestMethod.POST, path = "/findPage") //和前台向后台发送请求的路径一致
    @ResponseBody
    public String findPage(BoolInfoModel boolInfoModel,String count, Page page,String url){  //cout：url最后的一个页数、url是爬取的路径
    	if(count!=null&&url!=null){
    		List<BoolInfoModel>  list= Crawler(count,url);  //根据前台传过来的url利用jsoup解析html并获得该url页面上所有的图书信息
        	List<String> tagList = bookInfoService.selectTag();  //返回tag（页数）列中唯一不同的值（例如：列中多个相同的则只会返回一个值）
        	List<String> titleList = bookInfoService.selectTitle();  //返回title（页数）列中唯一不同的值（例如：列中多个相同的则只会返回一个值）
        	for (BoolInfoModel boolInfo : list) { //bollInfoModel类型的boolInfo对象循环遍历list（该url页面上所有的图书信息）对象
        		
        		
        		if((!tagList.contains(boolInfo.getTag()))||(!titleList.contains(boolInfo.getTitle()))) {
        			boolInfo.setStatus(1);
        			bookInfoService.insert(boolInfo);   //将爬取到的数据存储到数据库中
        		};
        		
    		}
    	}
    
    	//从数据库中查询数据
    	 page.setSearchParam(boolInfoModel);
         List<BoolInfoModel> result = bookInfoService.find(page);
         String aj = AjaxResponse.fromData(page).toJSONString();
         return aj;
    }
    
    
 	/* 根据前台传过来的url利用jsoup解析html并获得该url页面上所有的图书信息*/
	public List<BoolInfoModel>  Crawler(String count,String bookUrl) { 
		List<BoolInfoModel> resultMap = new ArrayList<BoolInfoModel>();  //定义一个数组resultMap
		
			String url = bookUrl + count;
			try {
				Document doc = Jsoup.connect(url).get();                  //根据前台传过来的url，获取该url页面的整个HTML内容
				
				Elements itemElements = doc.getElementById("listBox").getElementsByClass("item");   //获取该url里的所有图书信息
				for (Element element : itemElements) {          //循环遍历itemElements对象并获取每本书的信息
					BoolInfoModel info = new BoolInfoModel();   //定义个info对象
					//获取该本书的图片信息
					Element pImageAElement = element.getElementsByClass("item-img").get(0).getElementsByTag("a").get(0);
					
					info.setLink(pImageAElement.attr("href"));  //修改info的link内容为该书超链接href

					Element pImageElement = pImageAElement.getElementsByTag("img").get(0);   //获取图片中的img信息
					info.setTitle(pImageElement.attr("alt"));    //给info对象的title字段赋值为图片的alt
					info.setImage(pImageElement.attr("src"));    //给info对象的image字段赋值为图片的alt
					//获取该图书的作者、出版、出版时间、价格等信息
					Elements textElements = element.getElementsByClass("item-info").get(0).getElementsByClass("text");
					
					info.setAuthor(textElements.get(0).text());    //给info对象的author字段赋值为该书的作者名
					info.setPress(textElements.get(1).text());     //给info对象的press字段赋值为该书的出版社名称
					info.setPressDate(textElements.get(2).text()); //给info对象的pressDate字段赋值为该书的出版日期
				
					if(textElements.size()==5) {
						info.setPrice(textElements.get(4).text()); //给info对象的price字段赋值为该书的价格
					}
						
					info.setTag(count);  //给info对象的tag字段赋值为该类图书所在的页数
					
					resultMap.add(info); //将该页面的所有图书信息存储到resultMap数组中
				}

			} catch (IOException e) { //输出异常错误
				e.printStackTrace();
			}
			
		return resultMap;     //返回该url页面所有的图书信息

	}
	
	
    /**
     * 删除图书数据
     * */
	@RequestMapping(method = RequestMethod.POST,path = "/delete")
	@ResponseBody
	public String delete(BoolInfoModel boolInfoModel){
		boolInfoModel.setStatus(0);    //后台给status赋值-1 ，然后传到数据库
		int result = bookInfoService.update(boolInfoModel);
		return result+"";
	}
    
}
