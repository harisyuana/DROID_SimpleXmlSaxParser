package com.algoristaengineering.simplexmlsaxparser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends ActionBarActivity {

    private EditText xmlInput;
    private TextView xmlOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xmlInput = (EditText) findViewById(R.id.xmlInput);
        xmlOutput = (TextView) findViewById(R.id.xmlOutput);

        Button parseMyXML = (Button) findViewById(R.id.parse);
        parseMyXML.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                parseXML();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void parseXML() {

        String parsedData = "";

        try {

            Log.w("AndroidParseXMLActivity", "Start");
            /** Handling XML */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

            ItemXmlHandler myXMLHandler = new ItemXmlHandler();
            xr.setContentHandler(myXMLHandler);
            InputSource inStream = new InputSource();
            Log.w("AndroidParseXMLActivity", "Parse1");

            inStream.setCharacterStream(new StringReader(xmlInput.getText().toString()));
            Log.w("AndroidParseXMLActivity", "Parse2");

            xr.parse(inStream);
            Log.w("AndroidParseXMLActivity", "Parse3");

            ArrayList<Item> itemsList = myXMLHandler.getItemList();
            for(int i=0;i<itemsList.size();i++){
                Item item = itemsList.get(i);
                parsedData = parsedData + "----->\n";
                parsedData = parsedData + "Item Number: " + item.getItemNumber() + "\n";
                parsedData = parsedData + "Description: " + item.getDescription() + "\n";
                parsedData = parsedData + "Price: " + item.getPrice() + "\n";
                parsedData = parsedData + "Weight: "+ item.getWeight() + "\n";

            }
            Log.w("AndroidParseXMLActivity", "Done");
        }
        catch (Exception e) {
            Log.w("AndroidParseXMLActivity",e );
        }

        xmlOutput.setText(parsedData);

    }
}
