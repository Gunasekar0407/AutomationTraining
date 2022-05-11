package AutomationDayone;

public class CapitalizeString {
	public static void main (String[] args) {
		String s="the quick brown fox jumps over the lazy dog.";
		String r="";
		String[] arr=s.split(" ");
		for(int i=0; i<arr.length; i++) {
			char c=arr[i].charAt(0);
			String c1=String.valueOf(c).toUpperCase();
			String sub=arr[i].substring(1);
			r=r+c1+sub + " ";
		}
		System.out.println(r.trim());
	}}