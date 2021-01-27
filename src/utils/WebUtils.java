package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


public class WebUtils {
	
	//����һ�ַ���
	public static<T> T param2bean(HttpServletRequest request,T t) {
		//��װ���󣬲�����
		//��ȡ��������
		Field[] fields = t.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			//��ȡ������
			String name = field.getName();
			//��request�л�ȡ��Ӧ������ֵ
			String value = request.getParameter(name);
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	//��һ�ַ���
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
