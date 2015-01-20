package com.algoristaengineering.simplexmlsaxparser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by NavcoreWindow8 on 1/20/2015.
 */
public class ItemXmlHandler extends DefaultHandler {
    private boolean currentElement = false;
    private String currentValue = "";
    private Item item = null;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public ArrayList<Item> getItemList(){
        return itemList;
    }

    //Called when tag starts
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException{
        currentElement = true;
        currentValue = "";

        if(localName.equals("ItemData")){
            item = new Item();
        }
    }

    //Called when tag closing
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        currentElement = false;

        //set value
        if(localName.equals("ItemNumber")){
            item.setItemNumber(currentValue);
        }
        else if(localName.equals("Description")){
            item.setDescription(currentValue);
        }
        else if(localName.equals("Price")){
            item.setPrice(currentValue);
        }
        else if(localName.equals("Weight")){
            item.setWeight(Double.parseDouble(currentValue));
        }
        else if(localName.equals("ItemData")){
            itemList.add(item);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        if(currentElement){
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
