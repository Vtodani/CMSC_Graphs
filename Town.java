import java.util.*;
public class Town implements Comparable<Town> {
    private String name;
	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		if(name.compareTo(o.getName())==0) {
			return 0;
		}
		return 1;
	}

	public Town(String name) {
		this.name=name;
	}
	
	
	public Town(Town templateTown) {
		this.name=templateTown.getName();
		
	}
	
	public int hashCode() {
		int towncode=name.hashCode();
		return towncode;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Object obj) {
		Town compare=(Town) obj;
		if(name.equals(compare.getName())) {
			return true;
		}
		return false;
	}
	public String toString() {
		return this.name;	
	}
}
