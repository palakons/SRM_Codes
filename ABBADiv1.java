import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ABBADiv1 {
	public static void main(String[] a) {
		System.out.println(canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
		System.out.println(canObtain("A", "BABABABABABABABABABABABABABABABAABABABABABABABABABABABABABABABABAB"));
	}

	public static boolean find(String in, String tar) {
		if (in.length() == tar.length()) {
			if (in.equals(tar)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (tar.charAt(0) == 'A' && tar.charAt(tar.length() - 1) == 'A') {
				return find(in, tar.substring(0, tar.length() - 1));
			} else if (tar.charAt(0) == 'A' && tar.charAt(tar.length() - 1) == 'B') {
				return false;
			} else if (tar.charAt(0) == 'B' && tar.charAt(tar.length() - 1) == 'A') {
				String rev = new StringBuilder(tar.substring(1, tar.length() )).reverse().toString();
				return find(in, rev) || find(in, tar.substring(0, tar.length() - 1));
			} else {
				String rev = new StringBuilder(tar.substring(1, tar.length() )).reverse().toString();
				return find(in, rev);
			}
		}
	}

	public static String canObtain(String initial, String target) {
		if(find(initial,target)) return "Possible";
		return "Impossible";
	}

}