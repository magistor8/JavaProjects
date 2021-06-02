package lesson8.part2;

public enum Color {
    BLACK("черный") {
        @Override
        public void action() {
            System.out.println("1111");
        }
    },
    GREY("серый") {
        @Override
        public void action() {
            System.out.println("2222");

        }
    },
    WHITE("белый") {
        @Override
        public void action() {
            System.out.println("3333");

        }
    };

    private String russianColor;

    Color(String russianColor) {
        this.russianColor = russianColor;
    }

    public String getRussianColor() {
        return russianColor;
    }

    abstract public void action();
}
