package edu.xhu.entity;
/**
 * 
 * （Accepted,AC）、答案错误(Wrong Answer,WA)、超时(Time Limit Exceed,TLE)
 * 超过输出限制（Output Limit Exceed,OLE)、超内存（Memory Limit Exceed,MLE）
 * 运行时错误（Runtime Error,RE）、格式错误（Presentation Error,PE)
 * 或是无法编译（Compile Error,CE），并返回程序使用的内存、运行时间等信息。
 * @author Trayvon
 * @since  2015年5月1日
 *  www.xhu.edu.cn
 * 
 * 
 */
public enum ResultType
{
	WA,AC,TLE,CE,PE,MLE,RE
}
