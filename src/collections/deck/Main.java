package collections.deck;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        var sortingAlgorithm = Comparator.comparing(Card::getRank)
                .thenComparing(Card::getSuit);

        //Collections.sort(deck, sortingAlgorithm);
        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Sorted Deck", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed:", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("deck Contains tens= " + deck.containsAll(tens));  // poor performance

        //new HashSet<>(deck).containsAll(tens)  //...for better performance

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("deck disjoint tens = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("kings disjoint tens = " + disjoint2);

        Collections.sort(deck, sortingAlgorithm);  // previously reversed deck is sorted again

        Card tenOfHeart = Card.getNumericCard(Card.Suit.HEART, 10);

        int foundIndex = Collections.binarySearch(deck, tenOfHeart, sortingAlgorithm);

        Card found = deck.get(foundIndex);

        int countHeart = Collections.frequency(deck, tenOfHeart);

        Card bestCard = Collections.max(deck, sortingAlgorithm);
        Card worstCard = Collections.min(deck, sortingAlgorithm);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));

        System.out.println("before rotation copied : "+copied);

        Collections.rotate(copied, 3);

        System.out.println("rotated copied : "+copied);

        Collections.rotate(copied, -3);

        System.out.println("reverse rotated copied : "+copied);

        int n = copied.size();

        for(int i=0; i<n; i++)
            Collections.swap(copied, i, n-1-i);

    }
}
