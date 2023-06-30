import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        String str = br.readLine();
        
        while (!str.equals("#")) {
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                for (char c : vowel) {
                    if (str.charAt(i) == c) {
                        cnt++;
                        break;
                    }
                }
            }

            sb.append(cnt + "\n");
            str = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}