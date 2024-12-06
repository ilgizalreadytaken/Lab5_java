package N4;

public class Pupil {
    private String surname;
    private String name;
    private int[] scores;

    public Pupil(String surname, String name, int[] scores) {
        this.surname = surname;
        this.name = name;
        this.scores = scores;
    }

    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
