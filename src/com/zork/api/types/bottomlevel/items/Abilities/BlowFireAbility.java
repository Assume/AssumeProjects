package com.zork.api.types.bottomlevel.items.Abilities;

import com.zork.api.types.bottomlevel.game.Game;

public class BlowFireAbility implements Abilities {
	public static final String DESCRIPTION = "the BLOWFIREABILITY: blow fire at your enemies and increase your attack strength";
	
	public static final int STRENGTH_INCREASE = -10;
	
	@Override
	public void giveAbility() {
		Game.getGame().getPlayer().incrementBaseAttackStrength(STRENGTH_INCREASE);
		System.out.println("You can now blow fire at your enemies.");
	}
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	

}
