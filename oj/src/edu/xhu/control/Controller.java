package edu.xhu.control;

import edu.xhu.compile.Compiler;
import edu.xhu.compile.OJCCompiler;
import edu.xhu.compile.OJCPPCompiler;
import edu.xhu.compile.OJJavaCompiler;
import edu.xhu.entity.CompileMessage;
import edu.xhu.entity.JudgeResult;
import edu.xhu.entity.ResultType;
import edu.xhu.run.RunJavaThread;

/**
 * 
 * @author Trayvon
 * @since  2015年4月30日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class Controller
{
	private JudgeResult result;
	public  JudgeResult getResultMessage(String source , CompileType type)
	{
		switch(type)
		{
		case JAVA:dealWithJava(source);break;
		case C:dealWithC(source);break;
		case CPP:dealWithCPP(source);break;
		}
		return result;
	}
	private void dealWithJava(String source)
	{
		Compiler compiler = new OJJavaCompiler();
		compiler.compile(source);
		String message = compiler.getErrorMessage();
		System.out.println(message);
		if(message!=null&&message.length()!=0)
		{
			result = new JudgeResult(new CompileMessage(message));
			return;
		}
		RunJavaThread rjt = new RunJavaThread();
		long start = System.currentTimeMillis();
		rjt.start();
		while(System.currentTimeMillis()-start<5000)
		{
			if(!rjt.isAlive()) break;
		}
		if(rjt.isAlive())
		{
			rjt.setExceed(true);
			result = new JudgeResult();
			result.setResultType(ResultType.TLE);
		}
		else if(rjt.isAc())
		{
			result = new JudgeResult();
			result.setResultType(ResultType.AC);
		}
		else
		{
			result = new JudgeResult();
			result.setResultType(ResultType.WA);
		}
		
		return ;
	}
	
	private void dealWithCPP(String source)
	{
		Compiler compiler = new OJCPPCompiler();
		compiler.compile(source);
		String message = compiler.getErrorMessage();
		System.out.println(message);
		if(message!=null&&message.length()!=0)
		{
			result = new JudgeResult(new CompileMessage(message));
			return;
		}
		RunJavaThread rjt = new RunJavaThread();
		long start = System.currentTimeMillis();
		rjt.start();
		while(System.currentTimeMillis()-start<5000)
		{
			if(!rjt.isAlive()) break;
		}
		if(rjt.isAlive())
		{
			rjt.setExceed(true);
			result = new JudgeResult();
			result.setResultType(ResultType.TLE);
		}
		else if(rjt.isAc())
		{
			result = new JudgeResult();
			result.setResultType(ResultType.AC);
		}
		else
		{
			result = new JudgeResult();
			result.setResultType(ResultType.WA);
		}
		
		return ;
	}
	private void dealWithC(String source)
	{
		Compiler compiler = new OJCCompiler();
		compiler.compile(source);
		String message = compiler.getErrorMessage();
		System.out.println(message);
		if(message!=null&&message.length()!=0)
		{
			result = new JudgeResult(new CompileMessage(message));
			return;
		}
		RunJavaThread rjt = new RunJavaThread();
		long start = System.currentTimeMillis();
		rjt.start();
		while(System.currentTimeMillis()-start<5000)
		{
			if(!rjt.isAlive()) break;
		}
		if(rjt.isAlive())
		{
			rjt.setExceed(true);
			result = new JudgeResult();
			result.setResultType(ResultType.TLE);
		}
		else if(rjt.isAc())
		{
			result = new JudgeResult();
			result.setResultType(ResultType.AC);
		}
		else
		{
			result = new JudgeResult();
			result.setResultType(ResultType.WA);
		}
		
		return ;
		
	}
}
