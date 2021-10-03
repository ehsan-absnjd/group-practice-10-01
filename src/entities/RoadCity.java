package entities;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Objects;

public class RoadCity {
    private Road road;
    private int from;
    private int to;

    public RoadCity(Road road, int from, int to) {
        this.road = road;
        this.from = from;
        this.to = to;
    }

    public RoadCity(Road road, int from) {
        this.road = road;
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadCity roadCity = (RoadCity) o;
        if(!Objects.equals(road, roadCity.road) )
            return false;
        int fromIndex = road.getCities().indexOf(from);
        int toIndex = road.getCities().indexOf(to);
        int otherFromIndex = roadCity.road.getCities().indexOf(roadCity.from);
        int otherToIndex = roadCity.road.getCities().indexOf(roadCity.to);
        if(Math.min(fromIndex,toIndex)>Math.max(otherFromIndex,otherToIndex) ||
                Math.max(fromIndex,toIndex)<Math.min(otherFromIndex,otherToIndex)
        ) {
            return false;
        }else
            return true;
//        if(this.road.isBiDirectional() ){
//            this
//            return true;
//        }else
//            return from <= roadCity.from;
    }

    @Override
    public int hashCode() {
        return Objects.hash(road, from);
    }

    @Override
    public String toString() {
        return "RoadCity{" +
                "road=" + road +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
