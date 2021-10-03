package entities;

import java.util.HashSet;
import java.util.Set;

public class City {
    private int id;
    private String name;
    private Set<Road> roads = new HashSet<>();

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Set<Road> getRoads() {
        return roads;
    }
}
