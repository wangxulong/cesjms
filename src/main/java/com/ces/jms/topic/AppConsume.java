package com.ces.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by wxl on 2017/9/22.
 *
 * @author wxl
 */
public class AppConsume {
    private static final String url = "tcp://localhost:61616";
    private static final String topicName = "topic-test";

    public static void main(String[] args) throws JMSException {
        //创建链接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //打开链接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination = session.createTopic(topicName);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage msg  = (TextMessage) message;
                try {
                    System.out.println("收到主题消息："+msg.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
