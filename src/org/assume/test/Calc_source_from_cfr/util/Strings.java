/*
 * Decompiled with CFR 0_118.
 */
package org.assume.test.Calc_source_from_cfr.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Strings {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (Exception e) {
            return 1;
        }
    }

    public static double parseDouble(String input) {
        try {
            return NumberFormat.getNumberInstance(Locale.ENGLISH).parse(input).doubleValue();
        }
        catch (Exception e) {
            return 1.0;
        }
    }
}

