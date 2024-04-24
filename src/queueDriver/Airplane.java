package queueDriver;

/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 *
 * @author (sdb)
 * @version (2020)
 */
public class Airplane implements Comparable
{
    int flight;
    int arrivalTime;
    int fuelLevel;       // gallons of jet fuel remaining

    public Airplane(int arrival, int fuel, int flight)
    {
        arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println(this);
    }

    public String toString()
    {
        return "[Flight: " + flight + ", Arrival: " + arrivalTime + ", Fuel: " + fuelLevel + " gal]";
    }

    public int compareTo(Object obj)
    {
        Airplane other = (Airplane) obj;
        int diff = other.fuelLevel - this.fuelLevel;
        int diffArrival = other.arrivalTime - this.arrivalTime;

        if(other.fuelLevel != this.fuelLevel)
        {
            return diff;
        }
        return diffArrival;

//        if(this.fuelLevel < 4 && other.fuelLevel >= 4)
//        {
//            return 1;
//        }
//        else if(this.fuelLevel < 4 && other.fuelLevel < 4)
//        {
//            if(this.fuelLevel < other.fuelLevel)
//            {
//                return 1;
//            }
//            else if(this.fuelLevel > other.fuelLevel)
//            {
//                return -1;
//            }
//            else if(this.fuelLevel == other.fuelLevel)
//            {
//                if(this.arrivalTime < other.arrivalTime)
//                {
//                    return 1;
//                }
//                else
//                {
//                    return -1;
//                }
//            }
//        }
//        else if(this.fuelLevel >= 4 && other.fuelLevel < 4)
//        {
//            return -1;
//        }
//        else
//        {
//            if(this.arrivalTime > other.arrivalTime)
//            {
//                return -1;
//            }
//            else
//            {
//                return 1;
//            }
//        }
//        return 0;
    }
}