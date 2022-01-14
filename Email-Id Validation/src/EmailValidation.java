import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

	//Regular Expression
	public static final String REGEX = "^[A-Za-z0-9.]+@[A-Za-z0-9.]+";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("****Welcome to Email Validation****" + "\n");
		System.out.println("Create Employee's email Id data");

		String[] str= getEmpEmailIDArray(sc);

		System.out.println("Checking email IDs are valid or not....");
		for (String emailId : str) {
			boolean flag = isValidEmailId(emailId);
			System.out.println((emailId + " is " + (flag ? " valid":" invalid")));
		}

		System.out.println("If you Want to search email ID Type 'Y' Or Type 'Exit' to exit");
		String ch = sc.next();

		if("Y".equalsIgnoreCase(ch)) {
			System.out.println("Please Enter Email-ID You want to search in Employee Email-ID Data");
			String searchEmailId = sc.next();
			searchEmailId(str, searchEmailId);
		} else if("Exit".equalsIgnoreCase(ch)) {
			System.out.println("Application Logout! ");
			return;
		} else {
			System.out.println("Invalid Type Option. Application Logout! ");
		}

		sc.close();
	}

	/**
	 * Method to return user entered email id.
	 * 
	 * @param sc  scanner object to take input from console
	 * @return strArray String of array
	 */
	private static String[] getEmpEmailIDArray(Scanner sc) {
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Please enter employee Email-ID's to store and validate");
		System.out.println("Type 'Q' when you done");

		while(true) {
			String inputValue = sc.next();
			if("Q".equalsIgnoreCase(inputValue))
				break;
			al.add(inputValue);
		}

		String[] strArray = new String[al.size()];
		strArray = al.toArray(strArray);

		return strArray;
	}

	/**
	 * Method to match email Id with regular expression
	 * 
	 * @param emailID entered email Id
	 * @return boolean true/false based on Matcher.matches() method
	 */
	private static boolean isValidEmailId(String emailID) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(emailID);
		return m.matches();

	}

	/**
	 * Method to search user entered email id in String array
	 * 
	 * @param strArray  collection of email id
	 * @param inputEmailId user entered email Id
	 */
	private static void searchEmailId(String[] strArray, String inputEmailId) {
		boolean recordExistFlag = false;
		System.out.println("Searching email ID "+inputEmailId+" in records.........");
		for (int i = 0; i < strArray.length; i++) {
			if(inputEmailId.equalsIgnoreCase(strArray[i])) {
				System.out.println("Entered Employee Email Id found in records");
				recordExistFlag =true;
			}
		}

		if(!recordExistFlag) {
			System.out.println("No Records Found");
		}
	}
}
