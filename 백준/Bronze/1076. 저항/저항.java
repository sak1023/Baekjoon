import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] res = new long[3];
        String color;

        for (int i = 0; i < 3; i++) {
            color = br.readLine();

            switch(color) {
                case    "black"     :	res[i] = 0; break;
                case    "brown"     :	res[i] = 1; break;
                case    "red"       :	res[i] = 2; break;
                case    "orange"    :	res[i] = 3; break;
                case    "yellow"    :	res[i] = 4; break;
                case    "green"    :	res[i] = 5; break;
                case    "blue"      :	res[i] = 6; break;
                case    "violet"    :	res[i] = 7; break;
                case    "grey"      :	res[i] = 8; break;
                default             :   res[i] = 9;
            }
        }
        
        bw.write((res[0] * 10 + res[1]) * (long) Math.pow(10, res[2]) + "\n");
        bw.flush();
        bw.close();
    }
}