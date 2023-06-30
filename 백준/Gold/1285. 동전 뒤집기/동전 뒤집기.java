import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int N;
    public static int answer = Integer.MAX_VALUE;
    public static char[][] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        coin = new char[N][N];

        for (int i = 0; i < N; i++) {
            coin[i] = br.readLine().toCharArray();
        }

        flip(0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void flip(int row) {
        if (row == N) {
            int min_count = 0;
            for (char[] i : coin) {
                int count = 0;
                for (char j : i) {
                    if (j == 'T') {
                        count++;
                    }
                }
                min_count += Math.min(count, N - count);
            }
            answer = Math.min(answer, min_count);
            return;
        }
        flip(row + 1);

        for (int i = 0; i < N; i++) {
            coin[i][row] = coin[i][row] == 'H' ? 'T' : 'H';
        }

        flip(row + 1);
    }
}