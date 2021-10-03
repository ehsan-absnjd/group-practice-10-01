package entities;

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
        if(this.road.isBiDirectional() ){
            return true;
        }else
            return from >= roadCity.from;
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
