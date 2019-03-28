/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author newbi
 */
public class GrafoNoDirigido extends Grafo{
    
    public GrafoNoDirigido(){}
    
    public GrafoNoDirigido(String nombre,boolean sameVertexEdge)
    {
        super(nombre,sameVertexEdge);
    }
    
    
    /**
     * 
     * @param vertex1
     * @param vertex2
     * Adds an edge with vertex1 and vertex2
     * verifying if exist v1,v2 or v2,v1
     */
    public boolean addEdge(Vertex vertex1, Vertex vertex2)
    {
        Edge nvoEdge12 = new Edge(vertex1,vertex2);
        Edge nvoEdge21 = new Edge(vertex2,vertex1);
        if(!isInEdge(nvoEdge12) && !isInEdge(nvoEdge21) )
                 
        {
            if(isSameVertexEdge())
            {
                addEdge(new Edge(vertex1,vertex2));
                return true;
            }else
            {
                if(!vertex1.getName().equals(vertex2.getName()))
                {
                    addEdge(new Edge(vertex1,vertex2));
                    return true;
                }else
                {
                    return false;
                }
            }
        }
        
        return false;
        
    }
    
    
    public void exportToGraphViz() throws IOException, InterruptedException
    {
        String dot = "";
        System.out.println("graph "+getName()+"{ ");
        dot+="graph "+getName()+"{ \n";
        for(Vertex v : getVertexes())
        {
            System.out.println(v.getName()+";");
            dot+=v.getName()+";";
        }
        
        for(Edge ed : getEdges())
        {
            System.out.println(ed.getVertex1().getName()+" -- "+ed.getVertex2().getName()+";");
            dot+=ed.getVertex1().getName()+" -- "+ed.getVertex2().getName()+";";
        }
        
		
	System.out.println("}");
        dot+="}";
        
        writeDotFile(dot);
    }
    
    
}
