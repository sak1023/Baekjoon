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
        int[] P = new int[N];
        Integer[] answer = new Integer[50];
        int min1 = -1;
        int min2 = -1;
        int wei1 = Integer.MAX_VALUE;
        int wei2 = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());

            if (wei2 > P[i]) {
                if (wei1 > P[i]) {
                    wei2 = wei1;
                    wei1 = P[i];
                    min2 = min1;
                    min1 = i;
                } else {
                    wei2 = P[i];
                    min2 = i;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        int remain = M;
        int idx = 0;

        if (min1 == 0 && M >= wei2) {
            answer[idx++] = min2;
            remain -= P[min2];

            while (remain - wei1 >= 0) {
                answer[idx++] = min1;
                remain -= wei1;
            }
        } else {
            answer[idx++] = min1;
            remain -= P[min1];

            while (remain - wei1 >= 0 && min1 != 0) {
                answer[idx++] = min1;
                remain -= wei1;
            }
        }

        int end = idx - 1;
        idx = 0;
        boolean possible = true;

        while (possible && idx <= end) {
            possible = false;

            for (int i = N - 1; i >= 0; i--) {
                if (answer[idx] > i) {
                    idx++;
                    possible = true;
                    break;
                }
                if (i != answer[idx] && remain - (P[i] - P[answer[idx]]) >= 0) {
                    possible = true;
                    remain -= (P[i] - P[answer[idx]]);
                    answer[idx++] = i;
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= end; i++) {
            sb.append(answer[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}