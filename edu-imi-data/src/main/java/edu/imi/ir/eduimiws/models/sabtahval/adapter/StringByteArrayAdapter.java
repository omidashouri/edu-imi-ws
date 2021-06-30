package edu.imi.ir.eduimiws.models.sabtahval.adapter;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@Component
public class StringByteArrayAdapter extends XmlAdapter<String, byte[]> {

    @Override
    public  byte[] unmarshal(String inputString) throws Exception {
        Charset charset = StandardCharsets.UTF_8;
        if(inputString==null)
            return null;
        byte[] byteArray = inputString.getBytes(charset);
        return byteArray;
    }

    @Override
    public String marshal(byte[] byteArray) throws Exception {
        Charset charset = StandardCharsets.UTF_8;
        if(byteArray==null)
            return null;
        String returnString = new String(byteArray, charset);
        return returnString;
    }
}
