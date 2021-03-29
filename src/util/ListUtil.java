package util;

import java.util.List;

public class ListUtil {
	
	private ListUtil() {}
	
	public static <T> String toString(List<T> args, String regex) {
		String string = "";
		for (int i = 0; i < args.size(); i++) {
			string += args.get(i) + (i < args.size() - 1 ? regex : "");
		}
		return string;
	}
}