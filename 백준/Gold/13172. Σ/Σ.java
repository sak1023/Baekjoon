import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    final static int mod = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int g = gcd(N, S);

            N /= g;
            S /= g;

            answer += S * pow(N, mod - 2) % mod;
            answer %= mod;
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        return;
    }

    public static long pow(long a, long b) {
        if (b == 1) {
            return a;
        }

        long return_val = pow(a, b / 2);

        if (b % 2 == 1) {
            return (return_val * return_val % mod) * a % mod;
        }

        return return_val * return_val % mod;
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}