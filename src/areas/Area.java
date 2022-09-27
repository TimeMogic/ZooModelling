package areas;

import java.util.ArrayList;

public abstract class Area implements IArea{

    private ArrayList<Integer> adjacentAreas;

    public Area() {
        this.adjacentAreas = new ArrayList<>();
    }

    @Override
    public ArrayList<Integer> getAdjacentAreas() {
        return adjacentAreas;
    }

    @Override
    public void addAdjacentArea(int areaId) {
        if (this.adjacentAreas.contains(areaId)) {
            return;
        }
        this.adjacentAreas.add(areaId);
    }

    @Override
    public void removeAdjacentArea(int areaId) {
        this.adjacentAreas.remove((Integer) areaId);
    }
}
