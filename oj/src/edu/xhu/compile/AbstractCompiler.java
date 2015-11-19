package edu.xhu.compile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import edu.xhu.util.Configuration;

/**
 * 
 * @author Trayvon
 * @since  2015年4月30日
 *  www.xhu.edu.cn
 * 
 * 
 */
public abstract class AbstractCompiler implements Compiler
{
	protected Logger logger = Logger.getLogger(OJCPPCompiler.class);
	
	/**
	 * workDir oj系统运行时的工作目录
	 */
	protected final String workDir = Configuration.getCWorkplaceDir();
	
	/**
	 *  c和c++的写入本地文件名，默认为main.cpp
	 */
	protected  String fileName =workDir+"\\"+"main.cpp";
	
	/**
	 *  c和c++ 默认的编译输出文件名
	 */
	protected  String exeFileName=workDir+"\\"+"execute";
	
	/**
	 * 编译的错误信息，如果编译正确，errorMessage为空
	 */
	protected  String errorMessage ;
	
	@Override
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	/**
	 *  确保工作目录存在
	 */
	private void ensureWorkspace()
	{
		File workspace = new File(workDir);
		if(!workspace.exists())
			workspace.mkdirs();
	}
	
	/**
	 *  把代码写入本地文件
	 * @param source 要写入本地文件的代码
	 */
	protected void writeToFile(String source)
	{
		writeToFile(source,null);
	}
	
	
	/**
	 * 把代码写入本地文件用name指定的文件名，如果name为空，则用默认的文件名
	 * @param source 要写入文件的代码
	 * @param name 指定的文件名
	 * @return 返回文件名
	 */
	protected String writeToFile(String source,String name)
	{
		File file;
		ensureWorkspace();
		if(name!=null)
			setFileName(name);
		 file = new File(fileName);
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(source);
			bw.flush();
			bw.close();
		} catch (IOException e)
		{
			logger.error(e.getMessage());
		}
		return name;
	}
	
	/**
	 *  编译代码
	 * @param source 源代码
	 * @param name 文件名
	 * @return 返回错误信息
	 */
	public String compileCode(String source,String name)
	{
		if(!compile(source,name))
		{
			getErrorMessage();
			return errorMessage;
		}
		return null;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String name)
	{
		this.fileName = workDir+"\\"+name+".cpp";
	}

	public String getExeFileName()
	{
		return exeFileName;
	}

	public void setExeFileName(String name)
	{
		this.exeFileName = workDir+"\\"+name;
	}
	
	
}
