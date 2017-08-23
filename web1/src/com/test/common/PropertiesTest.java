package com.test.common;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	Properties pro = new Properties();
	
	public static void main(String[] args){
		PropertiesTest pt = new PropertiesTest();
		try{
			pt.pro.load(PropertiesTest.class.getClassLoader().getResourceAsStream("db.properties")); // (최상위폴더를 바라봄, )
			System.out.println(pt.pro.getProperty("db.driver"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
