package com.example.thibault.lecteurjson.Data;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.util.Log;

import com.example.thibault.lecteurjson.R;

/**
 * Created by Thibault on 17/05/2016.
 */
public class CompilateurXML
{
    private String fileName;
    private String url;
    private String XsltFile;

    private String bdd; // Pour tests seulement...

    public CompilateurXML(String _fileNameJson, String _fileNameXslt, String _url)
    {
        fileName =_fileNameJson;
        XsltFile = _fileNameXslt;
        url =_url;
    }
    public CompilateurXML()// Pour tests seulement...
    {

    }

    public boolean update()
    {
        String newBdd = download();
        newBdd = xmlToJson(newBdd);
        save(newBdd);

        return true;
    }
    /*public String getBddInJson(Activity context)
    {
        String myXmlDocument;

        return transformXmlDocument(
                myXmlDocument,
                context.getResources().openRawResource(R.raw.xsltfile));
    }*/
    private String download()
    {
        return " ";
    }
    private String xmlToJson(String xml)
    {
        return " ";
    }
    private boolean save(String bdd)
    {
        return true;
    }

    public final Document transformXmlDocument(Document sourceDocument, InputStream xsltFile) {

        DOMSource xmlSource = new DOMSource(sourceDocument);
        StreamSource xsltSource = new StreamSource(xsltFile);

        Document transformedData = null;

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(output);

            transformer.transform(xmlSource, result);

            DocumentBuilder resultBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            transformedData = resultBuilder.parse(
                    new InputSource(
                            new StringReader(
                                    new String(output.toByteArray())
                            )
                    )
            );
        } catch (Exception e) {
            Log.e("XSLT Transformation", e.getMessage());
        }

        return transformedData;
    }





}
