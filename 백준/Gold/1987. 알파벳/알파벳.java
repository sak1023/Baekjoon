import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static String[] alphabet;
    public static boolean[] ispassed = new boolean[26];
    public static int R, C, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[R];

        for (int i = 0; i < R; i++) {
            alphabet[i] = br.readLine();
        }

        ispassed[alphabet[0].charAt(0) - 'A'] = true;

        Count_Alphabet_Move(0, 1);

        System.out.print(max);
    }

    public static void Count_Alphabet_Move(int matrix, int cnt) {
        max = Math.max(max, cnt);

        if (matrix - C >= 0) {
            move(matrix - C, cnt + 1);
        }

        if (matrix + C < R * C) {
            move(matrix + C, cnt + 1);
        }

        if (matrix - 1 >= 0 && (matrix - 1) % C != C - 1) {
            move(matrix - 1, cnt + 1);
        }

        if ((matrix + 1) % C != 0) {
            move(matrix + 1, cnt + 1);
        }
    }

    public static void move(int matrix, int cnt) {
        int y = matrix / C;
        int x = matrix % C;

        if (ispassed[alphabet[y].charAt(x) - 'A']) {
            return;
        }

        ispassed[alphabet[y].charAt(x) - 'A'] = true;
        Count_Alphabet_Move(matrix, cnt);
        ispassed[alphabet[y].charAt(x) - 'A'] = false;
    }
}