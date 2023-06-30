import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int N;
    public static Character[][] list;
    public static boolean[][] Visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new Character[N][N];
        Visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                list[i][j] = tmp.charAt(j);
            }
        }

        int ans1 = 0, ans2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Visited[i][j]) {
                    ans1 += Parsing(i, j, list[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Visited[i][j] = false;
                if (list[i][j] == 'G') {
                    list[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Visited[i][j]) {
                    ans2 += Parsing(i, j, list[i][j]);
                }
            }
        }

        bw.write(ans1 + " " + ans2);
        bw.flush();
        bw.close();
    }

    public static int Parsing(int y, int x, Character c) {
        if (x == -1 || y == -1 || x == N || y == N) {
            return 0;
        }

        if (Visited[y][x] || c != list[y][x]) {
            return 0;
        } else {
            Visited[y][x] = true;
            Parsing(y, x - 1, c);
            Parsing(y - 1, x, c);
            Parsing(y, x + 1, c);
            Parsing(y + 1, x, c);
            return 1;
        }
    }
}