package com.utn.JFutbolManager.Model;

public enum CurrencyType {
    EURO("Euro", 165),
    DOLAR("dolar", 143);

    private String description;
    private double value;

    CurrencyType(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public static CurrencyType find(final String in) {
        for (CurrencyType v : values()) {
            if (v.toString().equalsIgnoreCase(in)) {
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid CurrencyType: %s", in));
    }

    public String getDescription() {
        return description;
    }

    public double getValue(){
        return value;
    }
}
