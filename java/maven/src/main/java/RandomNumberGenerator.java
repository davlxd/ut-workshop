import java.util.Random;

/**
 * Created by xdli on 2/24/14.
 */
public class RandomNumberGenerator {

    public String generate() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i =0; i < 4; i++) {
            int d = random.nextInt(10);
            while (sb.toString().contains(""+d)) {
                d = random.nextInt(10);
            }

            sb.append(d);
        }

        return sb.toString();
    }
}
