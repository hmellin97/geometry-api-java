package big.brain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class CoverageTool {
    private static HashMap<String, LinkedList<Branch>> coverageData = new HashMap();

    public static Branch addBranch(String functionName, int branchID) {
        Branch b = new Branch(branchID);

        if (coverageData.get(functionName) == null)
            coverageData.put(functionName, new LinkedList<Branch>());

        coverageData.get(functionName).add(b);

        return b;
    }

    public static void printCoverageResults() {
        System.out.println("COVERAGE RESULTS");

        Set<String> functions = coverageData.keySet();
        for (String function : functions) {
            final int totalBranches = coverageData.get(function).size();
            int reachedBranches = 0;

            for (Branch b : coverageData.get(function)) {
                if (b.didReach) reachedBranches++;
            }

            double coveragePercentage = ((double) reachedBranches / (double) totalBranches) * 100;
            System.out.println(function + " has " + coveragePercentage + "% coverage, reached " + reachedBranches + "/" + totalBranches + " branches.");
        }
    }

    static class Branch {
        private int branchID;
        private boolean didReach;

        public Branch(int branchID) {
            this.branchID = branchID;
            this.didReach = false;
        }

        public void setReached() {
            didReach = true;
        }
    }
}
