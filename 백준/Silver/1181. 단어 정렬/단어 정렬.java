import java.io.*;
import java.util.*;

public class Main {
  public static void main(String Args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    List<String> words = new ArrayList<>();
    String temp;

    for (int i = 0; i < N; i++) {
      temp = br.readLine();
      if (!words.contains(temp)) {
        words.add(temp);
      }
    }

    words = sorting(words);

    for (String word : words) {
      bw.write(word + "\n");
    }

    bw.flush();
    bw.close();
  }

  static List<String> sorting(List<String> list) {

    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        } else {
          return o1.length() - o2.length();
        }
      }
    });
    return list;
  }
}