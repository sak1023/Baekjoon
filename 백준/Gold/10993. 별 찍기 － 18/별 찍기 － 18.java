import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static String[][] star;
    public static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        width = 1;
        int height = 1;
        int mul_four = 4;
        int mul_two = 2;

        for (int i = 1; i < N; i++) {
            width += mul_four;
            height += mul_two;
            mul_four *= 2;
            mul_two *= 2;
        }

        star = new String[height][width];

        Star_Dots(0, height - 1, 0, width - 1, N);
        StringBuilder sb = new StringBuilder();

        if (N % 2 == 0) {
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width - count; j++) {
                    sb.append(star[i][j]);
                }
                sb.append("\n");
                count++;
            }
        } else {
            int count = 1;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width / 2 + count; j++) {
                    sb.append(star[i][j]);
                }
                sb.append("\n");
                count++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void Star_Dots(int ys, int ye, int xs, int xe, int depth) {
        if (depth == 0) {
            return;
        }

        int dot = width / 2;

        if (depth % 2 == 0) {
            int count = 1;
            for (int j = xs; j <= xe; j++) {
                star[ys][j] = "*";
            }
            for (int i = ys + 1; i <= ye; i++) {
                for (int j = xs; j <= xe; j++) {
                    if (j == xs + count || j == xe - count) {
                        star[i][j] = "*";
                    } else {
                        star[i][j] = " ";
                    }
                }
                count++;
            }
            Star_Dots(ys + 1, (ys + ye) / 2, xs + (ye - ys) / 2 + 1, xe - (ye - ys) / 2 - 1, depth - 1);
        } else {
            int count = 0;
            for (int i = ys; i < ye; i++) {
                for (int j = xs; j <= xe; j++) {
                    if (j == dot + count || j == dot - count) {
                        star[i][j] = "*";
                    } else {
                        star[i][j] = " ";
                    }
                }
                count++;
            }
            for (int j = xs; j <= xe; j++) {
                star[ye][j] = "*";
            }
            Star_Dots((ys + ye) / 2, ye - 1, xs + (ye - ys) / 2 + 1, xe - (ye - ys) / 2 - 1, depth - 1);
        }
    }
}