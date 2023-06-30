import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        System.out.println(Cal(N) + "\n" + sb.toString());
    }

    public static int Cal(int N) {
        for (int i = 2; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int tmp = N;
        sb.append(tmp + " ");
        while (tmp != 1) {
            if (tmp % 6 == 0) {
                if (dp[tmp / 3] <= dp[tmp / 2] && dp[tmp / 3] <= dp[tmp - 1]) {
                    tmp = tmp / 3;
                    sb.append(tmp + " ");
                } else if (dp[tmp / 2] <= dp[tmp / 3] && dp[tmp / 2] <= dp[tmp - 1]) {
                    tmp = tmp / 2;
                    sb.append(tmp + " ");
                } else if (dp[tmp - 1] <= dp[tmp / 3] && dp[tmp - 1] <= dp[tmp / 2]) {
                    tmp = tmp - 1;
                    sb.append(tmp + " ");
                }
            } else if (tmp % 3 == 0) {
                if (dp[tmp / 3] <= dp[tmp - 1]) {
                    tmp = tmp / 3;
                    sb.append(tmp + " ");
                } else {
                    tmp = tmp - 1;
                    sb.append(tmp + " ");
                }
            } else if (tmp % 2 == 0) {
                if (dp[tmp / 2] <= dp[tmp - 1]) {
                    tmp = tmp / 2;
                    sb.append(tmp + " ");
                } else {
                    tmp = tmp - 1;
                    sb.append(tmp + " ");
                }
            } else {
                tmp = tmp - 1;
                sb.append(tmp + " ");
            }
        }

        return dp[N];
    }
}