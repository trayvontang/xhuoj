package edu.xhu.compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class SimpleCompare
{
	public static boolean judgeCompare(InputStream in,String ansFileName)
	{
		FileReader fr ;
		BufferedReader standard =null;
		BufferedReader toTest = new BufferedReader(new InputStreamReader(in));
		 try
		{
			fr = new FileReader(ansFileName);
			standard = new BufferedReader(fr);
			String tested,test;
			while(( test = standard.readLine())!=null)
			{
				tested = toTest.readLine();
				if(tested == null) return false;
				else
				{
//					if(compare(test,tested)) continue;
					if(test.equals(tested)) continue;
					else return false;
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}	
		 finally
		 {
			 try
			{
				standard.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		 }
		 return true;
	}
//	private static boolean compare(String source,String dst)
//	{
//		return true;
//	}
}
