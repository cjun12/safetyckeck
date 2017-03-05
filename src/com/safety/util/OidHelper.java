package com.safety.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class OidHelper {
	private static SAXReader saxReader = null;
	private static Document document = null;
	private static Element rootElement = null;
	private static OidHelper oidHelper;
	private OidHelper() {
		try {
			InputStream inputStream = new FileInputStream(new File("res/oid.xml"));
			saxReader = new SAXReader();
			document = saxReader.read(inputStream);
			rootElement = document.getRootElement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static OidHelper getOidHelper() {
		if(oidHelper == null){
			oidHelper = new OidHelper();
		}
		return oidHelper;
	}
	public String getOid(String classify,String name){
		List<Element> elements = rootElement.element(classify).elements("item");
		for(Element item :elements ){
			String str = item.attributeValue("name");
			if (name.equals(str)) {				
				return item.getText();
			}
		}
		return null;
	}
	
	public List<String> getOidByClassify(String classify){
		List<Element> elements = rootElement.element(classify).elements("item");
		List<String> result = new ArrayList<String>();
		for(Element item :elements ){
			result.add(item.getText());
		}
		return result;
	}
}
