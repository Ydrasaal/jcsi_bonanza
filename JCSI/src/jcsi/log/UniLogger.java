package jcsi.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jcsi.exception.BadConfException;
import jcsi.gui.WindowView;

import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

public class UniLogger {

	private final WindowView view;
	private Logger mLog;
	private StringWriter sw;
	private static UniLogger instance;
	
	private UniLogger(WindowView view)  {
		this.mLog = Logger.getRootLogger();
		this.view = view;
		
		Layout lay = new PatternLayout("%d{dd MMM yyyy HH:mm:ss:SSS} [%t] %-5p - %m%n");
		sw = new StringWriter();
		WriterAppender writerAppender = new WriterAppender(lay, sw);
		mLog.addAppender(writerAppender);

		FileWriter fw;
		try {
			fw = new FileWriter(new File("").getAbsolutePath().concat(("\\l" + 
			(new SimpleDateFormat("HH-mm")).format(new Date()) + ".log")));
		} catch (IOException e) {
			throw new BadConfException();
		}
		
		WriterAppender wrfAppender = new WriterAppender(lay, fw);
		mLog.addAppender(wrfAppender);
	}
	
	public static synchronized UniLogger getInstance(WindowView view) {
		
		if (instance == null) {
			instance = new UniLogger(view);
		}
		return instance;
	}
	
	public static UniLogger getInstance() {
		return instance;
	}
	
	public void info(Object text) {
		mLog.info(text);
		view.log.append(sw.toString());
		sw.getBuffer().setLength(0);
	}
	
	public void warn(Object text) {
		mLog.warn(text);
		view.log.append(sw.toString());
		sw.getBuffer().setLength(0);
	}
	
	public void error(Object text) {
		mLog.error(text);
		view.log.append(sw.toString());
		sw.getBuffer().setLength(0);
	}
}
