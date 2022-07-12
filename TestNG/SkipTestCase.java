package TestNG;

import org.testng.annotations.Test;

public class SkipTestCase {
    @Test(priority = 0)
    public void startTheCar(){
        System.out.println("Car Started");
    }
    @Test(priority =4, enabled = false ) // enabled false means this method will be skipped
    public void turnMusiOn(){
        System.out.println("Music Turned on");
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
