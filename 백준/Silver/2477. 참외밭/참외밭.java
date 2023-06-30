import java.io.*;

public class Main {
  public static void main(String[] Args)  throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int K = Integer.parseInt(br.readLine());
    String[] square = new String[6];
    int l_num1 = 0;
    int l_num2 = 0;
    int l_area = 0;
    int n_area = 0;
    int count1, count2;
    
    
    for (int i = 0; i < square.length; i++) {
      square[i] = br.readLine();
      if (Integer.parseInt(square[l_num1].substring(2)) < Integer.parseInt(square[i].substring(2))) {
        l_num1 = i;
      }
    }

    if (l_num1 == 0)  {
      l_num2 = 1;
    }

    if (Character.getNumericValue(square[l_num1].charAt(0)) <= 2) {
      for (int i = 1; i < square.length; i++) {
        if (Character.getNumericValue(square[i].charAt(0)) >= 3) {
          if (Integer.parseInt(square[l_num2].substring(2)) < Integer.parseInt(square[i].substring(2))) {
            l_num2 = i;
          }
        }
      }
    }
    else if (Character.getNumericValue(square[l_num1].charAt(0)) >= 3)  {
      for (int i = 1; i < square.length; i++) {
        if (Character.getNumericValue(square[i].charAt(0)) <= 2) {
          if (Integer.parseInt(square[l_num2].substring(2)) < Integer.parseInt(square[i].substring(2))) {
            l_num2 = i;
          }
        }
      }
    }

    l_area = Integer.parseInt(square[l_num1].substring(2)) * Integer.parseInt(square[l_num2].substring(2));

    count1 = l_num1 + 3;
    count2 = l_num2 + 3;

    if (count1 >= 6) {
      count1 -= 6;
    }

    if (count2 >= 6) {
      count2 -= 6;
    }

    n_area = Integer.parseInt(square[count1].substring(2)) * Integer.parseInt(square[count2].substring(2));

    bw.write(Integer.toString((l_area - n_area) * K));
    bw.flush();
    bw.close();
  }
}