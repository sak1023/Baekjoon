import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i = Integer.parseInt(br.readLine());

        while (i != 0) {
            sb.append((i + 1) * i / 2 + "\n");
            i = Integer.parseInt(br.readLine());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}