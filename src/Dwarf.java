public class Dwarf implements Character {
    private static final double DEFAULT_ATTACK = 2;
    private static final double DEFAULT_DEFENCE = 5;

    private static final double FLATLAND_ATTACK_POWER_UP = 1;
    private static final double FLATLAND_DEFENCE_POWER_UP = 1;
    private static final double WOODLAND_ATTACK_POWER_UP = 1;
    private static final double WOODLAND_DEFENCE_POWER_UP = 1;
    private static final double MOUNTAIN_ATTACK_POWER_UP = 2;
    private static final double MOUNTAIN_DEFENCE_POWER_UP = 1;

    private static final double DAY_ATTACK_POWER_UP = 1;
    private static final double DAY_DEFENCE_POWER_UP = 1;
    private static final double NIGHT_ATTACK_POWER_UP = 1;
    private static final double NIGHT_DEFENCE_POWER_UP = 1;

    private double attack;
    private double defence;

    public Dwarf() {
        this.attack = DEFAULT_ATTACK;
        this.defence = DEFAULT_DEFENCE;
    }

    @Override
    public double getDayAttack(String terrain) {
        double attack = this.attack;

        if(terrain.equals("pianura")) {
            attack *= FLATLAND_ATTACK_POWER_UP * DAY_ATTACK_POWER_UP;
        }

        else if(terrain.equals("bosco")) {
            attack *= WOODLAND_ATTACK_POWER_UP * DAY_ATTACK_POWER_UP;
        }

        else if(terrain.equals("montagna")) {
            attack *= MOUNTAIN_ATTACK_POWER_UP * DAY_ATTACK_POWER_UP;
        }
        
        return attack;
    }

    @Override
    public double getDayDefence(String terrain) {
        double defence = this.defence;

        if(terrain.equals("pianura")) {
            defence *= FLATLAND_DEFENCE_POWER_UP * DAY_DEFENCE_POWER_UP;
        }

        else if(terrain.equals("bosco")) {
            defence *= WOODLAND_DEFENCE_POWER_UP * DAY_DEFENCE_POWER_UP;
        }

        else if(terrain.equals("montagna")) {
            defence *= MOUNTAIN_DEFENCE_POWER_UP * DAY_DEFENCE_POWER_UP;
        }

        return defence;
    }

    @Override
    public double getNightAttack(String terrain) {
        double attack = this.attack;

        if(terrain.equals("pianura")) {
            attack *= FLATLAND_ATTACK_POWER_UP * NIGHT_ATTACK_POWER_UP;
        }

        else if(terrain.equals("bosco")) {
            attack *= WOODLAND_ATTACK_POWER_UP * NIGHT_ATTACK_POWER_UP;
        }

        else if(terrain.equals("montagna")) {
            attack *= MOUNTAIN_ATTACK_POWER_UP * NIGHT_ATTACK_POWER_UP;
        }
        
        return attack;
    }

    @Override
    public double getNightDefence(String terrain) {
        double defence = this.defence;

        if(terrain.equals("pianura")) {
            defence *= FLATLAND_DEFENCE_POWER_UP * NIGHT_DEFENCE_POWER_UP;
        }

        else if(terrain.equals("bosco")) {
            defence *= WOODLAND_DEFENCE_POWER_UP * NIGHT_DEFENCE_POWER_UP;
        }

        else if(terrain.equals("montagna")) {
            defence *= MOUNTAIN_DEFENCE_POWER_UP * NIGHT_DEFENCE_POWER_UP;
        }

        return defence;
    }
    
    public String toString() {
        return "Nano";
    }
}
