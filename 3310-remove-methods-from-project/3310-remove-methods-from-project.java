class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge:invocations){
            graph.get(edge[0]).add(edge[1]);
        }
        boolean [] visited = new boolean [n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k]= true;

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v:graph.get(u)){
                if(!visited[v]){
                    visited[v] =true;
                    q.add(v);
                }
            }
        }

        for(int [] edge:invocations){
            int u = edge[0];
            int v= edge[1];
            if(!visited[u]&&visited[v]){
                List<Integer> all = new ArrayList<>();
                for(int i =0;i<n;i++){
                    all.add(i);
                }
                return all;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                result.add(i);
            }
        }
        return result;
    }
}