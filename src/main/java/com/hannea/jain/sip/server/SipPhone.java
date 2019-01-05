package com.hannea.jain.sip.server;

import javax.sip.*;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;
import java.util.Properties;

/**
 * https://www.oracle.com/technetwork/java/jain-sip-tutorial-149998.pdf
 */
public class SipPhone  {



    public void init(String ipAddr, Integer port)
    {
        //创建系统的各种对象的工厂类。这些类将返回实现标准接口的对象
        SipFactory sipFactory = SipFactory.getInstance();
        if (null == sipFactory)
        {
            System.out.println("init sipFactory is null.");
            return;
        }

        sipFactory.setPathName("gov.nist");
        Properties properties = new Properties();
        properties.setProperty("javax.sip.STACK_NAME", "sipphone");
        // You need 16 for logging traces. 32 for debug + traces.
        // Your code will limp at 32 but it is best for debugging.
        properties.setProperty("gov.nist.javax.sip.TRACE_LEVEL", "32");
        properties.setProperty("gov.nist.javax.sip.DEBUG_LOG",
                "sipphonedebug.txt");
        properties.setProperty("gov.nist.javax.sip.SERVER_LOG",
                "sipphonelog.txt");
        SipStack sipStack = null;
        try
        {
            //SIP 工厂用于实例化 SipStack 实现，但由于可能存在多个实现，您必须通过 setPathName() 方法指定所需的一个实现。名称“gov.nist”表示所获取的 SIP 堆栈。
            //SipStack 对象接受一些属性。至少必须设置堆栈名称。
            sipStack = sipFactory.createSipStack(properties);
        }
        catch (PeerUnavailableException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        try
        {
            HeaderFactory headerFactory = sipFactory.createHeaderFactory();
            AddressFactory addressFactory = sipFactory.createAddressFactory();
            MessageFactory msgFactory = sipFactory.createMessageFactory();
            ListeningPoint lp = sipStack.createListeningPoint(ipAddr,
                    port, "udp");

            SipProvider sipProvider = sipStack.createSipProvider(lp);
            SipListener sipListener = new MySipListener(ipAddr, port, addressFactory, msgFactory, headerFactory, sipProvider);
            System.out.println("udp provider " + sipProvider.toString());
            System.out.println("=====================OK==================");
            sipProvider.addSipListener(sipListener);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }

    }

}