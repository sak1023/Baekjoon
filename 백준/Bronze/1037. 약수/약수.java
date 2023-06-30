import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int A = Integer.parseInt(br.readLine());
    
    int[] Divisor = new int[A];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < A; i++) {
      Divisor[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(Divisor);

    bw.write(Integer.toString(Divisor[0] * Divisor[A - 1]));
    bw.flush();
    bw.close();
  }
}