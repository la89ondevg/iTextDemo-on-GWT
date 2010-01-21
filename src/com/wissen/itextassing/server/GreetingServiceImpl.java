package com.wissen.itextassing.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wissen.itextassing.client.GreetingService;
import com.wissen.pdfgenerator.Demo;
import com.wissen.pdfgenerator.DBFetch;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

    public String greetServer(String input) {
        String serverInfo = getServletContext().getServerInfo(); 
        String userAgent = getThreadLocalRequest().getHeader("User-Agent");
             Demo p=new Demo();
        p.createPdf("Paul Graham");
        return "Reports/HelloWorld.pdf";
          
    }
}
