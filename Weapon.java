class Weapon extends Item {

    private boolean onehand;
    private int range;

    Weapon(String name, boolean small, int range) {
        super(name);
        this.onehand = small;
        this.range = range;
    }
    Weapon(String name, boolean small) {Weapon(name,true,0);}
    Weapon(String name) {Weapon(name,true);}

    int shoots() {return this.range;}

}
