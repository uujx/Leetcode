class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Follow the rules
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++)
            index.add(i);
        
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        for (int card : deck) {
            res[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }
        
        return res;
    }
}
