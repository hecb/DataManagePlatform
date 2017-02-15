/**
 * Project Name:DataManagePlatform
 * File Name:SequenceBuilder.java
 * Package Name:com.huaxia
 * Date:2017年1月5日下午2:59:01
 * Copyright (c) 2017, China Link Communications LTD All Rights Reserved.
 *
 */


package com.huaxia;

import java.util.UUID;

/**
 * ClassName: SequenceBuilder <br/>
 * Date: 2017年1月5日 下午2:59:01 <br/>
 * Description: TODO 
 *
 * @author GeC
 * @version 
 * @see
 */
public class SequenceBuilder {

    public static void main(String[] args) {
        String sequence=sequence();
        System.out.println("sequence="+sequence);

    }
    
    public static String sequence( ){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String str=uuid.substring(0, 8);
        return str;
    }

}

