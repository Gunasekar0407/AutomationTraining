package AutomationDayone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CurrentTime {
//	
//	
//	
//	 void addNumber(int a,int b){
//					
//		 
//		
//	}
	 
	public static void main(String args[]) {
        Date today = new Date();
       DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:SS z");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String GMT = df.format(today);
        System.out.println("Time in GMT : " + GMT);
//		CurrentTime currentTime = new CurrentTime();
        
	}}						