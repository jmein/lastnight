
public class ZombieHero extends Zombie{
	
	ZombieHero(Hero corpse){
		super(corpse.location);
		this.name=("Zombie " + corpse.name);
		this.health = this.maxHealth = corpse.maxHealth;
	}
	
}
