import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Application {
    int memory;
    int weight;

    Application(int memory, int weight) {
        this.memory = memory;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[10001];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        Application[] app = new Application[N];

        for (int i = 0; i < N; i++) {
            app[i] = new Application(Integer.parseInt(st2.nextToken()), Integer.parseInt(st3.nextToken()));
        }

        for (Application a : app) {
            for (int i = 10000; i >= a.weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - a.weight] + a.memory);
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= M) {
                bw.write(Integer.toString(i));
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}