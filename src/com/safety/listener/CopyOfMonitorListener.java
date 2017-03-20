package com.safety.listener;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.safety.entity.MonitoringItem;
import com.safety.service.HTTPCheckService;
import com.safety.service.IMonitorService;
import com.safety.service.OtherCheckService;

public class CopyOfMonitorListener implements ServletContextListener {
	private Connection conn;

	public CopyOfMonitorListener() {
		// TODO Auto-generated constructor stub
		try {
			Properties prop = new Properties();
			String path = this.getClass().getResource("/").getPath();
			prop.load(new FileInputStream(path + "db.properties"));
			String url = (String) prop.get("db.url");
			String driverClassName = (String) prop.get("db.driverClassName");
			String password = (String) prop.get("db.password");
			String username = (String) prop.get("db.username");
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new CheckTask(), 1000 * 10);
	}

	class CheckTask extends TimerTask {

		@Override
		public void run() {
			List<MonitoringItem> items = null;
			// TODO Auto-generated method stub
			if(conn==null)
				return;
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from tb_monitor_item order by create_time";
				ResultSet result = stmt.executeQuery(sql);
				while(result.next()){
					int id = result.getInt("id");
					int uid = result.getInt("uid");
					String target = result.getString("target");
					String name = result.getString("name");
					int task_type = result.getInt("task_type");
					int frequency = result.getInt("frequency");
					int 	state = result.getInt("	state");
					boolean 	enabled = result.getBoolean("enabled");
					Date date =  result.getDate("create_time");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (MonitoringItem item : items) {
				switch (item.getTaskType()) {
				case MonitoringItem.HTTP:
					HTTPCheckService service = new HTTPCheckService();
					service.setAddr(item.getTarget());
					int result = service.sendGet();
					System.out.println(result);
					break;
				case MonitoringItem.DNS:
					String DNSResult = OtherCheckService.dns(item.getTarget());
					System.out.println(DNSResult);
					break;
				case MonitoringItem.PING:
					boolean PINGResult = OtherCheckService.ping(item
							.getTarget());
					System.out.println(PINGResult);
					break;
				default:
					break;
				}
			}
		}
	}
}
