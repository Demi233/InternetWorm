/**
 * FileUploadSupport.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zcnhome.business.commons.Constants.Commons;
import com.zcnhome.business.commons.Constants.FileType;
import com.zcnhome.business.commons.Constants.SystemConfig;
import com.zcnhome.business.models.RawFileModel;
import com.zcnhome.business.models.UserModel;
import com.zcnhome.common.utils.MultipartResolver;

/**
 * 公共文件上传
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
@Component
public class FileUploadSupport {

    /**
     * 统一上传文件路径前缀
     */
    private static final String OPEN_RESOURCES = "openresources/";

    /**
     * 用户资源文件路径前缀
     */
    private static final String USER = "user/";

    /**
     * 轮播图Banner资源文件路径前缀
     */
    private static final String BANNER = "banner/";

    /**
     * 最新资讯资源文件路径前缀
     */
    private static final String INFORMATION = "news/";

    /**
     * 友情链接资源文件路径前缀
     */
    private static final String COOPERATION_LINK = "cooperation_link/";

    /**
     * 二维码资源文件路径前缀
     */
    private static final String QR_CODE = "qr_code/";

    /**
     * 图片路径
     */
    private static final String IMAGE_PATH = "image/";

    /**
     * 宣传视频
     */
    private static final String PROPAGANDA_VIDEO_PATH = "propaganda/video/";

    /**
     * 用户头像图片上传路径
     */
    private static final String USER_IMAGE = OPEN_RESOURCES + USER + IMAGE_PATH;

    /**
     * 轮播图Banner封面图片上传路径
     */
    private static final String BANNER_IMAGE = OPEN_RESOURCES + BANNER + IMAGE_PATH;

    /**
     * 最新资讯图片上传路径
     */
    private static final String INFORMATION_IMAGE = OPEN_RESOURCES + INFORMATION + IMAGE_PATH;

    /**
     * 友情链接图片上传路径
     */
    private static final String COOPERATION_LINK_IMAGE = OPEN_RESOURCES + COOPERATION_LINK + IMAGE_PATH;

    /**
     * 二维码图片输出路径
     */
    private static final String QR_CODE_IMAGE = OPEN_RESOURCES + QR_CODE + IMAGE_PATH;

    /**
     * 宣传视频
     */
    private static final String WEB_PROPAGANDA_VIDEO = OPEN_RESOURCES + PROPAGANDA_VIDEO_PATH;

    /**
     * 多文件上传分解器
     */
    @Autowired
    private MultipartResolver multipartResolver;


    /**
     * 获取上传原始文件句柄
     *
     * @author hqsun
     * @param relatePath
     *            相对路径
     * @return 文件句柄
     * @since 2017-8-1
     */
    public File file(String relatePath) {
        return new File(multipartResolver.store() + "/" + relatePath);
    }

    /**
     * 用户头像图片
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2017-8-1
     */
    public List<RawFileModel> userImage(HttpServletRequest request,String avatar_data) {
        return this.upload(request,avatar_data, USER_IMAGE, FileType.USER_ICON);
    }
    
    /**
     * 
     * 用户头像图片
     *
     * @author mike
     * @param request
     * @return
     * @since 2017年9月7日
     * @see
     */
    public List<RawFileModel> userImage(HttpServletRequest request) {
        return this.upload(request,USER_IMAGE, FileType.USER_ICON);
    }

    /**
     * 上传轮播图Banner封面
     * 
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2016年9月23日
     */
    public List<RawFileModel> bannerImage(HttpServletRequest request) {
        return this.upload(request, BANNER_IMAGE, FileType.BANNER_IMAGE);
    }


    /**
     * 上传最新资讯图片
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2016年11月18日
     */
    public List<RawFileModel> informationImage(HttpServletRequest request) {
        return this.upload(request, INFORMATION_IMAGE, FileType.NEWS_IMAGE);
    }

    /**
     * 上传友情链接图片
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2017-8-1
     */
    public List<RawFileModel> cooperationLinkImage(HttpServletRequest request) {
        return this.upload(request, COOPERATION_LINK_IMAGE, FileType.FRIENDLY_URL_IMAGE);
    }

    /**
     * 输出二维码图片
     *
     * @author hqsun
     * @param inputStream
     *            输入流
     * @param originName
     *            原文件名
     * @param creator
     *            用户id
     * @return
     * @since 2017-8-1
     */
    public RawFileModel qrCodeImage(InputStream inputStream, String originName, Long creator) {
        return this.output(inputStream, originName, QR_CODE_IMAGE, FileType.QR_IMAGE, creator);
    }

    /**
     * 上传宣传视频
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2017-8-1
     */
    public List<RawFileModel> propagandaVideo(HttpServletRequest request) {
        return this.upload(request, WEB_PROPAGANDA_VIDEO, FileType.PROPAGANDA_VIDEO);
    }


  

    /**
     * 获取上传文件流
     *
     * @author hqsun
     * @param request
     * @return
     * @since 2016年12月26日
     */
    public InputStream getUploadStream(HttpServletRequest request) {
        InputStream in = null;
        try {
            in = multipartResolver.getUploadStream(request);
        }
        catch (IOException e) {
            IOUtils.closeQuietly(in);
            throw new RuntimeException(e);
        }
        return in;
    }

    /**
     * 获取文件存储的绝对路径
     *
     * @author hqsun
     * @param fileName
     * @return
     * @since 2016年12月29日
     */
    public String getCanonicalPath(String fileName) {
        try {
            return canonicalFile(fileName).getCanonicalPath();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取本地文件存储目录
     *
     * @author hqsun
     * @return
     * @since 2016年12月21日
     */
    public String store() {
        return multipartResolver.store();
    }

    /**
     * 上传文件
     *
     * @author hqsun
     * @param request
     * @param path
     * @param type
     *            1,头像
     * @return
     * @since 2016年10月25日
     */
    private List<RawFileModel> upload(HttpServletRequest request, String path, Integer type) {

        // 上传文件，物理存储
        List<RawFileModel> rawFileList = null;

        try {
            rawFileList = multipartResolver.upload(request, path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // session的userId
        Long userId = null;
        HttpSession session = request.getSession();
        if (null != session) {
//            Object object = session.getAttribute(Commons.SESSION_STORE_USER);
            Object object = session.getAttribute(Commons.SESSION_WEB_USER);
            if (object instanceof UserModel) {
                UserModel userSession = (UserModel) object;
                userId = userSession.getId();
            }
        }

        save2DB(rawFileList, type, userId);

        return rawFileList;
    }
    
    
    /**
     * 上传文件
     *
     * @author hqsun
     * @param request
     * @param path
     * @param type
     *            1,头像
     * @return
     * @since 2016年10月25日
     */
    private List<RawFileModel> upload(HttpServletRequest request, String avatar_data, String path, Integer type) {

        // 上传文件，物理存储
        List<RawFileModel> rawFileList = null;

        try {
            rawFileList = multipartResolver.upload(request, avatar_data, path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // session的userId
        Long userId = null;
        HttpSession session = request.getSession();
        if (null != session) {
//            Object object = session.getAttribute(Commons.SESSION_STORE_USER);
            Object object = session.getAttribute(Commons.SESSION_WEB_USER);
            if (object instanceof UserModel) {
                UserModel userSession = (UserModel) object;
                userId = userSession.getId();
            }
        }

        save2DB(rawFileList, type, userId);

        return rawFileList;
    }

    /**
     * 保存文件
     *
     * @author hqsun
     * @param inputStream
     *            输入流
     * @param originName
     *            原文件名
     * @param path
     *            目标存储相对路径
     * @param type
     *            资源类型
     * @param creator
     *            用户id
     * @return
     * @since 2017-8-1
     */
    private RawFileModel output(InputStream inputStream, String originName, String path, Integer type, Long creator) {

        // 文件物理存储
        RawFileModel raw = null;

        try {
            raw = multipartResolver.output(inputStream, originName, path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            IOUtils.closeQuietly(inputStream);
        }

        if (raw != null) {
            List<RawFileModel> rawFileList = new ArrayList<>(1);
            rawFileList.add(raw);

            save2DB(rawFileList, type, creator);
        }

        return raw;
    }

    /**
     * 数据库存储原始文件MD5映射信息
     *
     * @author hqsun
     * @param rawFileList
     *            资源文件列表
     * @param type
     *            资源类型
     * @param creator
     *            用户id
     * @since 2017-8-1
     */
    private void save2DB(List<RawFileModel> rawFileList, Integer type, Long creator) {
        if (CollectionUtils.isNotEmpty(rawFileList)) {
            try {
                // 填充文件类型，上传文件的用户id
                for (RawFileModel raw : rawFileList) {
                    raw.setType(type);
                    raw.setCreator(creator);

                    raw.setAccess("resource/access/" + Base64.getUrlEncoder().encodeToString(
                            (raw.getFilePath() + Commons.DOLLAR + raw.getFileName()).getBytes(Commons.CHARACTER_SET)));
                }

            }
            catch (Exception e) {
                // 删除已物理存储的文件
                multipartResolver.delete(rawFileList);

                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 拼接用户存储文件的全路径
     *
     * @author hqsun
     * @param fileName
     *            文件名
     * @return
     * @since 2016年12月28日
     */
    public File canonicalFile(String fileName) {
        String file = multipartResolver.getSysConf(SystemConfig.USER_FILES_PATH);

        if (!StringUtils.endsWith(file, "/") && !StringUtils.startsWith(fileName, "/")) {
            file += "/";
        }
        file += fileName;
        return new File(file);
    }

}
