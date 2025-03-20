import java.util.concurrent.*;
import java.util.*;

public class Mnogopoto4ka {

    // Задача 1: Общий счётчик
    static class Counter {
        private int count = 0;
        private final Object lock = new Object();

        public void increment() {
            synchronized (lock) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    // Задача 2: Генерация последовательности чисел
    static class NumberGenerator implements Runnable {
        private final List<Integer> list;

        public NumberGenerator(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                list.add(i);
            }
        }
    }

    // Задача 3: Пул потоков
    static class TaskExecutor implements Runnable {
        private final int taskNumber;

        public TaskExecutor(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
        }
    }

    // Задача 4: Симуляция работы банка
    static class Account {
        private int balance;

        public Account(int balance) {
            this.balance = balance;
        }

        public synchronized void transfer(Account target, int amount) {
            if (this.balance >= amount) {
                this.balance -= amount;
                target.balance += amount;
                System.out.println(Thread.currentThread().getName() + " transferred " + amount);
            }
        }

        public int getBalance() {
            return balance;
        }
    }

    // Задача 5: Барьер синхронизации
    static class TaskWithBarrier implements Runnable {
        private final CyclicBarrier barrier;

        public TaskWithBarrier(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is working...");
                Thread.sleep(1000); // Simulate work
                barrier.await();  // Wait for other threads
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Задача 6: Ограниченный доступ к ресурсу
    static class SemaphoreTask implements Runnable {
        private final Semaphore semaphore;

        public SemaphoreTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // Acquire semaphore
                System.out.println(Thread.currentThread().getName() + " is using the resource");
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Release semaphore
            }
        }
    }

    // Задача 7: Обработка результатов задач
    static class FactorialTask implements Callable<Long> {
        private final int number;

        public FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            return factorial(number);
        }

        private long factorial(int n) {
            if (n == 0) return 1;
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    // Задача 8: Симуляция производственной линии
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer item = queue.take();
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Задача 9: Многопоточная сортировка
    static class SortTask implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;

        public SortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            Arrays.sort(array, start, end);
        }
    }

    // Задача 10: Обед философов
    static class Philosopher implements Runnable {
        private final Object leftFork;
        private final Object rightFork;

        public Philosopher(Object leftFork, Object rightFork) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (leftFork) {
                        synchronized (rightFork) {
                            System.out.println(Thread.currentThread().getName() + " is eating");
                            Thread.sleep(1000); // Simulate eating
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Задача 11: Расчёт матрицы в параллельных потоках
    static class MatrixMultiplicationTask implements Runnable {
        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] resultMatrix;
        private final int row;

        public MatrixMultiplicationTask(int[][] matrixA, int[][] matrixB, int[][] resultMatrix, int row) {
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.resultMatrix = resultMatrix;
            this.row = row;
        }

        @Override
        public void run() {
            for (int col = 0; col < matrixB[0].length; col++) {
                resultMatrix[row][col] = 0;
                for (int i = 0; i < matrixA[0].length; i++) {
                    resultMatrix[row][col] += matrixA[row][i] * matrixB[i][col];
                }
            }
        }
    }

    // Задача 12: Таймер с многопоточностью
    static class TimerTask implements Runnable {
        @Override
        public void run() {
            int seconds = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    System.out.println("Time: " + seconds + " seconds");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Задача 1
        Counter counter = new Counter();
        Runnable counterTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread[] threads1 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads1[i] = new Thread(counterTask);
            threads1[i].start();
        }
        for (Thread t : threads1) {
            t.join();
        }
        System.out.println("Counter value: " + counter.getCount());

        // Задача 2
        List<Integer> numberList = new CopyOnWriteArrayList<>();
        Thread[] threads2 = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads2[i] = new Thread(new NumberGenerator(numberList));
            threads2[i].start();
        }
        for (Thread t : threads2) {
            t.join();
        }
        System.out.println("Generated numbers: " + numberList);

        // Задача 3
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 20; i++) {
            executor.submit(new TaskExecutor(i));
        }
        executor.shutdown();

        // Задача 4
        Account account1 = new Account(1000);
        Account account2 = new Account(500);
        Runnable transferTask = () -> account1.transfer(account2, 100);
        Thread[] threads4 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads4[i] = new Thread(transferTask);
            threads4[i].start();
        }
        for (Thread t : threads4) {
            t.join();
        }
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        // Задача 5
        CyclicBarrier barrier = new CyclicBarrier(5);
        Thread[] threads5 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads5[i] = new Thread(new TaskWithBarrier(barrier));
            threads5[i].start();
        }
        for (Thread t : threads5) {
            t.join();
        }

        // Задача 6
        Semaphore semaphore = new Semaphore(2);
        Thread[] threads6 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads6[i] = new Thread(new SemaphoreTask(semaphore));
            threads6[i].start();
        }
        for (Thread t : threads6) {
            t.join();
        }

        // Задача 7
        ExecutorService executor7 = Executors.newCachedThreadPool();
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            futures.add(executor7.submit(new FactorialTask(i)));
        }
        for (Future<Long> future : futures) {
            System.out.println("Factorial result: " + future.get());
        }
        executor7.shutdown();

        // Задача 8
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        // Задача 9
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        Thread[] threads9 = new Thread[2];
        threads9[0] = new Thread(new SortTask(numbers, 0, 5));
        threads9[1] = new Thread(new SortTask(numbers, 5, numbers.length));
        threads9[0].start();
        threads9[1].start();
        threads9[0].join();
        threads9[1].join();
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));

        // Задача 10
        Object[] forks = new Object[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
        Thread[] philosophers = new Thread[5];
        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Thread(new Philosopher(forks[i], forks[(i + 1) % 5]));
            philosophers[i].start();
        }
        for (Thread p : philosophers) {
            p.join();
        }

        // Задача 11
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        int[][] resultMatrix = new int[2][2];
        Thread[] threads11 = new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads11[i] = new Thread(new MatrixMultiplicationTask(matrixA, matrixB, resultMatrix, i));
            threads11[i].start();
        }
        for (Thread t : threads11) {
            t.join();
        }
        System.out.println("Matrix multiplication result: " + Arrays.deepToString(resultMatrix));

        // Задача 12
        Thread timerThread = new Thread(new TimerTask());
        timerThread.start();
        Thread.sleep(10000);  // Sleep for 10 seconds
        timerThread.interrupt(); // Stop the timer
    }
}
