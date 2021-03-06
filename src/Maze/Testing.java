package Maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Testing {

    static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public static void main(String args[]) throws IOException {
        String s = readFile("DFS4.txt");
        System.out.println(s);
    }
}
