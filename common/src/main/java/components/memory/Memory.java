package components.memory;

import tools.descriptors.classes.DecToHexDescriptor;
import tools.descriptors.classes.HexToDecDescriptor;

public class Memory {
    private final int[] memoryArray;
    private final HexToDecDescriptor hexToDecDescriptor;
    private final DecToHexDescriptor decToHexDescriptor;

    private Memory() {
        memoryArray = new int[65536];
        hexToDecDescriptor = new HexToDecDescriptor();
        decToHexDescriptor = new DecToHexDescriptor();
    }

    public int getValueFromMemory(String hexAddress) {
        hexToDecDescriptor.reset();
        hexToDecDescriptor.setValue(hexAddress);
        return memoryArray[hexToDecDescriptor.getIntValue()];
    }

    public void setValueInMemory(String hexAddress, String hexValue) {
        int intAddress;

        hexToDecDescriptor.reset();
        hexToDecDescriptor.setValue(hexAddress);
        intAddress = hexToDecDescriptor.getIntValue();
        hexToDecDescriptor.setValue(hexValue);
        memoryArray[intAddress] = hexToDecDescriptor.getIntValue();
    }

    public String getHexValueFromMemory(String hexAddress) {
        hexToDecDescriptor.reset();
        hexToDecDescriptor.setValue(hexAddress);
        decToHexDescriptor.reset();
        decToHexDescriptor.setValue(memoryArray[hexToDecDescriptor.getIntValue()]);
        return decToHexDescriptor.getHexValue();
    }
}
