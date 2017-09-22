package com.ces.jms.spring;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by wxl on 2017/9/22.
 *
 * @author wxl
 */
public class ConsumeSessionAwareMessageListener implements SessionAwareMessageListener {
    private Destination destination;
    public void onMessage(Message message, Session session) throws JMSException {
        System.out.println("收到一个消息");

    }
}
