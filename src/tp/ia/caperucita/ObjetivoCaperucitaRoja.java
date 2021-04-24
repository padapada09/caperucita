package tp.ia.caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoCaperucitaRoja extends GoalTest {

  @Override
  public boolean isGoalState(AgentState agentState) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) agentState;
    if (estadoAgenteCaperucitaRoja.getX() != estadoAgenteCaperucitaRoja.getSalidaX())
      return false;
    if (estadoAgenteCaperucitaRoja.getY() != estadoAgenteCaperucitaRoja.getSalidaY())
      return false;
    return true;
  }
}
