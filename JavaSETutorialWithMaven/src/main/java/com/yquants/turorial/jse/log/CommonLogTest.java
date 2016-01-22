package com.yquants.turorial.jse.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonLogTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			C1.doAction();
			C2.doAction();
		}
	}

	private static final class C1 {
		public static void doAction() {
			Log4jHelper.getLogger(C1.class).info("[C1].[doAction]");
		}
	}

	private static final class C2 {
		public static void doAction() {
			Log4jHelper.getLogger(C2.class).info("[C2].[doAction]");
		}
	}

	private static final class Log4jHelper {
		private static Map<String, Log> map = new HashMap<String, Log>();

		public static Log getLogger(String name) {
			
			if (!map.containsKey(name))
				map.put(name, LogFactory.getLog(name));
			return map.get(name);
		}

		public static Log getLogger(Class<?> clazz) {
			if (clazz != null)
				return getLogger(clazz.getName());
			return null;
		}
	}
}
