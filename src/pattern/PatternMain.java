package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pattern p = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
		String text = "This is my number, 1-123-456-7890. Give me a call." + "Otherwise callme onthis other number 1 718 222 2222";
		Matcher m = p.matcher(text);
		boolean b = m.matches();
		
		System.out.println(b);
		
		while(m.find()){
			String number = text.substring(m.start(), m.end());
			System.out.println(number);
		}
		
		Pattern email = Pattern.compile("(.+)@(.+).\\d{3}");
		String t = "rivkareifman@gmail.com";
		Matcher m2 = email.matcher(t);
		boolean b2 = m2.matches();
		
		System.out.println(b2);
	}

}
