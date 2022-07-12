package TestNG;

import org.testng.annotations.Test;

public class DriveCar {

    @Test(priority = 0)
    public void startTheCar(){
        System.out.println("Car Started");
    }
    @Test(priority = 1)
    public void putFirstGear(){
        System.out.println("FirstGear");
    }
    @Test(priority = 2)
    public void putSecondGear(){
        System.out.println("SecondGear");
    }
    @Test(priority = 3)
    public void putThirdGear(){
        System.out.println("ThirdGear");
    }
}
