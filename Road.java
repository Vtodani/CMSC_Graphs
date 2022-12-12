import java.util.*;
public class Road implements Comparable<Road> {
	
	private String name;
	private int degrees;
	//location to approach
	private Town destination;
	//location from departure
	private Town source;
	
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}

	
	public Road(Town source,Town destination,int degrees,String name) {
		this.source=source;
		this.destination=destination;
		this.name=name;
		this.degrees=degrees;	
	}
	
	
	public Road(Town source,Town destination,String name) {
		this.source=source;
		this.destination=destination;
		this.name=name;		
		degrees=1;
	}
	public boolean equals(Object r) {
		if(r==null) {
			return false;
		}
		Road compare=(Road) r;
		if(this.destination.equals(compare.getDestination()) 
				&& source.equals(compare.getSource())) {
			return true;
		}
		return false;
	}
	
	public Town getSource() {
		return source;
	}
	
	public Town getDestination() {
		return destination;
	}
	public int getWeight() {
		return degrees;
	}
	public boolean contains(Town town) {
		if(source.getName().compareTo(town.getName())==0 ||
				destination.getName().equals(town.getName())) {
			
			return true;
		}
		return false;
	}
	public String getName(){
		return name;
	}
	
	public String toString() {
		return name;	
	}


	
}
