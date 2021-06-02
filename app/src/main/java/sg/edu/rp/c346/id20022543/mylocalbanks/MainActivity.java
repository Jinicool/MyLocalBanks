package sg.edu.rp.c346.id20022543.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS,tvOCBC,tvUOB;
    String wordClicked;
    boolean togglefavouriteDBS=false;
    boolean togglefavouriteOCBC=false;
    boolean togglefavouriteUOB=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.DBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.OCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.UOB);
        registerForContextMenu(tvUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if(v == tvDBS) {
            wordClicked = "DBS";
        }
        else if(v == tvOCBC){
            wordClicked = "OCBC";
        }
        else if(v == tvUOB) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 0) {
            Toast.makeText(MainActivity.this, "Website selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("DBS")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            }
            else if(wordClicked.equalsIgnoreCase("OCBC")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            }

            else if(wordClicked.equalsIgnoreCase("UOB")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            }

        }
        else if(item.getItemId() == 1){
            if(wordClicked.equalsIgnoreCase("DBS")) {
                Toast.makeText(MainActivity.this, "Contact the bank", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800-111-1111"));
                startActivity(i);
            }
            else if(wordClicked.equalsIgnoreCase("OCBC")) {
                Toast.makeText(MainActivity.this, "Contact the bank", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            }
            else if(wordClicked.equalsIgnoreCase("UOB")){
                Toast.makeText(MainActivity.this, "Contact the bank", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(i);

            }

}

        else if(item.getItemId() == 2) {
            if(!togglefavouriteDBS) {
                togglefavouriteDBS=true;
                tvDBS.setTextColor(Color.RED);
            } else {
                togglefavouriteDBS = false;
                tvDBS.setTextColor(Color.BLACK);
            }

            if(!togglefavouriteOCBC) {
                togglefavouriteOCBC=true;
                tvOCBC.setTextColor(Color.RED);
            } else {
                togglefavouriteOCBC = false;
                tvOCBC.setTextColor(Color.BLACK);
            }

            if(!togglefavouriteUOB) {
                togglefavouriteUOB=true;
                tvUOB.setTextColor(Color.RED);
            } else {
                togglefavouriteUOB = false;
                tvUOB.setTextColor(Color.BLACK);
            }
        }
        return super.onContextItemSelected(item);
}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }
        else if(item.getItemId() == R.id.chineseSelection){
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }

        return super.onOptionsItemSelected(item);
    }
}







