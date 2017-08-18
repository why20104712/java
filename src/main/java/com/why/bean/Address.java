package com.why.bean;

/**
 * 地址
 * @author wanghaiyang
 * @date 14/08/2017 17:23
 */
public class Address {


    private String province;

    private String city;

    /**
     * 邮编
     */
    private String postcode;


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
