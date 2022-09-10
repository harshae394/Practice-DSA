package threadstest;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.log4j.Logger;

public class InterThreadCommunicationExample {
    private static final Logger logger = Logger.getLogger(InterThreadCommunicationExample.class);
    public static void main(String args[]) {

        final Queue<Integer> sharedQ = new LinkedList<Integer>();
        logger.debug("Queue is empty, waiting");
        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);

        producer.start();
        consumer.start();

    }
}

