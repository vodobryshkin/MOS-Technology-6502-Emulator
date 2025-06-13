package tools.descriptors.classes;

import tools.descriptors.interfaces.Descriptor;

public class HexToDecDescriptor implements Descriptor {
    private String hexValue = "0x0000";

    @Override
    public void reset() {
        hexValue = "0x0000";
    }

    @Override
    public int getIntValue() {
        int sum = 0;

        System.out.println(hexValue);

        while (hexValue.length() < 4) {
            hexValue = "0" + hexValue;
        }

        while (hexValue.length() > 4) {
            hexValue = hexValue.substring(1);
        }

        byte[] bytesValues = hexValue.getBytes();

        for (int i = 0; i < bytesValues.length; i++) {
            if (bytesValues[i] >= '0' && bytesValues[i] <= '9') {
                sum += (int) ((bytesValues[i] - '0') * Math.pow(16, 3 - i));
            } else {
                sum += (int) ((bytesValues[i] - 55) * Math.pow(16, 3 - i));
            }
        }

        return sum;
    }

    public void setValue(String hexValue) {
        this.hexValue = hexValue.substring(2).toUpperCase();
    }

    @Override
    public String getHexValue() {
        return "0x" + hexValue;
    }
}
