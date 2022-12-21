package com.musala.soft.api.utils;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

public class Util {
    public static String getUniqueIdentifier(){

        return UUID.randomUUID().toString();
    }
}
