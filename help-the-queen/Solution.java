import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class Solution{
  URL input;
  URL output;
  BufferedReader br;
  PrintWriter out;
  StringTokenizer st;

  public Solution(){
    initialize();
  }

  public void initialize(){
    try {
      input = getClass().getResource("help-the-queen.in");
      br = new BufferedReader(new FileReader(input.getPath()));
    }catch(IOException e) {
      e.printStackTrace();
    }
    try{
      output = getClass().getResource("help-the-queen.out");
      out = new PrintWriter(output.getPath());
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public void readWriteData(){
    try {
      int testCount = Integer.parseInt(br.readLine());
      ArrayList<String> tribes = new ArrayList();//total tribes for particular case
      ArrayList<HashSet> tribeSet = new ArrayList();//list of Hashsets storing names of soldiers for particular tribe

      for (int i = 1; i <=testCount; i++) {
        out.println("Case: "+i);
        int rows = Integer.parseInt(br.readLine());
        for (int j = 0; j < rows; j++) {
          String line = br.readLine();
          String tribeName = line.substring(0, line.indexOf(" "));//assuming that name of the tribe will always be of one word
          String soldierName = line.substring(line.indexOf(" ")+1);
          if (!tribes.contains(tribeName)) {
            tribes.add(tribeName);
            HashSet tribeNameSet = new HashSet();
            tribeNameSet.add(soldierName);
            tribeSet.add(tribeNameSet);
          }
          else{
            tribeSet.get(tribes.indexOf(tribeName)).add(soldierName);
          }
        }

        for (int x = 0; x < tribes.size(); x++) {
          out.println(tribes.get(x)+" "+tribeSet.get(x).size());
        }
        out.println();
        tribes.clear();
        tribeSet.clear();
      }
      br.close();
      out.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Solution().readWriteData();
  }
}
