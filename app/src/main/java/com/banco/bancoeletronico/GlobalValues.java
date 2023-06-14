package com.banco.bancoeletronico;

public class GlobalValues {
    private static GlobalValues instance;
    private float globalValue;

    private GlobalValues() {
    }

    public static synchronized GlobalValues getInstance() {
        if (instance == null) {
            instance = new GlobalValues();
        }
        return instance;
    }

    public synchronized void decrementGlobalValue(float value) {
        globalValue -= value;
    }

    public float getGlobalValue() {
        return globalValue;
    }

    public void setGlobalValue(float value) {
        globalValue = value;
    }
}
