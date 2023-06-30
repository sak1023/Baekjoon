import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class matrix {
    int r;
    int c;

    public matrix(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        matrix[] m = new matrix[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m[i] = new matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = m[i].r * m[i].c * m[i + 1].c;
        }

        for (int d = 2; d < N; d++) {
            for (int i = 0; i + d < N; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + m[i].r * m[k].c * m[j].c);
                }
            }
        }

        bw.write(Integer.toString(dp[0][N - 1]));
        bw.flush();
        bw.close();
    }
}