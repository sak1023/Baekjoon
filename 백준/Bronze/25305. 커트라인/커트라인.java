import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    String str1 = br.readLine();
    String str2 = br.readLine();
  
    StringTokenizer st = new StringTokenizer(str1);

    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = Stream.of(str2.split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(arr);

    bw.write(String.valueOf(arr[N - k]));
    bw.flush();
    bw.close();
  }
}