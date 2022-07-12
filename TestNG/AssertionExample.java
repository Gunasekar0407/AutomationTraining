package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample {
    String name="Guna";
    boolean value=false;
    //String name="Guna" // checking this string and another string are same using equals.
    //if(name.equals("Guna"){sout}else{sout}
    @Test
    public void checkEquals(){
//        if (name.equals("Guna")){
//            System.out.println("Name is equal");
//        }
//        else {
//            System.out.println("Name is not equal"); // checking through java
//        }
        // checking through asserts
      //  Assert.assertEquals(name, "Gna");
       // Assert.assertNotEquals(name, "gna");
       // Assert.assertTrue(value, "This should not be true");
        Assert.assertFalse(value,"This should be false");

    }
}
