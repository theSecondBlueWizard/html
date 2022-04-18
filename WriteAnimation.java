import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteAnimation {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("Geometric selfie copy.svg");
            Scanner in = new Scanner(reader);

            FileWriter writer = new FileWriter("Animation.css");

            int pathNr = 0; 
            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.length() > 8) {
                    boolean lineHasPath = line.substring(3, 7).equals("path")? true : false;
                    if (lineHasPath) {
                        writer.append("<animate xlink:href=\"p" + pathNr + "\" attributeName=\"opacity\" from=\"0\" to=\"1\">\n");
                        pathNr += 1;
                    }                    
                }
            }
            in.close();
            writer.close();
        } catch(Exception e) {};
    }
}
