package tesis.presentar.casabluetooth;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Arduino_refactor extends Activity {
	private static final String TAG = "LEDOnOff";

	Button btnOn, btnOff;

	private static final int REQUEST_ENABLE_BT = 1;
	private BluetoothAdapter btAdapter = null;
	private BluetoothSocket btSocket = null;
	private OutputStream outStream = null;

	// conexion SPP UUID
	private static final UUID MY_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");

	// Obtendra la direccion del dispositivo movil
	private static String address = "00:00:00:00:00:00";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d(TAG, "In onCreate()");

		setContentView(R.layout.activity_main);

		// btnOn = (Button) findViewById(R.id.btnOn);
		// btnOff = (Button) findViewById(R.id.btnOff);

		btAdapter = BluetoothAdapter.getDefaultAdapter();
		checkBTState();

		
		//Conexion ardruino entre el telefono
		
		btnOn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sendData("1");
				Toast msg = Toast.makeText(getBaseContext(),
						"You have clicked On", Toast.LENGTH_SHORT);
				msg.show();
			}
		});

		btnOff.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sendData("0");
				Toast msg = Toast.makeText(getBaseContext(),
						"You have clicked Off", Toast.LENGTH_SHORT);
				msg.show();
			}
		});
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.d(TAG, "...In onResume - Attempting client connect...");

		// desde el nodo de modulos obtendra un apuntador.
		BluetoothDevice device = btAdapter.getRemoteDevice(address);

		// se necesitan dos cosas para conectarse:
		// la direccion MAC que se obtiene de este metodo.
		//el serrvicio de ID o UUID. en este caso uusamos el metodo:
		// UUID para SPP.
		try {
			btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
		} catch (IOException e) {
			errorExit("Fatal Error", "In onResume() and socket create failed: "
					+ e.getMessage() + ".");
		}

		
		// si no hay conexion no enviara ningun mensaje.
		btAdapter.cancelDiscovery();

		// Esto hara la conexion entre los dispositivos.
		Log.d(TAG, "...Connecting to Remote...");
		try {
			btSocket.connect();
			Log.d(TAG, "...Connection established and data link opened...");
		} catch (IOException e) {
			try {
				btSocket.close();
			} catch (IOException e2) {
				errorExit("Fatal Error",
						"In onResume() and unable to close socket during connection failure"
								+ e2.getMessage() + ".");
			}
		}

		// Crea una data entre el cada dispositivo.
		Log.d(TAG, "...Creating Socket...");

		try {
			outStream = btSocket.getOutputStream();
		} catch (IOException e) {
			errorExit(
					"Fatal Error",
					"In onResume() and output stream creation failed:"
							+ e.getMessage() + ".");
		}
	}

	
	
	
	// Si esta en pausa el espera hasta establecer conexion
	@Override
	public void onPause() {
		super.onPause();

		Log.d(TAG, "...In onPause()...");

		if (outStream != null) {
			try {
				outStream.flush();
			} catch (IOException e) {
				errorExit(
						"Fatal Error",
						"In onPause() and failed to flush output stream: "
								+ e.getMessage() + ".");
			}
		}

		try {
			btSocket.close();
		} catch (IOException e2) {
			errorExit("Fatal Error", "In onPause() and failed to close socket."
					+ e2.getMessage() + ".");
		}
	}

	private void checkBTState() {
		// Verifica si el bluetooth esta encendido

		// Si el bluetooth no es encontrado aborta la conexion
		if (btAdapter == null) {
			errorExit("Fatal Error", "Bluetooth Not supported. Aborting.");
		} else {
			if (btAdapter.isEnabled()) {
				Log.d(TAG, "...Bluetooth is enabled...");
			} else {
				// Administra la conexion
				Intent enableBtIntent = new Intent(
						btAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			}
		}
	}

	private void errorExit(String title, String message) {
		Toast msg = Toast.makeText(getBaseContext(), title + " - " + message,
				Toast.LENGTH_SHORT);
		msg.show();
		finish();
	}

	private void sendData(String message) {
		byte[] msgBuffer = message.getBytes();

		Log.d(TAG, "...Sending data: " + message + "...");

		try {
			outStream.write(msgBuffer);
		} catch (IOException e) {
			String msg = "In onResume() and an exception occurred during write: "
					+ e.getMessage();
			if (address.equals("00:00:00:00:00:00"))
				msg = msg
						+ ".\n\nUpdate your server address from 00:00:00:00:00:00 to the correct address on line 37 in the java code";
			msg = msg + ".\n\nCheck that the SPP UUID: " + MY_UUID.toString()
					+ " exists on server.\n\n";

			errorExit("Fatal Error", msg);
		}
	}
}