import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AddId {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("Geometric selfie copy.svg");
            Scanner in = new Scanner(reader);

            FileWriter writer = new FileWriter("Geometric Selfie Second Copy.svg");

            int pathNr = 0; 

            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.length() > 8) {
                    boolean lineHasPath = line.substring(3, 7).equals("path")? true : false;
                    if (lineHasPath) {
                        String newline = line.substring(0, 8);
                        newline += "id=\"p" + pathNr + "\" " + line.substring(8);
                        pathNr ++;
                        line = newline;
                        if (pathNr > 0) {
                            line += "\n\t\t<animate attributeName=\"opacity\" from=\"0\" to=\"1\" dur=\"0.002s\" fill=\"freeze\"" + "d=\"a" + pathNr + "\"" + "begin=\"d" + (pathNr - 1) + ".end\"" + "/>";
                        }
                    }                    
                }
                writer.append(line + "\n");
            }
            in.close();
            writer.close();
        } catch(Exception e) {};
    }
}
