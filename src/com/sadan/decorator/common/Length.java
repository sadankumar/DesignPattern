package com.sadan.decorator.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length implements Comparable<Length> {
    private BigDecimal meters;

    public Length(BigDecimal meters) {
        this.meters = meters.setScale(4, RoundingMode.HALF_UP);
    }

    public static final Length ZERO = new Length(BigDecimal.ZERO);
    public static final Length MILLIMETER = new Length(BigDecimal.valueOf(.001));

    public Length add(Length other) {
        return new Length(this.meters.add(other.meters));
    }

    public Length scale(double factor) {
        return new Length(this.meters.multiply(BigDecimal.valueOf(factor)));
    }

    public Length max(Length other) {
        return this.compareTo(other) >= 0 ? this : other;
    }

    public static Length max(Length first, Length... others) {
        Length winner = first;
        for (Length candidate: others) {
            winner = winner.max(candidate);
        }
        return winner;
    }

    @Override
    public String toString() {
        return this.toString(this.getScale());
    }

    public static String toString(String separator, Length first, Length... others) {
        return toString(separator, Length.max(first, others).getScale(), first, others);
    }

    private static String toString(String separator, int scale, Length first, Length... others) {
        StringBuilder builder = new StringBuilder();

        builder.append(first.toString(scale));
        for (Length other : others) {
            builder.append(separator);
            builder.append(other.toString(scale));
        }

        return builder.toString();
    }

    private String toString(int scale) {
        return
            scale == 3 ? String.format(this.meters.multiply(BigDecimal.valueOf(1000)).setScale(0, RoundingMode.HALF_UP).toString() + "mm")
            : scale == 2 ? String.format(this.meters.multiply(BigDecimal.valueOf(100)).setScale(1, RoundingMode.HALF_UP).toString() + "cm")
            : String.format(this.meters.setScale(2, RoundingMode.HALF_UP).toString() + "m");
    }

    private int getScale() {
        return
            this.compareTo(MILLIMETER.scale(100)) < 0 ? 3
            : this.compareTo(MILLIMETER.scale(1000)) < 0 ? 2
            : 1;
    }

    @Override
    public int compareTo(Length o) {
        return this.meters.compareTo(o.meters);
    }
}
