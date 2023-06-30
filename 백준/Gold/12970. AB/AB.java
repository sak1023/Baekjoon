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
        int len_A = 0;
        int len_B = 0;
        int count = 1;
        int target;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            len_A = i;
            len_B = N - i;

            if (len_A * len_B >= K) {
                break;
            }
        }

        if (len_A * len_B < K) {
            bw.write("-1");
            bw.flush();
            bw.close();
            System.exit(0);
        } else if (len_A * len_B == K) {
            for (int i = 0; i < len_A; i++) {
                sb.append("A");
            }

            for (int i = 0; i < len_B; i++) {
                sb.append("B");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.exit(0);
        }

        len_A--;
        len_B++;
        
        for (int i = 0; i < len_A; i++) {
            sb.append("A");
            count++;
        }

        target = N - (K - (len_A * len_B - len_A)) - 1;

        for (int i = len_A; i < target; i++) {
            sb.append("B");
            count++;
        }
        sb.append("A");
        
        for (int i = count; i < N; i++) {
            sb.append("B");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}