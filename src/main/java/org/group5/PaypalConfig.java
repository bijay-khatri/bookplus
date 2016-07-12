package org.group5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by Neha on 7/10/2016.
 */
@Component
public class PaypalConfig {

    private static Logger logger = LoggerFactory.getLogger(PaypalConfig.class);
    @Value("${project.title}")
    private String authToken;

    @Value("${posturl}")

    private String posturl;

    @Value("${business}")
    private String business;

     @Value("${returnurl}")
    private String returnurl;
    private String cancelurl;
    private String cmd;

    public String getAuthToken() {
        return authToken;
    }

    public String getPosturl() {
        return posturl;
    }

    public String getBusiness() {
        return business;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public String getCancelurl() {
        return cancelurl;
    }

    public String getCmd() {
        return cmd;
    }
    public PaypalConfig getConfig(HttpServletRequest request){
        PaypalConfig pc=new PaypalConfig();
        try {
            System.out.println(authToken);
            pc.authToken = request.getServletContext().getInitParameter("authtoken");
            pc.posturl = request.getServletContext().getInitParameter("posturl");
            pc.returnurl = request.getServletContext().getInitParameter("business");
            pc.business = request.getServletContext().getInitParameter("returnurl");
            System.out.println(authToken);
            logger.info("Property One: " + authToken);
            logger.info("Property Two: " + posturl);
            logger.info("Property Three: " + returnurl);
            logger.info("Property Four: " + business);
        }

        catch(Exception e){
            pc=null;
        }
        return pc;
    }

}
