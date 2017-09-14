/*
 * Decompiled with CFR 0_118.
 */
package org.assume.test.Calc_source_from_cfr.data.equipment;
import java.util.Random;

import org.assume.test.Calc_source_from_cfr.data.Player;

public interface Weapon {
    public int[] getBonuses();

    default public int getAtkBonus() {
        return this.getBonuses()[0];
    }

    default public int getStrBonus() {
        return this.getBonuses()[1];
    }

    default public int getDefBonus() {
        return this.getBonuses()[2];
    }

    default public double getDmgMod() {
        return 1.0;
    }

    default public double getAccMod() {
        return 1.0;
    }

    public int attack(Random var1, Player var2, Player var3);
}

