import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

class Line {
    double x1, y1, x2, y2;

    Line(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.y1 = x2;
        this.x2 = y1;
        this.y2 = y2;
    }
}

class Intersection {
    double x, y;

    Intersection(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static Integer[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Line[] la = new Line[N];
        node = new Integer[N];

        Double x1, y1, x2, y2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Double.parseDouble(st.nextToken());
            y1 = Double.parseDouble(st.nextToken());
            x2 = Double.parseDouble(st.nextToken());
            y2 = Double.parseDouble(st.nextToken());

            la[i] = new Line(x1, y1, x2, y2);
            node[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Find_Intersection(la[i], la[j])) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            find(i);
        }

        HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(node));

        int max = 0;

        for (int i : hs) {
            max = Math.max(max, Collections.frequency(Arrays.asList(node), i));
        }

        bw.write(hs.size() + "\n" + max);
        bw.flush();
        bw.close();
    }

    public static boolean Find_Intersection(Line p1, Line p2) {
        double x1 = p1.x1; double x3 = p2.x1;
        double y1 = p1.y1; double y3 = p2.y1;
        double x2 = p1.x2; double x4 = p2.x2;
        double y2 = p1.y2; double y4 = p2.y2;

        double x_numerator = (x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4);
        double y_numerator = (x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4);
        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        double IntersectionX = x_numerator / denominator;
        double IntersectionY = y_numerator / denominator;

        if (denominator == 0) {
            if (Math.min(y3, y4) <= y1 && y1 <= Math.max(y3, y4) || Math.min(y3, y4) <= y2 && y2 <= Math.max(y3, y4) ||
                Math.min(y1, y2) <= y3 && y3 <= Math.max(y1, y2) || Math.min(y1, y2) <= y4 && y4 <= Math.max(y1, y2)) {
                if (x1 == x2 && x2 == x3 && x3 == x4) {
                    return true;
                }
                double n1 = -(y2 - y1) / (x2 - x1) * x1 + y1;
                double n2 = -(y4 - y3) / (x4 - x3) * x3 + y3;

                if (n1 == n2) {
                    if (Math.min(x3, x4) <= x1 && x1 <= Math.max(x3, x4) || Math.min(x3, x4) <= x2 && x2 <= Math.max(x3, x4) ||
                        Math.min(x1, x2) <= x3 && x3 <= Math.max(x1, x2) || Math.min(x1, x2) <= x4 && x4 <= Math.max(x1, x2)) {
                        return true;
                    }
                }
            }
        }
        if (Math.min(x1, x2) <= IntersectionX && IntersectionX <= Math.max(x1, x2) &&
            Math.min(x3, x4) <= IntersectionX && IntersectionX <= Math.max(x3, x4) &&
            Math.min(y1, y2) <= IntersectionY && IntersectionY <= Math.max(y1, y2) &&
            Math.min(y3, y4) <= IntersectionY && IntersectionY <= Math.max(y3, y4)) {
            return true;
        }
        return false;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x >= y) {
                node[x] = y;
            } else {
                node[y] = x;
            }
        }
    }

    public static int find(int x) {
        if (node[x] == x) {
            return x;
        }

        return node[x] = find(node[x]);
    }
}