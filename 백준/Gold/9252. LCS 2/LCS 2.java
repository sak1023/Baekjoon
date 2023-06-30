import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int cnt = 0;
        int target = dp[len1][len2];
        int y = len1;
        int x = len2;
        Stack<Character> stack = new Stack<>();

        answer.append(target + "\n");

        while(cnt != target) {
            int cur = dp[y][x];
            if (cur == dp[y][x - 1]) {
                x--;
            } else if (cur == dp[y - 1][x]) {
                y--;
            } else {
                stack.add(str1.charAt(y - 1));
                x--;
                y--;
                cnt++;
            }
        }

        for (int i = 0; i < target; i++) {
            answer.append(stack.pop());
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}