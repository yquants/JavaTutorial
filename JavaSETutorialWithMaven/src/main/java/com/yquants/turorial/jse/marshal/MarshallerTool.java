package com.yquants.turorial.jse.marshal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

public class MarshallerTool {

	public static String marshal(User user) throws Exception {
		if (user != null) {
			JAXBContext context = JAXBContext.newInstance(User.class);
			Marshaller marshaller = context.createMarshaller();
			OutputStream os = new ByteArrayOutputStream();
			marshaller.marshal(user, os);
			return ((ByteArrayOutputStream) os).toString("UTF8");
		}
		return null;
	}

	public static User unmarshal(String str) throws Exception {
		if (str != null && str.trim().length() > 0) {
			JAXBContext context = JAXBContext.newInstance(User.class);
			Unmarshaller uMarshaller = context.createUnmarshaller();
			OutputStream os = new ByteArrayOutputStream();
			return (User)uMarshaller.unmarshal(new ByteArrayInputStream(str.getBytes()));
		}
		return null;
	}
	
	@XmlRootElement
	public static final class User {
		private String name;
		private int age;
		private int id;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder().append("User[")
					.append("name=").append(name).append(",")
					.append("id=").append(id).append(",")
					.append("age=").append(age).append("]");
			return sb.toString();
		}
	}
}
