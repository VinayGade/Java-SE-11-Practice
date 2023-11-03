package enums;

import beans.enums.PizzaStatus;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza  {

    private PizzaStatus status;

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery()+ " days");
    }

    public void deliver() {
        if (isDeliverable()) {
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                        (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    // EnumMap is a Map implementation that exclusively takes Enum as its keys.

    /*
    with HashMap, the type parameterization is sufficient, meaning we can get away with new HashMap<>().
    However, EnumMap requires the key type in the constructor.
    * */

    public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        EnumMap<PizzaStatus, List<Pizza>> pzByStatus =
                new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for (Pizza pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza> newPzList = new ArrayList<Pizza>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }


    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(PizzaStatus.READY);
        System.out.println("pizza dispatched ? "+testPz.isDeliverable());

        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        /*
        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);

        System.out.println(undeliveredPzs.size() == 3);

        List<Pizza> pizList = new ArrayList<>();
        Pizza piz1 = new Pizza();
        pz1.setStatus(PizzaStatus.DELIVERED);

        Pizza piz2 = new Pizza();
        pz2.setStatus(PizzaStatus.ORDERED);

        Pizza piz3 = new Pizza();
        pz3.setStatus(PizzaStatus.ORDERED);

        Pizza piz4 = new Pizza();
        pz4.setStatus(PizzaStatus.READY);

        pzList.add(piz1);
        pzList.add(piz2);
        pzList.add(piz3);
        pzList.add(piz4);

        EnumMap<PizzaStatus,List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
        System.out.println(map.get(PizzaStatus.DELIVERED).size() == 1);
        System.out.println(map.get(PizzaStatus.ORDERED).size() == 2);
        System.out.println(map.get(PizzaStatus.READY).size() == 1);

         */
    }
}
