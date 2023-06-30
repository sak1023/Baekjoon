import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] city, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        city = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(Visit_City(0, 1));
    }

    public static int Visit_City(int located, int visited) {
        if (visited == (dp[0].length)) {
            if (city[located][0] == 0) {
                return 16000001;
            } else {
            return city[located][0];
            }
        }

        if (dp[located][visited] != Integer.MAX_VALUE) {
            return dp[located][visited];
        }

        for (int i = 0; i < dp.length; i++) {
            if ((visited & 1 << i) == 0 && city[located][i] != 0) {
                int tmp = Visit_City(i, visited | 1 << i);

                if (tmp != Integer.MAX_VALUE) {
                    dp[located][visited] = Math.min(dp[located][visited], tmp + city[located][i]);
                }
            }
        }

        return dp[located][visited];
    }
}