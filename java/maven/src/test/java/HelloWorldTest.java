import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloWorldTest {
   @Test
   public void hello_world_test(){
     assertThat("Hello World", is("Hello World"));
   }
}
