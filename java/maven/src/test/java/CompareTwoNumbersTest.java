import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by lxd on 23/2/14.
 */
public class CompareTwoNumbersTest {
    private CompareTwoNumbers compareTwoNumbers;

    @Before
    public void setUp() {
        compareTwoNumbers = new CompareTwoNumbers();
    }

    @Test
    public void test_4_A_0_B() {
        assertThat(compareTwoNumbers.countAB("1234", "1234")).isEqualTo("4A0B");
    }

    @Test
    public void test_0_A_0_B() {
        assertThat(compareTwoNumbers.countAB("1234", "5678")).isEqualTo("0A0B");
    }

    @Test
    public void test_0_A_4_B() {
        assertThat(compareTwoNumbers.countAB("1234", "4312")).isEqualTo("0A4B");
    }

    @Test
    public void test_1_A_3_B() {
        assertThat(compareTwoNumbers.countAB("1234", "4132")).isEqualTo("1A3B");
    }

    @Test
    public void test_0_A_2_B() {
        assertThat(compareTwoNumbers.countAB("1234", "5372")).isEqualTo("0A2B");
    }

}
