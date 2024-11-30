import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")))
        {
            int count = Integer.parseInt(reader.readLine());

            List<int[]> cells = new ArrayList<>();
            String[] temp;
            String str;

            while (cells.size() < count){
                str = reader.readLine();
                temp = str.split(" ");

                int[] pair = new int[2];
                pair[0] =Integer.parseInt(temp[0]);
                pair[1] =Integer.parseInt(temp[1]);

                cells.add(pair);
            }

            int[][] board = new int[8][8];

            for (int[] cell : cells) {
                board[cell[0] - 1][cell[1] - 1] = 1;
            }

            int perimeter = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 1){
                            if (i + 1 >= 8 || board[i+1][j] == 0) perimeter++;
                            if (i - 1 < 0 || board[i-1][j] == 0) perimeter++;
                            if (j + 1 >= 8 || board[i][j+1] == 0) perimeter++;
                            if (j - 1 < 0 || board[i][j-1] == 0) perimeter++;
                    }
                }
            }

            writer.write(String.valueOf(perimeter));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}