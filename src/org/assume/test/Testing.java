package org.assume.test;

import java.text.DecimalFormat;

public class Testing
{

    public static void main(String[] args)
    {
	Testing x = new Testing(10, 10, 10, 10, 10, 10, 10, 10);
	x.doWork();
	DecimalFormat f = new DecimalFormat("#.##");
	System.out.println(f.format(x.getWin()));
	System.out.println(f.format(x.getLoss()));
    }

    private double[] health;
    private double[] ohealth;
    private double att;
    private double str;
    private double def;
    private double con;
    private double oatt;
    private double ostr;
    private double odef;
    private double ocon;
    private double eff_str;
    private double bas_dam;
    private double eff_def;
    private double eff_att;
    private double oeff_att;
    private double oeff_str;
    private double obas_dam;
    private double oeff_def;

    private double acc;
    private double oacc;
    private double xy = 0;
    private double win = 0;
    private double loss = 0;

    private Testing(double att, double str, double def, double con,
	    double oatt, double ostr, double odef, double ocon)
    {
	this.health = initHealth(con);
	this.ohealth = initHealth(ocon);
	this.att = att;
	this.str = str;
	this.def = def;
	this.con = con;
	this.oatt = oatt;
	this.ostr = ostr;
	this.odef = odef;
	this.ocon = ocon;
	eff_str = str + 8;
	bas_dam = eff_str + 5;
	eff_def = 10 * (def + 8);
	eff_att = 10 * (att + 8 + 3);
	oeff_att = 10 * (oatt + 8 + 3);
	oeff_str = ostr + 8;
	obas_dam = oeff_str + 5;
	oeff_def = 10 * (odef + 8);

	acc = att < odef ? (eff_att - 1) / (2 * oeff_def) : 1 - (oeff_def + 1)
		/ (2 * eff_att);

	oacc = oatt < def ? (oeff_att - 1) / (2 * eff_def) : 1 - (eff_def + 1)
		/ (2 * oeff_att);

    }

    private void combatOp(double oaccuracy, double obas_dam)
    {

	for (int j = 1; j < ohealth.length; j++)
	{
	    for (int k = 1; k < obas_dam; k++)
	    {
		if (j - k >= 0)
		    ohealth[j - k] += oaccuracy * ohealth[j] / obas_dam;
		else
		    ohealth[0] += oaccuracy * ohealth[j] / obas_dam;
	    }
	    ohealth[j] *= 1 - oaccuracy;
	    ohealth[j] += oaccuracy * ohealth[j] / obas_dam;
	}

    }

    private void combatMe(double oaccuracy, double obas_dam)
    {
	for (int j = 1; j < health.length; j++)
	{
	    for (int k = 1; k < obas_dam; k++)
	    {
		if (j - k >= 0)
		    health[j - k] += oaccuracy * health[j] / obas_dam;
		else
		    health[0] += oaccuracy * health[j] / obas_dam;
	    }
	    health[j] *= 1 - oaccuracy;
	    health[j] += oaccuracy * health[j] / obas_dam;
	}
    }

    private void statistics()
    {
	double temp = 1 - (1 - health[0]) * (1 - ohealth[0]);
	temp -= this.xy;

	if (health[0] > 0 || ohealth[0] > 0)
	{
	    this.win += temp * (ohealth[0] / (ohealth[0] + health[0]));
	    this.loss += temp * (health[0] / (ohealth[0] + health[0]));

	}
	this.xy += temp;
    }

    public void doWork()
    {
	for (int hit = 0; win + loss < 0.99 && hit < 1000; hit++)
	{
	    this.combatMe(oacc, obas_dam);
	    this.combatOp(acc, bas_dam);
	    statistics();
	}
    }

    private double[] initHealth(double constitution)
    {
	double[] hp = new double[(int) (constitution * 10)];
	hp[hp.length - 1] = 1;
	return hp;
    }

    public double getWin()
    {
	return win * 100;
    }

    public double getLoss()
    {
	return loss * 100;
    }

    /*
     * public static double getWinPercent(Staker staker) { if (Vars.ATTACK == -1
     * || Vars.DEFENCE == -1 || Vars.HEALTH == -1 || Vars.STRENGTH == -1) {
     * Vars.ATTACK = Skills.getActualLevel(SKILLS.ATTACK); Vars.STRENGTH =
     * Skills.getActualLevel(SKILLS.STRENGTH); Vars.DEFENCE =
     * Skills.getActualLevel(SKILLS.DEFENCE); Vars.HEALTH =
     * Skills.getActualLevel(SKILLS.HITPOINTS); } WinPercent p = new
     * WinPercent(Vars.ATTACK, Vars.STRENGTH, Vars.DEFENCE, Vars.HEALTH,
     * staker.getAttack(), staker.getStrength(), staker.getDefence(),
     * staker.getHP()); p.doWork(); return p.getWin();
     * 
     * }
     */

}
