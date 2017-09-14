/*
 * Decompiled with CFR 0_118.
 */
package org.assume.test.Calc_source_from_cfr.data;

import java.util.Random;

public class Battle {
    private Player p1;
    private Player p2;
    double p1WinRate;
    double p2WinRate;
    double p1SpecWinRate;
    double p2SpecWinRate;
    private int iterations;

    public Battle(Player p1, Player p2, int iterations) {
        this.p1 = p1;
        this.p2 = p2;
        this.iterations = iterations;
    }

    public void simulate() {
        int p1Wins = 0;
        int p2Wins = 0;
        int p1SpecWins = 0;
        int p2SpecWins = 0;
        for (int i = 0; i < this.iterations * 2; ++i) {
            boolean p1_first;
            boolean spec = i > this.iterations;
            int p1_hp = this.p1.getHpLvl();
            int p2_hp = this.p2.getHpLvl();
            int p1_spec = 100;
            int p2_spec = 100;
            Random rng = new Random();
            boolean bl = p1_first = i % 2 == 0;
            while (p1_hp > 0 && p2_hp > 0) {
                if (p1_first ^= true) {
                    if (spec && p1_spec >= this.p1.getSpecWeapon().getReqSpecEnergy()) {
                        p2_hp -= this.p1.getSpecWeapon().attack(rng, this.p1, this.p2);
                        p1_spec -= this.p1.getSpecWeapon().getReqSpecEnergy();
                    } else {
                        p2_hp -= this.p1.getNormalWeapon().attack(rng, this.p1, this.p2);
                    }
                    if (p2_hp <= 0) continue;
                    if (spec && p2_spec >= this.p2.getSpecWeapon().getReqSpecEnergy()) {
                        p1_hp -= this.p2.getSpecWeapon().attack(rng, this.p2, this.p1);
                        p2_spec -= this.p2.getSpecWeapon().getReqSpecEnergy();
                        continue;
                    }
                    p1_hp -= this.p2.getNormalWeapon().attack(rng, this.p2, this.p1);
                    continue;
                }
                if (spec && p2_spec >= this.p2.getSpecWeapon().getReqSpecEnergy()) {
                    p1_hp -= this.p2.getSpecWeapon().attack(rng, this.p2, this.p1);
                    p2_spec -= this.p2.getSpecWeapon().getReqSpecEnergy();
                } else {
                    p1_hp -= this.p2.getNormalWeapon().attack(rng, this.p2, this.p1);
                }
                if (p1_hp <= 0) continue;
                if (spec && p1_spec >= this.p1.getSpecWeapon().getReqSpecEnergy()) {
                    p2_hp -= this.p1.getSpecWeapon().attack(rng, this.p1, this.p2);
                    p1_spec -= this.p1.getSpecWeapon().getReqSpecEnergy();
                    continue;
                }
                p2_hp -= this.p1.getNormalWeapon().attack(rng, this.p1, this.p2);
            }
            if (spec) {
                if (p1_hp > 0) {
                    ++p1SpecWins;
                    continue;
                }
                ++p2SpecWins;
                continue;
            }
            if (p1_hp > 0) {
                ++p1Wins;
                continue;
            }
            ++p2Wins;
        }
        this.p1WinRate = (double)p1Wins / (double)this.iterations * 100.0;
        this.p2WinRate = (double)p2Wins / (double)this.iterations * 100.0;
        this.p1SpecWinRate = (double)p1SpecWins / (double)this.iterations * 100.0;
        this.p2SpecWinRate = (double)p2SpecWins / (double)this.iterations * 100.0;
    }

    public double getP1WinRate() {
        return this.p1WinRate;
    }

    public double getP2WinRate() {
        return this.p2WinRate;
    }

    public double getP1SpecWinRate() {
        return this.p1SpecWinRate;
    }

    public double getP2SpecWinRate() {
        return this.p2SpecWinRate;
    }
}

