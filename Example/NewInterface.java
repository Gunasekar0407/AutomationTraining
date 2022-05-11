package Example;
interface ROI {
//void draw();
//}
//class Rectangle implements Drawing{
//	public void draw() {
//	System.out.println("Rectangle");
//}}
//class Circle implements Drawing{
//	public void draw() {
//		System.out.println("Circle");
//	}
//}
//public class NewInterface{
//	public static void main(String[] args) {
//		Circle C=new Circle();
//		C.draw();
//		Rectangle R=new Rectangle();
//		R.draw();
//	}
		float rateOfInterest();
	}
class SBI implements ROI{
	public float rateOfInterest() {
		return 7;
	}
}
class PNB implements ROI{
public float rateOfInterest() {
		return 9;
}
}
public class NewInterface{
	public static void main(String[] args) {
		ROI b=new SBI();
		System.out.println("SBI=" + b.rateOfInterest());
		ROI b1=new PNB();
		System.out.println("PNB =" + b1.rateOfInterest());
	}
}
