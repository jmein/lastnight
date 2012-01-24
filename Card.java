
class Card{

    private String name;

    Card(String nomen){
        this.name = nomen;
    }

    public String tag(){return this.name;}
    public void rename(String nomen){this.name = nomen;}

}
