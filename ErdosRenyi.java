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
public class ErdosRenyi {
    GrafoNoDirigido grafond;
    GrafoDirigido grafod;
    private int minimum = 1;//minimum of random numbers
    private int edges;
    private int vertexes;
    private boolean sameVertexEdge;
    
    public ErdosRenyi()
    {
        
    }
    
    
    
    public ErdosRenyi(int vertex,int edges,boolean sameVertexEdge)
    {
        this.edges = edges;
        this.vertexes = vertex;
        this.sameVertexEdge = sameVertexEdge;
        
    }
    
    public void grafoNoDirigido()
    {
        grafond = new GrafoNoDirigido("ErdosRenyiNoDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafond.generateVertexes(vertexes);
        
        if(edges>0)
            generateEdgesND(edges);
    }
    
    public void grafoDirigido()
    {
        grafod = new GrafoDirigido("ErdosRenyiDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafod.generateVertexes(vertexes);
        
        if(edges>0)
            generateEdgesD(edges);
    }
    
    private void generateEdgesND(int edges)
    { 
        int randomVertex1,randomVertex2;
        int maximum = grafond.getOrder();
        
        for(int i=0; i < edges; i++)
        {
            randomVertex1 = minimum + (int)(Math.random() * maximum);
            randomVertex2 = minimum + (int)(Math.random() * maximum);
            if(!grafond.addEdge(new Vertex(randomVertex1+""), new Vertex(randomVertex2+"")))
                i--;
        }
    }
    
    private void generateEdgesD(int edges)
    { 
        int randomVertex1,randomVertex2;
        int maximum = grafod.getOrder();
        
        for(int i=0; i < edges; i++)
        {
            randomVertex1 = minimum + (int)(Math.random() * maximum);
            randomVertex2 = minimum + (int)(Math.random() * maximum);
            if(!grafod.addEdge(new Vertex(randomVertex1+""), new Vertex(randomVertex2+"")))
                i--;
        }
    }
    
    public void exportGraphVizND() throws IOException, InterruptedException
    {
        grafond.exportToGraphViz();
    }
    
    public void exportGraphVizD() throws IOException, InterruptedException
    {
        grafod.exportToGraphViz();
    }
    
}
