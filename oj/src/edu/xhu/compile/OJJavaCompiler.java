package edu.xhu.compile;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;

import edu.xhu.util.Configuration;

/**
 * 
 * @author Trayvon
 * @since  2015年4月29日
 *  www.xhu.edu.cn
 * 
 * 
 */
public class OJJavaCompiler implements Compiler
{
	private Logger logger = Logger.getLogger(OJJavaCompiler.class);
	private  final String workDir = Configuration.getJavaWorkplaceDir();
	private  final String className = "Main";
	private DiagnosticCollector<JavaFileObject> diagnostic;
	
	
	private void checkWorkDir()
	{
		File file = new File(workDir);
		if(!file.exists())
			file.mkdirs();		
	}

	@Override
	public String getErrorMessage()
	{
		StringBuffer errorInfo = new StringBuffer();
		for(Diagnostic<?> d : diagnostic.getDiagnostics())
		{
			errorInfo.append("错误信息： "+d.getMessage(Locale.CANADA)+"\n");
			errorInfo.append("错误所在的行数： "+d.getLineNumber());

		}
		return errorInfo.toString();
	}

	@Override
	public boolean compile(String source)
	{
		return compile(source,null);
	}
	
	
	@Override
	public boolean compile(String source, String name)
	{
		 JavaCompiler compiler;
		 StandardJavaFileManager standardJavaFileManager;
		 CompilationTask task;
		 JavaFileObject sourceObject ;
		 Iterable<? extends JavaFileObject>  fileObject;
		
		checkWorkDir();
		 compiler = ToolProvider.getSystemJavaCompiler();
			if(compiler==null)
				logger.error("没有得到系统编译器，请检JAVA_HOME\\lib\\tool.jar是否存在");
			
		 sourceObject = new StringSourceJavaFileObject(className,source);
		 fileObject = Arrays.asList(sourceObject);
		 standardJavaFileManager = compiler.getStandardFileManager(null, null, null);
		 diagnostic = new DiagnosticCollector<JavaFileObject>();
//		 task = compiler.getTask(null, standardJavaFileManager, diagnostic, Arrays.asList("-d",workDir), null, fileObject);
		 task = compiler.getTask(null, standardJavaFileManager, diagnostic, Arrays.asList("-d",workDir,"-encoding","utf-8"), null, fileObject);
		return  task.call();
	}

}
