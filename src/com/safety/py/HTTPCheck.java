//package com.safety.py;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.python.core.PyFunction;
//import org.python.core.PyObject;
//import org.python.core.PyString;
//import org.python.core.codecs;
//import org.python.util.PythonInterpreter;
//
//public class HTTPCheck {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		HTTPCheck test = new HTTPCheck();
//		String[] result = test.checkURL("http://www.baidu.com");
//		System.out.println(result[0]+result[1]);
//	}
//
//	public String[] checkURL(String url) {
//		String root = System.getProperty("user.dir");
//		PythonInterpreter jython = new PythonInterpreter();
//		jython.execfile(root + "/py/HTTPCheck.py");
//		PyFunction function = (PyFunction) jython.get("HTTPCheck", PyFunction.class);
//		PyObject object = function.__call__(new PyString(url));
//		String code = object.__getitem__(0).toString();
//		String desc = object.__getitem__(1).toString();
//		return new String[] {code,desc};
//	}
//	
//}
