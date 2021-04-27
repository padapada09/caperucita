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
    this.world = Helper.makeMap(false);
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

  public ArrayList<ArrayList<Integer>> getWorld() {
    return world;
  }

  public void setWorld(ArrayList<ArrayList<Integer>> world) {
    this.world = world;
  }

  public int getCaperucitaRojaX() {
    return caperucitaRojaX;
  }

  public void setCaperucitaRojaX(int caperucitaRojaX) {
    this.caperucitaRojaX = caperucitaRojaX;
  }

  public int getCaperucitaRojaY() {
    return caperucitaRojaY;
  }

  public void setCaperucitaRojaY(int caperucitaRojaY) {
    this.caperucitaRojaY = caperucitaRojaY;
  }
}
