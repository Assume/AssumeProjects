/*
 * Decompiled with CFR 0_118.
 */

package org.assume.test.Calc_source_from_cfr.data.equipment;


import java.util.Random;

import org.assume.test.Calc_source_from_cfr.data.Player;

public enum SpecialWeapon implements Weapon
{
    NONE("None", 999, 1.0, 1.0, new int[]{0, 0, 0}){

        @Override
        public int attack(Random rng, Player attacker, Player defender) {
            return 0;
        }
    }
    ,
    DRAGON_DAGGER("Dragon dagger", 25, 1.25, 1.15, new int[]{40, 40, 0}){

        @Override
        public int attack(Random rng, Player attacker, Player defender) {
            attacker.setCurrentWeapon(this);
            attacker.useSpecStyle();
            int res = 0;
            int ar = rng.nextInt(attacker.getAtkRating() + 1);
            int dr = rng.nextInt(defender.getDefRating() + 1);
            res += ar > dr ? rng.nextInt(attacker.getMaxHit() + 1) : 0;
            ar = rng.nextInt(attacker.getAtkRating() + 1);
            dr = rng.nextInt(defender.getDefRating() + 1);
            attacker.useNormalStyle();
            return res += ar > dr ? rng.nextInt(attacker.getMaxHit() + 1) : 0;
        }
    }
    ,
    ABYSSAL_DAGGER("Abyssal dagger", 50, 1.25, 0.85, new int[]{75, 75, 0}){

        @Override
        public int attack(Random rng, Player attacker, Player defender) {
            attacker.setCurrentWeapon(this);
            attacker.useSpecStyle();
            int res = 0;
            int ar = rng.nextInt(attacker.getAtkRating() + 1);
            int dr = rng.nextInt(defender.getDefRating() + 1);
            if ((res += ar > dr ? rng.nextInt(attacker.getMaxHit() + 1) : 0) > 0) {
                ar = rng.nextInt(attacker.getAtkRating() + 1);
                res += ar > (dr = rng.nextInt(defender.getDefRating() + 1)) ? rng.nextInt(attacker.getMaxHit() + 1) : 0;
            }
            attacker.useNormalStyle();
            return res;
        }
    };
    
    private final String name;
    private final int reqSpecEnergy;
    private final double specAccMod;
    private final double specDmgMod;
    private final int[] bonuses;

    private /* varargs */ SpecialWeapon(String name, int reqSpecEnergy, double specAccMod, double specDmgMod, int ... bonuses) {
        this.name = name;
        this.reqSpecEnergy = reqSpecEnergy;
        this.specAccMod = specAccMod;
        this.specDmgMod = specDmgMod;
        this.bonuses = bonuses;
    }

    @Override
    public int[] getBonuses() {
        return this.bonuses;
    }

    @Override
    public double getAccMod() {
        return this.specAccMod;
    }

    @Override
    public double getDmgMod() {
        return this.specDmgMod;
    }

    public String toString() {
        return this.name;
    }

    public int getReqSpecEnergy() {
        return this.reqSpecEnergy;
    }

}

