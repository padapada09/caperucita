package tp.ia.caperucita;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like Uniform Cost.
 */
public class FuncionCostoCaperucitaRoja implements IStepCostFunction {

  /**
   * This method calculates the cost of the given NTree node.
   */
  @Override
  public double calculateCost(NTree node) {
    return ((EstadoAgenteCaperucitaRoja) node.getAgentState()).getCeldasVisitadas();
  }
}
