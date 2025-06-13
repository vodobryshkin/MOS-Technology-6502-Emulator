package components.registers.classes;

import components.registers.interfaces.Register;
import tools.descriptors.classes.DecToHexDescriptor;

public class PRegister implements Register {
    private int value;

    private int c;
    private boolean z;
    private boolean i;
    private boolean d;
    private boolean b;
    private boolean v;
    private boolean s;

    public PRegister() {
        value = 0b00100010;
        updateFlagsFromValue();
    }

    @Override
    public void setValue(int value) {
        this.value = value & 0xFF;
        updateFlagsFromValue();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        DecToHexDescriptor decToHexDescriptor = new DecToHexDescriptor();
        decToHexDescriptor.reset();
        decToHexDescriptor.setValue(value);
        return decToHexDescriptor.getHexValue();
    }

    private void updateFlagsFromValue() {
        // Извлекаем флаги из значения регистра
        c = (value & 0x01);
        z = (value & 0x02) != 0;
        i = (value & 0x04) != 0;
        d = (value & 0x08) != 0;
        b = (value & 0x10) != 0;
        v = (value & 0x40) != 0;
        s = (value & 0x80) != 0;
    }

    private void updateValueFromFlags() {
        // Собираем значение регистра из флагов
        value = c & 0x01;
        value |= z ? 0x02 : 0;
        value |= i ? 0x04 : 0;
        value |= d ? 0x08 : 0;
        value |= b ? 0x10 : 0;
        value |= 0x20; // 5-й бит всегда 1
        value |= v ? 0x40 : 0;
        value |= s ? 0x80 : 0;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
        updateValueFromFlags();
    }

    public boolean isZ() {
        return z;
    }

    public void setZ(boolean z) {
        this.z = z;
        updateValueFromFlags();
    }

    public boolean isI() {
        return i;
    }

    public void setI(boolean i) {
        this.i = i;
        updateValueFromFlags();
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
        updateValueFromFlags();
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
        updateValueFromFlags();
    }

    public int getFifthBit() {
        return 1; // 5-й бит всегда 1
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
        updateValueFromFlags();
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
        updateValueFromFlags();
    }
}