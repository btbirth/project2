package com.revature.serviceTest;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.service.BusinessService;

public class BusinessServiceTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	@Test
	@Ignore
	public void testAuthorLogin() {
		BusinessService service = context.getBean(BusinessService.class);
		Author goodUserGoodPass = new Author("The Writer ", null, "password", null);
		Author goodUserBadPass = new Author("The Writer", "a", "passwor", null);
		Author badUser = new Author("The Write", "a", "password", null);
		Author author = service.authorValidate(goodUserGoodPass.getUsername(), goodUserGoodPass.getPassword());
		System.out.println(author);
		Assert.assertNotNull(author);
		Assert.assertNull(service.authorValidate(goodUserBadPass.getUsername(), goodUserBadPass.getPassword()));
		Assert.assertNull(service.authorValidate(badUser.getUsername(), badUser.getPassword()));
	}
	@Test
	@Ignore
	public void testReaderLogin() {
		BusinessService service = context.getBean(BusinessService.class);
		Reader goodUserGoodPass = new Reader("Banops", null, "password", null, null, null);
		Reader goodUserBadPass = new Reader("Banops", null, "passwor", null, null, null);
		Reader badUser = new Reader("B", null, "password", null, null, null);
		Reader reader = service.readerValidate(goodUserGoodPass.getUsername(),goodUserGoodPass.getPassword());
		System.out.println(reader);
		Assert.assertNotNull(reader);
		Assert.assertNull(service.readerValidate(goodUserBadPass.getUsername(),goodUserBadPass.getPassword()));
		Assert.assertNull(service.readerValidate(badUser.getUsername(),badUser.getPassword()));
	}
}
