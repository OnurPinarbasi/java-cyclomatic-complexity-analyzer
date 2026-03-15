import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Check if the user provided a file
        if (args.length == 0){
            System.out.println("Usage: java Main <JavaFile>");
            return; 
        }

        // Get the file path from the command line
        String filePath = args[0];
        // Inform the user which file is being analyzed
        System.out.println("Analyzing file: " +filePath);

        FileReaderModule fileReader = new FileReaderModule();
        List<String> lines = fileReader.readFile(filePath);
        System.out.println("Total lines read: " +lines.size());

    }
}