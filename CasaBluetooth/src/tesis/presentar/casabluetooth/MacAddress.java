package tesis.presentar.casabluetooth;


import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;

// COn este metodo obtendremos la conexion entre el dispositivo y el Ardruino
public class MacAddress extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // Campo de texto donde mostraremos la info
        
	}
	
	
	private Activity context;
	WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	WifiInfo wifiInf = wifiMan.getConnectionInfo();
	int ipAddress = wifiInf.getIpAddress();
	String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));

	
	
	
}