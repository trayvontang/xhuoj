package edu.xhu.run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class RunJavaThread extends Thread
{
	private volatile boolean exceedTime = false;
	private static String exampleFile ="G:\\xhuoj\\oj\\addtest_input.txt";
	private static String answerFile = "G:\\xhuoj\\oj\\addtest_ans.txt"; 
	private Process process;
	private OutputStream out;
	private InputStream in;
	private BufferedReader standard;
	private boolean ac;
	private void initStandard()
	{
		try
		{
			FileReader fr = new FileReader(exampleFile);
			standard = new BufferedReader(fr);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run()
	{
		initStandard();
		while(!exceedTime)
		{
			RunJava rj = new RunJava();
			rj.start();
			process = rj.getProcess();
			while(process==null)
			{
				process = rj.getProcess();
			}
			out = process.getOutputStream();
			String str;
			try
			{
				while((str = standard.readLine())!=null)
				{
					out.write((str+"\n").getBytes());
				}
				out.flush();
				out.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in = process.getInputStream();
			
			BufferedReader outbr = new BufferedReader(new InputStreamReader(in));
			try
			{
				String temp;
				 standard = new BufferedReader(new FileReader(answerFile));
				while((str = standard.readLine()) != null && str.length()!=0)
				{
					System.out.println("s:"+str);
					temp = outbr.readLine();
					System.out.println(temp);
					if(temp==null||temp.length()==0)  
					{
						ac=false;
						return;
					}
					if(!str.equals(temp))
					{
						ac = false;
						return;
					}
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ac = true;
			break;
		}
		
	}
	public boolean isExceedTime()
	{
		return exceedTime;
	}
	public void setExceed(boolean exceedTime)
	{
		this.exceedTime = exceedTime;
	}
	public static String getAnswerFile()
	{
		return answerFile;
	}
	public static void setAnswerFile(String answerFile)
	{
		RunJavaThread.answerFile = answerFile;
	}
	public boolean isAc()
	{
		return ac;
	}
	public void setAc(boolean ac)
	{
		this.ac = ac;
	}
	
	
	
}
