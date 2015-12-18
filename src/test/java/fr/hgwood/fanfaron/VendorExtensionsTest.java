package fr.hgwood.fanfaron;

import fr.hgwood.fanfaron.utils.vendorextensions.DynamicObjectWithVendorExtensions;
import fr.hgwood.fanfaron.utils.vendorextensions.WithVendorExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static fr.hgwood.fanfaron.TestUtils.deserialize;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class VendorExtensionsTest {

    @Parameterized.Parameter public Class<?> classSupportingVendorExtensions;

    @Parameters(name = "{0}")
    public static List<Object[]> classes_which_support_vendor_extensions() {
        return asList(new Object[][] {
            {Contact.class},
            {ExternalDocumentation.class},
            {Info.class},
            {Items.class},
            {License.class},
            {Operation.class},
            {Parameter.class},
            {PathItem.class},
            {Paths.class},
            {Response.class},
            {Responses.class},
            {Scopes.class},
            {SecurityScheme.class},
            {Swagger.class},
            {Tag.class},
            {Xml.class}
        });
    }

    @Test public void supports_vendor_extensions() {
        Object instance =
            deserialize(getClass(), "vendorExtensions.json", classSupportingVendorExtensions);
        if (instance instanceof WithVendorExtensions) {
            assertEquals("extension", ((WithVendorExtensions)instance).vendorExtensions.get("x-extension"));
        } else if (instance instanceof DynamicObjectWithVendorExtensions) {
            assertEquals("extension", ((DynamicObjectWithVendorExtensions)instance).vendorExtensions.get("x-extension"));
            assertTrue(((DynamicObjectWithVendorExtensions)instance).isEmpty());
        }
    }

}
