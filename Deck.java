import java.util.ArrayList;

class Deck{

    private ArrayList<Card> cards;

    Deck(){this.cards = new ArrayList<Card>();}

    int size() {return cards.size();}
    Card cdAt(int i) {return cards.get(i);}
    Card topCd() {return cards.get(cards.size()-1);}
    Card botCd() {return cards.get(0);}

    void cut(int n){	//	cuts the deck n cards from the top
        int top = cards.size() - n;
        ArrayList<Card> stack = new ArrayList<Card>(cards.size());
        for(int i = 0; i<n; i++){
            stack.add(i, cards.get(top+i));
        }
        for(int i=0; i<top; i++){
            stack.add(n+i, cards.get(i));
        }
        cards = stack;
    }

    void mix(boolean cut){		//	a shuffling algorithm
        int half = cards.size()/2;
        ArrayList<Card> half1 = new ArrayList<Card>(half);
        ArrayList<Card> half2 = new ArrayList<Card>(half);
        for(int i = 0; i < half; i++){
            half1.add(cards.get(i));
            half2.add(cards.get(i+half));
        }
        for(int i = 0; i < half; i++){
            cards.set(2*i, half1.get(i));
            cards.set(2*i+1, half2.get(i));
        }
        if (cut){cut(cards.size()/3);}
    }
    void mix() {mix(false);}
    void mix(int n, boolean cut) {for(int i=0;i<n;i++) {this.mix(cut);} }
    void mix(int n) {for(int i=0;i<n;i++) {this.mix();} }
    
    void get(Card card, int place) {this.cards.add(place, card);}
    void get(Card card) {this.cards.add(card);}
    void lose(Card card) {this.cards.remove(card);}

    void deal(Card card, Deck deck) {
        deck.get(card);
        this.lose(card);
    }
    void lowDeal(Card card, Deck deck) {
        deck.get(card,0);
        this.lose(card);
    }
    void dealTo(Deck deck, boolean fromTop, boolean toTop, int num) {
        if(fromTop) {
            if(toTop) {
                for(int i=0; i<num; i++) {this.deal(this.topCd(),deck);}
            }
            else {
                for(int i=0; i<num; i++) {this.lowDeal(this.botCd(),deck);}
            }
        }
        else {
            if(toTop) {
                for(int i=0; i<num; i++) {this.deal(this.topCd(),deck);}
            }
            else {
                for(int i=0; i<num; i++) {this.lowDeal(this.botCd(),deck);}
            }
        }
    }
    
    void dealTo(Deck deck, int num) {}
}
