import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by xdli on 2/24/14.
 */
public class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @Before
    public void setup() {
        randomNumberGenerator = new RandomNumberGenerator();
    }


    @Test
    public void number_should_contains_only_digits() {
        String num = randomNumberGenerator.generate();
        for (int i = 0; i < num.length(); i++) {
            assertThat(num.charAt(i)).isGreaterThanOrEqualTo('0')
                    .isLessThanOrEqualTo('9');
        }
    }

    @Test
    public void number_should_has_exact_length() {
        String num = randomNumberGenerator.generate();
        assertThat(num.length()).isEqualTo(4);
    }


    private void do_number_should_have_no_duplicate_digits(String num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = 0; j < num.length() && i != j; j++) {
                assertThat(num.charAt(i)).isNotEqualTo(num.charAt(j));
            }
        }
    }
    @Test
    public void number_should_have_no_duplicate_digits() {
        for (int i =0 ; i < 9999; i++ ) {
            String num = randomNumberGenerator.generate();
            System.out.println(num);
            do_number_should_have_no_duplicate_digits(num);
        }

    }

    @Test
    public void numbers_should_not_duplicate_within_five_generates() {
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            l.add(randomNumberGenerator.generate());
        }
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.size() && i != j; j++) {
                assertThat(l.get(i)).isNotEqualTo(l.get(j));
            }
        }
    }


}
