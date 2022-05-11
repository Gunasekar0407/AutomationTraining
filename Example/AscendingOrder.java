package Example;

import java.util.Arrays;
import java.util.Collections;

public class AscendingOrder {
	    public static void main(String[] args) {
	        int[] ascending={6,8,9,5,7,4,1,3,2};
	        Arrays.sort(ascending);
	        System.out.println("Ascending order:" +Arrays.toString(ascending));
	        Integer descending[]={5,3,7,9,1,6,4,2,8};
	        Arrays.sort(descending, Collections.reverseOrder());
	        System.out.println("Descending order:"+Arrays.toString(descending));
	    }
	}
