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
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int[][] DP = new int[N + 1][K + 1];
    
    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= K && j <= i; j++) {
        if (j == 0 || i == j) {
          DP[i][j] = 1;
        } else {
          DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j]) % 10007;
        }
      }
    }

    bw.write(Integer.toString(DP[N][K]));
    bw.flush();
    bw.close();
  }
}