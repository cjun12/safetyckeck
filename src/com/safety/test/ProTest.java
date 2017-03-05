package com.safety.test;

import java.io.IOException;

import org.junit.Test;
import org.snmp4j.PDU;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;

import com.safety.service.OtherCheckService;
import com.safety.service.SnmpCheckService;
import com.safety.util.SnmpHelper;

public class ProTest {
	private static String addr = "udp:192.168.38.5/161";

	public static void main(String[] args) {
		SnmpHelper snmpHelper = new SnmpHelper(SnmpConstants.version2c);
		SnmpCheckService snmpCheck = new SnmpCheckService(snmpHelper, addr);
		try {
			ResponseEvent responseEvent = snmpCheck.getSysInfo();
			PDU response = responseEvent.getResponse();
			System.out.println(response.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void httpTest() {
		System.out.println(OtherCheckService.dns("baidu.com"));
	}
}
