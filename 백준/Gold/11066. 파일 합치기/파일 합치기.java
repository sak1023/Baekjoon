import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int[] chapter = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            chapter[1] = Integer.parseInt(st.nextToken());
            for (int i = 2; i <= K; i++) {
                chapter[i] = chapter[i - 1] + Integer.parseInt(st.nextToken());
                dp[i - 1][i] = chapter[i] - chapter[i - 2];
            }

            for (int d = 2; d <= K; d++) {
                for (int i = 1; d + i <= K; i++) {
                    int j = d + i;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + chapter[j] - chapter[i - 1], dp[i][j]);
                    }
                }
            }
            bw.write(dp[1][K] + "\n");
        }
        bw.flush();
        bw.close();
    }
}