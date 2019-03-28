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
public class Geografico {
    
    GrafoNoDirigido grafond;
    GrafoDirigido grafod;
    private int minimum = 0;//minimum of random numbers
    private int vertexes;
    private double r;
    private boolean sameVertexEdge;
    
    public Geografico(){}
    
    public Geografico(int vertex,double r,boolean sameVertexEdge)
    {
        this.r = r;
        this.vertexes = vertex;
        this.sameVertexEdge = sameVertexEdge;
        
    }
    
    public void grafoNoDirigido()
    {
        grafond = new GrafoNoDirigido("GeograficoNoDirigido",sameVertexEdge);
        double x = 0;
        double y = 0;
        String xs,ys;
        double maximum = 1;
        ArrayList<Vertex> tmpvertexes = new ArrayList<Vertex>();
        
        if(vertexes>0)
        {
            for(int i = 0; i< vertexes;i++)
            {
                x = minimum + (Math.random() * maximum);
                y = minimum + (Math.random() * maximum);
                xs = x+"";
                ys = y+"";
                Vertex nvo = new Vertex("x"+xs.substring(2, 6)+"y"+ys.substring(2, 6),x,y);
                if(!isInVertexes(tmpvertexes,nvo))
                    tmpvertexes.add(nvo);
            }
        }
        
            grafond.setVertexes(tmpvertexes);
        
        
            generateEdgesND();
    }
    
    public boolean isInVertexes(ArrayList<Vertex> ve,Vertex v)
    {
        for(Vertex tmpv : ve)
        {
            if(tmpv.getName().equals(v.getName()))
                return true;
        }
        return false;
    }


    
    public void grafoDirigido()
    {
        grafod = new GrafoDirigido("GeograficoDirigido",sameVertexEdge);
        double x = 0;
        double y = 0;
        String xs,ys;
        double maximum = 1;
        ArrayList<Vertex> tmpvertexes = new ArrayList<Vertex>();
        
        if(vertexes>0)
        {
            for(int i = 0; i< vertexes;i++)
            {
                x = minimum + (Math.random() * maximum);
                y = minimum + (Math.random() * maximum);
                xs = x+"";
                ys = y+"";
                Vertex nvo = new Vertex("x"+xs.substring(2, 6)+"y"+ys.substring(2, 6),x,y);
                if(!isInVertexes(tmpvertexes,nvo))
                    tmpvertexes.add(nvo);
            }
        }
        
            grafod.setVertexes(tmpvertexes);
        
        
            generateEdgesD();
    }
    
    private void generateEdgesND()
    { 
        double rn;//probaility's node
        
        for(Vertex v1 : grafond.getVertexes())
        {
            for(Vertex v2 : grafond.getVertexes())
            {
                
                rn = Math.sqrt(Math.pow(v1.getX()-v2.getX(), 2.0)+Math.pow(v1.getY()-v2.getY(),2.0));
              
                if(rn<=r )
                {
                   grafond.addEdge(new Vertex(v1.getName()), new Vertex(v2.getName()));
                }
            }
        }
    }
    
    private void generateEdgesD()
    { 
        double rn;//probaility's node
        
        for(Vertex v1 : grafod.getVertexes())
        {
            for(Vertex v2 : grafod.getVertexes())
            {
                
                rn = Math.sqrt(Math.pow(v1.getX()-v2.getX(), 2.0)+Math.pow(v1.getY()-v2.getY(),2.0));
              
                if(rn<=r )
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
