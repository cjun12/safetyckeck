package com.safety.service;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;


public class HTTPCheckService {
	private String addr = null;
	public HTTPCheckService(String addr) {
		// TODO Auto-generated constructor stub
		this.addr = addr;
	}
	public int sendGet(){
		int result = -1;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(addr);
			conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			result=conn.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void snapShot(){
		try{
			Desktop.getDesktop().browse(new URL(addr).toURI());
			Dimension dimension= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
			Robot robot = new Robot();
			robot.delay(10000);
			robot.keyRelease(KeyEvent.VK_F11);
			robot.delay(2000);
			BufferedImage screenshot = robot.createScreenCapture(
					new Rectangle(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight()));
			File file = new File("test.jpg");
			ImageIO.write(screenshot, "jpg", file);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	public void HtmlToImage(){
//		HtmlImageGenerator generator = new HtmlImageGenerator();
//		generator.loadUrl("http://www.baidu.com");
//		generator.saveAsImage("test.jpg");
//	}
}
