import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class JsonExampleTest {

    @Test
    public void personIsMick() {
        assertEquals("Mick",JsonExample.createJSON().get("name"));
    }
}