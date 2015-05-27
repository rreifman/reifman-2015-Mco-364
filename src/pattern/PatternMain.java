package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain {
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("\\S+?@\\S+?\\.\\S+");
	private static final Pattern PHONE_NUM = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "This is my number, 1-123-456-7890. Give me a call." + "Otherwise callme onthis other number 1 718 222 2222";
		Matcher m = PHONE_NUM.matcher(text);
		boolean b = m.matches();
		
		System.out.println(b);
		
		while(m.find()){
			String number = text.substring(m.start(), m.end());
			System.out.println(number);
		}
		

		String t = "this is my email rivkareifman@gmail.com";
		Matcher m2 = EMAIL_PATTERN.matcher(t);
		boolean b2 = m2.matches();
		
		System.out.println(b2);
		
		while(m2.find()){
			String number = t.substring(m2.start(), m2.end());
			System.out.println(number);
		}
	}

}
