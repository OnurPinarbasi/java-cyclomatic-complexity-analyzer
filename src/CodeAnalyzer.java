import java.util.List;

public class CodeAnalyzer {

    // Small data container to hold analysis results:
    public static class AnalysisResult{
        public int ifCount;
        public int loopCount;
        public int switchCount;
        public int caseCount;
        public int catchCount;
        public int logicalOpCount; // counts && and || operators

        //Calculation of total decision points:
        public int getDecisionCount(){
            return ifCount + loopCount + switchCount + caseCount + catchCount + logicalOpCount;
        }
    }

    // Analyzing lines of the code and count decision structures:
    public AnalysisResult analyze(List<String> lines){
        AnalysisResult result = new AnalysisResult();
        boolean inBlockComment = false;

        // We iterate through each line of the file
        for (String line : lines) {

            String noStrings = line.replaceAll("\"(\\\\.|[^\\\"])*\"", "");
            String trimmed = noStrings.trim();

            if (inBlockComment) {
                if (trimmed.contains("*/")) {
                    inBlockComment = false;
                }
                continue;
            }

            if (trimmed.startsWith("/*")) {
                if (!trimmed.contains("*/")) {
                    inBlockComment = true;
                }
                continue;
            }

            // Ignore empty lines
            if (trimmed.isEmpty()) {
                continue;
            }

            // Ignore single-line comments
            if (trimmed.startsWith("//")) {
                continue;
            }

            // Ignore block comments that start and end on the same line
            if (trimmed.startsWith("/*") && trimmed.endsWith("*/")) {
                continue;
            }

            // Detect decision keywords

            if (trimmed.startsWith("if") || trimmed.startsWith("else if")) {
                result.ifCount++;
            }

            boolean isLoop = trimmed.startsWith("for") || trimmed.startsWith("while");
            if (isLoop) {
                result.loopCount++;
            }

            if (trimmed.startsWith("switch")) {
                result.switchCount++;
            }

            if (trimmed.startsWith("case ")) {
                result.caseCount++;
            }

            if (trimmed.startsWith("catch")) {
                result.catchCount++;
            }

            // Count logical operators used in conditions
            int andCount = trimmed.split("&&", -1).length - 1;
            int orCount = trimmed.split("\\|\\|", -1).length - 1;
            result.logicalOpCount += andCount + orCount;
        }




        return result;  // It will return package for special container that we create in above (named as AnalysisResult).
    }



}
