class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        int [] primes = {2,3,5};
        long currUgly = 1L;
        for(int i=0;i<n;i++){
            currUgly = pq.poll();
            for(int prime : primes){
                long newUgly = currUgly*prime;
                if(!set.contains(newUgly)){
                    set.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}