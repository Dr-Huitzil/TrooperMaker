public class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soldierCount = 0;

    public RebelTrooper(String name, int soldierCount, String name1) {
/*        The parameterized constructor performs the following actions:
//         1) uses the constructor from the parent class to set the fields unit and number
//         2) increments soldierCounter
//         3) sets trooperKind to “pilot”
//         4) sets marchModifier to 0.75
           5) sets name to the parameter value passed in.
 */
        super(name, soldierCount);
        this.name = name1;
        soldierCount++;
        setTrooperKind("pilot");
        setMarchModifier(0.75);
        setName(name);
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
