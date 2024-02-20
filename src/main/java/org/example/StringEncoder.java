package org.example;

import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

public class StringEncoder implements Encoder.Text<String> {
    @Override
    public String encode(String s) throws EncodeException {
        return s;
    }
}
