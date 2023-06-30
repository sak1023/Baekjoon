import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());

        long answer = get_sum_digits(U) - get_sum_digits(L - 1);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static long get_sum_digits(int N) {
        long val = 0;
        long s = 1, e = N;

        for (int i = 0; i <= (int) Math.log(N); i++) {
            while (s % 10 != 0 && s <= e) {
                long tmp = s;

                while (tmp > 0) {
                    val += tmp % 10 * Math.pow(10, i);
                    tmp /= 10;
                }
                s++;
            }

            if (s > e) {
                break;
            }

            while (e % 10 != 9 && s <= e) {
                long tmp = e;

                while (tmp > 0) {
                    val += tmp % 10 * Math.pow(10, i);
                    tmp /= 10;
                }
                e--;
            }

            s /= 10;
            e /= 10;

            val += (e - s + 1) * 45 * Math.pow(10, i);
        }

        return val;
    }
}