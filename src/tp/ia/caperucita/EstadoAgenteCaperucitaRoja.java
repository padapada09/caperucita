package tp.ia.caperucita;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCaperucitaRoja extends SearchBasedAgentState {

  /** Cantidad de dulces que posee caperucita */
  private int dulces;
  /** Posición en el eje X de caperuita en el tablero */
  private int x;
  /** Posición en el eje Y de caperuita en el tablero */
  private int y;
  /** Cantidad de celdas ya visitadas */
  private int celdasVisitadas;
  /** Mundo percibido por Caperucita Roja */
  private ArrayList<ArrayList<Integer>> mapa;

  public EstadoAgenteCaperucitaRoja() {
    this.initState();
  };

  public EstadoAgenteCaperucitaRoja(int dulces, int x, int y, ArrayList<ArrayList<Integer>> mapa) {
    this.dulces = dulces;
    this.x = x;
    this.y = y;
    this.celdasVisitadas = 0;
    this.mapa = mapa;
  };

  @Override
  public String toString() {
    String stringedState = String.format("{x = %d, y = %d}\n", this.x, this.y);
    return stringedState;
  }

  @Override
  public boolean equals(Object obj) {
    EstadoAgenteCaperucitaRoja otroEstado = (EstadoAgenteCaperucitaRoja) obj;
    if (!(obj instanceof EstadoAgenteCaperucitaRoja))
      return false;
    if (otroEstado.dulces != this.dulces)
      return false;
    if (otroEstado.x != this.x)
      return false;
    if (otroEstado.y != this.y)
      return false;
    return true;
  }

  @Override
  public SearchBasedAgentState clone() {
    Integer dulces = Integer.valueOf(this.dulces);
    Integer x = Integer.valueOf(this.x);
    Integer y = Integer.valueOf(this.y);
    ArrayList<ArrayList<Integer>> clonedMap = new ArrayList<>();
    for (ArrayList<Integer> columna : mapa) {
      ArrayList<Integer> newColumn = new ArrayList<>();
      for (Integer cell : columna) {
        newColumn.add(cell);
      }
      clonedMap.add(newColumn);
    }
    return new EstadoAgenteCaperucitaRoja(dulces, x, y, mapa);
  }

  @Override
  public void updateState(Perception p) {
    PercepcionCaperucitaRoja percepcion = (PercepcionCaperucitaRoja) p;
    this.x = percepcion.getCaperucitaRojaX();
    this.y = percepcion.getCaperucitaRojaY();
    ArrayList<Integer> lineaDeVistaNorte = percepcion.getLineaDeVistaNorte();
    ArrayList<Integer> lineaDeVistaEste = percepcion.getLineaDeVistaEste();
    ArrayList<Integer> lineaDeVistaSur = percepcion.getLineaDeVistaSur();
    ArrayList<Integer> lineaDeVistaOeste = percepcion.getLineaDeVistaOeste();

    this.mapa.get(x).set(y, 0);

    for (int i = 0; i < lineaDeVistaNorte.size(); i++)
      this.mapa.get(this.x).set(this.y - i - 1, lineaDeVistaNorte.get(i));

    for (int i = 0; i < lineaDeVistaEste.size(); i++)
      this.mapa.get(this.x + i + 1).set(this.y, lineaDeVistaEste.get(i));

    for (int i = 0; i < lineaDeVistaSur.size(); i++)
      this.mapa.get(this.x).set(this.y + i + 1, lineaDeVistaSur.get(i));

    for (int i = 0; i < lineaDeVistaOeste.size(); i++)
      this.mapa.get(this.x - i - 1).set(this.y, lineaDeVistaOeste.get(i));
  }

  @Override
  public void initState() {
    this.celdasVisitadas = 0;
    this.mapa = Helper.makeMap(true);
  }

  public int getDulces() {
    return dulces;
  }

  public void setDulces(int dulces) {
    this.dulces = dulces;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public ArrayList<ArrayList<Integer>> getMapa() {
    return mapa;
  }

  public void setMapa(ArrayList<ArrayList<Integer>> mapa) {
    this.mapa = mapa;
  }

  public void contarCeldaVisitada() {
    this.celdasVisitadas++;
  }

  public int getCeldasVisitadas() {
    return this.celdasVisitadas;
  }

  public int getSalidaX() {
    for (int x = 0; x < this.mapa.size(); x++) {
      for (int y = 0; y < this.mapa.get(0).size(); y++) {
        if (this.mapa.get(x).get(y) == PercepcionCaperucitaRoja.PERCEPCION_FLORES) {
          return x;
        }
      }
    }
    throw new Error("Parece que el mapa no tiene ningún campo de flores");
  }

  public int getSalidaY() {
    for (int x = 0; x < this.mapa.size(); x++) {
      for (int y = 0; y < this.mapa.get(0).size(); y++) {
        if (this.mapa.get(x).get(y) == PercepcionCaperucitaRoja.PERCEPCION_FLORES) {
          return y;
        }
      }
    }
    throw new Error("Parece que el mapa no tiene ningún campo de flores");
  }

  public ArrayList<Integer> getColumna(int x) {
    return this.mapa.get(x);
  }

  public ArrayList<Integer> getFila(int y) {
    ArrayList<Integer> fila = new ArrayList<Integer>(this.mapa.size());
    for (ArrayList<Integer> columna : this.mapa) {
      fila.add(columna.get(y));
    }
    return fila;
  }
}
