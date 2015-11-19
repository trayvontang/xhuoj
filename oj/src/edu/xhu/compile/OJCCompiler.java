package edu.xhu.compile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * OJCCompiler继承了AbstractCompiler是编译c源代码的实现
 * @see AbstractCompiler
 * @see OJCPPCompiler
 * 
 * @author Trayvon
 * @since  2015年4月30日
 *  www.xhu.edu.cn
 * 
 */
public class OJCCompiler extends AbstractCompiler
{
	/**
	 * 编译命令用gcc编译指定fileName文件，输出exeFileName的可执行文件
	 */
	private final String compileCCommand = "gcc "+fileName+" -o "+exeFileName;
	
	/**
	 *  编译源代码source
	 */
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
			process = run.exec(compileCCommand);
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
