import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push" :   q.offer(Integer.parseInt(st.nextToken()));                              break;
                case "pop"  :   sb.append(q.isEmpty() == true ? -1 + "\n" : q.poll() + "\n");           break;
                case "size" :   sb.append(q.size() + "\n");                                             break;
                case "empty":   sb.append(q.isEmpty() == true ? 1 + "\n" : 0 + "\n");                   break;
                case "front":   sb.append(q.isEmpty() == true ? -1 + "\n" : q.peek() + "\n");           break;
                case "back" :   sb.append(q.isEmpty() == true ? -1 + "\n" : q.peekLast() + "\n");       break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}