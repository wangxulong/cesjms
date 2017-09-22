package com.ces.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by wxl on 2017/9/22.
 *
 * @author wxl
 */
public class AppProducer {
    private static final String url = "tcp://localhost:61616";
    private static final String queueName = "queue-test";

    /**
     * 1.创建连接工厂
     * 2.创建连接
     * 3.启动连接
     * 4.创建会话
     * 5.创建目的地
     * 6.创建生产者
     * 7.创建消息
     *
     * @param args
     */
    public static void main(String[] args) throws JMSException {
        //1.创建链接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination = session.createQueue(queueName);
        //创建生产者
        MessageProducer messageProducer = session.createProducer(destination);
        for (int i = 0; i < 100; i++) {
            TextMessage message = session.createTextMessage("test1:"+i);
            messageProducer.send(message);
            System.out.println("发送消息："+message.getText());
        }
        connection.close();
     }
}
