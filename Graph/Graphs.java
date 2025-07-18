import java.util.*;
//every nodes in graph is called vertex
//edges are trhe connector of vertex


public class Graphs { 
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d,int w){
            this.src = s;
            this.dest = d;
            this.wt =w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        //1st we have to initialize the arraylist 
        //bcz in java an array does not automatically initialize its elements.
        //By default for an array of objects (like ArrayList<Edge>[]), the initial value of each element is null.
        // If you attempt to directly call a method like add() on a 
        // null reference (e.g., graph[i].add(...)), you'll encounter 
        // a NullPointerException because graph[i] hasn't been assigned an instance of an ArrayList.
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,40));
        
        //graph[1].add(new Edge(1,4,2));
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,1,50));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,4,40));
       // graph[3].add(new Edge(4,5,50 ));
        graph[4].add(new Edge(4,3,0));
        // graph[4].add(new Edge(4,5,5));
        // graph[5].add(new Edge(5,3,-1));
        // graph[5].add(new Edge(5,4,-1));
    }
    //BFS - Bredath first search or traversal
    public static void BFS(ArrayList<Edge>graph[],int v){
        //first we'll create a queue
        Queue<Integer> q = new LinkedList<>();
        //if we have to perform BFS on two disconnected graph then we have to change something
        //public static void BFS(ArrayList<Edge>graph[],int v,boolean vis[],int start)
        //q.add(start)
        //and we'll remove vis array here and add it to main
        //then we'll create a boolean type visit array of size vertex
        boolean vis[] = new boolean[v];
        q.add(0);
        //we'll run a loop till q becomes empty
        while(!q.isEmpty()){
            int curr = q.remove();//remove the current
            if(vis[curr]==false){//if current is not visited
                System.out.print(curr + " ");//print curr
                vis[curr] = true;//marked it true in visited array
                //adding neighbour of current element. we did last time
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //DFS= depth first search
    public static void DFS(ArrayList<Edge> graph[],int curr, boolean vis[]){
        System.out.print(curr+" ");//1st print th current
        vis[curr] = true;//then make it true in visited array
        for(int i=0;i<graph[curr].size();i++){//then check for neighbour
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){//if not visited then call it recursively
                DFS(graph, e.dest, vis);
            }
            
        }
    }
    //print all path from source to target
    public static void printAllPath(ArrayList<Edge> graph[],boolean vis[],int src,String path,int tar){
        //base case
        if(src == tar){
            System.out.println(path);
            return;
        }
        // Mark the current node as visited
        vis[src] = true;
        // Traverse all neighbors of the current vertex
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            // Only proceed to unvisited neighbors
            if(!vis[e.dest]){
                // Recursively call for the neighbor with updated path
                printAllPath(graph, vis, e.dest, path+"-"+e.dest, tar);
                //this is after the recursive call end that means
                // Backtrack: Unmark the current vertex as visited
                vis[src]= false;
            }
            
        }
    }
    //cycle detection in directed graph
    public static boolean iscycleDirected(ArrayList<Edge>graph[],boolean vis[],int curr,boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){//If the neighbor is already in the recursion stack ,it means there's a cycle
               return true;
            }
            if(!vis[e.dest]){//If the neighbor hasn't been visited yet, it recursively calls iscycleDirected. If a cycle is found in any recursive call, the method returns true.
               if(iscycleDirected(graph, vis, e.dest, rec)){
                    return true;
               }
            }
        }
        rec[curr] = false;//After all neighbors are processed, the current node is removed from the recursion stack
        return false;
    }
    //TopoLogical Sort
    public static void topological(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer> stack){
        vis[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topological(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);//this will push the curr node in stack
    }
    //this can be done in main but we write it by making another function
    public static void topologicalSort(ArrayList<Edge>graph[],int v){
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topological(graph, i, vis, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
    //cycle detection in undirected graph
    public static boolean isCycleDetected(ArrayList<Edge>graph[],boolean vis[],int curr,int parent){
        vis[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==true && e.dest!=parent){//If a neighbor (e.dest) has already been visited and is not the parent node, it means there’s a back edge, indicating a cycle.
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleDetected(graph, vis, e.dest, curr)){//If the neighbor (e.dest) has not been visited, recursively check for cycles from that neighbor.
                    return true;
                }
            }
        }
        return false;
    }
    //comparing pair which is required to perform dijkstra
    // public static class Pair implements Comparable<Pair>{ //implements comparable pair for comparing like on which basis it will sort on distance or on weight, here we want on distance basis
    //     int node;
    //     int dist;

    //     public Pair(int n, int d){
    //         this.node = n;
    //         this.dist = d;
    //     }
    //     //logic for comparing distance in ascending order
    //     @Override
    //     public int compareTo(Pair p2){
    //         return this.dist-p2.dist;
    //     }
    // }
    //Dijkstra's algorithm .. Shortest path algorithm TC - O(E + E logV)
    public static void diskstra(ArrayList<Edge>graph[],boolean vis[],int src,int v){
        //creating a priority queue with storing pair
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[v];
        //initializing distance with Int.max as infinity
        for(int i =0;i<v;i++){
            if(i!= src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0,0));
        //now normal bfs code with simple change
        while(!pq.isEmpty()){
            Pair curr = pq.remove();//it will remove the shortest distance pair as priority q removes that only bydefault
            if(!vis[curr.node]){
                vis[curr.node] =true;
                //then for neighbour
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int a = e.src;
                    int b = e.dest;
                    if(dist[a] + e.wt <dist[b]){//relaxation
                        dist[b] = dist[a] + e.wt;
                        //after updating distance add into pq
                        pq.add(new Pair(b, dist[b]));
                    }
                }
            }
        }
        for( int i=0;i<v;i++){
            System.out.print(dist[i] +" ");
        }
        System.out.println();

    }

    //bellman ford algorithm for shortest distance 
    public static void bellmanFord(ArrayList<Edge>graph[],int src, int v){
        int dist[] = new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        for(int k=0;k<v-1;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int a = e.src;
                    int b = e.dest;
                    if(dist[a]!=Integer.MAX_VALUE && dist[a]+e.wt<dist[b]){
                        dist[b] = dist[a]+e.wt;
                    }
                }
            }
        }
        //-ve weight cycle
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int a = e.src;
                int b = e.dest;
                if(dist[a]!=Integer.MAX_VALUE && dist[a]+e.wt<dist[b]){
                    System.out.println("-ve weight cycle");
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    //required for comparing pair 
    public static class Pair implements Comparable<Pair>{ //implements comparable pair for comparing like on which basis it will sort on distance or on weight, here we want on distance basis
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }
        //logic for comparing distance in ascending order
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    //Minimum Spanning tree = Prims algo
    public static void primsAlgorithm(ArrayList<Edge>graph[],boolean vis[],int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int mstCost= 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(int i = 0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of mst = " + mstCost);
    }

    //kosaraju algorithms to find strongly connected components
    public static void topSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    //dfs is also needed for kosaraju 
    public static void dfs(ArrayList<Edge>graph [],int curr,boolean vis[]){
        vis[curr]  = true;
        System.out.print(curr + " ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge>graph[],int v){
        //step 1 = topological sort
        Stack<Integer> s = new Stack<>();
        boolean vis [] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSort(graph,i,vis,s);
            }
        }
        //step 2 = transpose...same like create graph
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for(int i=0;i<v;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            for(int j =0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src,e.wt));//here we just added e.wt just ignore it bcz we have created the edge with wt so here we have used constructor
            }//here we just basically reverse the src and dest. in place of src we placed dest and vice versa
        }
        //step 3 
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
            
        }
    }
    //tarzan's algorithm for find bridges in a graph for this also we have to perform dfs
    public static void dfs2(ArrayList<Edge>graph[],int curr,boolean vis[],int dt[],int low[],int time , int par){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest==par){
                continue;
            }else if(!vis[e.dest]){
                dfs2(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(dt[curr]<low[e.dest]){
                    System.out.println("bridge is : " + curr + "----" + e.dest);
                }
            }else{
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }
        }

    }
    public static void getbridge(ArrayList<Edge>graph[],int v){
        int dt[] = new int[v];
        int low [] = new int [v];
        int time =0;
        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs2(graph,i,vis,dt,low,time,-1);//here -1 is parent as now we are visiting 1st node so we dont hv parent that's why -1
            }
        }
    }
    public static void dfs3(ArrayList<Edge>graph[],int curr,boolean vis[],int dt[],int low[],int time ,int par, boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children =0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;//just store the value of neighbour without writting it again and again
            if(par==neigh){
                continue;
            }else if(vis[neigh]){
                low[curr] =Math.min(low[curr],dt[neigh]);
            }else{
                dfs3(graph, neigh, vis, dt, low, time, curr, ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr]<=low[neigh] && par!=-1){
                    ap[curr] = true;
                }
                children++;//while backtracking to parent updating the children value
            }
        }
        if(par==-1 && children>1){//after last if we find that parent ==-1 and its children is also >1 then it will be an Ap
            ap[curr] = true;
        }
    }
    public static void getAP(ArrayList<Edge>graph[],int v){//tc O(V+E)
        int dt [] = new int[v];
        int low [] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];
        boolean ap[]= new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs3(graph,i,vis,dt,low,time,-1,ap);
            }
        }
        for(int i = 0;i<v;i++){
            if(ap[i]){
                System.out.println("Ap : " +i);
            }
        }
    }
    public static void main(String args[]){

        int v = 5;
        ArrayList<Edge> graph [] = new ArrayList[v];
        createGraph(graph);
        //print 2's neighbour
        //what we do here 1st we go to the the index
        //then we'll run a loop on that index to access the list like graph[2].size (LOOP will run till the size of 2th index i.e till the last list of index 2 )
        // then edge is stored in every list of index , then we'll find edge by edge e = get(i) as it is 0,1,2...
        //then we'll print the destination of each edge
        //complexity = o(x);
        //similarly we can do for every index neighbour like 1,0..
    //     for(int i=0;i<graph[2].size();i++){
    //         Edge e = graph[2].get(i);
    //         System.out.println(e.dest + ",  w:" +e.weight );
    //     }
    //     //for discoonected component calling BFS
    //     //suppose two discoonected component are 0,1,2 and 3,4
    //     //we cant add 0 to start or else it will not visit 3 that's why this method
    //     // boolean vis[]= new boolean[v];
    //     // for(int i=0;i<v;i++){
    //     //     if(vis[i]==false){
    //     //         BFS(graph, v,vis,i);
    //     //     }
    //     // }
    //     BFS(graph, v);
    //     System.out.println();
    //     boolean vis[] = new boolean[v];
    //     // for(int i=0;i<v;i++){
    //     //     if(vis[i]==false){
    //     //         DFS(graph, i, vis);
    //     //     }
    //     // }
    //     System.out.println();
    //     //String path = " ";
    //     int src =0;
    //     printAllPath(graph, vis, 0, " "+src, 3);
    //    // printAllPath(graph, vis, v, null, v);
    //    //System.out.println(iscycleDirected(graph, new boolean[v], 0, new boolean[v]));
    //    //in case if disconnected graph will be there then we'll have to run a loop unless it visit every element
    //    boolean rec[] = new boolean[v];
    //    for(int i=0;i<v;i++){
    //     if(!vis[i]){
    //         boolean isCycle = iscycleDirected(graph, vis, 0, rec);
    //         if(isCycle){
    //             System.out.println(isCycle);
    //             break;
    //         }
    //     }
    //    }
       //topologicalSort(graph, v);
       //System.out.println(isCycleDetected(graph, new boolean[v], 0, -1));
       //another way if disconnected graph
       boolean vis[] = new boolean[v];

    // Call cycle detection function
    // for (int i = 0; i < v; i++) {
    //     if (!vis[i]) {
    //         if (isCycleDetected(graph, vis, i, -1)) {
    //             System.out.println("Cycle Detected!");
    //             return;
    //         }
    //     }
    // }
    // System.out.println("No Cycle Detected.");
    //diskstra(graph, vis, 0, v);
    //bellmanFord(graph, 0, v);
    //primsAlgorithm(graph, vis, v);
    //kosaraju(graph, v);
    getbridge(graph, v);
    getAP(graph, v);
    }
}
