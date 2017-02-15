/**
 * Project Name:DataManagePlatform
 * File Name:TestSingleInterface.java
 * Package Name:com.huaxia
 * Date:2017年1月5日下午2:45:33
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;

import net.sf.json.JSONObject;

/**
 * ClassName: TestSingleInterface <br/>
 * Date: 2017年1月5日 下午2:45:33 <br/>
 * Description: TODO 
 *
 * @author GeC
 * @version 
 * @see
 */
public class TestSingleInterface {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("号码是否黑名单", "http://111.198.162.10:8080/crp_test/inter/identity/telBlanklist.do");
        map.put("用户状态查询", "http://111.198.162.10:8080/crp_test/inter/uniquery/telVerify.do");
        map.put("用户名下号码个数查询", "http://111.198.162.10:8080/crp_test/inter/userstaus/userPnum.do");
        map.put("在网时长", "http://111.198.162.10:8080/crp_test/inter/userstaus/inUseTime.do");
        map.put("当前终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/model.do");
        map.put("历史终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/recently.do");
        map.put("用户话费评分", "http://111.198.162.10:8080/crp_test/inter/avgbillcheck/avgPhoneScore.do");
        map.put("用户换机频率", "http://111.198.162.10:8080/crp_test/inter/terminal/phoneChange.do");
        map.put("呼转风险验证", "http://111.198.162.10:8080/crp_test/inter/call/callforward.do");
        TestSingleInterface test = new TestSingleInterface();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            test.getSzjbaResult("13166090610",entry.getValue(),entry.getKey());
        }

    }
    
    public JSONObject getSzjbaResult(String tel,String url,String vailtype){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = formatter.format(date);
        String sequence = SequenceBuilder.sequence();
        String orgSeq =tel+"_"+"secboot_cJ89u_"+"SPHWU8iW8_hU#9YQ_"+dateStr+"_"+sequence;
        String md5Val = DigestUtils.md5DigestAsHex(orgSeq.getBytes()).toUpperCase();
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        if("号码是否黑名单".equals(vailtype)){
            sb.append("?telNo="+tel);
        }else{
            sb.append("?sendTelNo="+tel);
        }
        
        sb.append("&orgCode=secboot_cJ89u");
        sb.append("&curTime="+dateStr);
        sb.append("&orgSeq="+md5Val);
        sb.append("&sequence="+sequence);
        JSONObject json = this.httpPost(sb.toString());
        return json;
    }
    
    
    public static JSONObject httpPost(String url) {

        // post请求返回结果

        DefaultHttpClient httpClient = new DefaultHttpClient();

        JSONObject jsonResult = null;

        HttpPost post = new HttpPost(url);
        try {

            post.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=utf-8");

            HttpResponse result = httpClient.execute(post);

            url = URLDecoder.decode(url, "UTF-8");

            /** 请求发送成功，并得到响应 **/

            if (result.getStatusLine().getStatusCode() == 200) {

                String str = "";

                try {

                    /** 读取服务器返回过来的json字符串数据 **/

                    str = EntityUtils.toString(result.getEntity());

                    /** 把json字符串转换成json对象 **/

                    jsonResult = JSONObject.fromObject(str);

                } catch (Exception e) {
                    e.printStackTrace();
                    // logger.error("post请求提交失败:" + url, e);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            // logger.error("post请求提交失败:" + url, e);

        }

        return jsonResult;

    }
    
}

