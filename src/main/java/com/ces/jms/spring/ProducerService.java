package com.ces.jms.spring;

import javax.jms.Destination;

/**
 * Created by wxl on 2017/9/22.
 *
 * @author wxl
 */
public interface ProducerService {
    void sendMessage(Destination destination, String message);
}
