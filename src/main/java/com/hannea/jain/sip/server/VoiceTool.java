/*
package com.hannea.jain.sip.server;
import com.sun.media.rtp.RTPSessionMgr;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.TrackControl;
import javax.media.format.AudioFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import javax.media.rtp.ReceiveStream;
import javax.media.rtp.ReceiveStreamListener;
import javax.media.rtp.SendStream;
import javax.media.rtp.SessionAddress;
import javax.media.rtp.event.NewReceiveStreamEvent;
import javax.media.rtp.event.ReceiveStreamEvent;
*/
/**
 * @Author: wangguomin
 * @Date: 2019-01-04 21:36
 *//*


public class VoiceTool implements ReceiveStreamListener {


    private RTPSessionMgr myVoiceSessionManager;
    private Processor myProcessor;
    private SendStream ss;
    private ReceiveStream rs;
    private Player player;

    public void startMedia(String peerIP, int peerPort, int recvPort) {

        try {

            MediaLocator ml = new MediaLocator("javasound://44100");
            DataSource dataSource = Manager.createDataSource(ml);

            myProcessor = Manager.createProcessor(dataSource);
            myProcessor.configure();
            while (myProcessor.getState() != Processor.Configured) {

                Thread.sleep(10);

            }

            myProcessor.setContentDescriptor(new ContentDescriptor(ContentDescriptor.RAW_RTP));
            TrackControl track[] = myProcessor.getTrackControls();
            AudioFormat af = new AudioFormat(AudioFormat.DVI_RTP, 8000, 4, 1);
            track[0].setFormat(af);

            myProcessor.realize();
            while (myProcessor.getState() != Processor.Realized) {

                Thread.sleep(10);

            }

            DataSource ds = myProcessor.getDataOutput();
            myVoiceSessionManager = new RTPSessionMgr();
            myVoiceSessionManager.addReceiveStreamListener(this);

            SessionAddress sendAddr = new SessionAddress();
            myVoiceSessionManager.initSession(sendAddr, null, 0.05, 0.25);

            InetAddress destAddr = InetAddress.getByName(peerIP);
            SessionAddress localAddr = new SessionAddress(InetAddress.getLocalHost(), recvPort,
                    InetAddress.getLocalHost(), recvPort + 1);

            SessionAddress remoteAddr = new SessionAddress(destAddr, peerPort, destAddr, peerPort + 1);
            myVoiceSessionManager.startSession(localAddr, localAddr, remoteAddr, null);

            ss = myVoiceSessionManager.createSendStream(ds, 0);
            ss.start();
            myProcessor.start();


        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void stopMedia() {

        try {

            player.stop();
            player.deallocate();
            player.close();

            ss.stop();

            myProcessor.stop();
            myProcessor.deallocate();
            myProcessor.close();

            myVoiceSessionManager.closeSession("terminated");
            myVoiceSessionManager.dispose();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void update(ReceiveStreamEvent rse) {

        try {

            if (rse instanceof NewReceiveStreamEvent) {

                rs = rse.getReceiveStream();
                DataSource myDs = rs.getDataSource();
                player = Manager.createRealizedPlayer(myDs);
                player.start();

            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }


}
*/
