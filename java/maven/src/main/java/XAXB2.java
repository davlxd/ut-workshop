/**
 * Created by lxd on 23/2/14.
 */
public class XAXB2 {
    public String count(String challenge, String guess) {
        int countA = 0, countB = 0;
        for (int i = 0; i < challenge.length(); i++) {
            if (challenge.charAt(i) == guess.charAt(i)) {
                countA += 1;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < challenge.length(); j++) {
                if (guess.charAt(i) == challenge.charAt(j)) {
                    countB += 1;
                }
            }
        }

        return countA + "A" + countB + "B";
    }
}
