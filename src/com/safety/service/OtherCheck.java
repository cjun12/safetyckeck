package com.safety.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OtherCheck {
	public static boolean ping(String addr) {
		boolean result = false;
		try {
			result = InetAddress.getByName(addr).isReachable(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static String dns(String domain) {
		String result = null;
		try {
			result = InetAddress.getByName(domain).getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}