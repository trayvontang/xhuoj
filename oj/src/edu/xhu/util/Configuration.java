package edu.xhu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @author Trayvon
 * @since  2015年4月29日
 * 
 */
public class Configuration
{
	private  final static Properties properties = new Properties() ;
	static
	{
//		 properties=new Properties();
		try
		{
			properties.load(new FileInputStream("configuration.properties"));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getJavaWorkplaceDir()
	{
		return (String) properties.get("JavaCompileAndRunDir");
	}
	
	public static String getCWorkplaceDir()
	{
		return (String) properties.get("CCompileAndRunDir");
	}
	public static void test()
	{
		Enumeration<?> enums = properties.propertyNames();
		while(enums.hasMoreElements())
		{
			Object key = enums.nextElement();
			System.out.println("key= "+key+ "   values= "+properties.get(key));
		}
	}
	public static void main(String[] args)
	{
		test();
		System.out.println(getCWorkplaceDir());
	}
}
