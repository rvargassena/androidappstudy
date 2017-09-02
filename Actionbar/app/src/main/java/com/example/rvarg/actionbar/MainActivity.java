package com.example.rvarg.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.rvarg.actionbar.Fragmentos.Main2Activity;
import com.example.rvarg.actionbar.Galeria.ComidasPrincipal;
import com.example.rvarg.actionbar.Galeria.Main3Activity;
import com.example.rvarg.actionbar.Dialogos.Main4Activity;
import com.example.rvarg.actionbar.ListFragments.ListaProductosActivity;
import com.example.rvarg.actionbar.Tabs.Main5Activity;
import com.example.rvarg.actionbar.Agenda.Main7Activity;

import static android.R.id.progress;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView Myview=(WebView) findViewById(R.id.web);
        Myview.getSettings().setDisplayZoomControls(true);
        Myview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
        });
        Myview.loadUrl("https://www.google.com.co");
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        Myview.setWebChromeClient(new WebChromeClient(){
            @Override
                    public void onProgressChanged(WebView view, int progress){
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
                MainActivity.this.setProgress(progress*1000);
                progressBar.incrementProgressBy(progress);
                if(progress==100){
                    progressBar.setVisibility(View.GONE);
                }

            }

        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action1) {
            Intent Fragmentos=new Intent(this,Main2Activity.class);
            startActivity(Fragmentos);
            return true;
        }
        if (id == R.id.action2) {
            Intent Galeria=new Intent(this,ComidasPrincipal.class);
            startActivity(Galeria);
            return true;
        }
        if (id == R.id.action3) {
            Intent Dialogos=new Intent(this,Main4Activity.class);
            startActivity(Dialogos);
            return true;
        }
        if (id == R.id.action4) {
            Intent Tabs=new Intent(this,Main5Activity.class);
            startActivity(Tabs);
            return true;
        }
        if (id == R.id.action5) {
            Intent Agenda=new Intent(this,Main7Activity.class);
            startActivity(Agenda);
            return true;
        }
        if (id == R.id.action6) {
            Intent Listfragment=new Intent(this,ListaProductosActivity.class);
            startActivity(Listfragment);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
