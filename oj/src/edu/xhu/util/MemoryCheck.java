package edu.xhu.util;
/**
 * 
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class MemoryCheck
{
	/**
	 *  得到虚拟机的当前运行内存
	 * @return 返回虚拟机当前运行内存的字节数(KB)
	 */
	public static long getCurrentMemory()
	{
		Runtime run = Runtime.getRuntime();
		return (run.totalMemory()-run.freeMemory())/1024;
	}
}
