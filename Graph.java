import java.util.*;


public class Graph implements GraphInterface<Town,Road> {
//vertex= town
//edges= road
	/*private LinkedList<Object> adjLists[];*/
	/*private DisctionaryListInterface<T, Town>vertices*/
	
	//unordered set for towns and roads(functions as the adjacency List/set
	private Set<Town> vertex=new HashSet<Town>();
	private Set<Road> edge= new HashSet<Road>();
	
	 /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		if(sourceVertex==null || destinationVertex==null) {
			return null;
		}
		//enhanced loop to go through road set 
		for (Road item:edge) {
			if(item.contains(destinationVertex) && (item.contains(sourceVertex))) {
				return item;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		if(sourceVertex==null || destinationVertex==null) {
			throw new NullPointerException();
		}
		Road inputEdge= new Road(sourceVertex,destinationVertex,weight,description);	
		edge.add(inputEdge);
		return inputEdge;
	}
	 /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
	    if(v==null) {
	    	throw new NullPointerException("No town");
	    }
	    if(vertex.contains(v)) {
	    	return false;
	    }
	    else {
	     vertex.add(v);
	     return true;}
	    }
	

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		for (Road item:edge) {
			if(item.contains(destinationVertex) && item.contains(sourceVertex)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		if(vertex.contains(v)==true) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> reSet=new HashSet<Road>(edge);
		return reSet;	
	}
	 /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		if(this.vertex.contains(vertex)==false) {
			throw new IllegalArgumentException();
		}
		//roads are edges so a road set is used
		Set<Road> touchingEdge=new HashSet<Road>();
		//In terms of a set, the edge is considered touching 
		//if a town is seen at the start or end of a road
		//enhanced loop to size of road set
		for (Road item:edge) {
			if(item.contains(vertex)){
				touchingEdge.add(item);
			}
		}		
		return touchingEdge;
	}
	 /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		if(description==null||weight>-1) {
			for (Road item:edge) {
				if(item.contains(destinationVertex)&&(item.contains(sourceVertex))){
					edge.remove(item);
					return item;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		if(v==null){
			return false;
		}
		if(edge.contains(v)){
			return false;
		}
		vertex.remove(v);
		return true;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		Set<Town> reSet=new HashSet<Town>(vertex);
		return reSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		dijkstraShortestPath(sourceVertex);
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}