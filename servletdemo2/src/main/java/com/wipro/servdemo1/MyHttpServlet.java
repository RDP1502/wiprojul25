package com.wipro.servdemo1;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/http")
public class MyHttpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("This is My http servlet");
		try {
			resp.getWriter().println("Hello guys");;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
