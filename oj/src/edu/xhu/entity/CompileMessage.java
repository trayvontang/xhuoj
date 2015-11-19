package edu.xhu.entity;
/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class CompileMessage
{
	private boolean right;
	private String errorMessage;
	
	public CompileMessage()
	{
		super();
	}
	
	public CompileMessage(String errorMessage)
	{
		if(errorMessage!=null&&errorMessage.length()!=0)
		{
			this.errorMessage = errorMessage;
			this.right = false;
		}
		else
		{
			this.right = true;
			this.errorMessage = null;
		}
	}
	public boolean isRight()
	{
		return right;
	}
	public void setRight(boolean right)
	{
		this.right = right;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	
}
