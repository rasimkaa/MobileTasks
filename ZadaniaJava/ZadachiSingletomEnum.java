// Задача 1: Класс для подключения к базе данных (Singleton)
class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() {
        System.out.println("Подключение к базе данных создано.");
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// Задача 2: Класс логирования (Singleton)
import java.util.ArrayList;
import java.util.List;

class Logger {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();
    
    private Logger() {}
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        logs.add(message);
    }
    
    public void showLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}

// Задача 3: Enum для статусов заказа и класс Order
enum OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, CANCELLED;
}

class Order {
    private int id;
    private OrderStatus status;
    
    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }
    
    public void changeStatus(OrderStatus newStatus) {
        if (this.status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
            System.out.println("Нельзя отменить доставленный заказ.");
        } else {
            this.status = newStatus;
        }
    }
    
    public void showStatus() {
        System.out.println("Заказ " + id + " статус: " + status);
    }
}

// Задача 4: Enum для сезонов года и метод для получения их названия
enum Season {
    WINTER, SPRING, SUMMER, AUTUMN;
}

class SeasonHelper {
    public static String getSeasonName(Season season) {
        return switch (season) {
            case WINTER -> "Зима";
            case SPRING -> "Весна";
            case SUMMER -> "Лето";
            case AUTUMN -> "Осень";
        };
    }
}

// Тестирование всех классов
public class Main {
    public static void main(String[] args) {
        // Тестирование Singleton DatabaseConnection
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println(db1 == db2); // Должно быть true
        
        // Тестирование Singleton Logger
        Logger logger = Logger.getInstance();
        logger.log("Первое сообщение.");
        logger.log("Второе сообщение.");
        logger.showLogs();
        
        // Тестирование Order и OrderStatus
        Order order = new Order(101);
        order.showStatus();
        order.changeStatus(OrderStatus.IN_PROGRESS);
        order.showStatus();
        order.changeStatus(OrderStatus.DELIVERED);
        order.showStatus();
        order.changeStatus(OrderStatus.CANCELLED); // Нельзя отменить доставленный заказ
        order.showStatus();
        
        // Тестирование Enum Season
        System.out.println(SeasonHelper.getSeasonName(Season.WINTER)); // Зима
        System.out.println(SeasonHelper.getSeasonName(Season.SUMMER)); // Лето
    }
}