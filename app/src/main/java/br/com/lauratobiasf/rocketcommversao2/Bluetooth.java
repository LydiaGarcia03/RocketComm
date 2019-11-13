package br.com.lauratobiasf.rocketcommversao2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.widget.Toast;
import java.util.Set;
import androidx.appcompat.app.AppCompatActivity;

public class Bluetooth extends AppCompatActivity {

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
            startActivityForResult(enableBT, 0);
            Toast.makeText(getApplicationContext(), "Bluetooth ligado",Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getApplicationContext(), "Bluetooth já estava ligado", Toast.LENGTH_LONG).show();
        }

        visible();
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

    public void turnoff(){
        btAdapter.disable();
        Toast.makeText(getApplicationContext(), "Desligado" ,Toast.LENGTH_LONG).show();
    }

    public void visible(){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }

}
