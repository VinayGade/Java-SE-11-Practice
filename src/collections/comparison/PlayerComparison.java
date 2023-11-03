package collections.comparison;

import beans.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerComparison {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : ");
        footballTeam.forEach(player -> System.out.println(player.toString()));
        Collections.sort(footballTeam);
        System.out.println("After Sorting : ");
        footballTeam.forEach(player -> System.out.println(player.toString()));

        // Player Comparator
        Comparator<Player> byRanking = Comparator
                .comparingInt(Player::getRanking);

        // Seniority wise
        Comparator<Player> byAge = Comparator
                .comparing(Player::getAge).reversed();

        Comparator<Player> ageComparator = (x, y) -> y.getAge()-x.getAge();

        footballTeam.sort(byRanking);

        System.out.println("football players sorted w.r.t. ranking.");
        footballTeam.forEach(System.out::println);

        footballTeam.sort(byAge);

        System.out.println("football players sorted w.r.t. age.");
        footballTeam.forEach(System.out::println);
    }
}