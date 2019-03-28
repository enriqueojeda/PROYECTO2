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
public class BarabasiAlbert {
    GrafoNoDirigido grafond;
    GrafoDirigido grafod;
    private int vertexes;
    private double d;
    private boolean sameVertexEdge;
    
    public BarabasiAlbert(){}
    
    public BarabasiAlbert(int vertex,int d,boolean sameVertexEdge)
    {
        this.d = d;
        this.vertexes = vertex;
        this.sameVertexEdge = sameVertexEdge;
        
    }
    
    public void grafoNoDirigido()
    {
        grafond = new GrafoNoDirigido("BarabasiAlbertNoDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafond.generateVertexes(vertexes);
        
        
            generateEdgesND();
    }
    
    public void grafoDirigido()
    {
        grafod = new GrafoDirigido("BarabasiAlbertDirigido",sameVertexEdge);
        
        if(vertexes>0)
            grafod.generateVertexes(vertexes);
        
        
            generateEdgesD();
    }
    
    private void generateEdgesND()
    { 
        double pn;//probaility's node
        
        
        for(Vertex v1 : grafond.getVertexes())
        {
            for(Vertex v2 : grafond.getVertexes())
            {
                pn = 1-(grafond.Deg(v1)/d);
                
                if(pn>0)
                {
                    grafond.addEdge(new Vertex(v1.getName()), new Vertex(v2.getName()));
                }
            }
        }
    }
    
    private void generateEdgesD()
    { 
        double pn;//probaility's node
        
        
        for(Vertex v1 : grafod.getVertexes())
        {
            for(Vertex v2 : grafod.getVertexes())
            {
                pn = 1-(grafod.OutDeg(v1)/d);
                
                if(pn>0)
                {
                    
                    grafod.addEdge(new Vertex(v1.getName()), new Vertex(v2.getName()));
                    System.out.println("pn:"+pn+" v1:"+v1.getName()+" v2:"+v2.getName());
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
