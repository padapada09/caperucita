package tp.ia.caperucita;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any informed search
 * strategy, like A Star or Greedy.
 */
public class Heuristica implements IEstimatedCostFunction {

  /**
   * It returns the estimated cost to reach the goal from a NTree node.
   */
  @Override
  public double getEstimatedCost(NTree node) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) node.getAgentState();
    int salidaX = estadoAgenteCaperucitaRoja.getSalidaX();
    int salidaY = estadoAgenteCaperucitaRoja.getSalidaY();
    int caperucitaX = estadoAgenteCaperucitaRoja.getX();
    int caperucitaY = estadoAgenteCaperucitaRoja.getX();
    int catetoUno = Math.abs(salidaX - caperucitaX);
    int catetoDos = Math.abs(salidaY - caperucitaY);
    double distancia = Math.sqrt((catetoUno * catetoUno) + (catetoDos * catetoDos));
    return distancia;
  }
}