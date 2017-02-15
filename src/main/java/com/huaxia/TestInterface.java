package com.huaxia;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;

public class TestInterface {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
	//	map.put("号码是否黑名单", "http://111.198.162.10:8080/crp_test/inter/identity/telBlanklist.do");
	//	map.put("用户状态查询", "http://111.198.162.10:8080/crp_test/inter/uniquery/telVerify.do");
	//	map.put("用户名下号码个数查询", "http://111.198.162.10:8080/crp_test/inter/userstaus/userPnum.do");
	//	map.put("在网时长", "http://111.198.162.10:8080/crp_test/inter/userstaus/inUseTime.do");
	//	map.put("当前终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/model.do");
	//	map.put("历史终端情况", "http://111.198.162.10:8080/crp_test/inter/terminal/recently.do");
	//	map.put("用户话费评分", "http://111.198.162.10:8080/crp_test/inter/avgbillcheck/avgPhoneScore.do");
	//	map.put("用户换机频率", "http://111.198.162.10:8080/crp_test/inter/terminal/phoneChange.do");
	//	map.put("呼转风险验证", "http://111.198.162.10:8080/crp_test/inter/call/callforward.do");
		TestInterface test = new TestInterface();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			test.getSzjbaResult("18667172198",entry.getValue(),entry.getKey());
		}
		
		
	}
	
	public JSONObject getSzjbaResult(String tel,String url,String vailtype){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = formatter.format(date);
//		System.out.println(dateStr);
		String sequence = getSeq(date);
//		System.out.println(sequence);
		String orgSeq =tel+"_"+"secboot_cJ89u_"+"SPHWU8iW8_hU#9YQ_"+dateStr+"_"+sequence;
		String md5Val = DigestUtils.md5DigestAsHex(orgSeq.getBytes()).toUpperCase();
//		System.out.println(md5Val);
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
		System.out.println(vailtype+":    "+json);
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
    
	private static  String getSeq(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
		
		String[] strs = formatter.format(date).split("-");
		char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<strs.length;i++ ){
			if(i == 1){
				strs[i] = chars[Integer.parseInt(strs[i])]+"";
			}else if( i == 2){
				strs[i] = chars[Integer.parseInt(strs[i])]+"";
			}else if(i == 3){
				strs[i] = chars[Integer.parseInt(strs[i])]+"";
			}else if(i == 4){
				strs[i] = chars[Integer.parseInt(strs[i])]+"";
			}
			
			sb.append(strs[i]);
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}
}
