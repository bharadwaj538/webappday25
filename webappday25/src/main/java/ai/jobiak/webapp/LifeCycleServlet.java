package ai.jobiak.webapp;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet implements Servlet {


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		try {
			System.out.println("entered init()...");
			FileOutputStream fos=new FileOutputStream("Hello.txt");
			fos.write("This si added init() to demonstrate the timing of the init method".getBytes());
			fos.close();
			System.out.println("existing init()...");
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.getWriter().println("This is from service");
	}
		@Override
		public void destroy() { 
			try {
				System.out.println("Entered destroy()...");
				FileOutputStream fos=new FileOutputStream("Hello.txt");
				fos.write("This si added destroy() to demonstrate the timing of the destroy method".getBytes());
				fos.close();
				System.out.println("existing destroy()...");
				Thread.currentThread().join();
			}catch(IOException | InterruptedException e) {
				e.printStackTrace();
			} 

		}


}
