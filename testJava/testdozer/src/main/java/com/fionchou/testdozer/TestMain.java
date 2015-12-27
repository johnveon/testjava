package com.fionchou.testdozer;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;

import cn.jimmyshi.beanquery.BeanQuery;
import cn.jimmyshi.beanquery.Selector;
import cn.jimmyshi.beanquery.selectors.KeyValueMapSelector;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMain {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TestMain.class);

	/**
	 * @param args
	 * @author zhoufe 2015-12-27 下午2:30:55
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws Exception 
	{
		logger.debug("---");
		
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		
		Person person = new Person();
		person.setAge(34);
		person.setId("413333");
		person.setMarry(false);
		Map<String, Integer> children = new HashMap<String, Integer>();
		children.put("ketty", 1);
		children.put("mecy", 2);
		person.setChildren(children);
		
		List<Person> childs = new ArrayList<Person>();
		
		Person c1 = new Person();
		c1.setAge(12);
		childs.add(c1 );
		Person c2 = new Person();
		c2.setAge(8);
		childs.add(c2);
		person.setChilds(childs);
//		Map map =  dozerBeanMapper.map(person, HashMap.class);
//		
//		logger.info("map==>"+map);
//		
//		Person frommap = dozerBeanMapper.map(map, Person.class);
//		logger.info(frommap);
		
//		String s = JSONObject.toJSONString(person);
//		logger.info(s);
		RedisHostheathReportConfig config = new RedisHostheathReportConfig();
		
		config.setOpen(true);
		SickStander sickStander = new SickStander();
		sickStander.setHostSickRate("60%");
		sickStander.setInterval(3);
		sickStander.setRedisSickRate("80%");
		sickStander.setSickCode("51000,31000");
		
		RootTest test = new RootTest();
		TestI testI = new TestI();
		testI.setT("dxxx");
		test.setTestI(testI );
		config.setRootTest(test );
		config.setSickStander(sickStander);
		
		ObjectMapper mapper = new ObjectMapper();  
//		
//		Map m = mapper.convertValue(person, Map.class);
//		//Map m = mapper.readValue(s, Map.class);//转成map  
//		logger.info(m);
//		
//		
//		
//		
		final Map<String,Object> confiMap = mapper.convertValue(config, Map.class);
		logger.info(confiMap);
		
		
		//{open=true, sickStander={sickCode=51000,31000, redisSickRate=80%, hostSickRate=60%, interval=3}}
		
		Map zkDataMap = toZkDataMap(confiMap);
		
		logger.info("zkDataMap==>" + zkDataMap);
//
//		
//		List<Map<String, Object>> list = BeanQuery
//				.select("open,sickStander,sickStander.sickCode,sickStander.redisSickRate,sickStander.hostSickRate,sickStander.interval")
//				.from(config)
//				.execute();
//		
//		logger.info("list==>" + list);
		
		//logger.info("isJavaClass(HashMap==>" +isJavaClass(HashMap.class));
		
		//Map<String, Object> propertyMap = new HashMap<String, Object>();
		
		//toPropertyMap(propertyMap,config);
		
		//logger.info("f==>" + propertyMap);

	}
	
	

	private static void toPropertyMap(Map<String, Object> propertyMap,Object bean) throws Exception
	{
		Class clazz = bean.getClass();
		
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz); 
        //该对象有的属性
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors(); 

		for (int i = 0; i < propertyDescriptors.length; i++)
		{
			PropertyDescriptor descriptor = propertyDescriptors[i];
			//属性名称
			String propertyName = descriptor.getName();
			
			Object propertyValue = null;
			
			if ( ! propertyName.equals("class"))
			{
				Method readMethod = descriptor.getReadMethod();
				//属性值
				propertyValue = readMethod.invoke(bean, new Object[0]);
				//如果属性值为自定义类
				if(propertyValue != null && ! isJavaClass(propertyValue.getClass()))
				{
					//如果不是基础类就往下读
					toPropertyMap(propertyMap,propertyValue);
					logger.info("propertyName==>" + propertyName);
				}else
				{
					//把前面的属性+点号+现在的属性
					//读到基础类就存值
					propertyMap.put(propertyName, propertyValue);
					
					logger.info("propertyName==>" + propertyName);
					
					//logger.info("propertyValue==>" + propertyValue);
				}
			}
		}
	}
	/**
	 * 判断是基础类还是自定义类
	 * @param clazz
	 * @return
	 * @author zhoufe 2015-12-27 下午6:38:45
	 */
	public static boolean isJavaClass(Class<?> clazz)
	{
		return clazz != null && clazz.getClassLoader() == null;
	}

	private static Map<String, Object> toZkDataMap(Map<String, Object> confiMap)
	{

		Map<String,Object> zkDataMap = new HashMap<String, Object>();
		
		for(Entry<String, Object> confiMapEntry : confiMap.entrySet())
		{
			String key = confiMapEntry.getKey();
			Object value = confiMapEntry.getValue();
			
			if(value instanceof Map)
			{
				
			}else
			{
				
			}
		}
		return zkDataMap;
	}

}
