import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author USER
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * LocalTime localtime = LocalTime.now();
		 * System.out.println("localtime: "+localtime.getMinute());
		 * 
		 * LocalDateTime localdatetime = LocalDateTime.now();
		 * System.out.println("localdatetime: "+localdatetime);
		 */
		
		List<Integer> list1 = new LinkedList<>(Arrays.asList(9,9,9,9,9));
		List<Integer> list2 = new LinkedList<>(Arrays.asList(9,9,9,0,0));
		List<Integer> list3 = new LinkedList<>();
		int carry = 0;
		for(int i=0; i<list1.size(); i++) {
			int sum = list1.get(i)+list2.get(i)+carry;
			list3.add((sum)%10);
			carry=sum/10;
		}
		
		list3.forEach(System.out::println);

	}

}
