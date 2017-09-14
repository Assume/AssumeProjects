/*
 * Decompiled with CFR 0_118.
 */
package org.assume.test.Calc_source_from_cfr.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.assume.test.Calc_source_from_cfr.data.equipment.NormalWeapon;
import org.assume.test.Calc_source_from_cfr.data.equipment.SpecialWeapon;
import org.assume.test.Calc_source_from_cfr.data.equipment.Weapon;

public class Player {
    private String name = "";
    private int atkLvl;
    private int strLvl;
    private int defLvl;
    private int hpLvl;
    private int rngLvl;
    private int magLvl;
    private int pryLvl;
    private int atkBonus;
    private int atkMod;
    private int strBonus;
    private int strMod;
    private int defBonus;
    private int defMod;
    private Style style = Style.ACCURATE;
    private Style normalStyle = Style.ACCURATE;
    private Style specStyle = Style.ACCURATE;
    private Weapon currentWeapon = NormalWeapon.NONE;
    private NormalWeapon normalWeapon = NormalWeapon.NONE;
    private SpecialWeapon spec = SpecialWeapon.NONE;

    public Player(String name, int atkLvl, int defLvl, int strLvl, int hpLvl, int rngLvl, int pryLvl, int magLvl) {
        this.name = name;
        this.atkLvl = atkLvl;
        this.strLvl = strLvl;
        this.defLvl = defLvl;
        this.hpLvl = hpLvl;
        this.rngLvl = rngLvl;
        this.magLvl = magLvl;
        this.pryLvl = pryLvl;
    }

    public int getCombatLevel() {
        double base = 0.25 * (double)(this.defLvl + this.hpLvl + Math.floor((double)this.pryLvl / 2.0));
        double melee = 0.325 * (double)(this.atkLvl + this.strLvl);
        double range = 0.325 * (double)Math.floor((double)this.rngLvl * 1.5);
        double mage = 0.325 * (double)Math.floor((double)this.magLvl * 1.5);
        return Math.floor(base + Math.max(melee, range, mage));
    }

    public int getMaxHit() {
        return Math.floor((double)Math.floor((double)(this.strLvl + this.style.getStrBonus() + 8) * (64.0 + (double)this.currentWeapon.getStrBonus() + (double)this.strBonus) / 640.0 + 0.5) * this.currentWeapon.getDmgMod());
    }

    public static Player lookup(String name) {
        String lookup = name.trim().replace(" ", "_");
        ArrayList<String> res = new ArrayList<String>();
        try {
            String line;
            URL url = new URL("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + lookup);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = in.readLine()) != null) {
                res.add(line);
            }
            in.close();
        }
        catch (IOException e) {
            return null;
        }
        return new Player(name, Integer.parseInt(((String)res.get(1)).split(",")[1]), Integer.parseInt(((String)res.get(2)).split(",")[1]), Integer.parseInt(((String)res.get(3)).split(",")[1]), Integer.parseInt(((String)res.get(4)).split(",")[1]), Integer.parseInt(((String)res.get(5)).split(",")[1]), Integer.parseInt(((String)res.get(6)).split(",")[1]), Integer.parseInt(((String)res.get(7)).split(",")[1]));
    }

    public int getAtkRating() {
        return Math.floor((double)(this.atkLvl + 8 + this.style.getAtkBonus()) * (64.0 + (double)this.currentWeapon.getAtkBonus() + (double)this.atkBonus) * this.currentWeapon.getAccMod());
    }

    public int getDefRating() {
        return Math.floor((double)(this.defLvl + 8 + this.style.getDefBonus()) * (64.0 + (double)this.currentWeapon.getDefBonus() + (double)this.defBonus));
    }

    public String getName() {
        return this.name;
    }

    public int getAtkLvl() {
        return this.atkLvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtkLvl(int atkLvl) {
        this.atkLvl = atkLvl;
    }

    public int getStrLvl() {
        return this.strLvl;
    }

    public void setStrLvl(int strLvl) {
        this.strLvl = strLvl;
    }

    public int getDefLvl() {
        return this.defLvl;
    }

    public void setDefLvl(int defLvl) {
        this.defLvl = defLvl;
    }

    public int getHpLvl() {
        return this.hpLvl;
    }

    public void setHpLvl(int hpLvl) {
        this.hpLvl = hpLvl;
    }

    public int getRngLvl() {
        return this.rngLvl;
    }

    public void setRngLvl(int rngLvl) {
        this.rngLvl = rngLvl;
    }

    public int getMagLvl() {
        return this.magLvl;
    }

    public void setMagLvl(int magLvl) {
        this.magLvl = magLvl;
    }

    public int getPryLvl() {
        return this.pryLvl;
    }

    public void setPryLvl(int pryLvl) {
        this.pryLvl = pryLvl;
    }

    public int getAtkBonus() {
        return this.atkBonus;
    }

    public void setAtkBonus(int atkBonus) {
        this.atkBonus = atkBonus;
    }

    public int getStrMod() {
        return this.strMod;
    }

    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getAtkMod() {
        return this.atkMod;
    }

    public void setAtkMod(int atkMod) {
        this.atkMod = atkMod;
    }

    public int getStrBonus() {
        return this.strBonus;
    }

    public void setStrBonus(int strBonus) {
        this.strBonus = strBonus;
    }

    public int getDefBonus() {
        return this.defBonus;
    }

    public void setDefBonus(int defBonus) {
        this.defBonus = defBonus;
    }

    public SpecialWeapon getSpecWeapon() {
        return this.spec;
    }

    public void setSpecWeapon(SpecialWeapon weapon) {
        this.spec = weapon;
    }

    public NormalWeapon getNormalWeapon() {
        return this.normalWeapon;
    }

    public void setNormalWeapon(NormalWeapon weapon) {
        this.normalWeapon = weapon;
    }

    public Weapon getCurrentWeapon() {
        return this.currentWeapon;
    }

    public void setCurrentWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    public void copyBonuses(Player target) {
        this.atkBonus = target.atkBonus;
        this.strBonus = target.strBonus;
        this.defBonus = target.defBonus;
    }

    public void copyMods(Player target) {
        this.atkMod = target.atkMod;
        this.strMod = target.strMod;
        this.defMod = target.defMod;
    }

    public void copyWeaponsAndStyles(Player target) {
        this.normalWeapon = target.normalWeapon;
        this.spec = target.spec;
        this.currentWeapon = target.currentWeapon;
        this.style = target.style;
        this.normalStyle = target.normalStyle;
        this.specStyle = target.specStyle;
    }

    public void setNormalStyle(Style style) {
        this.style = this.normalStyle = style;
    }

    public void setSpecStyle(Style style) {
        this.specStyle = style;
    }

    public void useNormalStyle() {
        this.style = this.normalStyle;
    }

    public void useSpecStyle() {
        this.style = this.specStyle;
    }

    public static enum Style {
        ACCURATE("Accurate", 3, 0, 0),
        AGGRESIVE("Aggresive", 0, 3, 0),
        DEFENSIVE("Defensive", 0, 0, 3),
        CONTROLLED("Controlled", 1, 1, 1);
        
        private String name;
        private int[] bonuses;

        private /* varargs */ Style(String name, int ... bonuses) {
            this.name = name;
            this.bonuses = bonuses;
        }

        public int getAtkBonus() {
            return this.bonuses[0];
        }

        public int getStrBonus() {
            return this.bonuses[1];
        }

        public int getDefBonus() {
            return this.bonuses[2];
        }

        public String toString() {
            return this.name;
        }
    }

}

