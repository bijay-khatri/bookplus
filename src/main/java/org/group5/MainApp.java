package org.group5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class MainApp implements ServletContextInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		servletContext.setInitParameter(
				"authtoken",
				"AQ12ADtIy8GA7TXn5sOQ6iGP9DTvEpyV26dL0eh65FFSmG4ujTRNZEPlc6gwr4klKHeex5r0NbTerW5Y");
		servletContext.setInitParameter(
				"posturl",
				"https://www.sandbox.paypal.com/cgi-bin/webscr");
		servletContext.setInitParameter(
				"returnurl",
				"http://localhost:8282/paypaldemo/paypal/sucess.html");
		servletContext.setInitParameter(
				"business",
				"bansalneha2104-facilitator@gmail.com");
	}
}
