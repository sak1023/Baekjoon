import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class point {
    int y;
    int x;

    point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    final static int[] py = { -1, 1, 0, 0 }, px = { 0, 0, -1, 1 };
    public static int N, M, count = 4, answer = 0;
    public static boolean[] visited;
    public static int[][] map;
    public static ArrayList<point> empty = new ArrayList<>();
    public static ArrayList<point> bacteria = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int token = Integer.parseInt(st.nextToken());
                map[i][j] = token;

                if (token == 0) {
                    empty.add(new point(i, j));
                } else if (token == 2) {
                    bacteria.add(new point(i, j));
                }
            }
        }

        safety_area(0, 0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void safety_area(int idx, int depth) {
        if (depth == 3) {
            for (point i : bacteria) {
                growth(i.y, i.x);
            }

            int tmp_ans = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = map[i][j];

                    if (cur == 0 || (3 <= cur && cur < count - 1)) {
                        tmp_ans++;
                    }
                }
            }

            answer = Math.max(tmp_ans, answer);

            count += 2;
            return;
        }

        for (int i = idx; i < empty.size(); i++) {
            point p = empty.get(i);


            map[p.y][p.x] = 1;
            safety_area(i + 1, depth + 1);
            map[p.y][p.x] = 0;
        }
    }

    public static void growth(int y, int x) {
        map[y][x] = count - 1;

        for (int k = 0; k < 4; k++) {
            int i = py[k];
            int j = px[k];

            if (0 <= i + y && i + y < N && 0 <= j + x && j + x < M) {
                int cur = map[i + y][j + x];
                if (cur == 0 || (3 <= cur && cur < count - 1)) {
                    growth(i + y, j + x);
                }
            }
        }
        return;
    }
}