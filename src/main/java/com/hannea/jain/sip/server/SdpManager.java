/*
package com.hannea.jain.sip.server;

import java.util.Date;
import java.util.Vector;
import javax.media.rtp.SessionAddress;
import javax.sdp.Connection;
import javax.sdp.MediaDescription;
import javax.sdp.Origin;
import javax.sdp.SdpFactory;
import javax.sdp.SessionDescription;
import javax.sdp.SessionName;
import javax.sdp.Time;
import javax.sdp.Version;


*/
/**
 * @Author: wangguomin
 * @Date: 2019-01-04 21:38
 *//*

public class SdpManager {


    private SdpFactory mySdpFactory;
    private byte[] mysdpContent;

    public SdpManager() {

        mySdpFactory = SdpFactory.getInstance();

    }

    public byte[] createSdp(SdpInfo sdpinfo) {

        try {

            Version myVersion = mySdpFactory.createVersion(0);

            long ss = mySdpFactory.getNtpTime(new Date());
            Origin myOrigin = mySdpFactory.createOrigin("-", ss, ss, "IN", "IP4", sdpinfo.getIpAddress());

            SessionName mySessionName = mySdpFactory.createSessionName("-");
            Connection myConnection = mySdpFactory.createConnection("IN", "IP4", sdpinfo.getIpAddress());

            Time myTime = mySdpFactory.createTime();
            Vector myTimeVector = new Vector();
            myTimeVector.add(myTime);

            int[] aaf = new int[1];
            aaf[0] = sdpinfo.getVoiceFormat();

            MediaDescription myAudioMediaDescription = mySdpFactory.createMediaDescription("audio", sdpinfo.getVoicePort(), 1, "RTP/AVP", aaf);

            Vector myMediaDescriptionVector = new Vector();
            myMediaDescriptionVector.add(myAudioMediaDescription);

            SessionDescription mySdp = mySdpFactory.createSessionDescription();
            mySdp.setVersion(myVersion);
            mySdp.setOrigin(myOrigin);
            mySdp.setSessionName(mySessionName);
            mySdp.setConnection(myConnection);
            mySdp.setTimeDescriptions(myTimeVector);
            mySdp.setMediaDescriptions(myMediaDescriptionVector);

            return mySdp.toString().getBytes();


        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
        return null;

    }

    public SdpInfo getSdp(byte[] content) {

        try {

            SdpInfo mySdpinfo = new SdpInfo();

            String s = new String(content);
            SessionDescription recSdp = mySdpFactory.createSessionDescription(s);

            String myIpAddress = recSdp.getConnection().getAddress();
            mySdpinfo.setIpAddress(myIpAddress);

            Vector recMediaDescriptionVector = recSdp.getMediaDescriptions(false);
            MediaDescription myAudioDescription = (MediaDescription) recMediaDescriptionVector.elementAt(0);
            int voicePort = myAudioDescription.getMedia().getMediaPort();
            mySdpinfo.setVoicePort(voicePort);

            Vector voiceFormatVector = myAudioDescription.getMedia().getMediaFormats(false);
            int voiceFormat = Integer.parseInt(voiceFormatVector.elementAt(0).toString());
            mySdpinfo.setVoiceFormat(voiceFormat);

            return mySdpinfo;


        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
        return null;

    }

}
*/
