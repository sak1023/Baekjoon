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
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] MBTI = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (N > 32) {
                sb.append(0 + "\n");
                continue;
            }

            for (int i = 0; i < N; i++) {
                MBTI[i] = st.nextToken();
            }
            
            int o1 = 0, o2 = 1, o3 = 2, min = Integer.MAX_VALUE;

            while (true) {
                if (o3 == N) {
                    o2++;
                    o3 = o2 + 1;
                    if (o2 == N - 1) {
                        o1++;
                        o2 = o1 + 1;
                        o3 = o2 + 1;
                        if (o1 == N - 2) {
                            break;
                        }
                    } 
                }

                int sum = 0;

                for (int i = 0; i < 4; i++) {
                    if (MBTI[o1].charAt(i) != MBTI[o2].charAt(i)) {
                        sum++;
                    }
                    if (MBTI[o1].charAt(i) != MBTI[o3].charAt(i)) {
                        sum++;
                    }
                    if (MBTI[o2].charAt(i) != MBTI[o3].charAt(i)) {
                        sum++;
                    }
                }

                min = Math.min(min, sum);
                o3++;
                
                if (min == 0) {
                    break;
                }
            }

            sb.append(min + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}