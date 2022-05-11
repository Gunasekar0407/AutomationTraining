package AutomationDayone;

//abstract class Bank {
//	abstract int getRateOfInterest();
//}
//class Sbi extends Bank {
//	int getRateOfInterest()
//	{return 7;}
//}
//class Pnb extends Bank {
//	int getRateOfInterest()
//	{return 8;}
//}
//public class NewAbstract{
//	public static void main(String[] args) {
//		Bank b;
//		b=new Sbi();
//		System.out.println(b.getRateOfInterest()+"%");
//		b=new Pnb();
//		System.out.println(b.getRateOfInterest()+"%");
//	}
//}
abstract class bike{
	bike(){
		System.out.println("Bike is created");
	}
	abstract void run();
	void changeGear() {
		System.out.println("Gear Changed");
	}}
	class Honda extends bike{
		void run() {
		System.out.println("Running Safely");
	}
	}
public class NewAbstract{
	public static void main(String[] args){
		bike b=new Honda();
		b.run();
		b.changeGear();
	}
}