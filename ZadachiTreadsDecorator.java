import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.StandardCopyOption;

// Задание 1: Работа с потоками ввода-вывода (IO)
class FileProcessor {
    public static void processFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Задание 2: Реализация паттерна Декоратор
interface TextProcessor {
    String process(String text);
}

class SimpleTextProcessor implements TextProcessor {
    public String process(String text) {
        return text;
    }
}

class UpperCaseDecorator implements TextProcessor {
    private final TextProcessor processor;
    public UpperCaseDecorator(TextProcessor processor) {
        this.processor = processor;
    }
    public String process(String text) {
        return processor.process(text).toUpperCase();
    }
}

class TrimDecorator implements TextProcessor {
    private final TextProcessor processor;
    public TrimDecorator(TextProcessor processor) {
        this.processor = processor;
    }
    public String process(String text) {
        return processor.process(text).trim();
    }
}

class ReplaceDecorator implements TextProcessor {
    private final TextProcessor processor;
    public ReplaceDecorator(TextProcessor processor) {
        this.processor = processor;
    }
    public String process(String text) {
        return processor.process(text).replace(" ", "_");
    }
}

// Задание 3: Сравнение IO и NIO
class PerformanceComparison {
    public static void comparePerformance(String inputFile, String outputFileIO, String outputFileNIO) throws IOException {
        long start, end;
        
        // IO
        start = System.nanoTime();
        FileProcessor.processFile(inputFile, outputFileIO);
        end = System.nanoTime();
        System.out.println("IO Time: " + (end - start) / 1_000_000 + " ms");
        
        // NIO
        start = System.nanoTime();
        try (FileChannel srcChannel = FileChannel.open(Path.of(inputFile), StandardOpenOption.READ);
             FileChannel destChannel = FileChannel.open(Path.of(outputFileNIO), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (srcChannel.read(buffer) != -1) {
                buffer.flip();
                destChannel.write(buffer);
                buffer.clear();
            }
        }
        end = System.nanoTime();
        System.out.println("NIO Time: " + (end - start) / 1_000_000 + " ms");
    }
}

// Задание 4: Копирование файла с использованием NIO
class FileCopier {
    public static void copyFile(String source, String dest) throws IOException {
        try (FileChannel srcChannel = new FileInputStream(source).getChannel();
             FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
            srcChannel.transferTo(0, srcChannel.size(), destChannel);
        }
    }
}

// Задание 5: Асинхронное чтение файла с использованием NIO.2
class AsyncFileReader {
    public static void readFile(String filePath) {
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Path.of(filePath), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            CompletableFuture<Void> future = new CompletableFuture<>();
            fileChannel.read(buffer, 0, buffer, new java.nio.channels.CompletionHandler<>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    byte[] data = new byte[attachment.remaining()];
                    attachment.get(data);
                    System.out.println(new String(data));
                    future.complete(null);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                    future.completeExceptionally(exc);
                }
            });
            future.get();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

// Главный класс для запуска
public class Main {
    public static void main(String[] args) throws IOException {
        // Задание 1: Обработка файла IO
        FileProcessor.processFile("input.txt", "output.txt");

        // Задание 2: Декоратор
        TextProcessor processor = new ReplaceDecorator(
            new UpperCaseDecorator(
                new TrimDecorator(new SimpleTextProcessor())
            )
        );
        System.out.println(processor.process(" Hello world "));
        
        // Задание 3: Сравнение IO и NIO
        PerformanceComparison.comparePerformance("input.txt", "outputIO.txt", "outputNIO.txt");
        
        // Задание 4: Копирование файла NIO
        FileCopier.copyFile("input.txt", "copy.txt");
        
        // Задание 5: Асинхронное чтение файла
        AsyncFileReader.readFile("input.txt");
    }
}