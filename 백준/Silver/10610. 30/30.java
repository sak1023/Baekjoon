import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] arr = new int[10];
        int total = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            arr[num]++;
            total += num;
        }

        if (arr[0] > 0 && total % 3 == 0) {
            for (int i = 9; i >= 0; i--) {
                while (arr[i]-- > 0) {
                    sb.append(i);
                }
            }
        } else {
            sb.append("-1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}