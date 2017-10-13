package blockingqueue.delayqueue;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *  this is a wrong usage of DelayQueue, the DelayedTest should be a runnable
 */
public class DelayQueueTest {
    public static void main(String... args) {
        DelayQueue dq = new DelayQueue();
        DeleyedTest ob1 = new DeleyedTest(10);
        DeleyedTest ob2 = new DeleyedTest(5);
        DeleyedTest ob3 = new DeleyedTest(15);

        dq.offer(ob1);
        dq.offer(ob2);
        dq.offer(ob3);

        /*Iterator itr = dq.iterator();
        while (itr.hasNext()) {
            DeleyedTest dt = (DeleyedTest) itr.next();
            System.out.println(dt.deleyTime);
        }*/
        while(!dq.isEmpty()){
            DeleyedTest dt = (DeleyedTest)dq.poll();
            System.out.println(dt.deleyTime);

        }
    }
}

class DeleyedTest implements Delayed {
    public long deleyTime = 0;

    DeleyedTest(long deleyTime) {
        this.deleyTime = deleyTime;
    }

    @Override
    public int compareTo(Delayed ob) {
        if (this.deleyTime < ((DeleyedTest) ob).deleyTime) {
            return -1;
        } else if (this.deleyTime > ((DeleyedTest) ob).deleyTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        unit.convert(deleyTime - System.currentTimeMillis(), TimeUnit.SECONDS);
        return 0;
    }

}

