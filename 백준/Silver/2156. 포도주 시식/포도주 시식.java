import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static int[] dp;
  public static int[] wine;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    dp = new int[N];
    wine = new int[N];

    for (int i = 0; i < N; i++) {
      wine[i] = Integer.parseInt(br.readLine());
    }

    System.out.print(Get_Score(N));
  }

  public static int Get_Score(int N) {
    dp[0] = wine[0];
    if (N > 1) dp[1] = wine[0] + wine[1];
    if (N > 2) dp[2] = Math.max(Math.max(wine[0] + wine[2], wine[1] + wine[2]), dp[1]);

    for (int i = 3; i < N; i++) {
      dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), dp[i - 1]);
    }
    
    return dp[N - 1];
  }
}