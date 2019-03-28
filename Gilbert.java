/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.IOException;

/**
 *
 * @author newbi
 */
public class Gilbert {
    GrafoNoDirigido grafond;
    GrafoDirigido grafod;
    private int minimum = 0;//minimum of random numbers
    private int vertexes;
    private double probability;
    private boolean sameVertexEdge;
    
    public Gilbert(){}
    
    public Gilbert(int vertex,double probability,boolean sameVertexEdge)
    {
        this.probability = probability;
        this.vertexes = vertex;
        this.sameVertexEdge = sameVertexEdge;
        
    }
    
    public void grafoNoDirigido()
    {
        grafond = new GrafoNoDirigido("GilbertNoDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafond.generateVertexes(vertexes);
        
        
            generateEdgesND();
    }
    
    public void grafoDirigido()
    {
        grafod = new GrafoDirigido("GilbertDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafod.generateVertexes(vertexes);
        
        
            generateEdgesD();
    }
    
    private void generateEdgesND()
    { 
        float pn;//probaility's node
        double maximum = probability;
        
        for(Vertex v1 : grafond.getVertexes())
        {
            for(Vertex v2 : grafond.getVertexes())
            {
                pn = minimum + (float)(Math.random() * maximum);
                if(pn>=0 && pn <=probability)
                {
                    grafond.addEdge(new Vertex(v1.getName()), new Vertex(v2.getName()));
                }
            }
        }
    }
    
    private void generateEdgesD()
    { 
        float pn;//probaility's node
        double maximum = probability;
        
        for(Vertex v1 : grafod.getVertexes())
        {
            for(Vertex v2 : grafod.getVertexes())
            {
                pn = minimum + (float)(Math.random() * maximum);
                if(pn>=0 && pn <=probability)
                {
                    grafod.addEdge(new Vertex(v1.getName()), new Vertex(v2.getName()));
                }
            }
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
