public class ReportGenerator {

    public void generateReport(CodeAnalyzer.AnalysisResult analysisResult,
                               ComplexityCalculator.ComplexityResult complexityResult) {

        System.out.println("\n===== ANALYSIS REPORT =====");

        System.out.println("If Statements: " + analysisResult.ifCount);
        System.out.println("Loops: " + analysisResult.loopCount);
        System.out.println("Switch Statements: " + analysisResult.switchCount);
        System.out.println("Case Statements: " + analysisResult.caseCount);
        System.out.println("Catch Blocks: " + analysisResult.catchCount);

        System.out.println("\nCyclomatic Complexity: " + complexityResult.cyclomaticComplexity);
        System.out.println("Risk Level: " + complexityResult.riskLevel);
    }
}