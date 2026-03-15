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

        // STEP 1: Read File:
        FileReaderModule fileReader = new FileReaderModule();
        List<String> lines = fileReader.readFile(filePath);

        // STEP 2: Analyze code
        CodeAnalyzer analyzer = new CodeAnalyzer();
        CodeAnalyzer.AnalysisResult analysisResult = analyzer.analyze(lines);

        // STEP 3: Calculate complexity
        ComplexityCalculator calculator = new ComplexityCalculator();
        ComplexityCalculator.ComplexityResult complexityResult = calculator.calculate(analysisResult);

        // STEP 4: Generate report
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(analysisResult, complexityResult);

    }
}