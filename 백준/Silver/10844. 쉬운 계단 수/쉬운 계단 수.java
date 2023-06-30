import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static long[][] dp;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    dp = new long[N][10];

    for (int i = 1; i <= 9; i++) {
      dp[0][i] = 1;
    }

    System.out.print(Stairs(N - 1));
  }

  public static long Stairs(int N) {
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j + 1];
        } else if (j == 9) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]);
        }
        dp[i][j] %= 1000000000;
      }
    }

    int cnt = 0;

    for (int i = 0; i <= 9; i++) {
      cnt += dp[N][i];
      cnt %= 1000000000;
    }

    return cnt;
  }
}