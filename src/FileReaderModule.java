import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderModule {
    //This method receives the path of a file and return all lines inside it
    public List<String> readFile(String filePath) {

        //We create a list that will store each line of the file.
        List <String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // BufferedReader allows us to read the file line by line

            String line; // Temporarily holds each line we read

            // Read the file until there are no more lines
            while ((line = reader.readLine()) != null) {
                // Add each line into the list
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return lines;
    }
}
