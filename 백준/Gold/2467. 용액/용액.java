import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String Args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = arr.length - 1;
        int[] res = { 1000000000, 1000000000 };

        while (s < e) {
            int as = arr[s];
            int ae = arr[e];
            int cp = res[0] + res[1];

            if (as + ae == 0) {
                Exit(arr[s], arr[e]);
            } else if (as + ae > 0) {
                if (Math.abs(cp) > Math.abs(as + ae)) {
                    res[0] = as;
                    res[1] = ae;
                }

                e--;
            } else {
                if (Math.abs(cp) > Math.abs(as + ae)) {
                    res[0] = as;
                    res[1] = ae;
                }

                s++;
            }
        }

        Exit(res[0], res[1]);
    }

    public static void Exit(int s, int e) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(s) + " " + Integer.toString(e));
        bw.flush();
        bw.close();
        System.exit(0);
    }
}