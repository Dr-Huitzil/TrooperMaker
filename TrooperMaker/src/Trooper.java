import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Trooper {
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    Trooper() {
        this.unit = "AA";
        this.number = 0;
        this.trooperKind = "AA";
        this.marchSpeed = 0;
        this.marchModifier = 0;
    }

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        this.marchSpeed = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> army, Trooper t) {
        if (t == null) {
            return;
        }
        if (army.containsKey(t.getUnit())) {
            army.get(t.getUnit()).add(t);
        } else {
            List<Trooper> trooperList = new ArrayList<>();
            trooperList.add(t);
            army.put(t.getUnit(), trooperList);
        }
    }

    public double march(double distance){
        return 0;
    }

    public boolean attack(Trooper target, int roll) {

        if (this == target || roll == 1) {
            System.out.println(this.toString() + " is targeting itself.");
            System.out.println(this.toString() + " rolled a " + roll + " and hurt itself in the confusion");
            return true;
        }
        if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("rolled a " + roll + " against the rebel scum.");
                return roll > 10 && roll % 2 == 0;
            } else if (target instanceof StormTrooper) {
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable Collateral Damage!");
                return roll > 10 || roll % 2 == 0;
            }
        } else if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target instanceof StormTrooper) {
                System.out.println("rolled a " + roll + " against the imperial scum.");
                return roll > 5 || roll % 2 == 1;
            } else {
                System.out.println("Rebels target an innocent bystander");
                return roll >= 18 && roll % 2 == 0;
            }
        }
        return false;

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    @Override
    public String toString() {
        return "Trooper{" +
                "unit='" + unit + '\'' +
                ", number=" + number +
                ", trooperKind='" + trooperKind + '\'' +
                ", marchSpeed=" + marchSpeed +
                ", marchModifier=" + marchModifier +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Trooper trooper)) return false;
//        return getNumber() == trooper.getNumber() && Double.compare(trooper.getMarchSpeed(), getMarchSpeed()) == 0 && Double.compare(trooper.getMarchModifier(), getMarchModifier()) == 0 && getUnit().equals(trooper.getUnit()) && getTrooperKind().equals(trooper.getTrooperKind());
//    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnit(), getNumber(), getTrooperKind(), getMarchSpeed(), getMarchModifier());
    }
}