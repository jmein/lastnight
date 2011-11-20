
class ZombieHero extends Zombie{

	ZombieHero(Hero corpse){
		super(corpse.isAt());

		this.makeName("Zombie " + corpse.tag());
		this.setHP(corpse.hasHP()[1]);
	}

}
