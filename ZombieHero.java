
class ZombieHero extends Undead{

	ZombieHero(Hero corpse){
		super("Zombie "+corpse.tag(),corpse.hasHP()[1],corpse.isAt());
	}

}
