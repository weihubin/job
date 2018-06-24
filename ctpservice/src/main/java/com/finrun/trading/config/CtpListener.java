package com.finrun.trading.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by weihubin on 2018-03-27.
 */
@WebListener
public class CtpListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(CtpListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String libPath = System.getProperty("java.library.path");
        logger.info("libPath:" + libPath);
        loadlib();
    }

    /**
     * 调用.dll或.so文件
     */
    private void loadlib() {
        String osName = System.getProperty ("os.name");//运行系统
        if(osName.toLowerCase().indexOf("win") > -1){
            //加载文件存在依赖关系，有先后顺序
            System.loadLibrary("libglog");
            System.loadLibrary("libiconv" );
            System.loadLibrary("thosttraderapi");
            System.loadLibrary("ctptrade" );
            System.loadLibrary("thostmduserapi");
            System.loadLibrary("ctpmarketdata");
        }else if(osName.toLowerCase().indexOf("linux") > -1){
            //加载文件存在依赖关系，有先后顺序, 注意linux下load时需要去掉lib和so
            System.loadLibrary("glog");
            System.loadLibrary("iconv" );
            System.loadLibrary("thosttraderapi");
            System.loadLibrary("ctptrade");
            System.loadLibrary("thostmduserapi");
            System.loadLibrary("ctpmarketdata");
        }
        System.out.println("-------------------------------------");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoader.getSystemResource(""));
        ClassLoader systemClassloader=ClassLoader.getSystemClassLoader();
        System.out.println("the parent of system classloader : "+systemClassloader.getParent());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
