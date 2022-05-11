package String;

public class CommonCharacter {
	 public void removeCommonCharacter(String one, String two) {
	        String commonChar = "";

	        for (int i = 0; i < one.length(); i++) {
	            for (int j = 0; j < two.length(); j++) {
	                if (one.charAt(i) == two.charAt(j)) {
	                    commonChar += one.charAt(i);
	                }
	            }
	        }

	        for (int i = 0; i < commonChar.length(); i++) {
	            String charToRemove = commonChar.charAt(i) + "";
	            one = one.replace(charToRemove, "");
	            two = two.replace(charToRemove, "");
	        }
	        System.out.println("After removing common character " + one);
	        System.out.println("After removing common character " + two);
	    }
}
