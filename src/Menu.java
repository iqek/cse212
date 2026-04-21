public enum Menu{

    ADD_ITEM(1),
    DISPLAY_ITEMS(2),
    TOTAL_ITEMS(3),
    TOTAL_WORTH(4),
    INC_PRICE(5),
    ABOVE_LIMIT(6),
    REMOVE_CITY(7),

    ADD_ORDER(8),
    ORDER_COST(9),
    EXIT(10);

    private int value;

    Menu(int value) {
        this.value = value;
    }

    public static Menu fromInt(int choice) {
        for (Menu option : Menu.values()) {
            if (option.value == choice) {
                return option;
            }
        }
        return null;
    }
}
