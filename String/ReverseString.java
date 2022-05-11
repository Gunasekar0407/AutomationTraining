package String;

public class ReverseString {
	 String string = "Guna";
	    String result = "";
	    public void reverse() {
	        for (int value = string.length() - 1; value >= 0; value--) {

	            result = result + string.charAt(value);
	        }
	        System.out.println("Reverse String :" + result);
	    }
}