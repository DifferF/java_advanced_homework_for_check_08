package homework_08.task_02;


/*
Задание 2+
Задержка потока.
Необходимо создать 3 потока, каждых из этих потоков запустить (например: main, second, first),
и когда эти потоки успешно отработают – вывести на экран сообщение (завершение потом first, second и main).
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(new FirstThread());
        Thread second = new Thread(new SecondThread());
        Thread third = new Thread(new ThirdThread());
        first.start();
        second.start();
        third.start();
    }

}

class FirstThread extends Thread {

    public void run() {

        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(1700);
                System.out.println("FirstThread run = " + j + " ******");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("************ FirstThread FINISH ************");
    }
}

class SecondThread extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(1500);
                System.out.println("SecondThread run = " + j + " ************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("************ SecondThread FINISH ************");
    }
}

class ThirdThread extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            try {
                Thread.sleep(1000);
                System.out.println("ThirdThread run = " + j + " ********");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("************ ThirdThread FINISH ************");
    }
}

