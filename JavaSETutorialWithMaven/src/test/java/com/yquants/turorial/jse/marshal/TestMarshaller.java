package com.yquants.turorial.jse.marshal;

import org.junit.Test;

import com.yquants.turorial.jse.marshal.MarshallerTool.User;

import org.junit.Assert;

public class TestMarshaller {

	@Test
	public void testMarshaller() throws Exception {
		User user = new User();
		user.setName("TREWQ");
		user.setAge(10);
		user.setId(9);
		String before = user.toString();

		System.out.println(MarshallerTool.marshal(user));
		String after = MarshallerTool.unmarshal(MarshallerTool.marshal(user)).toString();

		Assert.assertEquals(before, after);
	}
}
