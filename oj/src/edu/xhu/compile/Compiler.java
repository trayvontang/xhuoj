package edu.xhu.compile;
/**
 * Compiler 是一个编译器的接口，代表着一个抽象编译器，可以编译String类型的源代码
 * 并且能够返回错误的信息
 * @author Trayvon
 * @since  2015年4月29日
 *  www.xhu.edu.cn
 * 
 * 
 */
public interface Compiler
{
	/**
	 * compile 表示执行编译
	 * @param source 代表要编译的代码
	 * @return  如果编译真确则返回true，否则返回 false
	 */
	public boolean compile(String source);
	
	/**
	 * 
	 * @param source
	 * @param name 文件名字
	 * @return 编译成功这返回true 否则返回false
	 */
	public boolean compile(String source ,String name);
	
	/**
	 *  一般先执行compile判断，例如：
	 *  if(!compile(source))
	 *  	getErrorMessage();
	 * @return 代表编译产生的错误信息
	 */
	public String getErrorMessage();
}
