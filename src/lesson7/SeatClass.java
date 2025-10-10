package lesson7;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SeatClass {
    ECONOMY("Эконом"),
    BUSINESS("Бизнес");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
