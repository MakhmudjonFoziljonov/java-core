package lesson11.task1;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
@Getter
public class Publisher implements Runnable {
    private final MessageService messageService;
    private final String name;
    private volatile boolean exit;

    private void publish(String message) {
        messageService.publisher(message);
    }

    @SneakyThrows
    @Override
    public void run() {
        publish(name);
        Thread.sleep(1000);
    }


    public void exit() {
        exit = false;
    }
}
