package project.app.warzone.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
package project.app.warzone.Commands;
class Continent {
    private String continentName;
    private int bonus;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public Continent(String continentName, int bonus) {
        this.continentName = continentName;
        this.bonus = bonus;
    }

    // Getters and setters for continentName and bonus

    public String getContinentName() {
        return continentName;
    }

    public int getBonus() {
        return bonus;
    }

    public void setContinentName(String newContinentName) {
        continentName = newContinentName;
    }

    public void setBonus(int newBonus) {
        bonus = newBonus;
    }

    @Override
    public String toString() {
        return continentName;
    }
}

class Territory {
    private String territoryName;
    private int ownerId;
    private int numberOfArmies;
    private Continent continent;

    public Territory() {}

    public Territory(String territoryName, Continent continent, int ownerId, int numberOfArmies) {
        this.territoryName = territoryName;
        this.ownerId = ownerId;
        this.numberOfArmies = numberOfArmies;
        this.continent = continent;
    }

    public Territory(String territoryName, Continent continent) {
        this.territoryName = territoryName;
        this.continent = continent;
    }

    // Getters and setters for territoryName, ownerId, numberOfArmies, and continent

    public String getTerritoryName() {
        return territoryName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getNumberOfArmies() {
        return numberOfArmies;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setTerritoryName(String newTerritoryName) {
        territoryName = newTerritoryName;
    }

    public void setOwnerId(int newOwnerId) {
        ownerId = newOwnerId;
    }

    public void setNumberOfArmies(int newNumberOfArmies) {
        numberOfArmies = newNumberOfArmies;
    }

    public void setContinent(Continent newContinent) {
        continent = newContinent;
    }

    @Override
    public String toString() {
        return territoryName + " which belongs to " + continent.getContinentName();
    }
}

class Node {
    private Territory data;
    private List<String> E;

    public Node() {}

    public Node(Territory data) {
        this.data = new Territory(data.getTerritoryName(), data.getContinent());
        E = new ArrayList<>();
    }

    public Node(Node original) {
        data = new Territory(original.data);
        E = new ArrayList<>(original.E);
    }

    // Getters and setters for data and E

    public Territory getData() {
        return data;
    }

    public List<String> getE() {
        return E;
    }

    public void setData(Territory data) {
        this.data = data;
    }

    public void addEdge(String edge) {
        E.add(edge);
    }

    @Override
    public String toString() {
        return "The Node contains the following territory: " + data.getTerritoryName() +
                " and has " + E.size() + " edges.";
    }
}

class Map {
    private List<Node> V;
    private List<Continent> listOfContinents;

    public Map() {
        V = new ArrayList<>();
        listOfContinents = new ArrayList<>();
    }

    public Map(Map original) {
        V = new ArrayList<>();
        for (Node node : original.V) {
            V.add(new Node(node));
        }

        listOfContinents = new ArrayList<>();
        for (Continent continent : original.listOfContinents) {
            listOfContinents.add(new Continent(continent.getContinentName(), continent.getBonus()));
        }
    }

    // Getters for V and listOfContinents

    public List<Node> getV() {
        return V;
    }

    public List<Continent> getListOfContinents() {
        return listOfContinents;
    }

    // Inserting and connecting territories

    public void insertATerritory(Territory data) {
        V.add(new Node(data));
    }

    public void insertAndConnectTwoTerritories(Territory dataA, Territory dataB) {
        insertATerritory(dataA);
        insertATerritory(dataB);
        connectTwoNodes(V.get(V.size() - 1), V.get(V.size() - 2));
    }

    public static void connectTwoNodes(Node A, Node B) {
        String edgeName = A.getData().getTerritoryName() + B.getData().getTerritoryName();
        A.addEdge(edgeName);
        B.addEdge(edgeName);
    }

    // Other functions

    public boolean areConnected(Node A, Node B) {
        String possibleEdge1 = A.getData().getTerritoryName() + B.getData().getTerritoryName();
        String possibleEdge2 = B.getData().getTerritoryName() + A.getData().getTerritoryName();

        for (String edge : A.getE()) {
            if (edge.equals(possibleEdge1) || edge.equals(possibleEdge2)) {
                return true;
            }
        }

        return false;
    }
}