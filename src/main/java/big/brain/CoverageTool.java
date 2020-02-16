package big.brain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CoverageTool {
    private static HashMap<String, CoverageFunction> coverageData = new HashMap();

    public static CoverageFunction addFunction(String functionName, int numberOfBranches) {
        if (coverageData.get(functionName) != null)
            return coverageData.get(functionName);

        CoverageFunction cf = new CoverageFunction(functionName, numberOfBranches);
        coverageData.put(functionName, cf);

        return cf;
    }

    public static void printCoverageResults() {
        System.out.println("COVERAGE RESULTS");

        Collection<CoverageFunction> functions = coverageData.values();
        for (CoverageFunction function : functions) {
            final int totalBranches = function.hasReachedBranch.length;

            int reachedBranches = 0;
            for (int branchID = 0; branchID < totalBranches; branchID++) {
                if (function.hasReachedBranch[branchID]) reachedBranches++;
            }

            double coveragePercentage = ((double) reachedBranches / (double) totalBranches) * 100;
            System.out.println(" * " + function.functionName + " has " + coveragePercentage + "% coverage, reached " + reachedBranches + "/" + totalBranches + " branches.");
        }
    }

    public static class CoverageFunction {
        String functionName;
        boolean[] hasReachedBranch;

        public CoverageFunction(String functionName, int numberOfBranches) {
            this.functionName = functionName;
            hasReachedBranch = new boolean[numberOfBranches];
        }

        public void setReachedBranch(int branchID) {
            hasReachedBranch[branchID] = true;
        }
    }

    public static class Branch {
        private int branchID;

        public Branch(int branchID) {
            this.branchID = branchID;
        }
    }
}
