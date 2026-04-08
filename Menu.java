public enum Menu{

    ADD_ITEM(1),
    DISPLAY_ITEMS(2),
    TOTAL_ITEMS(3),
    TOTAL_WORTH(4),
    INC_PRICE(5),
    ABOVE_LIMIT(6),

    ADD_ORDER(7),
    ORDER_COST(8),
    EXIT(9);

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
