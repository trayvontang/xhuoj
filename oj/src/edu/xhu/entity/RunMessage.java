package edu.xhu.entity;
/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class RunMessage
{
	private long memory;
	private int  time;
	private boolean right;
	private boolean isAc;
	
	public boolean isAc()
	{
		return isAc;
	}

	public void setAc(boolean isAc)
	{
		this.isAc = isAc;
	}

	public RunMessage()
	{
		super();
	}
	
	public RunMessage(long memory, int time, boolean right)
	{
		super();
		this.memory = memory;
		this.time = time;
		this.right = right;
	}

	public RunMessage(long memory, int time)
	{
		super();
		this.memory = memory;
		this.time = time;
	}
	
	public RunMessage(boolean isAc)
	{
		super();
		this.isAc = isAc;
	}

	public long getMemory()
	{
		return memory;
	}
	public void setMemory(long memory)
	{
		this.memory = memory;
	}
	public int getTime()
	{
		return time;
	}
	public void setTime(int time)
	{
		this.time = time;
	}
	public boolean isRight()
	{
		return right;
	}
	public void setRight(boolean right)
	{
		this.right = right;
	}
}
