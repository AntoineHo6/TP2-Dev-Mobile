package Model;

public class sectionMetier {

    private String sectionName;
    private char firstLetter;
    private boolean isActive;

    public sectionMetier(String name, boolean isActive) {
        this.sectionName = name;
        this.isActive = isActive;
        createFirstLetter();
    }

    private void createFirstLetter(){
        firstLetter = sectionName.charAt(0);
        firstLetter =  Character.toUpperCase(firstLetter);
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
