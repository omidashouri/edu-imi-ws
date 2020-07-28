package edu.imi.ir.eduimiws.utilities;

import lombok.extern.slf4j.Slf4j;

import java.sql.Clob;
import java.sql.SQLException;

@Slf4j
public class ClobHelper {

    public static String clobToString(Clob data) {
        long dataL = System.nanoTime();
        String result = "";
        int MAX_TEXT_LENGTH = 255;

        if (data != null) {
            try {
                result = data.getSubString(1, MAX_TEXT_LENGTH);
            } catch (SQLException e) {
                log.error("Exception Clob to String", e.getMessage());
            }
        }
        return result;
    }
}
