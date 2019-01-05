package com.hannea.jain.sip.server;

/**
 * @Author: wangguomin
 * @Date: 2019-01-04 20:02
 */
public class App {

    /**
     * 程序入口
     * @param args
     */
    public static void main(String []args)
    {
        new SipPhone().init("192.168.199.195", 5060);
    }

}
