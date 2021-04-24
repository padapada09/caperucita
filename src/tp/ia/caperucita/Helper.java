package tp.ia.caperucita;

import java.util.ArrayList;
import java.util.Arrays;

public class Helper {

  public static final int NORTE = 0;
  public static final int ESTE = 1;
  public static final int SUR = 2;
  public static final int OESTE = 3;

  /**
   * Función para buscar en la linea de vista dada si existe una percepción
   * especificada por parámetro. Si no encuentra la percepción en la linea de
   * vista, entonces retorna -1.
   */
  public static int enLineaDeVista(ArrayList<Integer> lineaDeVista, int comienzo, int direccion, int percepcion) {
    if (direccion > 0) {
      for (int i = comienzo; i < lineaDeVista.size(); i += direccion) {
        if (lineaDeVista.get(i) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
          if (percepcion == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
            return i;
          } else {
            /**
             * Si está buscando algo distinto a un arbol, ya no va a ser capaz de ver nada
             * más allá del arbol. Por eso se retorna -1, para indicar que no está en la
             * linea de vista.
             */
            return -1;
          }
        }
        if (lineaDeVista.get(i) == percepcion) {
          return i;
        }
      }
      if (percepcion == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
        return lineaDeVista.size();
      } else {
        return -1;
      }
    } else {
      for (int i = comienzo; i >= 0; i += direccion) {
        if (lineaDeVista.get(i) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
          if (percepcion == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
            return i;
          } else {
            /**
             * Si está buscando algo distinto a un arbol, ya no va a ser capaz de ver nada
             * más allá del arbol. Por eso se retorna -1, para indicar que no está en la
             * linea de vista.
             */
            return -1;
          }
        }
        if (lineaDeVista.get(i) == percepcion) {
          return i;
        }
      }
      if (percepcion == PercepcionCaperucitaRoja.PERCEPCION_ARBOL) {
        return 0 - 1;
      } else {
        return -1;
      }
    }
  };

  public static ArrayList<Integer> getLineaDeVista(ArrayList<ArrayList<Integer>> mapa, int x, int y, int direccion) {
    ArrayList<Integer> lineaDeVista = new ArrayList<>();
    switch (direccion) {
    case NORTE:
      for (int i = y - 1; i >= 0; i--) {
        lineaDeVista.add(mapa.get(x).get(i));
        if (mapa.get(x).get(i) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL)
          break;
      }
      break;
    case SUR:
      for (int i = y + 1; i < mapa.get(x).size(); i++) {
        lineaDeVista.add(mapa.get(x).get(i));
        if (mapa.get(x).get(i) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL)
          break;
      }
      break;
    case OESTE:
      for (int i = x - 1; i >= 0; i--) {
        lineaDeVista.add(mapa.get(i).get(y));
        if (mapa.get(i).get(y) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL)
          break;
      }
      break;
    case ESTE:
      for (int i = x + 1; i < mapa.size(); i++) {
        lineaDeVista.add(mapa.get(i).get(y));
        if (mapa.get(i).get(y) == PercepcionCaperucitaRoja.PERCEPCION_ARBOL)
          break;
      }
      break;
    }

    return lineaDeVista;
  }

  /**
   * La carga se da de manear transpuesta porque si no es muy dificil cargarlo
   * 
   * Mapa: //////////////////////////////////////////////////////////////////////
   * 2 0 0 0 1 0 0 2 1 //////////////////////////////////////////////////////////
   * 0 1 0 0 0 0 0 0 0 //////////////////////////////////////////////////////////
   * 0 0 0 0 0 2 1 0 0 //////////////////////////////////////////////////////////
   * 1 1 0 0 0 1 0 0 0 //////////////////////////////////////////////////////////
   * 0 1 1 0 0 0 0 0 0 //////////////////////////////////////////////////////////
   * 0 3 1 1 1 0 1 0 1 //////////////////////////////////////////////////////////
   * 0 0 0 1 0 0 0 0 1 //////////////////////////////////////////////////////////
   */
  public static ArrayList<ArrayList<Integer>> makeMap(boolean invisible) {
    ArrayList<ArrayList<Integer>> mapa = new ArrayList<>();
    mapa.add(makeRow(2, 0, 0, 1, 0, 0, 0));
    mapa.add(makeRow(0, 1, 0, 1, 1, 3, 0));
    mapa.add(makeRow(0, 0, 0, 0, 1, 1, 0));
    mapa.add(makeRow(0, 0, 0, 0, 0, 1, 1));
    mapa.add(makeRow(1, 0, 0, 0, 0, 1, 0));
    mapa.add(makeRow(0, 0, 2, 1, 0, 0, 0));
    mapa.add(makeRow(0, 0, 1, 0, 0, 1, 0));
    mapa.add(makeRow(2, 0, 0, 0, 0, 0, 0));
    mapa.add(makeRow(1, 0, 0, 0, 0, 1, 1));
    if (invisible) {
      for (ArrayList<Integer> fila : mapa) {
        for (Integer cell : fila) {
          if (cell == PercepcionCaperucitaRoja.PERCEPCION_DULCE)
            cell = 0;
          if (cell == PercepcionCaperucitaRoja.PERCEPCION_LOBO)
            cell = 0;
        }
      }
    }
    return mapa;
  };

  public static ArrayList<Integer> makeRow(Integer... values) {
    return new ArrayList<Integer>(Arrays.asList(values));
  }
}
