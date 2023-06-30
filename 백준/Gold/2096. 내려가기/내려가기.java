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

        int N = Integer.parseInt(br.readLine());
        int[] max_dp = new int[3];
        int[] min_dp = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            max_dp[i] = min_dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            int max0 = max_dp[0], max1 = max_dp[1], max2 = max_dp[2];
            int min0 = min_dp[0], min1 = min_dp[1], min2 = min_dp[2];

            max_dp[0] = Math.max(max0, max1) + n0;
            max_dp[1] = Math.max(max0, Math.max(max1, max2)) + n1;
            max_dp[2] = Math.max(max1, max2) + n2;

            min_dp[0] = Math.min(min0, min1) + n0;
            min_dp[1] = Math.min(min0, Math.min(min1, min2)) + n1;
            min_dp[2] = Math.min(min1, min2) + n2;
        }

        bw.write(Math.max(max_dp[0], Math.max(max_dp[1], max_dp[2])) + " " + Math.min(min_dp[0], Math.min(min_dp[1], min_dp[2])));
        bw.flush();
        bw.close();
    }
}