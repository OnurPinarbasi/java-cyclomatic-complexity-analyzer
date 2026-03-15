public class ComplexityCalculator {

    // Result container for complexity calculation
    public static class ComplexityResult {
        public int cyclomaticComplexity;
        public String riskLevel;
    }

    // Calculate cyclomatic complexity using decision points
    public ComplexityResult calculate(CodeAnalyzer.AnalysisResult analysisResult) {

        ComplexityResult result = new ComplexityResult();

        // Cyclomatic Complexity formula
        // complexity = decision_points + 1
        int decisionPoints = analysisResult.getDecisionCount();
        result.cyclomaticComplexity = decisionPoints + 1;

        // Determine risk level based on complexity value
        if (result.cyclomaticComplexity <= 10) {
            result.riskLevel = "Simple / Low Risk";
        }
        else if (result.cyclomaticComplexity <= 20) {
            result.riskLevel = "Moderate Complexity";
        }
        else if (result.cyclomaticComplexity <= 50) {
            result.riskLevel = "High Complexity";
        }
        else {
            result.riskLevel = "Very Complex / High Risk";
        }

        return result;
    }
}
