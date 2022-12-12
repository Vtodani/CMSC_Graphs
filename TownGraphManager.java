import java.io.*;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
	private ArrayList<Road> allRoads;
	private ArrayList<Town> allTowns;
    private Graph townGraph=new Graph();
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		//call town constructor to pass String
		Town addTown1=new Town(town1);
		Town addTown2=new Town(town2);
		townGraph.addEdge(addTown1,addTown2,weight,roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		Town addTown1=new Town(town1);
		Town addTown2=new Town(town2);
		Road returnRoad=townGraph.getEdge(addTown1,addTown2);
		return returnRoad.getName();
	}

	
	@Override
	public ArrayList<String> allRoads() {
		Set<Road> allRoad=townGraph.edgeSet();
		//pass set into arraylist
		allRoads=new ArrayList<Road>(allRoad);
		ArrayList<String> output=new ArrayList<>();
		Collections.sort(allRoads);
		for	(int i=0;i<allRoads.size();i++) {	
		output.add(allRoads.get(i).getName());
		}
		return output;
	}
	
	@Override
	public ArrayList<String> allTowns() {
		Set<Town> allTown=townGraph.vertexSet();
		//pass set into arraylist
		allTowns=new ArrayList<Town>(allTown);
		ArrayList<String> output=new ArrayList<>();
		Collections.sort(allTowns);
		for	(int i=0;i<allTowns.size();i++) {	
		output.add(allTowns.get(i).getName());
		}
		return output;
	}
	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		Town addTown1=new Town(v);
		townGraph.addVertex(addTown1);
		return true;
	}

	@Override
	public Town getTown(String name) {
		Set<Town> allTown=townGraph.vertexSet();
		allTowns=new ArrayList<Town>(allTown);
		for(int i=0; i<allTowns.size(); i++) {
			if(name.equals(allTowns.get(i).getName())) {
				return allTowns.get(i);
			}
			
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		Town addTown=new Town(v);
		if (townGraph.containsVertex(addTown)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		Town addTown1=new Town(town1);
		Town addTown2=new Town(town2);
		if(townGraph.containsEdge(addTown1,addTown2)) {
			return true;
		}
		return false;
	}


	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town addTown1=new Town(town1);
		Town addTown2=new Town(town2);
		if (townGraph.getEdge(addTown1,addTown2)==null){
			return false;
		}
		townGraph.removeEdge(addTown1,addTown2, 0, road);
		return true;
	}

	@Override
	public boolean deleteTown(String v) {
		Town addTown=new Town(v);
		return townGraph.removeVertex(addTown);
	}


	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		Town addTown1=new Town(town1);
		Town addTown2=new Town(town2);
		return townGraph.shortestPath(addTown1,addTown2);
	}

	public void populateTownGraph(File selectedFile) {
		// TODO Auto-generated method stub
	}

}
