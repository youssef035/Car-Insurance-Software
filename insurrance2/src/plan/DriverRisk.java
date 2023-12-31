package plan;

public class DriverRisk extends Risk{

    @Override
    public float getPremium() {
        return 0.05f;
    }

    @Override
    public float getCoverage() {
        return 0.7f;
    }

    @Override
    public float getCeiling() {
        return 6;
    }

    public String[] driverRiskCovered = {
            "Driver Damage"
    };
}
