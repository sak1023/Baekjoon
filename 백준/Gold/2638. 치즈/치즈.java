import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] visited;
    public static int[][] cheese;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][M];
            DFS(0, 0);
            boolean check = true;

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    
                    int melt = 0;

                    if (cheese[i][j] == 1) {
                        check = false;

                        if (cheese[i - 1][j] == -1) {
                            melt++;
                        }
                        if (cheese[i][j - 1] == -1) {
                            melt++;
                        }
                        if (cheese[i + 1][j] == -1) {
                            melt++;
                        }
                        if (cheese[i][j + 1] == -1) {
                            melt++;
                        }

                        if (melt >= 2) {
                            cheese[i][j] = -2;
                        }
                    }
                }
            }

            if (check) {
                break;
            }

            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    public static void DFS(int c, int r) {
        if (c != 0) {
            if (cheese[c - 1][r] <= 0 && !visited[c - 1][r]) {
                visited[c - 1][r] = true;
                cheese[c - 1][r] = -1;
                DFS(c - 1, r);
            }
        }

        if (r != 0) {
            if (cheese[c][r - 1] <= 0 && !visited[c][r - 1]) {
                visited[c][r - 1] = true;
                cheese[c][r - 1] = -1;
                DFS(c, r - 1);
            }
        }

        if (c != N - 1) {
            if (cheese[c + 1][r] <= 0 && !visited[c + 1][r]) {
                visited[c + 1][r] = true;
                cheese[c + 1][r] = -1;
                DFS(c + 1, r);
            }
        }

        if (r != M - 1) {
            if (cheese[c][r + 1] <= 0 && !visited[c][r + 1]) {
                visited[c][r + 1] = true;
                cheese[c][r + 1] = -1;
                DFS(c, r + 1);
            }
        }
    }
}