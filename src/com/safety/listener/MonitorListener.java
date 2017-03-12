package com.safety.listener;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.safety.entity.MonitoringItem;
import com.safety.service.HTTPCheckService;
import com.safety.service.IMonitorService;
import com.safety.service.OtherCheckService;
import com.safety.service.impl.MonitorServiceImpl;

public class MonitorListener implements ServletContextListener {

	private WebApplicationContext springContext;
	private IMonitorService monitorService;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		this.springContext = null;
		this.monitorService = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext servletContext = event.getServletContext();
		springContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		monitorService = (IMonitorService) springContext.getBean("monitorService");
		Timer timer = new Timer();
		timer.schedule(new CheckTask(), 0,1000 * 10);
	}

	class CheckTask extends TimerTask {

		@Override
		public void run() {
			List<MonitoringItem> items = monitorService.findAllList();
			// TODO Auto-generated method stub
			for (MonitoringItem item : items) {
				switch (item.getTaskType()) {
				case HTTP:
					HTTPCheckService service = new HTTPCheckService();
					service.setAddr(item.getTarget());
					int result = service.sendGet();
					System.out.println(result+"\t HTTP:"+item
							.getTarget());
					break;
				case DNS:
					String DNSResult = OtherCheckService.dns(item.getTarget());
					System.out.println(DNSResult+"\t DNS:"+item
							.getTarget());
					break;
				case PING:
					boolean PINGResult = OtherCheckService.ping(item
							.getTarget());
					System.out.println(PINGResult+"\t PING:"+item
							.getTarget());
					break;
				default:
					break;
				}
			}
		}
	}
}
