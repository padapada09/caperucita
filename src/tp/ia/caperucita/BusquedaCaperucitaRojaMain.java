package tp.ia.caperucita;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class BusquedaCaperucitaRojaMain {

  public static void main(String[] args) throws PrologConnectorException {
    AgenteCaperucitaRoja agenteCaperucitaRoja = new AgenteCaperucitaRoja();
    AmbienteCaperucitaRoja ambienteCaperucitaRoja = new AmbienteCaperucitaRoja();
    SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(ambienteCaperucitaRoja, agenteCaperucitaRoja);

    simulator.start();
  }
}
