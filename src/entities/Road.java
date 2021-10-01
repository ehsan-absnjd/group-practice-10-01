package entities;

import java.util.ArrayList;
import java.util.LinkedList;

public class Road {
    private int id;
    private String name;
    private int from;
    private int to;
    private LinkedList<Integer> cities;
    private ArrayList<City> cityList = new ArrayList<>() ;
    private int speedLimit;
    private int length;
    private boolean biDirectional;
    public Road(int id, String name, int from, int to,
                LinkedList<Integer> cities,
                int speedLimit, int length , boolean biDirectional) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.cities = (cities != null) ? cities : new LinkedList<>();
        this.speedLimit = speedLimit;
        this.length = length;
        this.cities.add(0,from);
        this.cities.add(to);
        this.biDirectional = biDirectional;
    }

    public LinkedList<Integer> getCities() {
        return cities;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public boolean getsFromTo(City from, City to) {
        if (cityList.contains(from) && cityList.contains(to))
            if(cityList.indexOf(from)<cityList.indexOf(to))
                return true;

        return false;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public ArrayList<City> MultiRoadCitiesFrom(City fromCity) {
        int from = cityList.indexOf(fromCity);
        ArrayList<City> cities = new ArrayList<>();
        for (int i=from+1; i<cityList.size() ; i++ ){
            if( cityList.get(i).getRoads().size()>1 )
                cities.add(cityList.get(i));
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
}
