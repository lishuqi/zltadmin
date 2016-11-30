import java.util.ArrayList;
import java.util.List;


public class testList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.remove(2);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
