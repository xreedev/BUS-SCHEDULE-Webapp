import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Reservation {
    public void seatUpdater( ArrayList<Bus> bus ,ArrayList<Reserve> res) {
        ArrayList<String> uniqBusList = new ArrayList<>();
        for (Reserve var : res) {
            uniqBusList.add(var.getBusName());
        }
        Set<String> uniqBusSet = new HashSet<>(uniqBusList);
        for(String busname:uniqBusSet)
        {
            for(Reserve varRes:res)
            {
                if(varRes.getBusName().equals(busname))
                {
                    if(varRes.getAction().equals("Reserve"))
                    {
                        for(Bus newbus:bus)
                        {
                            if(newbus.getBusName().equals(varRes.getBusName()))
                            {
                                newbus.setSeatcnt(String.valueOf(Integer.parseInt(newbus.getSeatcnt())+1));
                            }
                        }
                    }
                    if(varRes.getAction().equals("Cancel"))
                    {
                        for(Bus newbus:bus)
                        {
                            if(newbus.getBusName().equals(varRes.getBusName()))
                            {
                                newbus.setSeatcnt(String.valueOf(Integer.parseInt(newbus.getSeatcnt())-1));
                            }
                        }
                    }
                }
            }
        }

    }
}