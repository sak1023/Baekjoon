import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class node {
    char l;
    char r;

    public node (char l, char r) {
        this.l = l;
        this.r = r;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static node[] tree;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tree = new node[26];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parentNode = st.nextToken().charAt(0);
            char childNodeL = st.nextToken().charAt(0);
            char childNodeR = st.nextToken().charAt(0);

            tree[parentNode - 'A'] = new node(childNodeL, childNodeR);
        }

        preTravelsal(0);
        sb.append("\n");
        inTravelsal(0);
        sb.append("\n");
        postTravelsal(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void preTravelsal(int depth) {
        node n =  tree[depth];
        
        sb.append((char)('A' + depth));

        if (n.l != '.') {
            preTravelsal(n.l - 'A');
        }
        
        if (n.r != '.') {
            preTravelsal(n.r - 'A');
        }
    }
    public static void inTravelsal(int depth) {
        node n =  tree[depth];
        
        if (n.l != '.') {
            inTravelsal(n.l - 'A');
        }

        sb.append((char)('A' + depth));

        if (n.r != '.') {
            inTravelsal(n.r - 'A');
        }
    }
    public static void postTravelsal(int depth) {
        node n =  tree[depth];
        
        if (n.l != '.') {
            postTravelsal(n.l - 'A');
        }

        if (n.r != '.') {
            postTravelsal(n.r - 'A');
        }

        sb.append((char)('A' + depth));
    }
}