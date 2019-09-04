import java.util.ArrayList;
import java.util.Collections;

public class PokerHand {

    /*Task

    Create a poker hand that has a method to compare itself to another poker hand:

    Result PokerHand.compareWith(PokerHand hand);
    A poker hand has a constructor that accepts a string containing 5 cards:

    PokerHand hand = new PokerHand("KS 2H 5C JD TD");*/

   /* The characteristics of the string of cards are:

    Each card consists of two characters, where
    The first character is the value of the card: 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce)
    The second character represents the suit: S(pades), H(earts), D(iamonds), C(lubs)
    A space is used as card separator between cards*/

    /* Notes

    Apply the Texas Hold'em rules for ranking the cards.
    Low aces are NOT valid in this kata.
    There is no ranking for the suits.*/

    String hand;

    public enum Result { TIE, WIN, LOSS }

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public String getHand() {
        return hand;
    }

    public ArrayList<Integer> toInt(String handToInt){

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < handToInt.length(); i++) {
            if (handToInt.charAt(i) == 'T')
                arrayList.add(10);
            else if (handToInt.charAt(i) == 'J')
                arrayList.add(11);
            else if (handToInt.charAt(i) == 'Q')
                arrayList.add(12);
            else if (handToInt.charAt(i) == 'K')
                arrayList.add(13);
            else if (handToInt.charAt(i) == 'A')
                arrayList.add(14);
            else arrayList.add((Character.getNumericValue(handToInt.charAt(i))));
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        return arrayList;
    }

    public String getValues(){
        StringBuilder sb = new StringBuilder();
        String[] cards = hand.split(" ");
        for(int i = 0; i < cards.length; i++) {
            sb.append(cards[i].charAt(0));
        }
        return sb.toString();
    }

    public Result compareWith(PokerHand hand) {
        return Result.TIE;
    }

    public int isPair(ArrayList<Integer> cardInts){

        int result = 0;

        for(int i = 0; i < cardInts.size(); i++) {
            Integer card = cardInts.get(i);
            if(cardInts.stream().filter(x -> x.equals(card)).count() == 2) {
                result = card * 2;
                cardInts.remove(card); cardInts.remove(card);
            }
        }
        return result;
    }

    public int isTwoPairs(ArrayList<Integer> cardInts){
        int result = isPair(cardInts);
        result += isPair(cardInts);
        return result;
    }

    public int isThreeOfAKind(ArrayList<Integer> cardInts){

        int result = 0;

        for(int i = 0; i < cardInts.size(); i++) {
            Integer card = cardInts.get(i);
            if(cardInts.stream().filter(x -> x.equals(card)).count() == 3) {
                result = card * 3;
                cardInts.remove(card); cardInts.remove(card); cardInts.remove(card);
            }
        }
        return result;
    }

    public int isStraight(ArrayList<Integer> cardInts){
        int result = 0;
        return result;
    }

    public int isFlush(ArrayList<Integer> cardInts){
        int result = 0;
        return result;
    }

    public int isFullHouse(ArrayList<Integer> cardInts){
        int result = 0;
        return result;
    }

    public int isFourOfAKind(ArrayList<Integer> cardInts){

        int result = 0;

        for(int i = 0; i < cardInts.size(); i++) {
            Integer card = cardInts.get(i);
            if(cardInts.stream().filter(x -> x.equals(card)).count() == 4){
                result = card * 4;
                cardInts.remove(card); cardInts.remove(card); cardInts.remove(card); cardInts.remove(card);
            }

        }
        return result;
    }

    public int isStraightFlush(ArrayList<Integer> cardInts){
        int result = 0;
        return result;
    }

    public int isRoyalFlush(ArrayList<Integer> cardInts){
        int result = 0;
        return result;
    }

    public static void main(String[] args) {

        PokerHand pokerHand = new PokerHand("KS KH 2C JD TD");

        String str = pokerHand.getValues();

        System.out.println(str);

        ArrayList<Integer> arrayList = pokerHand.toInt(str);

        System.out.println(pokerHand.isPair(arrayList));
    }

}