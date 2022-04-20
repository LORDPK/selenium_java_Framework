package utilitys;

import org.testng.Assert;

public class Asserts {

    public static void assertStringContainsString(String StringValue, String valueExpected) {
        Assert.assertTrue(
                StringValue.contains(valueExpected),
                "Error string with the value: '"+ StringValue +"' not contains expected value '" + valueExpected + "'"
                );
    }
}
