package entities;

import java.util.ArrayList;
import java.util.LinkedList;

public class Road {
    private int id;
    private String name;
    private int from;
    private int to;
    private LinkedList<Integer> citiesIntegerLinkedList;
    private LinkedList<City> cityList = new LinkedList<>() ;
    private int speedLimit;
    private int length;
    private boolean biDirectional;
    public Road(int id, String name, int from, int to,
                LinkedList<Integer> cities,
                int speedLimit, int length , boolean biDirectional) {
        this.id = id;
        this.name = name;
        citiesIntegerLinkedList = (cities != null) ? cities : new LinkedList<>();
        this.speedLimit = speedLimit;
        this.length = length;
        citiesIntegerLinkedList.add(0,from);
        citiesIntegerLinkedList.add(to);
        this.biDirectional = biDirectional;
    }

    public LinkedList<Integer> getCities() {
        return citiesIntegerLinkedList;
    }

    public int getId() {
        return id;
    }

    public boolean getsFromTo(int from, int to) {
        if (citiesIntegerLinkedList.contains(from) && citiesIntegerLinkedList.contains(to)) {
            if(biDirectional)
                return true;
            else if (citiesIntegerLinkedList.indexOf(from) < citiesIntegerLinkedList.indexOf(to))
                return true;
        }
        return false;
    }

    public LinkedList<City> getCityList() {
        return cityList;
    }

    public ArrayList<City> MultiRoadCitiesFrom(int from, int to) {
        int indexOfTo = citiesIntegerLinkedList.indexOf(to);
        int indexOfFrom = citiesIntegerLinkedList.indexOf(from);


        int upperLimit=(indexOfTo>indexOfFrom) ? indexOfTo : cityList.size() ;
        int lowerLimit=(indexOfTo>-1 && indexOfTo<indexOfFrom) ? indexOfTo : 0 ;
        ArrayList<City> cities = new ArrayList<>();

        for (int i=indexOfFrom+1; i<upperLimit ; i++ ){
            if( cityList.get(i).getRoads().size()>1 )
                cities.add(cityList.get(i));
        }
        if(biDirectional){
            for (int i=lowerLimit; i<indexOfFrom ; i++ ){
                if( cityList.get(i).getRoads().size()>1 )
                    cities.add(cityList.get(i));
            }
        }
        return cities;
    }

    @Override
    public String toString() {
        return "Road{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isBiDirectional() {
        return biDirectional;
    }
}
