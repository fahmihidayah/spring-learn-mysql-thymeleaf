/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.sprone.server;


import org.eclipse.jetty.server.Server;
//import org.apache.jasper.servlet.JspServlet;
//import org.eclipse.jett
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 *
 * @author fahmi
 */
public class EmbeddedJetty {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedJetty.class);
    
    private static final int PORT = 8080;
    
    private static final String CONTEXT_PATH = "/";
    private static final String CONFIG_LOCATION_PACKAGE = "com.fernandospr.example.config";
    private static final String MAPPING_URL = "/";
    private static final String WEBAPP_DIRECTORY = "webapp";
    
    public static void main(String[] args){
        
    }
    
    
    private void startJetty(int port) throws Exception {
        LOGGER.debug("Starting server at port {}", port);
        Server server = new Server(port);
        
//        server.setHandler(getServletContextHandler());
//        
//        addRuntimeShutdownHook(server);
        
        server.start();
        LOGGER.info("Server started at port {}", port);
        server.join();
    }

}
