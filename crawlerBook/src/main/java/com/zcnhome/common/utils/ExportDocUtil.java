/**
 * ExportDocUtil.java 2017年9月8日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * <summary>
 * <description>
 * 
 * @author mike
 * @since 2017年9月8日
 * @see [Class/Method]
 *
 */
public class ExportDocUtil {

    /**
     * 私有化构造函数
     */
    private ExportDocUtil() {
    }

    private static ExportDocUtil instance;

    /**
     * 单例函数
     */
    public static ExportDocUtil getInstance() {
        if (instance == null) {
            instance = new ExportDocUtil();
        }
        return instance;
    }

    /**
     * 
     * 导出word文档
     *
     * @author mike
     * @param dataMap
     * @param catalog
     * @param template
     * @param exportPath
     * @return
     * @since 2017年9月8日
     * @see
     */
    @SuppressWarnings("deprecation")
    public File exportDoc(Map<String, Object> dataMap, String catalog, String template, String exportPath) {
        if (dataMap == null || dataMap.size() <= 0) {
            return null;
        }

        // 获取模板
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), catalog);
        Template t = null;

        File file = new File(exportPath);
        try {
            t = configuration.getTemplate(template);
            t.setEncoding("UTF-8");

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(exportPath), "UTF-8"));
            t.process(dataMap, out);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (TemplateException e) {
            e.printStackTrace();
        }
        return file;
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
    public  String getImageFromNetByUrl(String strUrl) {
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
    public  byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("designName", "华润凯旋门小区(测试)");
        dataMap.put("designer", "牛人设计师（测试）");
        dataMap.put("designerUnit", "金枕织巢鸟(测试)");
        
        dataMap.put("village", "测试小区");
        dataMap.put("projectName", "华润凯旋门小区 13#1006室 水电改造(测试)");
        dataMap.put("constAddress", "江苏省吴江市米龙谷(测试)");
        dataMap.put("createTime", "2017/09/08");
        
        dataMap.put("ssPlan", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        
        List<Map<String, Object>> ssList=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 4; i++) {
            Map<String, Object> ssMap = new HashMap<String, Object>();
            ssMap.put("no", i);
            ssMap.put("deviceName", i==0?"配电箱":"插座"+i);
            ssMap.put("position", "客厅");
            ssMap.put("distanceA", "入户门"+(i+1)*100);
            ssMap.put("distanceB", "标高"+(i+8)*100);
            ssList.add(ssMap);
        }
        dataMap.put("ssIndication", ssList);
        
        dataMap.put("llPlan", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        dataMap.put("spPlan", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        dataMap.put("dsrDiagram", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        dataMap.put("dbNum", "PZ30-12");
        dataMap.put("loopCount", "10");
        dataMap.put("scrDiagram", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        dataMap.put("lsrDiagram", ExportDocUtil.getInstance().getImageFromNetByUrl("http://ov0j32fqk.bkt.clouddn.com/%E6%95%B4%E4%BD%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg"));
        
        String catalog="/";
        String template="construction.xml";
        String exportPath="小册子导出A4按施工流程" + (new Date()).getTime() + ".doc";
        
        
        ExportDocUtil.getInstance().exportDoc(dataMap, catalog, template, exportPath);
    }
}
