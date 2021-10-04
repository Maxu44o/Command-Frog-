public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        if (position + steps <= MAX_POSITION && position + steps >= MIN_POSITION) {
            position = position + steps;
            return true;
        } else return false;
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
    }

    public void printFrog() {
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            if (i != position) System.out.print("_");
            else System.out.print("*");
        }
        System.out.println();
    }
}