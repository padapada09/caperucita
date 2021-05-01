package tp.ia.caperucita;

import java.util.ArrayList;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbienteCaperucitaRoja extends EnvironmentState {

  private ArrayList<ArrayList<Integer>> world;
  private int caperucitaRojaX;
  private int caperucitaRojaY;
  private int vidasCaperucitaRoja;
  private int dulcesCaperucita;
  private int celdasVisitadasCaperucitaRoja;

  public EstadoAmbienteCaperucitaRoja(ArrayList<ArrayList<Integer>> m) {
    world = m;
  }

  public EstadoAmbienteCaperucitaRoja() {
    this.world = new ArrayList<>();
    this.initState();
  }

  /**
   * This method is used to setup the initial real world.
   */
  @Override
  public void initState() {
    this.caperucitaRojaX = 8;
    this.caperucitaRojaY = 4;
    this.dulcesCaperucita = 0;
    this.vidasCaperucitaRoja = 3;
    this.celdasVisitadasCaperucitaRoja = 0;
    this.world = Helper.makeMap(false);
  }

  public void reset() {
    this.caperucitaRojaX = 8;
    this.caperucitaRojaY = 3;
    this.dulcesCaperucita = 0;
    this.celdasVisitadasCaperucitaRoja = 0;
    this.world = Helper.makeMap(false);
    this.vidasCaperucitaRoja--;
  }

  /**
   * String representation of the real world state.
   */
  @Override
  public String toString() {
    String str = "";

    str = str + "[ \n";
    for (int row = 0; row < world.size(); row++) {
      str = str + "[ ";
      for (int col = 0; col < world.get(0).size(); col++) {
        str = str + world.get(row).get(col) + " ";
      }
      str = str + " ]\n";
    }
    str = str + " ]";

    return str;
  }

  public void moverLobo() {
    int x = (int) Math.floor(Math.random() * this.world.size());
    int y = (int) Math.floor(Math.random() * this.world.get(0).size());

    while (this.world.get(x).get(y) != PercepcionCaperucitaRoja.PERCEPCION_VACIO) {
      x = (int) Math.floor(Math.random() * this.world.size());
      y = (int) Math.floor(Math.random() * this.world.get(0).size());
    }

    /** Si el lobo cae en la misma posición que caperucita, pierde una vida */
    if (this.caperucitaRojaX == x && this.caperucitaRojaY == y)
      this.reset();

    int loboX = this.getLoboX();
    int loboY = this.getLoboY();

    this.world.get(loboX).set(loboY, PercepcionCaperucitaRoja.PERCEPCION_VACIO);
    this.world.get(x).set(y, PercepcionCaperucitaRoja.PERCEPCION_LOBO);
  }

  public int getLoboX() {
    for (int x = 0; x < this.world.size(); x++) {
      for (int y = 0; y < this.world.get(0).size(); y++) {
        if (this.world.get(x).get(y) == PercepcionCaperucitaRoja.PERCEPCION_LOBO)
          return x;
      }
    }
    throw new Error("Parece que no hay un lobo en el mapa");
  };

  public int getLoboY() {
    for (int x = 0; x < this.world.size(); x++) {
      for (int y = 0; y < this.world.get(0).size(); y++) {
        if (this.world.get(x).get(y) == PercepcionCaperucitaRoja.PERCEPCION_LOBO)
          return y;
      }
    }
    throw new Error("Parece que no hay un lobo en el mapa");
  };

  public ArrayList<ArrayList<Integer>> getWorld() {
    return world;
  }

  public void setWorld(ArrayList<ArrayList<Integer>> world) {
    this.world = world;
  }

  public int getCaperucitaRojaX() {
    return caperucitaRojaX;
  }

  public int getCaperucitaRojaY() {
    return caperucitaRojaY;
  }

  public void setCaperucitaRojaX(int caperucitaRojaX) {
    this.caperucitaRojaX = caperucitaRojaX;
  }

  public void setCaperucitaRojaY(int caperucitaRojaY) {
    this.caperucitaRojaY = caperucitaRojaY;
  }

  public int getVidasCaperucitaRoja() {
    return vidasCaperucitaRoja;
  }

  public int getCeldasVisitadasCaperucitaRoja() {
    return celdasVisitadasCaperucitaRoja;
  }

  public void setCeldasVisitadasCaperucitaRoja(int celdasVisitadasCaperucitaRoja) {
    this.celdasVisitadasCaperucitaRoja = celdasVisitadasCaperucitaRoja;
  }

  public void setVidasCaperucitaRoja(int vidasCaperucitaRoja) {
    this.vidasCaperucitaRoja = vidasCaperucitaRoja;
  }

  public int getDulcesCaperucita() {
    return dulcesCaperucita;
  }

  public void setDulcesCaperucita(int dulcesCaperucita) {
    this.dulcesCaperucita = dulcesCaperucita;
  }
}
