/**
 * MultipartResolver.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.zcnhome.business.commons.Constants.Commons;
import com.zcnhome.business.commons.Constants.SystemConfig;
import com.zcnhome.business.models.RawFileModel;
import com.zcnhome.common.dao.SystemConfigMapper;
import com.zcnhome.common.models.SystemConfigModel;

/**
 * 多文件上传分解器
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
@EnableScheduling
public class MultipartResolver extends CommonsMultipartResolver {

    /**
     * SystemConfig Mapper
     */
    @Autowired
    private SystemConfigMapper systemConfigMapper;

    /**
     * 系统配置信息
     */
    private Map<String, String> cfg = new HashMap<String, String>();

    /**
     * 默认构造初始化
     */
    public MultipartResolver(PropertiesHolder propertiesHolder) {
        super();

        super.setDefaultEncoding(Commons.CHARACTER_SET);

        // 配置上传的文件最大限制 MB
        long max = -1;
        max = propertiesHolder.bigInteger("sys.upload.file.max", max);
        max = max * 1024 * 1024;

        // 写入磁盘缓存大小
        super.setMaxInMemorySize(40960);

        // 上传总文件大小
        super.setMaxUploadSize(max);

        // 上传每个文件大小
        super.setMaxUploadSizePerFile(max);
    }

    /**
     * 获取上传文件流
     *
     * @author hqsun
     * @param request
     * @return
     * @throws IOException
     * @since 2016年12月26日
     */
    public InputStream getUploadStream(HttpServletRequest request) throws IOException {
        this.setServletContext(request.getServletContext());
        if (this.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itor = multiRequest.getFileNames();
            while (itor.hasNext()) {
                return multiRequest.getFile(itor.next()).getInputStream();
            }
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @author hqsun
     * @param request
     *            请求
     * @param path
     *            文件存储目的路径
     * @return 文件存储信息
     * @throws IOException
     * @since 2017-8-1
     */
    public List<RawFileModel> upload(HttpServletRequest request, String path) throws IOException {

        this.setServletContext(request.getServletContext());

        // 声明返回类型
        List<RawFileModel> rawFileList = null;

        if (this.isMultipart(request)) {
            rawFileList = new ArrayList<RawFileModel>();

            // 本地服务绝对路径
            String appPath = store();

            // 当前上传文件的原文件名
            String originalFileName = "";

            // 上传文件重新命名
            String newFileName = "";

            // 文件扩展名
            String extName = "";

            // 本地文件存储路径
            String localPath = "";

            // MD5摘要
            String digest = "";

            RawFileModel rawFile = null;
            File localFile = null;
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            // 取得request中的所有文件名
            Iterator<String> itor = multiRequest.getFileNames();
            MultipartFile file = null;

            while (itor.hasNext()) {
                // 取得上传文件
                file = multiRequest.getFile(itor.next());

                if (file != null) {
                    // 取得当前上传文件的文件名称
                    originalFileName = file.getOriginalFilename();

                    if (StringUtils.isNotBlank(originalFileName)) {

                        // 构造存储路径，用***/2016/10
                        if (!StringUtils.startsWith(path, "/")) {
                            path = "/" + path;
                        }
                        localPath = appPath + path + DateFormatter.formatDate("yyyy") + "/"
                                + DateFormatter.formatDate("MM") + "/";
                        localFile = new File(localPath);

                        if (!localFile.exists()) {
                            localFile.mkdirs();
                        }

                        // 重命名上传后的文件名
                        digest = EncryptUtil.md5(originalFileName + String.valueOf(UUID.randomUUID()));
                        newFileName = localPath + digest;

                        if (StringUtils.contains(originalFileName, ".")) {
                            extName = StringUtils.substringAfterLast(originalFileName, ".");
                            newFileName += ".";
                            newFileName += extName;
                        }

                        // 存储文件
                        localFile = new File(newFileName);
                        file.transferTo(localFile);

                        newFileName = StringUtils.substringAfterLast(newFileName, appPath);

                        // 构造返回对象
                        rawFile = new RawFileModel();
                        rawFile.setNum(digest);
                        rawFile.setFileName(originalFileName);
                        rawFile.setFilePath(newFileName);
                        rawFile.setExtName(extName);

                        rawFileList.add(rawFile);
                    }
                }
            }
        }

        return rawFileList;
    }
    
    
    /**
     * 上传文件
     *
     * @author hqsun
     * @param request
     *            请求
     * @param path
     *            文件存储目的路径
     * @return 文件存储信息
     * @throws IOException
     * @since 2017-8-1
     */
    public List<RawFileModel> upload(HttpServletRequest request,String avatar_data, String path) throws IOException {

        this.setServletContext(request.getServletContext());

        // 声明返回类型
        List<RawFileModel> rawFileList = null;

        if (this.isMultipart(request)) {
            rawFileList = new ArrayList<RawFileModel>();

            // 本地服务绝对路径
            String appPath = store();

            // 当前上传文件的原文件名
            String originalFileName = "";

            // 上传文件重新命名
            String newFileName = "";

            // 文件扩展名
            String extName = "";

            // 本地文件存储路径
            String localPath = "";

            // MD5摘要
            String digest = "";

            RawFileModel rawFile = null;
            File localFile = null;
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            // 取得request中的所有文件名
            Iterator<String> itor = multiRequest.getFileNames();
            MultipartFile file = null;
            
            JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
            // 用户经过剪辑后的图片的大小  
            float x = joData.getFloatValue("x");
            float y = joData.getFloatValue("y");
            float w = joData.getFloatValue("width");
            float h = joData.getFloatValue("height");

            while (itor.hasNext()) {
                // 取得上传文件
                file = multiRequest.getFile(itor.next());

                if (file != null) {
                    // 取得当前上传文件的文件名称
                    originalFileName = file.getOriginalFilename();

                    if (StringUtils.isNotBlank(originalFileName)) {

                        // 构造存储路径，用***/2016/10
                        if (!StringUtils.startsWith(path, "/")) {
                            path = "/" + path;
                        }
                        localPath = appPath + path + DateFormatter.formatDate("yyyy") + "/"
                                + DateFormatter.formatDate("MM") + "/";
                        localFile = new File(localPath);

                        if (!localFile.exists()) {
                            localFile.mkdirs();
                        }

                        // 重命名上传后的文件名
                        digest = EncryptUtil.md5(originalFileName + String.valueOf(UUID.randomUUID()));
                        newFileName = localPath + digest;

                        if (StringUtils.contains(originalFileName, ".")) {
                            extName = StringUtils.substringAfterLast(originalFileName, ".");
                            newFileName += ".";
                            newFileName += extName;
                        }

                        // 存储文件
                        localFile = new File(newFileName);
                        
                        try {
                            InputStream is = file.getInputStream();
                            ImageCutUtil.cut(is, localFile, (int) x, (int) y, (int) w, (int) h);
                            is.close();
                        }
                        catch (Exception e) {
                            throw e;
                        }

                        newFileName = StringUtils.substringAfterLast(newFileName, appPath);

                        // 构造返回对象
                        rawFile = new RawFileModel();
                        rawFile.setNum(digest);
                        rawFile.setFileName(originalFileName);
                        rawFile.setFilePath(newFileName);
                        rawFile.setExtName(extName);

                        rawFileList.add(rawFile);
                    }
                }
            }
        }

        return rawFileList;
    }

    /**
     * 将输入流复制到指定路径文件中
     *
     * @author hqsun
     * @param inputStream
     *            输入流
     * @param originName
     *            原文件名
     * @param path
     *            输出相对路径
     * @return
     * @throws IOException
     * @since 2017-8-1
     */
    public RawFileModel output(InputStream inputStream, String originName, String path) throws IOException {

        if (inputStream != null && StringUtils.isNotBlank(path)) {

            // 本地服务绝对路径
            String appPath = store();

            // 构造存储路径，用***/2016/10
            if (!StringUtils.startsWith(path, "/")) {
                path = "/" + path;
            }

            // 本地文件存储路径
            String localPath = appPath + path + DateFormatter.formatDate("yyyy") + "/" + DateFormatter.formatDate("MM")
                    + "/";

            File localFile = new File(localPath);

            if (!localFile.exists()) {
                localFile.mkdirs();
            }

            // 文件的原文件名
            String originalFileName = StringUtils.isNotBlank(originName) ? originName : "";

            // MD5摘要 重命名上传后的文件名
            String digest = EncryptUtil.md5(originalFileName + String.valueOf(UUID.randomUUID()));
            String newFileName = localPath + digest;

            // 文件扩展名
            String extName = "";

            if (StringUtils.contains(originalFileName, ".")) {
                extName = StringUtils.substringAfterLast(originalFileName, ".");
                newFileName += ".";
                newFileName += extName;
            }

            // 输出文件流
            OutputStream outputStream = null;

            try {
                outputStream = new FileOutputStream(newFileName);
                IOUtils.copyLarge(inputStream, outputStream);
            }
            finally {
                IOUtils.closeQuietly(inputStream, outputStream);
            }

            newFileName = StringUtils.substringAfterLast(newFileName, appPath);

            // 构造返回对象
            RawFileModel rawFile = new RawFileModel();
            rawFile.setNum(digest);
            rawFile.setFileName(originalFileName);
            rawFile.setFilePath(newFileName);
            rawFile.setExtName(extName);

            return rawFile;
        }

        return null;
    }

    /**
     * 获取本地文件存储目录
     *
     * @author hqsun
     * @return
     * @since 2017-8-1
     */
    public String store() {

        String s = getSysConf(SystemConfig.SYSTEM_FILES_PATH);

        if (StringUtils.isBlank(s)) {
            throw new RuntimeException("MultipartResolver store get\"system.files.path\" is Empty...");
        }

        return s;
    }

    /**
     * 获取系统配置信息
     *
     * @author hqsun
     * @param key
     *            参数键
     * @return 配置值
     * @since 2017年1月4日
     */
    public String getSysConf(String key) {

        if (MapUtils.isEmpty(cfg)) {
            this.loadSysStorage();
        }

        return cfg.get(key);
    }

    /**
     * 批量删除文件
     *
     * @author hqsun
     * @param rawFileList
     * @since 2016年10月25日
     */
    public void delete(List<RawFileModel> rawFileList) {

        if (CollectionUtils.isNotEmpty(rawFileList)) {
            for (RawFileModel raw : rawFileList) {
                delete(raw);
            }
        }
    }

    /**
     * 删除文件
     *
     * @author hqsun
     * @param rawFile
     * @since 2016年10月31日
     */
    public void delete(RawFileModel rawFile) {
        if (null != rawFile) {
            FileUtils.deleteQuietly(new File(store() + rawFile.getFilePath()));
        }
    }

    /**
     * 定时读取本地文件存储目录
     *
     * @author hqsun
     * @since 2016年12月21日
     */
    @Scheduled(fixedDelay = 600000)
    private void loadSysStorage() {
//      this.storage = System.getProperty("catalina.home") + "/" + "webapps";

        List<SystemConfigModel> list = systemConfigMapper.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (SystemConfigModel conf : list) {
                cfg.put(conf.getParamKey(), conf.getParamValue());
            }
        }
    }
}
