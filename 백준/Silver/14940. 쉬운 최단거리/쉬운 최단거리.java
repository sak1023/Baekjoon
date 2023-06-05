import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
    int y, x, val;

    protected Point(int y, int x, int val) {
        this.y = y;
        this.x = x;
        this.val = val;
    }
}

public class Main {
    private static int[][] map;
    private static Point goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) { // 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;

                if (val == 2) {
                    goal = new Point(i, j, 0);
                }
            }
        }

        BFS(n, m); // 너비우선탐색으로 출력값 지정

        for (int i = 0; i < n; i++) { // 출력
            for (int j : map[i]) {
                bw.write(j + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int max_y, int max_x) {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        boolean[][] visited = new boolean[max_y][max_x];
        Deque<Point> dq = new LinkedList<>();
        dq.add(goal);
        visited[goal.y][goal.x] = true;

        while (!dq.isEmpty()) {
            Point cur = dq.poll();
            map[cur.y][cur.x] = cur.val;

            for (int i = 0; i < 4; i++) {
                int y = dy[i];
                int x = dx[i];
                Point next = new Point(cur.y + y, cur.x + x, cur.val + 1);

                if (0 <= next.y && next.y < max_y) {
                    if (0 <= next.x && next.x < max_x) {
                        if (map[next.y][next.x] == 1 && !visited[next.y][next.x]) {
                            dq.add(new Point(next.y, next.x, next.val));
                            visited[next.y][next.x] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < max_y; i++) {
            for (int j = 0; j < max_x; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    map[i][j] = -1;
                }
            }
        }
    }
}