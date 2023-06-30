import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, T, pr = -1;
    public static int[] coor1 = { -1, 1, 0, 0 }, coor2 = { 0, 0, -1, 1 };
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] room = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && pr == -1) {
                    pr = i;
                }
            }
        }

        cleaning(room, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void cleaning(int[][] dirty_room, int depth) {
        if (depth == T) {
            int sum = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (dirty_room[i][j] > 0) {
                        sum += dirty_room[i][j];
                    }
                }
            }
            sb.append(sum);
            return;
        }

        int[][] clean_room = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dirty_room[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        if (0 <= i + coor1[k] && i + coor1[k] < R && 0 <= j + coor2[k] && j + coor2[k] < C
                                && dirty_room[i + coor1[k]][j + coor2[k]] != -1) {
                            count++;
                            clean_room[i + coor1[k]][j + coor2[k]] += dirty_room[i][j] / 5;
                        }
                    }
                    clean_room[i][j] += dirty_room[i][j] - dirty_room[i][j] / 5 * count;
                } else if (dirty_room[i][j] == -1) {
                    clean_room[i][j] = -1;
                }
            }
        }

        int[][] move_dust = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cur = clean_room[i][j];
                if (cur > 0) {
                    if (i == 0 && j != 0) {
                        move_dust[i][j - 1] = cur;
                    } else if ((i == pr || i == pr + 1) && j != C - 1) {
                        move_dust[i][j + 1] = cur;
                    } else if (i == R - 1 && j != 0) {
                        move_dust[i][j - 1] = cur;
                    } else if (j == 0) {
                        if (i <= pr) {
                            if (i + 1 != pr) {
                                move_dust[i + 1][j] = cur;
                            }
                        } else {
                            if (i - 1 != pr + 1) {
                                move_dust[i - 1][j] = cur;
                            }
                        }
                    } else if (j == C - 1) {
                        if (i <= pr) {
                            move_dust[i - 1][j] = cur;
                        } else {
                            move_dust[i + 1][j] = cur;
                        }
                    } else {
                        move_dust[i][j] = cur;
                    }
                } else if (cur == -1) {
                    move_dust[i][j] = -1;
                }
            }
        }

        cleaning(move_dust, depth + 1);
    }
}