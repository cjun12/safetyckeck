package com.safety.service;
import java.io.IOException;

import org.snmp4j.PDU;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

import com.safety.util.OidHelper;
import com.safety.util.SnmpHelper;

public class SnmpCheckService {
	private SnmpHelper snmpHelper = null;
	private String addr = null;

	public SnmpCheckService(SnmpHelper snmpHelper, String addr) {
		this.snmpHelper = snmpHelper;
		this.addr = addr;
	}

	public ResponseEvent getSysInfo() throws IOException {
		PDU pdu = new PDU();
		OidHelper oidHelper = OidHelper.getOidHelper();
		String sysDesc = oidHelper.getOid("sysInfo", "SysDesc");
		String sysUptime = oidHelper.getOid("sysInfo", "sysUptime");
		pdu.add(new VariableBinding(new OID(sysDesc)));
		pdu.add(new VariableBinding(new OID(sysUptime)));
		pdu.setType(PDU.GET);
		ResponseEvent response = snmpHelper.sendMessage(pdu, addr);
		return response;
	}
	
	public ResponseEvent getCpuInfo() throws IOException{
		PDU pdu = new PDU();
		OidHelper oidHelper = OidHelper.getOidHelper();
		String ssCpuUser = oidHelper.getOid("cpuInfo", "ssCpuUser");
		String ssCpuSystem = oidHelper.getOid("cpuInfo", "ssCpuUser");
		String ssCpuIdle = oidHelper.getOid("cpuInfo", "ssCpuUser");
		pdu.add(new VariableBinding(new OID(ssCpuUser)));
		pdu.add(new VariableBinding(new OID(ssCpuSystem)));
		pdu.add(new VariableBinding(new OID(ssCpuIdle)));
		pdu.setType(PDU.GET);
		ResponseEvent response = snmpHelper.sendMessage(pdu, addr);
		return response;
	}
	public ResponseEvent getSwapAndDiskInfo() throws IOException{
		PDU pdu = new PDU();
		OidHelper oidHelper = OidHelper.getOidHelper();
		String memTotalReal = oidHelper.getOid("swapAndDisk", "memTotalReal");
		String memAvailReal = oidHelper.getOid("swapAndDisk", "memAvailReal");
		String memTotalFree = oidHelper.getOid("swapAndDisk", "memTotalFree");
		String dskTotal = oidHelper.getOid("swapAndDisk", "dskTotal");
		String dskAvail = oidHelper.getOid("swapAndDisk", "dskAvail");
		String dskUsed = oidHelper.getOid("swapAndDisk", "dskUsed");
		String dskPercent = oidHelper.getOid("swapAndDisk", "dskPercent");
		pdu.add(new VariableBinding(new OID(memTotalReal)));
		pdu.add(new VariableBinding(new OID(memAvailReal)));
		pdu.add(new VariableBinding(new OID(memTotalFree)));
		pdu.add(new VariableBinding(new OID(dskTotal)));
		pdu.add(new VariableBinding(new OID(dskAvail)));
		pdu.add(new VariableBinding(new OID(dskUsed)));
		pdu.add(new VariableBinding(new OID(dskPercent)));
		pdu.setType(PDU.GET);
		ResponseEvent response = snmpHelper.sendMessage(pdu, addr);
		return response;
	}
}
