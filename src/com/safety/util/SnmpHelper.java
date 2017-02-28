package com.safety.util;


import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.UserTarget;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.event.ResponseListener;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.PrivDES;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocol;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpHelper {
	private Snmp snmp ;
	private int version ;
	public SnmpHelper(int version) {
		// TODO Auto-generated constructor stub
		try{
			this.version = version;
			TransportMapping<?> transportMapping = new DefaultUdpTransportMapping();
			snmp = new Snmp(transportMapping);
			if(version == SnmpConstants.version3){
				USM usm = new USM(SecurityProtocols.getInstance(),
						new OctetString(MPv3.createLocalEngineID()),0);
				SecurityModels.getInstance().addSecurityModel(usm);
			}
			transportMapping.listen();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public ResponseEvent sendMessage(PDU pdu,String addr) throws IOException{
		Address targetAddress = GenericAddress.parse(addr);
		Target target = null;
		if(version == SnmpConstants.version3){
			snmp.getUSM().addUser(
					new OctetString("MD5DES"),
					new UsmUser(new OctetString("MD5DES"), 
							AuthMD5.ID, 
							new OctetString("MD5DESUserAuthPassword"), 
							PrivDES.ID, 
							new OctetString("MD5DESUserPrivPassword")));
			target = new UserTarget();
			((UserTarget)target).setSecurityLevel(SecurityLevel.AUTH_PRIV);
			((UserTarget)target).setSecurityName(new OctetString("MD5DES"));
			target.setVersion(SnmpConstants.version3);
		}else{
			target = new CommunityTarget();
			if(version == SnmpConstants.version1){
				target.setVersion(SnmpConstants.version1);
				((CommunityTarget)target).setCommunity(new OctetString("public"));
			}else{
				target.setVersion(SnmpConstants.version2c);
				((CommunityTarget) target).setCommunity(new OctetString("public"));
			}
		}
		
		target.setAddress(targetAddress);
		target.setRetries(5);
		target.setTimeout(1000);
		
//		if(!syn){
			ResponseEvent responseEvent = snmp.send(pdu, target);
			return responseEvent;
//		}else{
//			ResponseListener listener = new ResponseListener() {
//				
//				@Override
//				public void onResponse(ResponseEvent event) {
//					// TODO Auto-generated method stub
//					if(bro.equals(false)){
//						((Snmp) event.getSource()).cancel(event.getRequest(),this);
//					}
//					
//					PDU request = event.getRequest();
//					PDU response = event.getResponse();
//				}
//			};
//			snmp.send(pdu, target,target,listener);
//		}
	}
}
