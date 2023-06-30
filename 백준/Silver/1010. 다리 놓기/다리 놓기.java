import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    int[][] DP = new int[31][31];

    for (int i = 1; i <= 30; i++) {
      for (int j = 0; j <= 30 && i >= j; j++) {
        if (j == 0 || i == j) {
          DP[i][j] = 1;
        } else {
          DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
        }
      }
    }

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      sb.append(DP[M][N] + "\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}