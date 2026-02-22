class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        //Adjancy list to build the graph

        //Step 1: build a graph 

        List<List<Integer>>graph = new ArrayList<>();
        int [] indegree = new int [numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        //Step 2: Fill the graph with the values..
        // int n = 
        for(int i=0;i<n;i++){
            int course = prerequisites[i][0]; //ai
            int prereq = prerequisites[i][1]; //bi
            graph.get(prereq).add(course);
            indegree[course]++; //we have got 1 couses bi as a prereq for ai that's why
            //we have been incremented the indegree
        }

        //step 3: now add the nodes in a queue as they are the
        //staring nodes with indegree =0

        Queue<Integer>q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

     

        //Step 4: now count for no of courses which we can complete
        int completed =0;
        // ArrayList<Integer>li = new ArrayList<>();
        int [] result = new int [numCourses];



        while(!q.isEmpty()){
            int curr = q.poll();
            // li.add(curr);
            result[completed] = curr;

            completed++;

            for(int next : graph.get(curr)){//all the nodes/courese which are dependent on curr
            indegree[next]--;
            //as we are processing curr node it means curr is completable
            //thats why we are reducing the indegree of every node 
            //for which curr is prerequestite
            if (indegree[next] == 0) {
                    q.add(next);
                }

            }
        }

        if(completed != numCourses){
            return new int[0];
        }

        return result;

    }
}