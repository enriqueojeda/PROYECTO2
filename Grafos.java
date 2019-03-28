package grafos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import grafos.BarabasiAlbert;
import grafos.BarabasiAlbert;
import grafos.Gilbert;
import grafos.SearchAlgorithms;
import java.io.IOException;

/**
 *
 * @author newbi
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, CloneNotSupportedException {
       
        // TODO code application logic here
        
//        ErdosRenyi er = new ErdosRenyi(5,5,false);//vertexes, edges, sameVertexEdge
//        er.grafoNoDirigido();
//        er.exportGraphVizND();
//        SearchAlgorithms sand = new SearchAlgorithms(er.grafond,er.grafond.getVertexes().get(0));
//        sand.GraphToBFSND();
//        sand.GraphToDFSND();

//        er.grafoDirigido();
//        er.exportGraphVizD();
//        SearchAlgorithms sad = new SearchAlgorithms(er.grafod,er.grafod.getVertexes().get(0));
//        sad.GraphToBFSD();
//        sad.GraphToDFSD();


        

        
        
 //       Gilbert g = new Gilbert(5,0.6,true);//vertexes, probability, sameVertexEdge
 //       g.grafoNoDirigido();
 //       g.exportGraphVizND();
 //       
 //       SearchAlgorithms sand = new SearchAlgorithms(g.grafond,g.grafond.getVertexes().get(0));
 //       sand.GraphToBFSND();
 //       sand.GraphToDFSND();

 //       g.grafoDirigido();
 //       g.exportGraphVizD();
 //       SearchAlgorithms sad = new SearchAlgorithms(g.grafod,g.grafod.getVertexes().get(0));
 //       sad.GraphToBFSD();
 //       sad.GraphToDFSD();


        
 //       Geografico ge = new Geografico(5,0.6,false);//vertexes, distance, sameVertexEdge
 //       ge.grafoNoDirigido();
 //       ge.exportGraphVizND();
 //      SearchAlgorithms sand = new SearchAlgorithms(ge.grafond,ge.grafond.getVertexes().get(0));
 //       sand.GraphToBFSND();
 //       sand.GraphToDFSND();

 //       ge.grafoDirigido();
 //      ge.exportGraphVizD();
 //       SearchAlgorithms sad = new SearchAlgorithms(ge.grafod,ge.grafod.getVertexes().get(0));
 //       sad.GraphToBFSD();
 //       sad.GraphToDFSD();

        
       BarabasiAlbert ba = new BarabasiAlbert(5,4,true);//vertexes, number of edges, sameVertexEdge
//        ba.grafoNoDirigido();
//        ba.exportGraphVizND();
//        SearchAlgorithms sand = new SearchAlgorithms(ba.grafond,ba.grafond.getVertexes().get(0));
//        sand.GraphToBFSND();
//        sand.GraphToDFSND();

        ba.grafoDirigido();
       ba.exportGraphVizD();
       SearchAlgorithms sad = new SearchAlgorithms(ba.grafod,ba.grafod.getVertexes().get(0));
        sad.GraphToBFSD();
        sad.GraphToDFSD();
        
    }
    
}
