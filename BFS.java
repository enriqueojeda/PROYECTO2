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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author newbi
 */
public class BFS extends SearchAlgorithms{
    
    private Grafo grafo;
    private Vertex vertex;
    ArrayList<Edge> bfsedgesnd,bfsedgesd;
    public BFS(){}
    
    public BFS(Grafo grafo,Vertex vertex)
    {
        this.grafo = grafo;
        this.vertex = vertex;
        VertexUnvisited();
    }
    
    private void VertexUnvisited()
    {
        for(Vertex v:grafo.getVertexes())
            v.setVisited(false);
    }
    
    public void GraphToBFSND()
    {
        try {
            bfsedgesnd = new ArrayList<Edge>();
            Queue<Vertex> queue= new LinkedList<Vertex>();
            vertex.setVisited(true);
            grafo.updateVisited(vertex);
            queue.add(vertex);
            //        System.out.println("IN:"+vertex.getName());
            while(!queue.isEmpty())
            {
                Vertex v = queue.remove();
                //             System.out.print(""+v.getName()+"\t");
                for(Vertex ve:grafo.DegVertexes(v))
                {
//                 System.out.println("ve:"+ve.getName());
                    if(!ve.isVisited())
                    {
                        if(!isInEdgesND(v,ve) && !isInEdgesND(ve,v))
                        {
                            //System.out.println(""+v.getName()+"->"+ve.getName());
                            bfsedgesnd.add(new Edge(v,ve));
                        }
        
                        queue.add(ve);
                        ve.setVisited(true);
                        grafo.updateVisited(ve);
        
                    }
}
}
System.out.println("--------------");
String dot = printEdges(bfsedgesnd);
writeDotFile(dot);
        } catch (IOException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void GraphToBFSD()
    {
        try {
            bfsedgesd = new ArrayList<Edge>();
            Queue<Vertex> queue= new LinkedList<Vertex>();
            vertex.setVisited(true);
            grafo.updateVisited(vertex);
            queue.add(vertex);
            //        System.out.println("IN:"+vertex.getName());
            while(!queue.isEmpty())
            {
                Vertex v = queue.remove();
                System.out.print(""+v.getName()+"\t");
                for(Vertex ve:grafo.OutDegVertexes(v))
                {
                 System.out.println("ve:"+ve.getName());
                    if(!ve.isVisited())
                    {
                        if(!isInEdgesD(v,ve) && !isInEdgesD(ve,v))
                        {
                            //System.out.println(""+v.getName()+"->"+ve.getName());
                            bfsedgesd.add(new Edge(v,ve));
                        }
                        ve.setVisited(true);
                        grafo.updateVisited(ve);
                        queue.add(ve);
                        
        
                    }
}
}
System.out.println("--------------");
String dot = printEdges(bfsedgesd);
writeDotFile(dot);
        } catch (IOException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeDotFile(String dot) throws IOException, InterruptedException
    {
        PrintWriter writer;
    try {
        
        writer = new PrintWriter("src\\dots\\"+grafo.getName()+"BFS.dot", "UTF-8");
        writer.print(dot);
        writer.close();
        Process p;
        p = Runtime.getRuntime().exec("dot.exe src\\dots\\"+grafo.getName()+"BFS.dot -Tpng -o src\\dots\\"+grafo.getName()+"BFS.png");
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
        dot+="graph "+grafo.getName()+"BFS{ \n";
        for(Edge e:bfsedges)
        {
            System.out.println(e.getVertex1().getName()+"->"+e.getVertex2().getName());
            dot+=""+e.getVertex1().getName()+" -- "+e.getVertex2().getName()+";";
        }
        dot+="}\n";
        return dot;
    }
    
   
    private boolean isInEdgesND(Vertex v1,Vertex v2)
    {
        for(Edge e:bfsedgesnd)
        {
            if(e.getVertex1().getName().equals(v1.getName()) && e.getVertex2().getName().equals(v2.getName()))
                return true;
        }
        
        return false;
    }
    
    private boolean isInEdgesD(Vertex v1,Vertex v2)
    {
        for(Edge e:bfsedgesd)
        {
            if(e.getVertex1().getName().equals(v1.getName()) && e.getVertex2().getName().equals(v2.getName()))
                return true;
        }
        
        return false;
    }
    
    
}
