package com.ll.standard.util;

public class ut {

        public static class str {

            public static int parseInt(String value, int defultValue) {

                try {
                    return Integer.parseInt(value);
                }
                catch (NumberFormatException e) {
                    return defultValue;
                }
            }
        }
}
