package com.example.rayih.tiposdemenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Vida del Boton Menu Contexto
        Button btnContexto = (Button) findViewById(R.id.btnContexto);
        registerForContextMenu(btnContexto);
        //Fin vida del Boton Menu Contexto//

    }

    @Override
    //Menu de Opciones
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;

            case R.id.mSettings:
                Intent intent2 = new Intent(this, ActivitySettings.class);
                startActivity(intent2);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    // Fin Menu de Opciones//


    @Override
    //Menu de Contexto
    //Se puede Realizar con imagenes o con cualquier texto.
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEdit:
                //Intent
                Toast.makeText(this, getResources().getString(R.string.menu_edit), Toast.LENGTH_SHORT).show();
                break;

            case R.id.mDelete:
                //Intent
                Toast.makeText(this, getResources().getString(R.string.menu_delete), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    //Fin Menu de Contexto//


    //Menu PopUp
    //Se puede Realizar con imagenes o con cualquier texto.
    public void menuPopUp(View v){
        Button btnPopup = (Button) findViewById(R.id.btnPopup);
        PopupMenu popupMenu = new PopupMenu(this, btnPopup);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
            public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()){
                case R.id.mView:
                    Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_view), Toast.LENGTH_LONG).show();
                    break;

                case R.id.mViewDetail:
                    Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_View_detail), Toast.LENGTH_LONG).show();
                    break;
            }
                return true;
                }
            });
                popupMenu.show();
    }
    //Fin Menu PopUp
}
