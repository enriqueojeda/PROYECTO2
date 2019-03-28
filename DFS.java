/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author newbi
 */
public class DFS {
     private Grafo grafo;
    private Vertex vertex;
    ArrayList<Edge> dfsedgesnd,dfsedgesd;
    public DFS(){}
    
    public DFS(Grafo grafo,Vertex vertex)
    {
        this.grafo = grafo;
        this.vertex = vertex;
        dfsedgesnd = new ArrayList<Edge>();
        dfsedgesd = new ArrayList<Edge>();
        VertexUnvisited();
    }
    
    private void VertexUnvisited()
    {
        for(Vertex v:grafo.getVertexes())
            v.setVisited(false);
    }
    
    public void GraphToDFSND(Vertex v)
    {
        DFSND(v);
        String dot = printEdges(dfsedgesnd);
         try {
             writeDotFile(dot);
         } catch (IOException ex) {
             Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InterruptedException ex) {
             Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void GraphToDFSD(Vertex v)
    {
        DFSD(v);
        String dot = printEdges(dfsedgesd);
         try {
             writeDotFile(dot);
         } catch (IOException ex) {
             Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InterruptedException ex) {
             Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void DFSND(Vertex v)
    {
        
            v.setVisited(true);
            grafo.updateVisited(v);
            
            for(Vertex ve:grafo.DegVertexes(v))
            {
                if(!ve.isVisited())
                {
                    System.out.println(""+v.getName()+"->"+ve.getName());
                    dfsedgesnd.add(new Edge(v,ve));
                    DFSND(ve);
                }
            }
    }
    
    public void DFSD(Vertex v)
    {
        v.setVisited(true);
        grafo.updateVisited(v);
            
        for(Vertex ve:grafo.OutDegVertexes(v))
        {
            if(!ve.isVisited())
            {
                System.out.println(""+v.getName()+"-->"+ve.getName());
                dfsedgesd.add(new Edge(v,ve));
                DFSD(ve);
            }
        }
    }
    
    
    public void writeDotFile(String dot) throws IOException, InterruptedException
    {
        PrintWriter writer;
    try {
        
        writer = new PrintWriter("src\\dots\\"+grafo.getName()+"DFS.dot", "UTF-8");
        writer.print(dot);
        writer.close();
        Process p;
        p = Runtime.getRuntime().exec("dot.exe src\\dots\\"+grafo.getName()+"DFS.dot -Tpng -o src\\dots\\"+grafo.getName()+"DFS.png");
        p.waitFor();

    } catch (FileNotFoundException ex) {
        Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private String printEdges(ArrayList<Edge> bfsedges)
    {
        String dot = "";
        dot+="graph "+grafo.getName()+"DFS{ \n";
        for(Edge e:bfsedges)
        {
            //System.out.println(e.getVertex1().getName()+"-->"+e.getVertex2().getName());
            dot+=""+e.getVertex1().getName()+" -- "+e.getVertex2().getName()+";";
        }
        dot+="}\n";
        return dot;
    }
    
   
    private boolean isInEdgesND(Vertex v1,Vertex v2)
    {
        
        
        for(Edge e:dfsedgesnd)
        {
            if(e.getVertex1().getName().equals(v1.getName()) && e.getVertex2().getName().equals(v2.getName()))
                return true;
        }
        
        return false;
    }
    
    private boolean isInEdgesD(Vertex v1,Vertex v2)
    {
        for(Edge e:dfsedgesd)
        {
            if(e.getVertex1().getName().equals(v1.getName()) && e.getVertex2().getName().equals(v2.getName()))
                return true;
        }
        
        return false;
    }
    
    
}
