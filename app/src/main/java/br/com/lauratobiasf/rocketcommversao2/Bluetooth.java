package br.com.lauratobiasf.rocketcommversao2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.widget.Toast;
import java.util.Set;

public class Bluetooth {

    final BluetoothAdapter btAdapter;
    Set<BluetoothDevice> pairedDevices;
    BluetoothDevice btPairedDevice;
    boolean deviceFound = false;

    public Bluetooth(){

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        if(btAdapter == null){
            Toast.makeText(null, "Bluetooth não compatível", Toast.LENGTH_LONG);
        }

        if(!btAdapter.isEnabled()){
            Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        }

        findDevice();
    }

    private void findDevice() {

        pairedDevices = btAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equals("Device_name")) {
                    btPairedDevice = device;
                    deviceFound = true;
                    break;
                }
            }
        }

    }

}
