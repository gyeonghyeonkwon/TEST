package com.ll.domain;
import com.ll.standard.util.ut;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    @Getter
    private String cmd;
    @Getter
    private String cmdAction;
    private String queryString;
    private Map<String , String> paramMap;
    Rq(String cmd) {
        this.cmd = cmd;

        paramMap = new HashMap<>();

        String[] cmdBit = cmd.split("\\?", 2);

        cmdAction = cmdBit[0];

        if(cmdBit.length == 1){
            return;
        }

        String queryString = cmdBit[1];

        String[] queryStringBit = queryString.split("&");

        for (int i = 0; i < queryStringBit.length; i++) {

            String queryStringStr = queryStringBit[i]; //"id=2"

            String[] queryStringStrBit = queryStringStr.split("=", 2);

            String paramName = queryStringStrBit[0];

            String paramValue = queryStringStrBit[1];

            paramMap.put(paramName,paramValue);
        }
    }



        public int getParamAsInt (String findparamName , int defultValue) {

            return ut.str.parseInt(paramMap.get(findparamName),defultValue);
        }


    }
