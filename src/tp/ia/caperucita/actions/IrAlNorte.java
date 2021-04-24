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

public class IrAlNorte extends SearchAction {

  @Override
  public String toString() {
    return "Ir al norte";
  };

  @Override
  public Double getCost() {
    return null;
  }

  @Override
  public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) ast;
    EstadoAmbienteCaperucitaRoja estadoAmbienteCaperucitaRoja = (EstadoAmbienteCaperucitaRoja) est;
    int y = estadoAgenteCaperucitaRoja.getY();
    int x = estadoAgenteCaperucitaRoja.getX();
    ArrayList<Integer> fila = estadoAgenteCaperucitaRoja.getFila(0);
    if (fila.size() <= x || x < 0)
      return null;
    ArrayList<Integer> columna = estadoAgenteCaperucitaRoja.getColumna(x);

    /** Evalúa las precondiciones */
    if (y <= 0)
      return null;
    if (columna.get(y - 1) != PercepcionCaperucitaRoja.PERCEPCION_VACIO)
      return null;
    if (Helper.enLineaDeVista(columna, y - 1, -1, PercepcionCaperucitaRoja.PERCEPCION_LOBO) != -1)
      return null;
    if (Helper.enLineaDeVista(columna, y - 1, -1, PercepcionCaperucitaRoja.PERCEPCION_DULCE) != -1)
      return null;

    /** Busca la posición anterior al arbol en su linea de vista */
    int proximaFila = Helper.enLineaDeVista(columna, y, -1, PercepcionCaperucitaRoja.PERCEPCION_ARBOL) + 1;

    estadoAgenteCaperucitaRoja.setY(proximaFila);
    estadoAmbienteCaperucitaRoja.setCaperucitaRojaY(proximaFila);

    return estadoAmbienteCaperucitaRoja;
  }

  @Override
  public SearchBasedAgentState execute(SearchBasedAgentState s) {
    EstadoAgenteCaperucitaRoja estadoAgenteCaperucitaRoja = (EstadoAgenteCaperucitaRoja) s;
    int y = estadoAgenteCaperucitaRoja.getY();
    int x = estadoAgenteCaperucitaRoja.getX();
    ArrayList<Integer> fila = estadoAgenteCaperucitaRoja.getFila(0);
    if (fila.size() <= x || x < 0)
      return null;
    ArrayList<Integer> columna = estadoAgenteCaperucitaRoja.getColumna(x);

    /** Evalúa las precondiciones */
    if (y <= 0)
      return null;
    if (columna.get(y - 1) != PercepcionCaperucitaRoja.PERCEPCION_VACIO)
      return null;
    if (Helper.enLineaDeVista(columna, y - 1, -1, PercepcionCaperucitaRoja.PERCEPCION_LOBO) != -1)
      return null;
    if (Helper.enLineaDeVista(columna, y - 1, -1, PercepcionCaperucitaRoja.PERCEPCION_DULCE) != -1)
      return null;

    /** Busca la posición anterior al arbol en su linea de vista */
    int proximaFila = Helper.enLineaDeVista(columna, y, -1, PercepcionCaperucitaRoja.PERCEPCION_ARBOL) + 1;

    estadoAgenteCaperucitaRoja.setY(proximaFila);

    return estadoAgenteCaperucitaRoja;
  }
}
