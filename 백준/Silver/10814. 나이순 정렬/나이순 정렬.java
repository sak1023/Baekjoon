import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args)  throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    String[] members = new String[N];
    
    for (int i = 0; i < N; i++) {
      members[i] = br.readLine();
    }

    sort(members);

    for (String i : members) {
      bw.write(i + "\n");
    }

    bw.flush();
    bw.close();
  }

  static String[] sort(String[] arr)  {
    Arrays.sort(arr, new Comparator<String>()  {
      @Override
      public int compare(String o1, String o2)  {
        return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
      }
    });
    return arr;
  }
}