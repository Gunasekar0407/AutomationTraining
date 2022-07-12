package TestNG;

import org.testng.annotations.Test;

public class GroupingExample {
    // scenerio : A big basket is having a different kind of mobiles.
    // Let us say there are Apple phones, Moto, VIVO and Lenovo.
    // I want to run tests only for VIVO and Moto phones. Write a program for that.
    @Test(groups = {"Apple"})
    public void appleOne(){
        System.out.println("Apple Testing");
    }
    @Test(groups = {"Apple"})
    public void appleTwo(){
        System.out.println("Apple Testing");
    }
    @Test(groups = {"Moto"})
    public void motoOne(){
        System.out.println("Moto testing");
    }
    @Test(groups = {"Moto"})
    public void motoTwo(){
        System.out.println("Moto testing");
    }
    @Test(groups = {"Vivo"})
    public void vivoOne(){
        System.out.println("Vivo Testing");
    }
    @Test(groups = {"Vivo"})
    public void vivoTwo(){
        System.out.println("Vivo Testing");
    }
    @Test(groups = {"Lenovo"})
    public void lenovoOne(){
        System.out.println("Lenovo testing");
    }
    @Test(groups = {"Lenovo"})
    public void lenovoTwo(){
        System.out.println("Lenovo testing");
    }

}
