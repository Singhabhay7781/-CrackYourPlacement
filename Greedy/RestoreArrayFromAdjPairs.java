class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            graph.putIfAbsent(pair[0], new ArrayList<>());
            graph.putIfAbsent(pair[1], new ArrayList<>());
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        int n = adjacentPairs.length + 1;
        int result[] = new int[n];
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                result[0] = key;
                break;
            }
        }

        result[1] = graph.get(result[0]).get(0);

        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = graph.get(result[i - 1]);

            result[i] = (neighbors.get(0) == result[i - 2]) ? neighbors.get(1) : neighbors.get(0);
        }
        return result;
    }
}