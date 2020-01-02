package com.wht.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCode extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BufferedImage��Image��һ�����࣬BufferedImage���ɵ�ͼƬ���ڴ�����һ��ͼ�񻺳���
		BufferedImage image = new BufferedImage(100, 30,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 100, 30);
		String number = getNumber(5);
		//
		HttpSession session = request.getSession();
		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font(null, Font.BOLD, 24));
		g.drawString(number, 5, 25);
		session.setAttribute("code", number);
		for (int i = 0; i < 8; i++) {
			g
					.setColor(new Color(r.nextInt(255), r.nextInt(255), r
							.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r
					.nextInt(30));
		}
		response.setContentType("image/jpeg");
		OutputStream ops = response.getOutputStream();
		ImageIO.write(image, "jpeg", ops);
		ops.close();
	}

	private String getNumber(int size) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			number += str.charAt(r.nextInt(str.length()));
		}
		return number;
	}

}
