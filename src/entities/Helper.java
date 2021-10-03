package entities;

import java.util.*;

public class Helper {
    Map<Integer, City> cities = new HashMap<>();
    Set<Road> roads = new HashSet<>();
    public void addCity(City city){
        cities.put( city.getId(),city);
    }
    public void addRoad(Road road){
        roads.add(road);
        LinkedList<City> cityList = road.getCityList();
        for(int city : road.getCities()){
            cityList.add(cities.get(city));
            ((City)cities.get(city)).getRoads().add(road);
        }
    }
    public HashSet<ArrayList<RoadCity>> getPath(int from , int to ){
        HashSet<ArrayList<RoadCity>> list = new HashSet<>();

        getPath(from ,to , new ArrayList<RoadCity>() , list);
        return list;
    }
    public void removeCity(int id){
        cities.remove(id);
        for(Road road : roads){
            int index = road.getCities().indexOf(id);
            if (index>-1) {
                road.getCities().remove(index);
                road.getCityList().remove(index);
            }
        }

    }
    public void removeRoad(int id){
        Iterator<Road> iterator = roads.iterator();
        while(iterator.hasNext()){
            Road road = iterator.next();
            if(road.getId()==id) {
                iterator.remove();
                for (Map.Entry<Integer, City> entry : cities.entrySet()){
                    entry.getValue().getRoads().remove(road);
                }
            }
        }

    }

    public void getPath(int from , int to , ArrayList<RoadCity>  roadCities , HashSet<ArrayList<RoadCity> >  results){
        if(from ==to)
            return;
        for(Road road : cities.get(from).getRoads()){
                RoadCity roadCity = new RoadCity(road , from , to);
                if(road.getsFromTo(from , to) && !roadCities.contains(roadCity)) {
                    ArrayList<RoadCity> newRoadCities = new ArrayList<>(roadCities);
                    newRoadCities.add(roadCity);
                    results.add(newRoadCities);
                }
                for (City city : road.MultiRoadCitiesFrom(from , to) ) {
                    roadCity = new RoadCity(road , from , city.getId() );
                    ArrayList<RoadCity> newRoadCities = new ArrayList<>(roadCities);
                    if(!roadCities.contains(roadCity)){
                    newRoadCities.add(roadCity);
                    getPath(city.getId(), to, newRoadCities , results);
                }
            }

        }
    }
}
