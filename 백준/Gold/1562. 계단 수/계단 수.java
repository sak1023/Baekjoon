import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static long[][][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    dp = new long[N][10][1 << 10];

    for (int i = 1; i < 10; i++) {
      dp[0][i][1 << i] = 1;
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k < 1024; k++) {
          int bit = k | (1 << j);
          if (j == 0) {
            dp[i][j][bit] += dp[i - 1][j + 1][k] % 1000000000;
          } else if (j == 9) {
            dp[i][j][bit] += dp[i - 1][j - 1][k] % 1000000000;
          } else {
            dp[i][j][bit] += (dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % 1000000000;
          }
        }
      }
    }

    long sum = 0;

    for ( int i = 0; i < 10; i++) {
      sum = (sum + dp[N - 1][i][1023]) % 1000000000;
    }

    System.out.println(sum);
  }
}