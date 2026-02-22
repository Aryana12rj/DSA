class Solution {
    public class DisjointSets{
        List<Integer> rank;
        List<Integer> parent;

        public DisjointSets(int n){
            rank = new ArrayList<>();
            parent = new ArrayList<>();
            for(int i = 0; i <= n;i++){
                rank.add(0);
                parent.add(i);
            }

         }
        

        public int findUltParent(int u){
            if(parent.get(u) == u){
                return u;
            }

            int ulp_u = findUltParent(parent.get(u));
            parent.set(u,ulp_u);
            return parent.get(u);
        }

        public void unionByRank(int u,int v){
            int ulp_u = findUltParent(u);
            int ulp_v = findUltParent(v);

            if(ulp_u == ulp_v){
                return;
            }
            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }else{
                if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
            }else{
                parent.set(ulp_v,ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u,rankU+1);
            }
            }
        }        
    }
     public List<List<String>> accountsMerge(List<List<String>> accounts) {

        
        int users = accounts.size();
        Map<String,Integer> mpp = new HashMap<>();
        Map<Integer,String> mpp2 = new HashMap<>();
        int k = 0;
        for(int i = 0;i < users ;i++){
            List<String> userMails = accounts.get(i);
            for(int j = 1;j < userMails.size() ; j++){
                if(!mpp.containsKey(userMails.get(j))){
                    mpp.put(userMails.get(j),users + k);
                    mpp2.put(users+k,userMails.get(j));
                    k++;
                }
            }
        }
        DisjointSets ds = new DisjointSets(users + mpp.size());
        for(int i = 0; i < users ; i++){
            int userNode = i;
            List<String> userMails = accounts.get(i);
            for(int j = 1 ; j < userMails.size(); j++){
                ds.unionByRank(userNode,mpp.get(userMails.get(j)));
            }
        }
        List<String> uniqueUsers= new ArrayList<>();
        for(int i = 0;i < users;i++){
            if(ds.findUltParent(i) == i){
                uniqueUsers.add(accounts.get(i).get(0));

            }
            else{
                uniqueUsers.add("");
            }
        }
        List<List<String>> newMails = new ArrayList<>();
        for(int i = 0;i < uniqueUsers.size(); i++){
            if(uniqueUsers.get(i) == ""){
                continue;
            }
            List<String> lists = new ArrayList<>();
            for(int j = users; j<ds.parent.size();j++){
                if(ds.findUltParent(j) == i){
                    lists.add(mpp2.get(j));
                }
            }
            Collections.sort(lists);
            lists.add(0,uniqueUsers.get(i));
            newMails.add(lists);
        }



        return newMails;

    }
}