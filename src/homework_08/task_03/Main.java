package homework_08.task_03;


/*
Задание 3+
Демонстрация приоритетов.
Создать 2 класса PriorityRunner и PriorityThread.
Запустить 3 потока с приоритетами (min, max, norm).
При помощи цикла for выведем на экран значения от 1 до 50 и укажем, какой именно поток данную операцию делает.
 */


public class Main {

    public static int myCounter = 50;

    public static void main(String[] args) throws InterruptedException {

        Thread priorityRunner = new Thread(new PriorityRunner());
        Thread priorityThread = new Thread(new PriorityThread());

        Thread iAmWaveThread = Thread.currentThread(); // Статический метод currentThread() инкапсулирует текущий поток в этот объект

        priorityRunner.setPriority(1);
        priorityThread.setPriority(10);

        priorityRunner.start();
        priorityThread.start();

        System.out.println("Привет Я поток " + iAmWaveThread.getName());
        for (int i = 0; i < myCounter; i++) {   //В этом цикле у нас работа потока mainThread
            int sl = 500 + i;
            Thread.sleep(sl);      // Метод sleep() усыпляет поток на кол-во миллисекунд
            System.out.println("Я поток " + iAmWaveThread.getName() + " работаю в цикле, мой приоритет " + iAmWaveThread.getPriority() + " мой i = " + i + " я сплю " + sl + " milliS ");
        }

        System.out.println("************ " + iAmWaveThread.getName() +" FINISH ************");
    }
}

class PriorityRunner implements Runnable {


    @Override
    public void run() {  // Для того, чтобы поток выполнялся параллельно

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("PriorityRunner");
        System.out.println("Привет Я поток " + iAmWaveThread.getName());

        for (int r = 0; r < Main.myCounter; r++) {
            try {
                int sl = 500 + r;
                Thread.sleep(sl);
                System.out.println("Я поток " + iAmWaveThread.getName() + " работаю в цикле, мой приоритет " + iAmWaveThread.getPriority() + " мой r = " + r + " я сплю " + sl + " milliS ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("************ " + iAmWaveThread.getName() +" FINISH ************");
    }
}

class PriorityThread extends Thread {

    public void run() {  // Данный метод сработает при старте потока

        Thread iAmWaveThread = Thread.currentThread();
        iAmWaveThread.setName("PriorityThread");
        System.out.println("Привет Я поток " + iAmWaveThread.getName());

        for (int t = 0; t < Main.myCounter; t++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            try {
                int sl = 500 + t;
                Thread.sleep(sl);
                System.out.println("Я поток " + iAmWaveThread.getName() + " работаю в цикле, мой приоритет " + iAmWaveThread.getPriority() + " мой t = " + t + " я сплю " + sl + " milliS ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("************ " + iAmWaveThread.getName() +" FINISH ************");
    }

}
