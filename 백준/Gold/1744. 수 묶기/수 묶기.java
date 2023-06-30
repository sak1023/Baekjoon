import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] seq = new Integer[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 <= 0 && o2 <= 0) {
                    return o1 - o2;
                } else {
                    return o2 - o1;
                }
            }
        });

        int i = 0;
        while (i < N - 1) {
            int a = seq[i];
            int b = seq[i + 1];

            if (a * b > 0) {
                if (a * b >= a + b) {
                    answer += a * b;
                } else {
                    answer += a + b;
                }
                i += 2;
            } else if (a == 0 && b < 0 || a < 0 && b == 0) {
                i += 2;
            } else {
                answer += a;
                i++;
            }
        }

        if (i == N - 1) {
            answer += seq[i];
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}