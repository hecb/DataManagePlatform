/**
 * Project Name:DataManagePlatform
 * File Name:CycleTestInterface.java
 * Package Name:com.huaxia
 * Date:2017年1月5日下午1:41:37
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * ClassName: CycleTestInterface <br/>
 * Date: 2017年1月5日 下午1:41:37 <br/>
 * Description: TODO 
 *
 * @author GeC
 * @version 
 * @see
 */
public class CycleTestInterface {
    
    private static final String filename="E:/企业数据服务平台/hr.txt";
    
    private static final Map<String,String> interfaceTypeMap=new HashMap<String,String>();
    
    static{
        //interfaceTypeMap.put("号码是否黑名单", "http://111.198.162.10:8080/crp_test/inter/identity/telBlanklist.do");
        //interfaceTypeMap.put("用户状态查询", "http://111.198.162.10:8080/crp_test/inter/uniquery/telVerify.do");
        //interfaceTypeMap.put("用户名下号码个数查询", "http://111.198.162.10:8080/crp_test/inter/userstaus/userPnum.do");
        interfaceTypeMap.put("在网时长", "http://111.198.162.10:8080/crp_test/inter/userstaus/inUseTime.do");
        //interfaceTypeMap.put("当前终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/model.do");
        //interfaceTypeMap.put("历史终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/recently.do");
        //interfaceTypeMap.put("用户话费评分", "http://111.198.162.10:8080/crp_test/inter/avgbillcheck/avgPhoneScore.do");
      //  interfaceTypeMap.put("用户换机频率", "http://111.198.162.10:8080/crp_test/inter/terminal/phoneChange.do");
       // interfaceTypeMap.put("呼转风险验证", "http://111.198.162.10:8080/crp_test/inter/call/callforward.do");
    } 
    
    public static void main(String[] args) {
        CycleTestInterface cycleTest=new CycleTestInterface();
        List<String> tels= cycleTest.getTels(filename);
        System.out.println("在网时长： "+tels.size());
        String interfaceType="在网时长";
        cycleTest.cycleTest(tels, interfaceTypeMap.get(interfaceType), interfaceType);
    }
    
    public List<String> getTels(String filename ){
        List<String> list=new LinkedList<String>();
        FileInputStream fileInput=null;
        InputStreamReader inputReader=null;
        BufferedReader reader=null;
        try{
            fileInput=new FileInputStream(filename);
            inputReader=new InputStreamReader(fileInput);
            reader=new BufferedReader(inputReader);
            String message=null;
            while((message= reader.readLine())!=null ){
                list.add(message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(inputReader!=null){
                try {
                    inputReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(fileInput!=null){
                try {
                    fileInput.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        return list;
    }

    public void cycleTest(List<String> tels,String url,String vailtype ){
        System.out.println(vailtype+"接口测试开始,时间："+new Timestamp(System.currentTimeMillis())+",url="+url);
        TestSingleInterface testInterface=new TestSingleInterface();
        int sucCount=0,failCount=0;
        for(String tel:tels ){
            JSONObject json= testInterface.getSzjbaResult(tel, url, vailtype);
            System.out.println("手机号： "+tel+",返回结果： "+json);
            String status= json.getString("status");
            if("1".equals(status)){
                System.out.println("号码 "+tel+" 测试成功" );
                sucCount++;
            }else{
                failCount++;
            }
            
        }
        
        System.out.println(vailtype+"接口测试完成"+new Timestamp(System.currentTimeMillis()));
        System.out.println(vailtype+ "测试号码总数： "+tels.size()+",成功数量： "+sucCount+",失败数量："+failCount);
    }
}

