package zoo;

import animals.Animal;
import areas.Entrance;
import areas.Habitat;
import areas.IArea;
import dataStructures.CashCount;
import dataStructures.ICashCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Zoo implements IZoo {

    private HashMap<Integer,IArea> zooAreas;
    private int entranceFeePence;
    private CashCount cashSupply;

    public Zoo() {
        this.entranceFeePence = 0;
        this.cashSupply = new CashCount();
        this.zooAreas = new HashMap<>();
        Entrance entrance = new Entrance();
        this.zooAreas.put(0,entrance);
    }

    @Override
    public int addArea(IArea area) {
        if (area instanceof Entrance || this.zooAreas.containsValue(area)) {
            return -1;  //area can not be added
        } else {
            int newAreaId = 1;
            while (this.getArea(newAreaId) != null) {
                newAreaId++;
            }
            this.zooAreas.put(newAreaId,area);
            return newAreaId;
        }
    }

    @Override
    public boolean removeArea(int areaId) {
        if (areaId == 0 || this.getArea(areaId) == null) {
            return false;
        }else {
            zooAreas.remove(areaId);
            return true;
        }
    }

    @Override
    public IArea getArea(int areaId) {
        return this.zooAreas.get(areaId);
    }

    @Override
    public byte addAnimal(int areaId, Animal animal) {
        IArea area = this.getArea(areaId);
        if (!(area instanceof Habitat)) {
            return Codes.NOT_A_HABITAT;
        }
        return ((Habitat) area).putInAnimal(animal);
    }

    @Override
    public void connectAreas(int fromAreaId, int toAreaId) {
        if (fromAreaId != toAreaId) {
            getArea(fromAreaId).addAdjacentArea(toAreaId);
        }
    }

    @Override
    public boolean isPathAllowed(ArrayList<Integer> areaIds) {
        if (this.zooAreas.keySet().containsAll(areaIds)) {  //check for invalid ids
            for (int i = 0; i < areaIds.size() - 1; i++) {
                if (!this.getArea(areaIds.get(i)).getAdjacentAreas().contains(areaIds.get(i + 1))) {
                    return false;   //check if each area on the list leads to the next
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) {
        if (!this.isPathAllowed(areaIdsVisited)) {
            return null;
        } else {
            ArrayList<String> animalNames = new ArrayList<>();
            IArea area;
            for (int i = 0; i < areaIdsVisited.size(); i++) {
                area = getArea(areaIdsVisited.get(i));
                if (area instanceof Habitat) {
                    animalNames.addAll(((Habitat) area).getAnimalNames());
                }
            }
            return animalNames;
        }
    }

    @Override
    public Set<Integer> findUnreachableAreas() {
        Set<Integer> visited = new HashSet<>();
        dfs(0,visited);
        Set<Integer> unreachable = new HashSet<>(this.zooAreas.keySet());
        unreachable.removeAll(visited);
        return unreachable;
    }

    private void dfs(int v, Set<Integer> visited) {
        visited.add(v);
        ArrayList<Integer> adjacent = new ArrayList<>(this.zooAreas.get(v).getAdjacentAreas());
        for (int i = 0; i < adjacent.size(); i++) {
            if (!visited.contains(adjacent.get(i))) {
                dfs(adjacent.get(i),visited);
            }
        }
    }

    @Override
    public void setEntranceFee(int pounds, int pence) {
        this.entranceFeePence = (pounds * 100) + pence;
    }

    @Override
    public void setCashSupply(ICashCount coins) {
        this.cashSupply = (CashCount) coins;
    }

    @Override
    public ICashCount getCashSupply() {
        return this.cashSupply;
    }

    @Override
    public ICashCount payEntranceFee(ICashCount cashInserted) {
        int amountIn = ((CashCount) cashInserted).getValuePence();
        ICashCount change = new CashCount();
        if (amountIn < entranceFeePence) {
            return cashInserted;
        } else if (amountIn == entranceFeePence) {
            this.cashSupply.addCash(cashInserted);
            return change;
        } else {
            CashCount temp = new CashCount(this.cashSupply);
            temp.addCash(cashInserted);
            change = temp.findChange(amountIn - entranceFeePence);
            if (change == null) {
                return cashInserted;
            } else {
                this.cashSupply.addCash(cashInserted);
                this.cashSupply.subCash(change);
                return change;
            }
        }
    }
}
