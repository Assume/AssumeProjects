package com.zork.api.types.bottomlevel.items.Abilities;

import com.zork.api.types.bottomlevel.game.Game;

public class SuperhumanStrength implements Abilities {
	public static final String DESCRIPTION = "the ability of SUPERHUMANSTRENGTH: an increase in attack strength for one fight";
	public static final int ATTACK_STRENGTH_INCREASE = -30;
	
	@Override
	public void giveAbility() {
		Game.getGame().getPlayer().incrementBaseAttackStrength(ATTACK_STRENGTH_INCREASE);
		System.out.println("You now have the strength of a thousand you's. Enjoy it while it lasts.");
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	

}
