package edu.imi.ir.eduimiws.models.sabtahval.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Adapter extends XmlAdapter<byte[], String>{


    @Override
    public String unmarshal(byte[] v) throws Exception {
        return new String(v,StandardCharsets.UTF_8);
    }

    @Override
    public byte[] marshal(String v) throws Exception {
        String asB64 = Base64.getEncoder().encodeToString(v.getBytes("utf-8"));
        return Base64.getDecoder().decode(asB64);
    }
}
