package com.huaxia.base.bean;
/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 上午10:32:03
 */
public class Test {
	public boolean t(){
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.t());
	}
}
