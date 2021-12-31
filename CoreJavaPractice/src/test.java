import java.time.LocalDateTime;
import java.time.LocalTime;

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
		LocalTime localtime = LocalTime.now();
		System.out.println("localtime: "+localtime.getMinute());
		
		LocalDateTime localdatetime = LocalDateTime.now();
		System.out.println("localdatetime: "+localdatetime);

	}

}
