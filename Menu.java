public enum Menu{

    ADD_ITEM(1),
    DISPLAY_ITEMS(2),
    TOTAL_ITEMS(3),
    TOTAL_WORTH(4),
    ADD_ORDER(5),
    ORDER_COST(6),
    EXIT(7);

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
