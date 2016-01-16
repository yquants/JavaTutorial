package com.yquants.drools;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

public class DroolsMain {

	private static Map<String, KnowledgeBase> map = new HashMap<String, KnowledgeBase>();

	private static KnowledgeBase getKnowledgeBase(String filename) {
		if (!map.containsKey(filename)) {
			cacheKnowledgeBase(ResourceFactory.newFileResource(filename),
					filename);
		}
		return map.get(filename);
	}

	private static KnowledgeBase getKnowledgeBase(String content, String name) {
		if (!map.containsKey(name)) {
			cacheKnowledgeBase(
					ResourceFactory.newByteArrayResource(content.getBytes()),
					name);
		}
		return map.get(name);
	}

	private static void cacheKnowledgeBase(Resource resource, String name) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(resource, ResourceType.DRL);

		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors());
			return;
		}
		Assert.assertFalse(kbuilder.hasErrors());

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		map.put(name, kbase);
	}

	@Test
	public static void testWithDrlFile() throws Exception {
		final String filename = "rules/Game.drl";

		KnowledgeBase kbase = getKnowledgeBase(filename);
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.insert(new Message("Hello"));
		ksession.fireAllRules();
		ksession.dispose();
	}

	@Test
	public static void testGlobalVar() throws Exception {
		final String filename = "rules/Game.drl";
		KnowledgeBase kbase = getKnowledgeBase(filename);

		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		List<BigDecimal> list = new java.util.ArrayList<BigDecimal>();
		ksession.setGlobal("list", list);
		ksession.insert(new BigDecimal(1));
		ksession.fireAllRules();
		
		ksession.insert(new BigDecimal(-1));
		ksession.fireAllRules();
		
		ksession.dispose();
		
		Assert.assertFalse(list.isEmpty());
		
		for(BigDecimal bd: list)
			System.out.println(bd);
	}

	@Test
	public static void testWithInternalRule() throws Exception {
		StringBuilder sb = new StringBuilder()
				.append("package com.yquants.drools \n")
				.append("import com.yquants.drools.Message \n")
				.append("rule \"one\" \n").append("when \n")
				.append("eval(1==1) \n").append("eval(2==1) \n")
				.append("then \n")
				.append("System.out.println(\"internal rule[1==1]\"); \n")
				.append("end");

		KnowledgeBase kbase = getKnowledgeBase(sb.toString(), "Internal Simple");

		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.insert("111");
		ksession.fireAllRules();
		ksession.dispose();
	}

	public static void main(String[] args) throws Exception {
		Method[] methods = DroolsMain.class.getMethods();
		Object[] params = null;
		for (Method m : methods)
			if (m.isAnnotationPresent(Test.class))
				m.invoke(null, params);
	}
}
