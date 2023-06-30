import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Long answer = 0L;

        for (int i = 0; i <= N; i++) {
            answer *= 2;
            if (i % 2 == 0) {
                answer++;
            } else {
                answer--;
            }
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
}