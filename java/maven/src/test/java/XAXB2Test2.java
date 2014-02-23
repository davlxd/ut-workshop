import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by lxd on 23/2/14.
 */
public class XAXB2Test2 {
    private XAXB2 xAxB;

    @Before
    public void setUp() {
        xAxB = new XAXB2();
    }

    @Test
    public void test_4_A_0_B() {
        assertThat(xAxB.count("1234", "1234")).isEqualTo("4A0B");
    }

    @Test
    public void test_0_A_0_B() {
        assertThat(xAxB.count("1234", "5678")).isEqualTo("0A0B");
    }
}
