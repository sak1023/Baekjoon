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
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] Sticker = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    Sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            
            dp[0][1] = Sticker[0][1];
            dp[1][1] = Sticker[1][1];

            for (int j = 2; j <= N; j++) {
                for (int i = 0; i < 2; i++) {
                    dp[i][j] = Math.max(dp[i^1][j - 1], dp[i^1][j - 2]) + Sticker[i][j];
                }
            }
            sb.append(Math.max(dp[0][N], dp[1][N]) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}