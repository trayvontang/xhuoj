package edu.xhu.compile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * OJCPPCompiler 继承了AbstractCompiler 实现了compile方法
 * @see AbstractCompiler
 * @see OJCCompiler
 * 
 * @author Trayvon
 * @since  2015年4月30日
 *  www.xhu.edu.cn
 */
public class OJCPPCompiler extends AbstractCompiler
{
	/**
	 * 用g++编译指定fileName的文件输出exeFileName的可执行文件
	 */
	private final String compileCPPCommand = "g++ "+fileName+" -o "+exeFileName;
	@Override
	public boolean compile(String source)
	{
		return compile(source,null);
	}


	@Override
	public boolean compile(String source, String name)
	{
		if(name==null||name.length()==0)
			writeToFile(source);
		else
			writeToFile(source,name);
		Runtime run = Runtime.getRuntime();
		Process process = null;
		try
		{
//			System.out.println(compileCPPCommand);
			process = run.exec(compileCPPCommand);
			InputStream err = process.getErrorStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(err));
			errorMessage=reader.readLine();
			if(errorMessage==null||errorMessage.length()==0) return false;
			else
			{
				String str;
				StringBuffer sb = new StringBuffer();
				while((str=reader.readLine())!=null)
				{
					sb.append(str+"\n");
				}
				errorMessage = errorMessage+sb.toString();
			}
			
		} catch (IOException e)
		{
			logger.error(e.getMessage());
		}
		return true;
	}

}
