package com.example;

import com.example.db.DbImplConfig;
import com.example.order.CoreImplConfig;
import com.example.rest.RestConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(DbImplConfig.class, CoreImplConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));


        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(RestConfig.class);

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("WmServlet", new DispatcherServlet(mvcContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
