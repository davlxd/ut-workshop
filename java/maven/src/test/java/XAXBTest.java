import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by xdli on 2/19/14.
 */
public class XAXBTest {
    private XAXB xAxB;

    @Before
    public void setUp() {
        xAxB = new XAXB();
    }


    @Test
    public void format_output_valid_test() {
        assertThat("4A4B").isEqualTo(xAxB.formatOutput(4, 4));
        assertThat("0A0B").isEqualTo(xAxB.formatOutput(0, 0));
        assertThat("10A4B").isEqualTo(xAxB.formatOutput(10, 4));
    }

    @Test
    public void generate_node_list_test() {
        assertThat(xAxB.generateNode("12356")).hasSize(5);
    }

    @Test
    public void countA_test() {
        List<Node> challenges = xAxB.generateNode("1123");
        List<Node> guesses = xAxB.generateNode("0112");

        assertThat(xAxB.countA(challenges, guesses)).isEqualTo(1);
    }

    @Test
    public void countB_test() {
        List<Node> challenges = xAxB.generateNode("1123");
        List<Node> guesses = xAxB.generateNode("0112");

        assertThat(xAxB.countB(challenges, guesses)).isEqualTo(3);
    }

    @Test
    public void match_result_correct_test() {
        List<String> challenges = Arrays.asList(new String[] {"1234", "1234", "1234", "1123", "1111"});
        List<String> guesses =    Arrays.asList(new String[] {"1234", "1123", "4321", "0112", "1100"});
        List<String> answers =    Arrays.asList(new String[] {"4A0B", "1A2B", "0A4B", "1A2B", "2A0B"});

        Iterator<String> challegesIter = challenges.iterator();
        Iterator<String> guessesIter = guesses.iterator();
        Iterator<String> answersIter = answers.iterator();

        while (challegesIter.hasNext()) {
            String challenge = challegesIter.next();
            String guess = guessesIter.next();
            String answer = answersIter.next();

            assertThat(xAxB.countAB(challenge, guess)).isEqualTo(answer);
        }


    }



}
