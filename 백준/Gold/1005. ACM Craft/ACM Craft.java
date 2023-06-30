import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int[] link;
  public static Queue<Integer> q = new LinkedList<>();

  public static void main(String args[]) throws IOException {
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      sb.append(Build(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
    }

    System.out.print(sb.toString());
  }

  public static int Build(int N, int K) throws IOException {
    int[] dp = new int[N], time = new int[N];
    int[] link = new int[N];
    boolean[][] order = new boolean[N][N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      dp[i] = time[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      order[a][b] = true;

      link[b]++;
    }

    for (int i = 0; i < N; i++) {
      if (link[i] == 0) {
        dp[i] = time[i];
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int tmp = q.poll();

      for (int i = 0; i < N; i++) {
        if (order[tmp][i]) {
          dp[i] = Math.max(dp[tmp] + time[i], dp[i]);
          link[i]--;

          if (link[i] == 0)
            q.add(i);
        }
      }
    }

    return (dp[Integer.parseInt(br.readLine()) - 1]);
  }
}