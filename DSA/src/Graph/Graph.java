package Graph;
import java.util.*;
public class Graph
{
    
    //#region BFS
    public List<Integer> breathFirstSearch(List<List<Integer>> adj)
    {
        int vertices=adj.size();
        List<Integer> bfs=new ArrayList<>();  //all vertices in bfs order
        boolean[] visit=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty())
        {
            int vertix=queue.poll();
            bfs.add(vertix);
            for(int neighbour:adj.get(vertix))
            {
                if(visit[neighbour]==false)
                {
                    queue.add(neighbour);
                    visit[neighbour]=true;
                }
            }
        }
        return bfs;
    }

    public List<Integer> recursiveBreadthFirstSearch(List<List<Integer>> adj)
    {
        int vertices=adj.size();
        List<Integer> bfs=new ArrayList<>();  //all vertices in bfs order
        boolean[] visited=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        bfs.add(0);
        recursiveBreadthFirstSearch(adj,queue,visited,bfs);
        return bfs;
    }
    public void recursiveBreadthFirstSearch(List<List<Integer>> adj,Queue<Integer> queue,boolean[]visited,List<Integer> bfs)
    {
        if(queue.isEmpty()) return;
        int vertix=queue.poll();
        for(int neighbour:adj.get(vertix))
        {
            if(visited[neighbour]==false)
                {
                    queue.add(neighbour);
                    visited[neighbour]=true;
                    bfs.add(neighbour);
                }
        }
        recursiveBreadthFirstSearch(adj,queue,visited,bfs);
    }

    //#endregion


    //#region DFS
    public List<Integer> depthFirstSearch(List<List<Integer>> adj)
    {
        List<Integer> dfs=new ArrayList<>();
        boolean[] visited=new boolean[adj.size()];
        visited[0]=true;
        dfs.add(0);
        depthFirstSearch(adj,0,visited,dfs);
        return dfs;

    }
    public void depthFirstSearch(List<List<Integer>> adj,int vertex,boolean[]visited,List<Integer> dfs)
    {
        for(int neighbour:adj.get(vertex))
        {
            if(visited[neighbour]==false)
            {
                visited[neighbour]=true;
                dfs.add(neighbour);
                depthFirstSearch(adj,neighbour,visited,dfs);
            }
        }
    }


    //#endregion

    //#region numIslands
    public int numIslandsDFS(char[][] grid) 
    {
        int count=0;
        int tot_row=grid.length;
        int tot_col=grid[0].length;
        boolean[][] visited=new boolean[tot_row][tot_col];
        
        for(int i=0;i<tot_row;i++)
        {
            for(int j=0;j<tot_col;j++)
            {
                if(grid[i][j]-'0'==1 && visited[i][j]==false)
                {
                    count++;
                    visited[i][j]=true;
                    allDirectionCheckDFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }   
    private void allDirectionCheckDFS(int cur_row,int cur_col,char[][] grid,boolean[][] visited)
    {
        int tot_row=grid.length;
        int tot_col=grid[0].length;

        int[] drows={-1,1,0,0};
        int[] dcols={0,0,-1,1};

        
        for(int i=0;i<4;i++)
        {
            int adj_row=cur_row+drows[i];
            int adj_col=cur_col+dcols[i];
            if(adj_row<tot_row && adj_row>=0 && adj_col<tot_col && adj_col>=0 && grid[adj_row][adj_col]-'0'==1 && visited[adj_row][adj_col]==false)
            {
                 visited[adj_row][adj_col]=true;
                 allDirectionCheckDFS(adj_row,adj_col,grid,visited);
            }
        }
    }


    public int numIslandsBFS(char[][] grid) 
    {
        int count=0;
        int tot_row=grid.length;
        int tot_col=grid[0].length;
        boolean[][] visited=new boolean[tot_row][tot_col];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<tot_row;i++)
        {
            for(int j=0;j<tot_col;j++)
            {
                if(grid[i][j]-'0'==1 && visited[i][j]==false)
                {
                    count++;
                    visited[i][j]=true;
                    q.add(new Pair(i,j));
                    while(!q.isEmpty())
                    {
                        int cur_row=q.peek().row;
                        int cur_col=q.peek().col;
                        q.poll();

                        allDirectionCheckBFS(cur_row,cur_col,grid,visited,q);
                    }
                }
            }
        }
        return count;
    }   
    private void allDirectionCheckBFS(int cur_row,int cur_col,char[][] grid,boolean[][] visited,Queue<Pair> q)
    {
        int tot_row=grid.length;
        int tot_col=grid[0].length;

        int[] drows={-1,1,0,0};
        int[] dcols={0,0,-1,1};

        
        for(int i=0;i<4;i++)
        {
            int adj_row=cur_row+drows[i];
            int adj_col=cur_col+dcols[i];
            if(adj_row<tot_row && adj_row>=0 && adj_col<tot_col && adj_col>=0 && grid[adj_row][adj_col]-'0'==1 && visited[adj_row][adj_col]==false)
            {
                 visited[adj_row][adj_col]=true;
                 q.add(new Pair(adj_row,adj_col));
            }
        }
    }
    class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }

    //#endregion

    //#region floodFill

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int precolor=image[sr][sc];
        if(color!=precolor)
        {
            image[sr][sc]=color;
            allDirCheckDFS(image,sr,sc,color,precolor);
        }
        return image;
    }

    int[] drows={-1,1,0,0};
    int[] dcols={0,0,-1,1};
    public void allDirCheckDFS(int[][] image, int cur_row, int cur_col, int color,int precolor)
    {
        int tot_rows=image.length;
        int tot_cols=image[0].length;
        for(int i=0;i<4;i++)
        {
            int adj_row=cur_row+drows[i];
            int adj_col=cur_col+dcols[i];
            if(adj_row<tot_rows && adj_row>=0 && adj_col<tot_cols && adj_col>=0 && image[adj_row][adj_col]==precolor)
            {
                image[adj_row][adj_col]=color;
                allDirCheckDFS(image,adj_row,adj_col,color,precolor);
            }
        }
    }

    //#endregion

    //#region updateMatrix
    public int[][] updateMatrix(int[][] mat) {
        int tot_rows=mat.length;
        int tot_cols=mat[0].length;
        int [][] dis =new int[tot_rows][tot_cols];
        for(int i=0;i<tot_rows;i++)
        {
            for(int j=0;j<tot_cols;j++)
            {
                dis[i][j]=mat[i][j];
            }
        }
        for(int i=0;i<tot_rows;i++)
        {
            for(int j=0;j<tot_cols;j++)
            {
               if(mat[i][j]==1)
               {
                dis[i][j]=allDirCheckDFS(i,j,mat,1);
               }
            }
        }
        return dis;
    }    
        int[] drows1={-1,1,0,0};
        int[] dcols1={0,0,-1,1};
    public int allDirCheckDFS(int cur_row,int cur_col,int[][] mat,int cur_dis)
    {
        int tot_rows=mat.length;
        int tot_cols=mat[0].length;
        int min_dis=Integer.MAX_VALUE;
        for(int i=0;i<4;i++)
        {
            int adj_row=cur_row+drows1[i];
            int adj_col=cur_col+dcols1[i];
        if(adj_row>=0 && adj_row<tot_rows && adj_col<tot_cols && adj_col>=0)
        {
            if(mat[adj_row][adj_col]==0)
            {
                return cur_dis;
            }
            else
            {
                int dis= allDirCheckDFS(adj_row,adj_col,mat,cur_dis+1);
                if(dis<min_dis) min_dis=dis;
            }
        }
        }
        return min_dis;
    }

    //#endregion

    //#region Largest Sum Cycle
    long max;
    public long largestSumCycle(int N, int Edge[]){
        long max=-1;
        for(int i=0;i<N;i++)
        max=Math.max(max,findCycle(i,Edge,i,new ArrayList<>(),0));
        return max;
    }
    private int findCycle(int vertix,int[] neighbours,int parentVertix,List<Integer> cycle,int sum)
    {
        if((cycle.size()!=0)&&(vertix==parentVertix)) return sum;
        if((cycle.size()!=0)&&(cycle.contains(vertix))) return -1;
        if(vertix==-1) return -1;
        cycle.add(vertix);
        return findCycle(neighbours[vertix],neighbours,parentVertix,cycle,sum+vertix);
    }
    //#endregion

    //#region Max Weight Cell
    public int maxWeightCell(int N, int Edge[]){
        int [] weights=new int[N];
        for(int i=0;i<N;i++)
        {
            if(Edge[i]!=-1)
            weights[Edge[i]]+=i;
        }
        int maxI=-1;
        int maxW=-1;
        for(int i=0;i<N;i++)
        {
           if(weights[i]>=maxW) 
           {    
               maxW=weights[i];
               maxI=i;
           }
       // System.out.print(weights[i] + " "); // Weights of each node
        }
        
        return maxI;
     }
     //#endregion


     //#region Nearest Meeting Cell
    public int nearestMeetingCell(int c1,int c2,int[] Edge)  //or Shortest Meeting Point
    {
        int[] c1Nodes=new int[Edge.length];
        int[] c2Nodes=new int[Edge.length];

        nearestMeetingCell(c1, Edge,c1Nodes,0);
        nearestMeetingCell(c2, Edge,c2Nodes,0);

        int minSteps=Integer.MAX_VALUE;
        int minNode=-1;  //if no meeting points are present
        for(int i=0;i<Edge.length;i++)
        {
            if(c1Nodes[i]>0 && c2Nodes[i]>0) 
            {
                int totSteps=c1Nodes[i]+c2Nodes[i];
                if(totSteps<minSteps)
                {
                minSteps=totSteps;
                minNode=i;
                }
            }
        }   
        return minNode;
    }
    private void nearestMeetingCell(int vertix,int[] Edge,int[] path,int steps)
    {
        if(vertix==-1 || path[vertix]>0) return;
        path[vertix]=steps;
        nearestMeetingCell(Edge[vertix],Edge,path,steps+1);
    }
    //#endregion


    //#region Is Reachable
    public boolean isReachable(Map<Integer,List<Integer>> graph,int source ,int destination)
    {
       int maxVertix=Collections.max(graph.keySet());
       boolean[] visited=new boolean[maxVertix+1];
       Queue<Integer> q=new LinkedList<>();
       q.add(source);
       visited[source]=true;
       while(!q.isEmpty())
       {
           int cur=q.poll();
           if(cur==destination) return true;
           for(int neighbor:graph.get(cur))
           {
               if(visited[neighbor]==false)
               {
                   visited[neighbor]=true;
                   q.add(neighbor);
               }
           }
           
       }
       return false;
    }


    //#region All Reachables
    //Undirected Orbitary Unweighted (file:///home/sudeep/Documents/Learnings/DSA/images/GraphEx1.png)
    public Map<Integer,List<Integer>> findAllReachables(List<Integer> vertices,Map<Integer,List<Integer>> graph)
    {
        Map<Integer,List<Integer>> allReachables=new HashMap<>();
        int max=Collections.max(graph.keySet());
        boolean[] visited=new boolean[max+1];
        
        for(int vertex:vertices)
        {
            if(visited[vertex]==false)
            {
                List<Integer> vertexReachables=new ArrayList<>();
                visited[vertex]=true;
                vertexReachables.add(vertex);   
                for(int edge:graph.getOrDefault(vertex,new ArrayList<>()))
                {
                    if(visited[edge]==false)
                    {
                       visited[edge]=true;
                       List<Integer> edgeReachables=findReachables(edge,graph, max);
                       allReachables.put(edge,edgeReachables);
                       addUniques(vertexReachables,edgeReachables);
                    }
                    else addUniques(vertexReachables,allReachables.get(edge));
                }
                allReachables.put(vertex,vertexReachables);
            }
        }
        return allReachables;
    }
    public List<Integer> findReachables(int vertix,Map<Integer,List<Integer>> graph,int max)
    {
        List<Integer> edgeReachables=new ArrayList<>();
        boolean[] visit=new boolean[max+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(vertix);
        visit[vertix]=true;
        edgeReachables.add(vertix);
        while(!q.isEmpty())
        {
        int curVertix=q.poll();
        for(int edge:graph.get(curVertix))
        {
            if(visit[edge]==false)
                {
                    visit[edge]=true;
                    q.add(edge);
                    edgeReachables.add(edge);
                }
        }
        }
        return edgeReachables;
    }
    public void addUniques(List<Integer> list1,List<Integer> list2)
    {
        Set<Integer> set=new HashSet<>(list1);
        for(int element:list2)
            if(!set.contains(element))
                list1.add(element);
    }
    //#endregion


    //#region ShortestPath(UW)
    //Shortest Path in Undirected UnitWeighted Contiguous Vertices 
    public int[] findAllMinReachableDistance(List<List<Integer>> graph)
    {
        int[] distance=new int[graph.size()];
        boolean[] visited=new boolean[graph.size()];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        distance[0]=0;
        visited[0]=true;
        while(!q.isEmpty())
        {
            int vertex=q.poll();
            for(int edge:graph.get(vertex))
            {
                if(visited[edge]==false)
                {
                    visited[edge]=true;
                    distance[edge]=distance[vertex]+1;
                    q.add(edge);
                }
            }
        }
        return distance;
    }
    //#endregion
 
}


class Main
{
 public static void main(String[] args)
 {

     Scanner sc=new Scanner(System.in);
     Graph g=new Graph();
     

    // Inputting Graph: file:///home/sudeep/Documents/Learnings/DSA/references/input.ipynb

    //  List<List<Integer>> adj =new ArrayList<>();
    //  for(int i=0;i<5;i++)
    //  {
    //      adj.add(new ArrayList<>());
    //  }
    //  adj.get(0).add(1);
    //  adj.get(1).add(0);
    //  adj.get(2).add(1);
    //  adj.get(3).add(1);
    //  adj.get(4).add(0);
    //  adj.get(0).add(4);
    //  adj.get(1).add(2);
    //  adj.get(1).add(3);

    //  List<List<Integer>> graph = new ArrayList<>();
    //  graph.add(Arrays.asList(1, 2));  
    //  graph.add(Arrays.asList(2));     
    //  graph.add(Arrays.asList(0, 3));  
    //  graph.add(Arrays.asList(3));

     // List<Integer> bfs=g.breathFirstSearch(adj);
     // for(int vertix:bfs) System.out.print(vertix);

     // List<Integer> bfs=g.recursiveBreadthFirstSearch(adj);
     // for(int vertix:bfs) System.out.print(vertix);

     // List<Integer> dfs=g.depthFirstSearch(adj);
     // for(int vertix:dfs) System.out.print(vertix);

     // char[][] islands = {
     //     {'1', '1', '1', '1', '0'},
     //     {'1', '1', '0', '1', '0'},
     //     {'1', '1', '0', '0', '0'},
     //     {'0', '0', '0', '0', '0'}
     // };        
     // System.out.println(g.numIslandsDFS(islands));

     // char[][] islands = {
     //     {'1', '1', '0', '0', '0'},
     //     {'1', '1', '0', '0', '0'},
     //     {'0', '0', '1', '0', '0'},
     //     {'0', '0', '0', '1', '1'}
     // };
     // System.out.println(g.numIslandsBFS(islands));

     // int[][] image={
     //     {1,1,1},
     //     {1,1,0},
     //     {1,0,1}
     // };
     // int[][] modi_image=new int[image.length][image[0].length];
     // modi_image =g.floodFill(image,1,1,2);
     // for(int i=0;i<image.length;i++)
     // {
     //     for(int j=0;j<image[0].length;j++)
     //     {
     //         System.out.print(modi_image[i][j]);
     //     }
     //     System.out.println();
     // }



    //Is Reachable
    // int totEdges=sc.nextInt();
    // Map<Integer,List<Integer>> graph=new HashMap<>();
    // {
    //     int vertix=sc.nextInt();
    //     int edge=sc.nextInt();
    //     graph.putIfAbsent(vertix,new ArrayList<>());
    //     graph.putIfAbsent(edge,new ArrayList<>());
    //     graph.get(vertix).add(edge);
    //     graph.get(edge).add(vertix);
    // }
    // int source=sc.nextInt(),destination=sc.nextInt();
    // System.out.println(g.isReachable(graph,source,destination) ? "1" : "0");


    //All Reachables
    // 7
    // 1 2 3 4 5 6 7
    // 7
    // 1 2
    // 1 3
    // 2 4
    // 3 4
    // 5 6
    // 5 7
    // 6 7
    // int totMembers=sc.nextInt();
    // List<Integer> vertices=new ArrayList<>();
    // Map<Integer,List<Integer>> graph=new HashMap<>();
    // for(int i=0;i<totMembers;i++) 
    // {
    //     int vertix=sc.nextInt();
    //     vertices.add(vertix);
    //     graph.put(vertix,new ArrayList<>());
    // }
    // int totEdges=sc.nextInt();
    // for(int i=0;i<totEdges;i++)
    // {
    //     int vertix=sc.nextInt();
    //     int edge=sc.nextInt();
    //     graph.get(vertix).add(edge);
    //     graph.get(edge).add(vertix);
    // }
    // System.out.println(graph);
    // Map<Integer,List<Integer>> allReachables=g.findAllReachables(vertices,graph);
    // for(Map.Entry<Integer,List<Integer>> kv: allReachables.entrySet())
    // {
    //     System.out.println(kv.getKey()+" "+kv.getValue());
    // }


    //Shortest Path UW
    //All Min Reachable Distance
        // int n=sc.nextInt();
        // int m=sc.nextInt();
        // List<List<Integer>>  graph=new ArrayList<>();
        // for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        // for(int i=0;i<m;i++)
        // {
        //     int vertix=sc.nextInt();
        //     int edge=sc.nextInt();
        //     graph.get(vertix).add(edge);
        //     graph.get(edge).add(vertix);
        // }
        // System.out.println(graph);
        // System.out.println(Arrays.toString(g.findAllMinReachableDistance(graph)));
        //Sample IO
        // 9
        // 10
        // 0 1
        // 0 3
        // 3 4
        // 4 5
        // 5 6
        // 1 2
        // 2 6
        // 6 7
        // 7 8
        // 6 8



  }
}







// #region Notes:


// For graphs with contiguous vertices and a fixed number of vertices,
// a list of lists is generally preferred due to its simplicity and efficiency.
// For more complex or dynamic graphs, a map-based approach provides greater flexibility.



//graph.putIfAbsent() helps in managing and initializing graph structures efficiently, 
//especially when dealing with dynamic or incomplete data inputs. - in orbitary map ds



// Use a boolean array when the graph is dense or memory is not an issue.
// Use a HashSet when the graph is sparse, or memory optimization is needed.

//#endregion