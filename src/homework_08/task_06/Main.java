package homework_08.task_06;

/*
Задание 6+
Создать 2 класса. Реализовать взаимную блокировку(deadlock) этих классов.
 */

public class Main {

    public static void main(String[] args) {
        MySynchro s = new MySynchro();
        Thread first = new Thread(new OneClass(s));
        Thread second = new Thread(new SecondClass(s));
        first.start();
        second.start();
    }
}

class MySynchro {

    boolean aBoolean;

    synchronized void getOneClass(int i) {

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("__One Class__");
        if (aBoolean) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Я поток " + iAmWaveThread.getName() + " Печатаю - " + i);
        aBoolean = true;
        notify();
    }

    synchronized void getSecondClass(int i) {
        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("__Second Class__");
        if (!aBoolean) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Я поток " + iAmWaveThread.getName() + " Печатаю - " + i);
        aBoolean = false;
        notify();
    }
}

class OneClass extends Thread {
    MySynchro s;

    public OneClass(MySynchro s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0) {
                s.getOneClass(i);
            }
        }
    }
}

class SecondClass extends Thread {

    MySynchro s;

    public SecondClass(MySynchro s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            s.getSecondClass(i);
        }
    }
}
