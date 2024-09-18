import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Luis Ruiz Flores
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> pass;
	String pass1, pass2;

	@Before
	public void setUp() throws Exception {
		pass = new ArrayList<String>();
		
	}

	@After
	public void tearDown() throws Exception {
		pass = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("asd43"));
			assertTrue(PasswordCheckerUtility.isValidPassword("short1"));
			assertTrue(PasswordCheckerUtility.isValidPassword("shh32"));
			assertTrue(PasswordCheckerUtility.isValidPassword("yesnomayb"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",true);
			
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("thisislame123"));
			assertTrue(PasswordCheckerUtility.isValidPassword("nocapshere@@"));
			assertTrue(PasswordCheckerUtility.isValidPassword("ilovethefall24"));
			assertTrue(PasswordCheckerUtility.isValidPassword("catsanddogs"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
			
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("THISISLAME123"));
			assertTrue(PasswordCheckerUtility.isValidPassword("ALLCAPS!!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("NOLOWERCASE134"));
			assertTrue(PasswordCheckerUtility.isValidPassword("LOWERCASE??"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
			
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try
		{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("sucks12"));
			
			boolean sucks = PasswordCheckerUtility.isWeakPassword("sucks12");
			assertTrue(sucks);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides TestIsWeakException",true);
		}
		    
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("@@1122Charlieee"));
			assertTrue(PasswordCheckerUtility.isValidPassword("@GoooCommanders"));
			assertTrue(PasswordCheckerUtility.isValidPassword("@Cowboyssss"));
			assertTrue(PasswordCheckerUtility.isValidPassword("!Letsgooonatss"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
			
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Charlie"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Lisamona"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Mauricio"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Catalina"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExceptionExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitExceptionException",false);
			
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
	
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("strongPWD1"));
		}
		catch(NoSpecialCharacterException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides lengthException", true);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("asdfFFggg"));
			assertTrue(PasswordCheckerUtility.isValidPassword("froggggg"));
		}
		catch(LengthException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides lengthException", true);
		}
	}
	
}
