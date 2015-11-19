package edu.xhu.run;

import java.io.IOException;

import org.apache.log4j.Logger;
/**
 * 
 * @author Trayvon
 * @since  2015年4月30日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class RunJava extends Thread
{
	private static Logger logger = Logger.getLogger(RunCCPP.class);
	private static final String command = "java Main";
	private Process process;
	@Override
	public void run()
	{
		Runtime execution = Runtime.getRuntime();
		try
		{
			process =execution.exec(command);
		} catch (IOException e)
		{
			logger.error(e.getMessage());
		}
	}
	public Process getProcess()
	{
		return process;
	}
	public void setProcess(Process process)
	{
		this.process = process;
	}
	
}
