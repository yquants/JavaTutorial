package com.yquants.turorial.jse.marshal;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.yquants.turorial.jse.marshal.MarshallerTool.User;

public class TestMarshaller {

	@Test
	public void testMarshaller() throws Exception {
		User user = new User();
		user.setName("TREWQ");
		user.setAge(10);
		user.setId(9);
		user.setLogins(new ArrayList<String>() {

			private static final long serialVersionUID = -4924855663765219391L;

			{
				add("1");
				add("2");
			}
		});
		String before = user.toString();

		System.out.println(MarshallerTool.marshal(user));
		String after = MarshallerTool.unmarshal(MarshallerTool.marshal(user)).toString();

		Assert.assertEquals(before, after);
	}
}
