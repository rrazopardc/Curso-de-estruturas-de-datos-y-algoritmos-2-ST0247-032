import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Chavarria
 */
public class DigraphAL extends Digraph {
	// complete...
	ArrayList<ArrayList<Pair<Integer, Integer>>> list;

	public DigraphAL(int size) {
		super(size);
		// complete...
		list = new ArrayList<>(size);
		for (int i = 0; i < size; ++i)
			list.add(i, new ArrayList<>());
	}

        @Override
	public void addArc(int source, int destination, int weight) {
		// complete...
		// recuerde: grafo dirigido!
		list.get(source).add(Pair.makePair(destination, weight));
	}

        @Override
	public ArrayList<Integer> getSuccessors(int vertex) {
		// complete...
		ArrayList<Integer> s = new ArrayList<>(list.get(vertex).size());
		for (Pair<Integer, Integer> p : list.get(vertex))
			s.add(p.first);
		if (s.isEmpty())
			return null;
		Collections.sort(s);
		return s;
	}

        @Override
	public int getWeight(int source, int destination) {
		// complete...
		for (Pair<Integer, Integer> p : list.get(source))
			if (p.first == destination)
				return p.second;
		return 0;
	}

}