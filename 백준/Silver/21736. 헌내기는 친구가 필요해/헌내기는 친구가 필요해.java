import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
    int y;
    int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    private static int N, M;
    private static String[] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new String[N];
        boolean check = false;
        Point p = new Point(0, 0);

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine();

            if (!check) {
                for (int j = 0; j < M; j++) {
                    Character c = campus[i].charAt(j);

                    if (c.equals('I')) {
                        check = true;
                        p.y = i;
                        p.x = j;
                        break;
                    }
                }
            }

        }

        bw.write(BFS(p));
        bw.flush();
        bw.close();
    }

    public static String BFS(Point s) {
        int count = 0;
        int[] dy = { 0, 0, -1, 1 };
        int[] dx = { -1, 1, 0, 0 };
        Deque<Point> dq = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        dq.add(s);
        visited[s.y][s.x] = true;

        while (!dq.isEmpty()) {
            Point cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (0 <= ny && ny < N) {
                    if (0 <= nx && nx < M) {
                        Character c = campus[ny].charAt(nx);
                        if (!visited[ny][nx]) {
                            if (!c.equals('X')) {
                                dq.add(new Point(ny, nx));
                                visited[ny][nx] = true;
                                if (c.equals('P')) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return count == 0 ? "TT" : Integer.toString(count);
    }
}