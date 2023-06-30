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
        int[] seq = new int[N];
        int[] LIS = new int[N];
        int LIS_len = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        for (int i = 1; i < N; i++) {
            if (seq[i] > LIS[LIS_len - 1]) {
                LIS[LIS_len++] = seq[i];
            } else if (seq[i] < LIS[LIS_len - 1]) {
                int l = 0;
                int r = LIS_len;
                while (l < r) {
                    int m = (l + r) / 2;

                    if (LIS[m] < seq[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                LIS[l] = seq[i];
            }
        }

        bw.write(Integer.toString(LIS_len));
        bw.flush();
        bw.close();
    }
}