package tp.ia.caperucita.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp.ia.caperucita.EstadoAgenteCaperucitaRoja;
import tp.ia.caperucita.EstadoAmbienteCaperucitaRoja;
import tp.ia.caperucita.Helper;
import tp.ia.caperucita.PercepcionCaperucitaRoja;

public class IrAlEste extends SearchAction {

  @Override
  public String toString() {
    return "Ir al este";
  };

  @Override
  public Double getCost() {
    return null;
  }

  @Override
  public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) ast;
    EstadoAmbienteCaperucitaRoja estadoAmbienteCaperucitaRoja = (EstadoAmbienteCaperucitaRoja) est;
    int x = estadoAgenteCaperucitaRoja.getX();
    int y = estadoAgenteCaperucitaRoja.getY();
    ArrayList<Integer> columna = estadoAgenteCaperucitaRoja.getColumna(0);
    if (columna.size() <= y || y < 0)
      return null;
    ArrayList<Integer> fila = estadoAgenteCaperucitaRoja.getFila(y);

    /** Evalúa las precondiciones */
    if (x >= fila.size() - 1)
      return null;
    if (fila.get(x + 1) != PercepcionCaperucitaRoja.PERCEPCION_VACIO)
      return null;
    if (Helper.enLineaDeVista(fila, x + 1, +1, PercepcionCaperucitaRoja.PERCEPCION_LOBO) != -1)
      return null;
    if (Helper.enLineaDeVista(fila, x + 1, +1, PercepcionCaperucitaRoja.PERCEPCION_DULCE) != -1)
      return null;

    /** Busca la posición anterior al arbol en su linea de vista */
    int proximaColumna = Helper.enLineaDeVista(fila, x, +1, PercepcionCaperucitaRoja.PERCEPCION_ARBOL) - 1;

    estadoAgenteCaperucitaRoja.setX(proximaColumna);
    estadoAgenteCaperucitaRoja.contarCeldaVisitada();
    estadoAmbienteCaperucitaRoja.setCaperucitaRojaX(proximaColumna);
    estadoAmbienteCaperucitaRoja.moverLobo();

    return estadoAmbienteCaperucitaRoja;
  }

  @Override
  public SearchBasedAgentState execute(SearchBasedAgentState s) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) s;
    int y = estadoAgenteCaperucitaRoja.getY();
    int x = estadoAgenteCaperucitaRoja.getX();
    ArrayList<Integer> columna = estadoAgenteCaperucitaRoja.getColumna(0);
    if (columna.size() <= y || y < 0)
      return null;
    ArrayList<Integer> fila = estadoAgenteCaperucitaRoja.getFila(y);

    /** Evalúa las precondiciones */
    if (x >= fila.size() - 1)
      return null;
    if (fila.get(x + 1) != PercepcionCaperucitaRoja.PERCEPCION_VACIO)
      return null;
    if (Helper.enLineaDeVista(fila, x + 1, +1, PercepcionCaperucitaRoja.PERCEPCION_LOBO) != -1)
      return null;
    if (Helper.enLineaDeVista(fila, x + 1, +1, PercepcionCaperucitaRoja.PERCEPCION_DULCE) != -1)
      return null;

    /** Busca la posición anterior al arbol en su linea de vista */
    int proximaColumna = Helper.enLineaDeVista(fila, x, +1, PercepcionCaperucitaRoja.PERCEPCION_ARBOL) - 1;

    estadoAgenteCaperucitaRoja.setX(proximaColumna);
    estadoAgenteCaperucitaRoja.contarCeldaVisitada();

    return estadoAgenteCaperucitaRoja;
  }
}
