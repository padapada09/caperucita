package tp.ia.caperucita;

import java.util.Vector;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.solver.search.*;
import tp.ia.caperucita.actions.IrAlEste;
import tp.ia.caperucita.actions.IrAlEsteJuntandoCaramelo;
import tp.ia.caperucita.actions.IrAlNorte;
import tp.ia.caperucita.actions.IrAlNorteJuntandoCaramelo;
import tp.ia.caperucita.actions.IrAlOeste;
import tp.ia.caperucita.actions.IrAlOesteJuntandoCaramelo;
import tp.ia.caperucita.actions.IrAlSur;
import tp.ia.caperucita.actions.IrAlSurJuntandoCaramelo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteCaperucitaRoja extends SearchBasedAgent {

  public AgenteCaperucitaRoja() {
    ObjetivoCaperucitaRoja objetivo = new ObjetivoCaperucitaRoja();
    EstadoAgenteCaperucitaRoja estadoCaperucitaRoja = new EstadoAgenteCaperucitaRoja();
    this.setAgentState(estadoCaperucitaRoja);
    Vector<SearchAction> operadores = new Vector<SearchAction>();
    operadores.add(new IrAlNorte());
    operadores.add(new IrAlEste());
    operadores.add(new IrAlSur());
    operadores.add(new IrAlOeste());
    operadores.add(new IrAlNorteJuntandoCaramelo());
    operadores.add(new IrAlEsteJuntandoCaramelo());
    operadores.add(new IrAlSurJuntandoCaramelo());
    operadores.add(new IrAlOesteJuntandoCaramelo());
    Problem problem = new Problem(objetivo, estadoCaperucitaRoja, operadores);
    this.setProblem(problem);
  }

  /**
   * This method is executed by the simulator to ask the agent for an action.
   */
  @Override
  public Action selectAction() {

    // Create the search strategy
    BreathFirstSearch strategy = new BreathFirstSearch();

    /**
     * Another search strategy examples:
     * 
     * Depth First Search: DepthFirstSearch strategy = new DepthFirstSearch();
     * 
     * Breath First Search: BreathFirstSearch strategy = new BreathFirstSearch();
     * 
     * Uniform Cost: IStepCostFunction costFunction = new CostFunction();
     * UniformCostSearch strategy = new UniformCostSearch(costFunction);
     * 
     * A Star Search: IStepCostFunction cost = new CostFunction();
     * IEstimatedCostFunction heuristic = new Heuristic(); AStarSearch strategy =
     * new AStarSearch(cost, heuristic);
     * 
     * Greedy Search: IEstimatedCostFunction heuristic = new Heuristic();
     * GreedySearch strategy = new GreedySearch(heuristic);
     */

    // Create a Search object with the strategy
    Search searchSolver = new Search(strategy);

    /*
     * Generate an XML file with the search tree. It can also be generated in other
     * formats like PDF with PDF_TREE
     */
    searchSolver.setVisibleTree(Search.EFAIA_TREE);

    // Set the Search searchSolver.
    this.setSolver(searchSolver);

    // Ask the solver for the best action
    Action selectedAction = null;
    try {
      selectedAction = this.getSolver().solve(new Object[] { this.getProblem() });
    } catch (Exception ex) {
      Logger.getLogger(AgenteCaperucitaRoja.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Return the selected action
    return selectedAction;
  }

  /**
   * This method is executed by the simulator to give the agent a perception. Then
   * it updates its state.
   * 
   * @param p
   */
  @Override
  public void see(Perception p) {
    this.getAgentState().updateState(p);
  }
}
