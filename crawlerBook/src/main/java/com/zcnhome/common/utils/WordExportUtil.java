/**
 * WordExportUtil.java 2017年9月9日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeUtility;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.zcnhome.business.commons.Constants;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * The <code>WordExportUtil</code> class is a util class for word export.
 * 工具类：实现根据freemark 模板导出word文件
 * 
 * @author mike
 * @since 2017年9月9日
 * @see [Class/Method]
 *
 */
public class WordExportUtil {
    public static String WORD_2007 = "WORD_2007";
    public static String WORD_2003 = "WORD_2003";

    /**
     * 设置下载文件中文件的名称
     * 
     * @param filename
     * @param request
     * @return
     */
    public static String encodeFilename(String filename, HttpServletRequest request) {
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(filename);
            return URLEncoder.encode(filename, "UTF-8");
        }
        catch (Exception ex) {
            return filename;
        }
    }

    /**
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param version Word_2003/Word_2007
     * @param docFileName 生成的doc临时文件名
     * @param templateFile freemark模板文件名
     * @param beanParams 入参数据: Map<String, Object>类型
     */
    public static ResponseEntity<byte[]> writeResponse(HttpServletRequest request, String version,
            String docFileName, String templateFile, Map<String, Object> beanParams) {
        return writeResponse(request, version, UUID.randomUUID().toString(), docFileName, "ftl", templateFile, beanParams);
    }

    /**
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param version Word_2003/Word_2007
     * @param docTempDir 生成的doc临时文件目录
     * @param docFileName 生成的doc临时文件名
     * @param templateDir 存放freemark模板的目录
     * @param templateFile freemark模板文件名
     * @param beanParams 入参数据: Map<String, Object>类型
     */
    @SuppressWarnings("deprecation")
    public static ResponseEntity<byte[]> writeResponse(HttpServletRequest request, String version,
            String docTempDir, String docFileName, String templateDir, String templateFile,
            Map<String, Object> beanParams) {
        Configuration config = new Configuration();
        ServletContext sc = request.getSession().getServletContext();
        File previewFile = null;
        try {
            config.setDirectoryForTemplateLoading(new File(sc.getRealPath("/" + templateDir)));
            config.setObjectWrapper(new DefaultObjectWrapper());
            Template template = config.getTemplate(templateFile, "UTF-8");
            
            docFileName=new String(docFileName.getBytes(Constants.Commons.CHARACTER_SET), "iso-8859-1");
            if (WORD_2007.equals(version)) {
//                docFileName = encodeFilename(docFileName + ".docx", request);
                docFileName = docFileName + ".docx";
            }
            else {
//                docFileName = encodeFilename(docFileName + ".doc", request);
                docFileName = docFileName + ".doc";
            }
            String docName = request.getSession().getServletContext().getRealPath("/")+ docFileName;
            
            
            previewFile = new File(docName);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docName), "UTF-8"));
            template.process(beanParams, out);
            out.flush();  
            out.close();
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
            headers.setContentDispositionFormData("attachment", docFileName);  
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(previewFile),headers, HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (previewFile != null) {
                previewFile.delete();
            }
        }
        
        return null;
    }
    
    
    /**
     * 
     * 根据地址获得数据的字节流
     *
     * @author mike
     * @param 网络连接地址
     * @return
     * @since 2017年9月8日
     * @see
     */
    public static String getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return Base64.encodeBase64String(btImg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * 从输入流中获取数据
     *
     * @author mike
     * @param inStream
     * @return
     * @throws Exception
     * @since 2017年9月8日
     * @see
     */
    public static  byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
