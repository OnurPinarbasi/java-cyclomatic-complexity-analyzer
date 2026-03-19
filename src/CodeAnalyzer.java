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

            // --- Remove block comments (supports inline and multi-line) ---
            String working = line;
            if (inBlockComment) {
                int endIdx = working.indexOf("*/");
                if (endIdx != -1) {
                    // exit block comment and keep the rest of the line after */
                    working = working.substring(endIdx + 2);
                    inBlockComment = false;
                } else {
                    // still inside block comment, skip entire line
                    continue;
                }
            }

            // handle possible block comments starting in this line (can be inline)
            while (true) {
                int startIdx = working.indexOf("/*");
                if (startIdx == -1) break;

                int endIdx = working.indexOf("*/", startIdx + 2);
                if (endIdx != -1) {
                    // remove the inline block comment and keep surrounding code
                    working = working.substring(0, startIdx) + working.substring(endIdx + 2);
                } else {
                    // block comment starts here and continues to next lines
                    working = working.substring(0, startIdx);
                    inBlockComment = true;
                    break;
                }
            }

            // remove string literals so keywords inside strings are ignored
            String noStrings = working.replaceAll("\"(\\\\.|[^\\\"])*\"", "");
            String trimmed = noStrings.trim();

            // Ignore empty lines
            if (trimmed.isEmpty()) {
                continue;
            }

            // Ignore single-line comments
            if (trimmed.startsWith("//")) {
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
