package com.thefifthidiot.tficore.lib;

import net.minecraft.util.IStringSerializable;

/**
 * Created by fabbe50 on 23/06/2016.
 */
public enum EnumCompressed implements IStringSerializable {
    SINGLE(0, "single", "9"),
    DOUBLE(1, "double", "81"),
    TRIPLE(2, "triple", "729"),
    QUADRUPLE(3, "quadruple", "6,561"),
    QUINTUPLE(4, "quintuple", "59,049"),
    SEXTUPLE(5, "sextuple", "531,441"),
    SEPTUPLE(6, "septuple", "4,782,969"),
    OCTUPLE(7, "octuple", "43,046,721");

    private static final EnumCompressed[] META_LOOKUP = new EnumCompressed[values().length];
    private int meta;
    private String name;
    private String tooltip;

    EnumCompressed(int meta, String name, String tooltip) {
        this.name = name;
        this.meta = meta;
        this.tooltip = tooltip;
    }

    public String getUnlocalizedName() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public int getMetadata() {
        return this.meta;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public static EnumCompressed byMetadata(int meta){
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }
        return META_LOOKUP[meta];
    }

    static{
        for (EnumCompressed e : values()){
            META_LOOKUP[e.getMetadata()] = e;
        }
    }
}
