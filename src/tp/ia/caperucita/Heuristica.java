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
    EstadoAgenteCaperucitaRoja pacmanState = (EstadoAgenteCaperucitaRoja) node.getAgentState();

    /** TODO: Cambiar este calculo por algo mejor */
    return (4 - pacmanState.getDulces());
  }
}
