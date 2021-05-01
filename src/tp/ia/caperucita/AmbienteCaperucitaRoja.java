package tp.ia.caperucita;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCaperucitaRoja extends Environment {

  public AmbienteCaperucitaRoja() {
    this.environmentState = new EstadoAmbienteCaperucitaRoja();
  }

  @Override
  public EstadoAmbienteCaperucitaRoja getEnvironmentState() {
    return (EstadoAmbienteCaperucitaRoja) super.getEnvironmentState();
  }

  /**
   * This method is called by the simulator. Given the Agent, it creates a new
   * perception reading, for example, the agent position.
   * 
   * @param agent
   * @return A perception that will be given to the agent by the simulator.
   */
  @Override
  public Perception getPercept() {
    PercepcionCaperucitaRoja perception = new PercepcionCaperucitaRoja();
    EstadoAmbienteCaperucitaRoja estadoAmbienteCaperucitaRoja = this.getEnvironmentState();

    int x = estadoAmbienteCaperucitaRoja.getCaperucitaRojaX();
    int y = estadoAmbienteCaperucitaRoja.getCaperucitaRojaY();
    ArrayList<ArrayList<Integer>> world = estadoAmbienteCaperucitaRoja.getWorld();

    perception.setLineaDeVistaNorte(Helper.getLineaDeVista(world, x, y, Helper.NORTE));
    perception.setLineaDeVistaEste(Helper.getLineaDeVista(world, x, y, Helper.ESTE));
    perception.setLineaDeVistaSur(Helper.getLineaDeVista(world, x, y, Helper.SUR));
    perception.setLineaDeVistaOeste(Helper.getLineaDeVista(world, x, y, Helper.OESTE));
    perception.setCaperucitaRojaX(x);
    perception.setCaperucitaRojaY(y);

    return perception;
  }

  @Override
  public String toString() {
    return environmentState.toString();
  }

  @Override
  public boolean agentFailed(Action actionReturned) {
    return this.getEnvironmentState().getVidasCaperucitaRoja() == 0;
  }
}
