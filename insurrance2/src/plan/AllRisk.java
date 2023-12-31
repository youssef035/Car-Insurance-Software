package plan;

public class AllRisk extends Risk{


    @Override
    public float getPremium() {
        return 0.075f;
    }

    @Override
    public float getCoverage() {
        return 1;
    }

    @Override
    public float getCeiling() {
        return 10;
    }

    public String[] allRiskCovered = {
            "Fire",
            "Robbery",
            "transport",
            "Car replacement",
            "Vehicle damage",
            "Third party damage",
            "Driver Damage"
    };
}
