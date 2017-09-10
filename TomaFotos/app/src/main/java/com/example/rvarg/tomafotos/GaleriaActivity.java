package com.example.rvarg.tomafotos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by rvarg on 04/09/2017.
 */

public class GaleriaActivity extends Activity {
    private static final int PHOTO_SELECTED=1;
    private final int RESULTADO_CARGA_IMAGEN=1;
    ImageView fotogaleria;
    Button cargarfoto;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galerialayout);
        fotogaleria=(ImageView) this.findViewById(R.id.fotogaleria);
        cargarfoto=(Button) this.findViewById(R.id.cargarfoto);

        cargarfoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent fotIntent= new Intent(Intent.ACTION_GET_CONTENT);
                fotIntent.setType("image/*");
                startActivityForResult(fotIntent, PHOTO_SELECTED);
            }
        });
    }
    protected  void onActivityForResult(int requestCode,int resultCode,Intent data){
        if((requestCode==RESULTADO_CARGA_IMAGEN)&& (requestCode==RESULT_OK) && (data!=null)){
            Uri imagenseleccted=data.getData();
            String[] ruta={MediaStore.Images.Media.DATA};
            Cursor cursor=getContentResolver().query(imagenseleccted,ruta,null,null,null);
            cursor.moveToFirst();
            int Indice=cursor.getColumnIndex(ruta[0]);
            String picturePath=cursor.getString(Indice);
            cursor.close();
            fotogaleria=(ImageView) this.findViewById(R.id.fotogaleria);
            fotogaleria.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
