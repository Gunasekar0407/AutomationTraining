package TestNG;

import org.testng.annotations.Test;

public class DependenciesManagement {
    // enabled true means this method will execute, if i turn true into false means entire methods will not run.
    @Test(enabled = true)
    public void highSchool(){
        System.out.println("high School");
    }
    // this methods depends on previous method, if previous method skipped means this will not run
    @Test(dependsOnMethods="highSchool")
    public void higherSeondary(){
        System.out.println("Higher sec School");
    }
    // this methods depends on previous method, if previous method skipped means this will not run
    @Test(dependsOnMethods="higherSeondary")
    public void engineering(){
        System.out.println("College");
    }
}
