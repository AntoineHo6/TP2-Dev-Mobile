package Presenter;

class Student {

    private String name;
    private int progression;

    public Student(String name, int progression) {
        this.name = name;
        this.progression = progression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgression() {
        return progression;
    }

    public void setProgression(int progression) {
        this.progression = progression;
    }
}
