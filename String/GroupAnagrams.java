class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        //Approach 1 => using Sorting O(n*mlogn)
        // for (String s : strs) {
        //     char chars[] = s.toCharArray();

        //     Arrays.sort(chars);

        //     String key = new String(chars);

        //     if (!map.containsKey(key)) {
        //         map.put(key, new ArrayList<String>());
        //     }
        //     map.get(key).add(s);
        // }

        //Approach 2 => O(n*k)
        for(String s : strs){
            int count[] = new int[26];

            for(char ch : s.toCharArray()){
                count[ch-97]++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num : count){
                sb.append(num).append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}