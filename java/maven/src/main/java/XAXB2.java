/**
 * Created by lxd on 23/2/14.
 */
public class XAXB2 {

    public int countA(String challenge, String guess) {
        int count = 0;
        for (int i = 0; i < challenge.length(); i++) {
            if (challenge.charAt(i) == guess.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int countB(String challenge, String guess) {
        int count = 0;
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < challenge.length(); j++) {
                if (guess.charAt(i) == challenge.charAt(j)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public String count(String challenge, String guess) {
        int count_a = countA(challenge, guess);
        int count_b = countB(challenge, guess);

        return count_a + "A" + (count_b - count_a) + "B";
    }
}
