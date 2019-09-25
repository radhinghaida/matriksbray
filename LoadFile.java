import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class LoadFile {
  public static double[][] main(String args[]) throws IOException {

    double d;
    int countCol, countRow,i,j,x,y;
    FileReader fin = new FileReader("anjiingbrayy.txt");
    Scanner src = new Scanner(fin);
    countCol = 0;
    countRow = 0;

    while (src.hasNext()) {
      
        if (src.hasNextDouble()) {
            countCol += 1;
        } 
        else if (src.hasNextLine()) {
            countRow += 1;
        }
    }
    fin.close();
    
    double M[][] = new double[countCol][countRow];
    FileReader fin = new FileReader("anjiingbrayy.txt");
    Scanner src = new Scanner(fin);
    i = 0;
    j = 0;

    for (i = 0; i < countCol; i++) {
        for (j = 0; j < countRow; j++) {
            if (src.hasNextDouble())
        }
    }


  }
}
