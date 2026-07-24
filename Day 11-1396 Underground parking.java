import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    Map<Integer, CheckIn> checkInMap = new HashMap<>();
    Map<String, int[]> tripMap = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn c = checkInMap.get(id);

        String route = c.station + "-" + stationName;

        int[] trip = tripMap.getOrDefault(route, new int[2]);

        trip[0] += t - c.time;   // total travel time
        trip[1]++;               // number of trips

        tripMap.put(route, trip);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        int[] trip = tripMap.get(startStation + "-" + endStation);

        return (double) trip[0] / trip[1];
    }
}
