package NewPackage;

class Benz extends Maruti {
	Benz() {
		System.out.println("Class Benz");
	}

	void speed() {
		System.out.println("Maximum speed: 100Kmph");
		super.speed();
	}
}
