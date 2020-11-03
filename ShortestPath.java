/**
 * Class determines the path from start to destination
 * @author Hemming
 *
 */
public class ShortestPath {
CityMap cityMap;

/**
 * Constructor finds the shortest path between the start location and the destination
 * @param theMap User's specified object of type cityMap
 */
public ShortestPath(CityMap theMap) {
	 cityMap = theMap;
	}
	public void findShortestPath() {
		try {
	 OrderedCircularArray<MapCell> list = new OrderedCircularArray<MapCell>();
	 MapCell Current_Cell = cityMap.getStart();
	 list.insert(Current_Cell,0);
	 Current_Cell.markInList();
	 while (!list.isEmpty() && !Current_Cell.isDestination()) {
	  MapCell S = list.getSmallest();
	  S.markOutList();
	  if(S.isDestination()) {
	   System.out.println("Path found of length " + (S.getDistanceToStart()+1));
	   break;
	  }
	  
	  MapCell C = nextCell(S);
	  if (C == null) {
		   S = S.getPredecessor();
		   list.insert(S, S.getDistanceToStart()-1);
	  }
	  else {
	   int D = 1 + S.getDistanceToStart();
	   if (C.getDistanceToStart() > D) {
	    C.setDistanceToStart(D);
	    C.setPredecessor(S);
	    int P = C.getDistanceToStart();
	    if (C.isMarkedInList() && P < list.getValue(C)) {
	     list.changeValue(C,P);
	    }
	    if(! C.isMarkedInList()) {
	     list.insert(C, P);
	     C.markInList();
	    }
	   }
	  }
	 }
	}
		catch (Exception e) {
			System.out.println("Path not found");
		}
	}


/**
 * Method finds the next cell to travel to
 * @param cell The user's starting cell from which to move from
 * @return Neighbour_Cell The new location to move to
 * @return Return_Container The variable storing null
 */
private MapCell nextCell(MapCell cell) {
	MapCell Return_Container = null;
	for (int k=0 ; k < 4 ; k++ ) {
		MapCell Neighbour_Cell = cell.getNeighbour(k);
		if(Neighbour_Cell != null && Neighbour_Cell.isDestination()) {
			if (cell.isIntersection())
				return Neighbour_Cell;
				if (cell.isStart()) 
				return Neighbour_Cell;
				if (k==0 && cell.isNorthRoad())
					return Neighbour_Cell;
				if (k==1 && cell.isEastRoad())
					return Neighbour_Cell;
				if (k==2 && cell.isSouthRoad())
					return Neighbour_Cell;
				if (k==3 && cell.isWestRoad())
					return Neighbour_Cell;
			}
		if (Neighbour_Cell != null && Neighbour_Cell.isIntersection() && !Neighbour_Cell.isMarked()) {
			if (cell.isIntersection())
			return Neighbour_Cell;
			if (cell.isStart()) 
			return Neighbour_Cell;
			if (k==0 && cell.isNorthRoad())
				return Neighbour_Cell;
			if (k==1 && cell.isEastRoad())
				return Neighbour_Cell;
			if (k==2 && cell.isSouthRoad())
				return Neighbour_Cell;
			if (k==3 && cell.isWestRoad())
				return Neighbour_Cell;
		}
		if (Neighbour_Cell != null && !Neighbour_Cell.isMarked() && (Neighbour_Cell.isNorthRoad() || Neighbour_Cell.isEastRoad() || Neighbour_Cell.isSouthRoad() || Neighbour_Cell.isWestRoad())) {
			if (k==0 && Neighbour_Cell.isNorthRoad()) {
			return Neighbour_Cell;
			}
			else if (k==1 && Neighbour_Cell.isEastRoad()) {
			return Neighbour_Cell;
			}
			else if (k==2 && Neighbour_Cell.isSouthRoad()) {
			return Neighbour_Cell;
			}
			else if (k==3 && Neighbour_Cell.isWestRoad()) {
			return Neighbour_Cell;
			}
		}
		

}
	return Return_Container;
}
}


