/*
 * Decompiled with CFR 0_118.
 */
package org.assume.test.Calc_source_from_cfr.util;

public class Math {
    public static int floor(double d) {
        return (int)d;
    }

    public static /* varargs */ int max(int ... vals) {
        int max = Integer.MIN_VALUE;
        for (int i : vals) {
            if (i <= max) continue;
            max = i;
        }
        return max;
    }

    public static /* varargs */ double max(double ... vals) {
        double max = Double.MIN_VALUE;
        for (double i : vals) {
            if (i <= max) continue;
            max = i;
        }
        return max;
    }
}

