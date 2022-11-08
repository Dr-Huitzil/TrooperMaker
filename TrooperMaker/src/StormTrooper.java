public class StormTrooper extends Trooper {
    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String name, int soldierCount) {
        super(name, soldierCount);
        this.name = name;
        soldierCount++;
        setTrooperKind("StormTrooper");
        setMarchModifier(1.10);
    }

    public double march(double duration) {
        return marchSpeed * duration * marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    @Override
    public String toString() {
        return "StormTrooper{" +
                "name='" + name + '\'' +
                ", soldierCount=" + soldierCount +
                '}';
    }
}
