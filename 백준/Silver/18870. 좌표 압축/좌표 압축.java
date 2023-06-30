import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] Args)  throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Integer[] arr = new Integer[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
    Integer[] sorted_arr = set.toArray(new Integer[0]);

    Arrays.sort(sorted_arr);

    for (int i = 0; i < sorted_arr.length; i++)  {
      map.put(sorted_arr[i], i);
    }

    for (int i = 0; i < arr.length; i++)  {
    bw.write(map.get(arr[i]) + " ");
    }
    
    bw.flush();
    bw.close();
  }
}