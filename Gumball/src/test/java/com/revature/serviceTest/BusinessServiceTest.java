package com.revature.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
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
	public void testAuthorLogin() {
		BusinessService service = context.getBean(BusinessService.class);
		Author goodUserGoodPass = new Author("The Writer ", null, "password", null);
		Author goodUserBadPass = new Author("The Writer", "a", "passwor", null);
		Author badUser = new Author("The Write", "a", "password", null);
		Author author = service.authorValidate(goodUserGoodPass);
		System.out.println(author);
		assertNotNull(author);
		assertNull(service.authorValidate(goodUserBadPass));
		assertNull(service.authorValidate(badUser));
	}
	@Test
	public void testReaderLogin() {
		BusinessService service = context.getBean(BusinessService.class);
		Reader goodUserGoodPass = new Reader("Banops", null, "password", null, null, null);
		Reader goodUserBadPass = new Reader("Banops", null, "passwor", null, null, null);
		Reader badUser = new Reader("Banop", null, "password", null, null, null);
		Reader reader = service.readerValidate(goodUserGoodPass);
		System.out.println(reader);
		assertNotNull(reader);
		assertNull(service.readerValidate(goodUserBadPass));
		assertNull(service.readerValidate(badUser));
	}
}
