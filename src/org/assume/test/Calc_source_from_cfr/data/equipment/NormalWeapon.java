/*
 * Decompiled with CFR 0_118.
 */

package org.assume.test.Calc_source_from_cfr.data.equipment;

import java.util.Random;

import org.assume.test.Calc_source_from_cfr.data.Player;

public enum NormalWeapon implements Weapon
{
    NONE("None", 0, 0, 0),
    TENTACLE_WHIP("Tentacle Whip", 90, 86, 0),
    ABYSSAL_WHIP("Abyssal Whip", 82, 82, 0),
    DRAGON_SCIMITAR("Dragon Scimitar", 67, 66, 1),
    DRAGON_DAGGER("Dragon Dagger", 40, 40, 0);
    
    private String name;
    private int[] bonuses;

    private /* varargs */ NormalWeapon(String name, int ... bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    @Override
    public int[] getBonuses() {
        return this.bonuses;
    }

    @Override
    public int attack(Random rng, Player attacker, Player defender) {
        attacker.setCurrentWeapon(this);
        int ar = rng.nextInt(attacker.getAtkRating() + 1);
        int dr = rng.nextInt(defender.getDefRating() + 1);
        return ar > dr ? rng.nextInt(attacker.getMaxHit() + 1) : 0;
    }

    public String toString() {
        return this.name;
    }
}

