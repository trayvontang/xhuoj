package edu.xhu.entity;


/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class JudgeResult
{
	private CompileMessage compileMessage;
	private RunMessage	   runMessage;
	private ResultType     resultType;
	
	public JudgeResult()
	{
		super();
	}
	public JudgeResult(CompileMessage compileMessage)
	{
		super();
		this.compileMessage = compileMessage;
	}
	public CompileMessage getCompileMessage()
	{
		return compileMessage;
	}
	public void setCompileMessage(CompileMessage compileMessage)
	{
		this.compileMessage = compileMessage;
	}
	public RunMessage getRunMesaage()
	{
		return runMessage;
	}
	public void setRunMesaage(RunMessage runMesaage)
	{
		this.runMessage = runMesaage;
	}
	public ResultType getResultType()
	{
		setResultType();
		return resultType;
	}
	private void setResultType()
	{
		if(compileMessage != null)
		{
			if(!compileMessage.isRight())
			{
				this.resultType = ResultType.CE; 
				return;
			}
		}
		if(runMessage != null)
		{
			CheckRunMessage crm = new CheckRunMessage();
			if(crm.checkTime()>0)
			{
				this.resultType = ResultType.TLE;
			}
			if(crm.checkMemory()>0)
			{
				this.resultType = ResultType.MLE;
			}
			return ;
		}
	}
	
	
	
	public void setResultType(ResultType resultType)
	{
		this.resultType = resultType;
	}



	class CheckRunMessage
	{
		final int exetime = 1000;
		final long memory = 262144; //1<<18 
		long checkTime()
		{
			return runMessage.getTime()-exetime;
		}
		long checkMemory()
		{
			return runMessage.getMemory()-memory;
		}
	}
	
	
}
