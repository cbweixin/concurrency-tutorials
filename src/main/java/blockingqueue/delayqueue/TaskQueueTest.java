package blockingqueue.delayqueue;

import blockingqueue.delayqueue.Task;

public class TaskQueueTest {
    public static void main(String[] args) {
        /*Task<Runnable> task1 = new Task<>(500,()->{
            System.out.println("task 1");
        });


        Task<Runnable> task2 = new Task<>(1000, ()->{
            System.out.println("task 2");
        });

        Task<Runnable> task3 = new Task<>(1500, ()->{
            System.out.println("task 3");
        });

        Task<Runnable> task4 = new Task<>(2000, ()->{
            System.out.println("task 4");
        });*/

        TaskQueueDaemonThread.getInstance().init();

        TaskQueueDaemonThread.getInstance().put(500, ()->{
            System.out.println("task 1 -- 500");
        });

        TaskQueueDaemonThread.getInstance().put(1000, ()->{
            System.out.println("task 2 -- 1000");
        });

        TaskQueueDaemonThread.getInstance().put(1500, ()->{
            System.out.println("task 3 -- 1500");
        });

        TaskQueueDaemonThread.getInstance().put(2000, ()->{
            System.out.println("task 4 -- 2000");
        });

        TaskQueueDaemonThread.getInstance().put(3000, ()->{
            System.out.println("task 5 -- 3000");
        });



    }
}
