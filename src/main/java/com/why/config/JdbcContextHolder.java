package com.why.config;

public class JdbcContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();



    public static void setJdbcType(String jdbcType) {
        contextHolder.set(jdbcType);
    }


    public static void  setSlave() {
        setJdbcType("slave");
    }


    public static void setMaster() {
        setJdbcType("master");
    }

    public static String getJdbcType() {
        return (String) contextHolder.get();
    }

    public static void clearJdbcType() {
        contextHolder.remove();
    }
}
