package lesson11.task1;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class Subscriber implements Runnable {

    private final MessageService messageService;
    private final String name;
    private volatile boolean exit;



    @Override
    public void run() {
        String message;
        while (true) {
            try {
                message = messageService.subscriber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (message != null) {
                System.out.println("Consumed Message = " + name);
                try {
                    Thread.sleep(100);
                    System.out.println("Enter anyone message bro, If you want to stop the program, type 'exit': ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void exit() {
        exit = false;
    }
}
