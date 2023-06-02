import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {
    public static int[] choices;
    public static boolean[] visited1, visited2;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            choices = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            count = 0;
            visited1 = new boolean[n];
            visited2 = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited1[i]) {
                    DFS(i);
                }
            }

            sb.append(n - count + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void DFS(int input) {
        int output = choices[input] - 1;

        if (visited2[input]) {
            visited1[input] = true;
            count++;
        } else {
            visited2[input] = true;
        }

        if (!visited1[output]) {
            DFS(output);
        }

        visited1[input] = true;
        visited2[input] = false;
    }
}