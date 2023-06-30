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
        int[] road = new int[N - 1];
        int[] gas_station = new int[N];
        Long sum = (long) 0;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gas_station[i] = Integer.parseInt(st.nextToken());
        }

        int min = gas_station[0];

        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, gas_station[i]);
            sum += (min * road[i]);
        }

        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
    }
}