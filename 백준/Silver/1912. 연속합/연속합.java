import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[] dp, arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    dp = new int[T];
    arr = new int[T];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < T; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(Array_Sum(T));
  }

  public static int Array_Sum(int T) {
    int max = dp[0] = arr[0];

    for (int i = 1; i < T; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
      max = Math.max(dp[i], max);
    }
    return max;
  }
}