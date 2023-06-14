import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BackTracking(board, 0);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    public static void BackTracking(int[][] board, int depth) {
        if (depth == 5) {
            Get_Max(board);
            return;
        }
        
        Up(board, depth);
        Down(board, depth);
        Left(board, depth);
        Right(board, depth);
    }

    public static void Get_Max(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }

    public static void Up(int[][] b, int depth) {
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = b[i][j];
            }
        }
        
        for (int row = 0; row < N; row++) {
            int col = 0;

            while (col < N - 1) {
                int tmp = col + 1;

                while (tmp < N) {
                    if (board[tmp][row] != 0) {
                        if (board[col][row] == board[tmp][row]) {
                            board[col][row] *= 2;
                            board[tmp][row] = 0;
                            col = tmp;
                        }
                        break;
                    }
                    tmp++;
                }
                col++;
            }
        }
        BackTracking(Sort("Up", depth, board), depth + 1);
    }

    public static void Down(int[][] b, int depth) {
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = b[i][j];
            }
        }
        
        for (int row = 0; row < N; row++) {
            int col = N - 1;

            while (col > 0) {
                int tmp = col - 1;

                while (tmp >= 0) {
                    if (board[tmp][row] != 0) {
                        if (board[col][row] == board[tmp][row]) {
                            board[col][row] *= 2;
                            board[tmp][row] = 0;
                            col = tmp;
                        }
                        break;
                    }
                    tmp--;
                }
                col--;
            }
        }
        BackTracking(Sort("Down", depth, board), depth + 1);
    }

    public static void Left(int[][] b, int depth) {
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = b[i][j];
            }
        }

        for (int col = 0; col < N; col++) {
            int row = 0;

            while (row < N - 1) {
                int tmp = row + 1;

                while (tmp < N) {
                    if (board[col][tmp] != 0) {
                        if (board[col][row] == board[col][tmp]) {
                            board[col][row] *= 2;
                            board[col][tmp] = 0;
                            row = tmp;
                        }
                        break;
                    }
                    tmp++;
                }
                row++;
            }
        }
        BackTracking(Sort("Left", depth, board), depth + 1);
    }

    public static void Right(int[][] b, int depth) {
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = b[i][j];
            }
        }

        for (int col = 0; col < N; col++) {
            int row = N - 1;

            while (row > 0) {
                int tmp = row - 1;

                while (tmp >= 0) {
                    if (board[col][tmp] != 0) {
                        if (board[col][row] == board[col][tmp]) {
                            board[col][row] *= 2;
                            board[col][tmp] = 0;
                            row = tmp;
                        }
                        break;
                    }
                    tmp--;
                }
                row--;
            }
        }
        BackTracking(Sort("Right", depth, board), depth + 1);
    }

    public static int[][] Sort(String s, int depth, int[][] b) {
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = b[i][j];
            }
        }

        switch (s) {
            case "Up":
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        int tmp = i + 1;

                        while (tmp < N) {
                            if (board[tmp][j] != 0) {
                                board[i][j] = board[tmp][j];
                                board[tmp][j] = 0;
                                break;
                            }
                            tmp++;
                        }
                    }
                }
            }
            // Print(s, depth, board);
            return board;
            case "Down":
            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        int tmp = i - 1;

                        while (tmp >= 0) {
                            if (board[tmp][j] != 0) {
                                board[i][j] = board[tmp][j];
                                board[tmp][j] = 0;
                                break;
                            }
                            tmp--;
                        }
                    }
                }
            }
            // Print(s, depth, board);
            return board;
            case "Left":
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (board[i][j] == 0) {
                        int tmp = j + 1;

                        while (tmp < N) {
                            if (board[i][tmp] != 0) {
                                board[i][j] = board[i][tmp];
                                board[i][tmp] = 0;
                                break;
                            }
                            tmp++;
                        }
                    }
                }
            }
            // Print(s, depth, board);
            return board;
            default:
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j > 0; j--) {
                    if (board[i][j] == 0) {
                        int tmp = j - 1;

                        while (tmp >= 0) {
                            if (board[i][tmp] != 0) {
                                board[i][j] = board[i][tmp];
                                board[i][tmp] = 0;
                                break;
                            }
                            tmp--;
                        }
                    }
                }
            }
            // Print(s, depth, board);
            return board;
        }
    }

    // public static void Print(String s, int depth, int[][] board) {
    //     System.out.println(s + "\t" + depth);

    //     for (int i = 0; i < N; i++) {
    //         for (int j = 0; j < N; j++) {
    //             System.out.print(board[i][j] + "\t");
    //         }
    //         System.out.println();
    //     }
    // }
}