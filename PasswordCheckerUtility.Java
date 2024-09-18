import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.regex.*;

public class PasswordCheckerUtility 
{


	
	//constructor 
	
	public PasswordCheckerUtility() 
	{
		
;	}
	
	
	/**
	 * compare the equality of two passwords
	 * @param password - password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against password for
	 * @throws UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(password.equalsIgnoreCase(passwordConfirm))
		{
			
		}
	}
	
	
	/**
	 * Compare equality of two passwords
	 * @param password - password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against password
	 * @return - true if both same (case sensitive), false otherwise
	 */
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if(password.equalsIgnoreCase(passwordConfirm))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	/**
	 * checks the password length requirement - the password must be at least 6 characters long
	 * @param password - password string to be checked for length
	 * @return - true if meets minimum length requirenment
	 * @throws LengthException - thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException
	{
		
		
			if (password.length() < 6) 
			{
				throw new LengthException("The password must be at least 6 characters long");
			} 
			else 
			{
				return true;
			}
		
	}
	
	
	/**
	 * Checks the password alpha character requirement - Password must contain an upper case alpha character.
	 * @param password - password string to be checked for alpha character requirement
	 * @return - true if meet alpha character requirement
	 * @throws noUpperAlphaException - thrown if does not meet alpha requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		
		if (!(password.matches(".*[A-Z].*"))) 
		{
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
		else 
		{
			return true;
		}
	}
	
	
	/**
	 * Checks the password lower case requirement - password must contain at least one lower case alpha character.
	 * @param password - password string to be checked for lower case requirement
	 * @return - true if it meets lower case requirement
	 * @throws NoLowerAlphaException - thrown if does not meet lower case requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		if (!(password.matches(".*[a-z].*")))
		{
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Checks the password digit requirement - Password must contain a numeric character
	 * @param password - password string to be checked for digit requirement
	 * @return - true if meet digit requirement
	 * @throws NoDigitException - thrown if does not meet digit requirement. 
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		if (!(password.matches(".*\\d.*")))
		{
			throw new NoDigitException("The password must contain at least one digit");
		}
		
		else 
		{
			return true;
		}
	}
	
	/**
	 * Checks the password SpecialCharacter Requirement - Password must contain a Special Character
	 * @param password - password string to be checked for SpecialCharacter requirement.
	 * @return - true if meets special character requirement
	 * @throws NoSpecialCharacterException - thrown if does not meet special character requirement.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		if(!(password.matches(".*[$&+,:;=\\\\?@#|/'<>.^*()%!-].*")))
		{
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * Checks the password sequence requirement - Password should not contain more than 2 of the same character in a sequence
	 * @param password - password string to be checked for the sequence requirement
	 * @return - false if does NOT meet sequence requirement
	 * @throws InvalidSequenceException - thrown if meets sequence requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		char[] pass = password.toCharArray();
		
		for (int i = 0; i < pass.length; i++)
		{
			int same = 0;
			for (int j = 0; j < pass.length; j++)
			{
				if (pass[i] == pass[j] && i != j)
				{
					same ++;
				}
				
			}
			if (same >= 2)
			{
				throw new InvalidSequenceException("Password contains more than 2 of the same character in sequence");
			}
			
		}
		
			return false;
	}
	
	
	/**
	 * Return if valid password( Follows all of the following rules), Returns false if an invalid password. 
	 * 1) at least 6 characters long. 
	 * 2) at least 1 numeric character. 
	 * 3) at least 1 uppercase alphabetic Character.
	 * 4) at least 1 lowercase alphabetic character. 
	 * 5) at least 1 special character. 
	 * 6) No more than 2 of the same character in a sequence - Hello@123 - OK AAAbb@123 - not OK. Aaabb@123- OK
	 * @param password - String to be checked for validity.
	 * @return - true if valid password (follows all rules from above), False if an invalid password. 
	 * @throws LenghtException - thrown if length is less than 6 characters
	 * @throws NoIpperAlphaException - thrown if no upper case alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic 
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoSpecialCharacterException - thrown if does not meet special character requirement. 
	 * @throws InvalidSequenceException - thrown if more than 2 of the same character
	 */
	public static boolean isValidPassword(String password) throws LengthException, 
															NoUpperAlphaException, 
															NoLowerAlphaException, 
															NoDigitException, 
															NoSpecialCharacterException,
															InvalidSequenceException
	{
	
		 if (!isValidLength(password)) 
		 	{
		        throw new LengthException("The password must be at least 6 characters long.");
		    }

		  if (!hasUpperAlpha(password)) 
		 	{
		        throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character.");
		    }

		  if (!hasLowerAlpha(password)) 
		 	{
		        throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character.");
		    }

		  if (!hasDigit(password)) 
		 	{
		        throw new NoDigitException("The password must contain at least one digit.");
		    }

		  if (!hasSpecialChar(password)) 
		 	{
		        throw new NoSpecialCharacterException("The password must contain at least one special character.");
		    }

		  if (!NoSameCharInSequence(password)) 
		 	{
		        throw new InvalidSequenceException("Password contains more than 2 of the same character in sequence.");
		    }

		    return true;
		
		
	}
	
	
	
	/**
	 * Checks if the password contains 6 to 9 characters
	 * @param password - password string to be checked for
	 * @return - true if password contains 6 to 9 characters, false otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if (password.length() >= 6 && password.length() <= 9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Checks if the password is VALID and the length is NOT between 6-9 characters. 
	 * @param password - string to be checked if weak password
	 * @return - false if the password is valid and the length of password NOT between 6 and 9 (inclusive)
	 * @throws WeakPasswordException - if length of password is between 6 and 9 (inclusive) ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		if (!(hasBetweenSixAndNineChars(password)))
		{
			return false;
		}
		else
		{
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
		}
	}
	
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of 
	 * any invalid passwords(weak passwords are not considered invalid). 
	 * The ArrayList of invalid passwords will be of the following format: 
	 * password BLANK message of the exception thrown.
	 * @param passwords - list of passwords
	 * @return - ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String>passwords)
	{
		ArrayList<String> invalid = new ArrayList<String>();

		 for (String i : passwords) 
		    {
		        try {
					if (!(isValidPassword(i)))
					{
					    invalid.add(i);
					    System.out.println(i);
					}
				} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
						| NoSpecialCharacterException | InvalidSequenceException e) {
					e.printStackTrace();
				}
		    }
		    
		    return invalid;
	}
	
	

}
