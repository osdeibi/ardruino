package tesis.presentar.casabluetooth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

// Instanciamos los botones
	ImageView imageView1;
	TextView textView4;
	TextView textView6;
	Button button1;
	Button Button01;
	Button BtnBanio;
	Button Button05;
	Button Button10;
	Button Button09;
	Button Button15;
	Button Button12;
	Button Button18;
	Button Button17;
	Button Button23;
	Button Button20;
	Button Button26; 
	Button Button25;
	
	//Boton check
	Button Button24;
	
	//botones encendido y apagado
	ImageView image;
	ImageView image1;
	ImageView image2;
	ImageView image3;
	ImageView image4;
	ImageView image5;
	ImageView image6;
	ImageView image7;
	ImageView image8;
	ImageView image9;
	ImageView image10;
	ImageView image11;

	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		

		// Botones de conexion (recursos)
		textView4 = (TextView) findViewById(R.id.textView4); // Recepcion
		textView6 = (TextView) findViewById(R.id.textView6); // Conexion
		
		button1 = (Button) findViewById(R.id.button1);
		Button01 = (Button) findViewById(R.id.Button01);
		BtnBanio = (Button) findViewById(R.id.BtnBanio);
		Button05 = (Button) findViewById(R.id.Button05);
		Button10 = (Button) findViewById(R.id.Button10);
		Button09 = (Button) findViewById(R.id.Button09);
		Button15 = (Button) findViewById(R.id.Button15);
		Button12= (Button) findViewById(R.id.Button12);
		Button18 = (Button) findViewById(R.id.Button18);
		Button17 = (Button) findViewById(R.id.Button17);
		Button23 = (Button) findViewById(R.id.Button23);
		Button20 = (Button) findViewById(R.id.Button20);
		Button26 = (Button) findViewById(R.id.Button26);
		Button25 = (Button) findViewById(R.id.Button25);
		
		//Boton check
		Button24 = (Button) findViewById(R.id.Button24);
		
		//Botones encendido apagado
		image = (ImageView) findViewById(R.id.imageView2);
		image1 = (ImageView) findViewById(R.id.imageView1);
		image2 = (ImageView) findViewById(R.id.ImageView06);
		image3 = (ImageView) findViewById(R.id.ImageView01);		
		image4 = (ImageView) findViewById(R.id.ImageView02);		
		image5 = (ImageView) findViewById(R.id.ImageView07);		
		image6 = (ImageView) findViewById(R.id.ImageView03);		
		image7 = (ImageView) findViewById(R.id.ImageView08);		
		image8 = (ImageView) findViewById(R.id.ImageView05);		
		image9 = (ImageView) findViewById(R.id.ImageView09);		
		image10 = (ImageView) findViewById(R.id.ImageView04);		
		image11 = (ImageView) findViewById(R.id.ImageView10);
		
		
		

		// Botón relay 1 ON
		
		OnClickListener oclbutton1 = new OnClickListener() {
			
			@Override
	// Hace un llamado al boton para regresar la condicion
			public void onClick(View v) {
				 
				textView4.setText("Relay 1 Encendido");						
				image.setImageResource(R.drawable.boton_verde);

			}
		};

		// encendera las luces del led
		button1.setOnClickListener(oclbutton1);
		Button01.setOnClickListener(oclButton01);
		BtnBanio.setOnClickListener(oclBtnBanio);
		Button05.setOnClickListener(oclButton05);
		Button10.setOnClickListener(oclButton10);
		Button09.setOnClickListener(oclButton09);
		Button15.setOnClickListener(oclButton15);
		Button12.setOnClickListener(oclButton12);
		Button18.setOnClickListener(oclButton18);
		Button17.setOnClickListener(oclButton17);
		Button23.setOnClickListener(oclButton23);
		Button20.setOnClickListener(oclButton20);
		Button26.setOnClickListener(oclButton26);
		Button25.setOnClickListener(oclButton25);
		Button24.setOnClickListener(oclButton24);

	}

	// Botón relay1 OFF
	OnClickListener oclButton01 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 1 Apagado");
			image1.setImageResource(R.drawable.boton_rojo);
			image.setImageResource(R.drawable.boton_verdeclaro);

		}

	};

	// Botón relay 2 ON
	OnClickListener oclBtnBanio = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 2 Encendido");
			image2.setImageResource(R.drawable.boton_verde);
			// encendera las luces del led

		}

	};

	// Boton relay 2 OFF
	OnClickListener oclButton05 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 2 Apagado");
			image3.setImageResource(R.drawable.boton_rojo);
			image2.setImageResource(R.drawable.boton_verdeclaro);
			// encendera las luces del led

		}

	};

	// Botón relay 3 ON
	OnClickListener oclButton10 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 3 Encendido");
			image5.setImageResource(R.drawable.boton_verde);
			// encendera las luces del led

		}

	};
	
	// Botón relay 3 OFF
	OnClickListener oclButton09 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 3 Apagado");
			image4.setImageResource(R.drawable.boton_rojo);
			image5.setImageResource(R.drawable.boton_verdeclaro);
			// encendera las luces del led

		}

	};

	// Botón relay 4 ON
	OnClickListener oclButton15 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 4 Encendido");
			image7.setImageResource(R.drawable.boton_verde);
			// encendera las luces del led

		}

	};
	
	// Botón relay 4 OFF
	OnClickListener oclButton12 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 4 Apagado");
			image6.setImageResource(R.drawable.boton_rojo);
			image7.setImageResource(R.drawable.boton_verdeclaro);
			// encendera las luces del led

		}

	};
	
	// Botón relay 5 ON
	OnClickListener oclButton18 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 5 Encendido");
			image9.setImageResource(R.drawable.boton_verde);
			// encendera las luces del led

		}

	};
	
	// Botón relay 5 OFF
	OnClickListener oclButton17 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 5 Apagado");
			image8.setImageResource(R.drawable.boton_rojo);
			image9.setImageResource(R.drawable.boton_verdeclaro);
			// encendera las luces del led

		}

	};
	
	
	// Botón relay 6 ON
	OnClickListener oclButton23 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 6 Encendido");
			image11.setImageResource(R.drawable.boton_verde);
			// encendera las luces del led

		}

	};
	
	
	// Botón relay 6 OFF
	OnClickListener oclButton20 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Relay 6 Apagado");
			image10.setImageResource(R.drawable.boton_rojo);
			image11.setImageResource(R.drawable.boton_verdeclaro);
			// encendera las luces del led

		}

	};
	
	// Botón Conectar
	OnClickListener oclButton26 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Conectado...");
			textView6.setText("98:D3:31:90:12:E2");
			
		}

	};
	
	
	// Botón desconectar 
	OnClickListener oclButton25 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// Se coloca en el listener la accion que hara el boton
			textView4.setText("Desconectado");
			textView6.setText("00:00:00:00:00:00");
			// encendera las luces del led

		}

	};
	
	
	// Botón Check
	
	OnClickListener oclButton24 = new OnClickListener() {
		
		@Override
		
		public void onClick(View v) {
			
			textView4.setText("Bluetooth Desconectado");						
			

		}
	};
	
	
	
}