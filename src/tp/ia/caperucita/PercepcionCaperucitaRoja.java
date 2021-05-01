package tp.ia.caperucita;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionCaperucitaRoja extends Perception {

  public static int PERCEPCION_DESCONOCIDO = -1;
  public static int PERCEPCION_VACIO = 0;
  public static int PERCEPCION_ARBOL = 1;
  public static int PERCEPCION_DULCE = 2;
  public static int PERCEPCION_LOBO = 3;
  public static int PERCEPCION_FLORES = 4;

  private ArrayList<Integer> lineaDeVistaNorte;
  private ArrayList<Integer> lineaDeVistaSur;
  private ArrayList<Integer> lineaDeVistaEste;
  private ArrayList<Integer> lineaDeVistaOeste;
  private int caperucitaRojaX;
  private int caperucitaRojaY;
  private int vidasCaperucitaRoja;
  private int dulcesCaperucitaRoja;
  private int celdasVisitadasCaperucita;

  public PercepcionCaperucitaRoja() {
  }

  public PercepcionCaperucitaRoja(Agent agent, Environment environment) {
    super(agent, environment);
  }

  @Override
  public void initPerception(Agent agent, Environment environment) {
    AmbienteCaperucitaRoja ambienteCaperucitaRoja = (AmbienteCaperucitaRoja) environment;
    EstadoAmbienteCaperucitaRoja estadoAmbienteCaperucitaRoja = ambienteCaperucitaRoja.getEnvironmentState();

    int x = estadoAmbienteCaperucitaRoja.getCaperucitaRojaX();
    int y = estadoAmbienteCaperucitaRoja.getCaperucitaRojaY();
    ArrayList<ArrayList<Integer>> world = estadoAmbienteCaperucitaRoja.getWorld();

    this.setLineaDeVistaNorte(Helper.getLineaDeVista(world, x, y, Helper.NORTE));
    this.setLineaDeVistaEste(Helper.getLineaDeVista(world, x, y, Helper.ESTE));
    this.setLineaDeVistaSur(Helper.getLineaDeVista(world, x, y, Helper.SUR));
    this.setLineaDeVistaOeste(Helper.getLineaDeVista(world, x, y, Helper.OESTE));
    this.setCaperucitaRojaX(x);
    this.setCaperucitaRojaY(y);
    this.setVidasCaperucitaRoja(estadoAmbienteCaperucitaRoja.getVidasCaperucitaRoja());
    this.setDulcesCaperucitaRoja(estadoAmbienteCaperucitaRoja.getDulcesCaperucita());
  }

  @Override
  public String toString() {
    return (String.format("\nLinea de vista norte: %s\n", this.lineaDeVistaNorte)
        + String.format("Linea de vista este: %s\n", this.lineaDeVistaEste)
        + String.format("Linea de vista sur: %s\n", this.lineaDeVistaSur)
        + String.format("Linea de vista oeste: %s\n", this.lineaDeVistaOeste));
  }

  public ArrayList<Integer> getLineaDeVistaNorte() {
    return lineaDeVistaNorte;
  }

  public void setLineaDeVistaNorte(ArrayList<Integer> lineaDeVistaNorte) {
    this.lineaDeVistaNorte = lineaDeVistaNorte;
  }

  public ArrayList<Integer> getLineaDeVistaSur() {
    return lineaDeVistaSur;
  }

  public void setLineaDeVistaSur(ArrayList<Integer> lineaDeVistaSur) {
    this.lineaDeVistaSur = lineaDeVistaSur;
  }

  public ArrayList<Integer> getLineaDeVistaEste() {
    return lineaDeVistaEste;
  }

  public void setLineaDeVistaEste(ArrayList<Integer> lineaDeVistaEste) {
    this.lineaDeVistaEste = lineaDeVistaEste;
  }

  public ArrayList<Integer> getLineaDeVistaOeste() {
    return lineaDeVistaOeste;
  }

  public void setLineaDeVistaOeste(ArrayList<Integer> lineaDeVistaOeste) {
    this.lineaDeVistaOeste = lineaDeVistaOeste;
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

  public int getVidasCaperucitaRoja() {
    return vidasCaperucitaRoja;
  }

  public void setVidasCaperucitaRoja(int vidasCaperucitaRoja) {
    this.vidasCaperucitaRoja = vidasCaperucitaRoja;
  }

  public int getDulcesCaperucitaRoja() {
    return dulcesCaperucitaRoja;
  }

  public void setDulcesCaperucitaRoja(int dulcesCaperucitaRoja) {
    this.dulcesCaperucitaRoja = dulcesCaperucitaRoja;
  }

  public int getCeldasVisitadasCaperucita() {
    return celdasVisitadasCaperucita;
  }

  public void setCeldasVisitadasCaperucita(int celdasVisitadasCaperucita) {
    this.celdasVisitadasCaperucita = celdasVisitadasCaperucita;
  }
}
