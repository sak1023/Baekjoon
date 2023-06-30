import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int y;
    int x;
    int count;
    int wasbreak;

    Point(int y, int x, int count, int wasbreak) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.wasbreak = wasbreak;
    }
}

public class Main {
    public static int[][] wall;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                wall[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(Integer.toString(BFS()));
        bw.flush();
        bw.close();
    }

    public static int BFS() {
        int answer = -1;
        int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][] visited = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 1));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Point cur = q.remove();

            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.count;
            }

            for (int[] i : move) {
                int y = cur.y + i[0];
                int x = cur.x + i[1];

                if (N <= y || y < 0 || M <= x || x < 0) {
                    continue;
                }

                if (visited[y][x] == 0) {
                    if (wall[y][x] == 0) {
                        visited[y][x] = cur.wasbreak;
                        q.add(new Point(y, x, cur.count + 1, cur.wasbreak));
                    } else if (cur.wasbreak == 1) {
                        visited[y][x] = -1;
                        q.add(new Point(y, x, cur.count + 1, -1));
                    }
                } else if (visited[y][x] == -1 && cur.wasbreak == 1 && wall[y][x] == 0) {
                    visited[y][x] = 1;
                    q.add(new Point(y, x, cur.count + 1, 1));
                }
            }
        }
        return answer;
    }
}