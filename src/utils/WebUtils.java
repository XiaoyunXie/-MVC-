package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


public class WebUtils {
	
	//其中一种方法
	public static<T> T param2bean(HttpServletRequest request,T t) {
		//封装对象，并返回
		//获取所有属性
		Field[] fields = t.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			//获取属性名
			String name = field.getName();
			//在request中获取相应的属性值
			String value = request.getParameter(name);
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	//另一种方法
	public static<T> T param2bean2(HttpServletRequest request,T t) {
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println(e.toString());
		}
		return t;
	}
	
	
}
