package edu.xhu.complete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import edu.xhu.control.CompileType;
import edu.xhu.control.Controller;
import edu.xhu.entity.JudgeResult;
import edu.xhu.entity.ResultType;

public class OJRunCTest
{
	@Test
	public void testRunC()
	{
		String source =null;
		try
		{
			FileReader fr = new FileReader("source\\add.c");
			BufferedReader br = new BufferedReader(fr);
			String str;
			StringBuffer sb = new StringBuffer();
			while((str = br.readLine())!=null)
			{
				sb.append(str+"\n");
				System.out.println(str);
			}
			source=sb.toString();
			br.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Controller controller = new Controller();
		JudgeResult result = controller.getResultMessage(source, CompileType.C);
		if(result.getResultType()==ResultType.AC)
		{
			System.out.println("AC");
		}
		else if(result.getResultType() == ResultType.WA)
		{
			System.out.println("WA");
		}
	}
}
