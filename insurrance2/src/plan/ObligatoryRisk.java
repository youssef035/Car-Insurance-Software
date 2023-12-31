package plan;

public class ObligatoryRisk extends Risk{


    @Override
    public float getPremium() {
        return 0.01f;
    }

    @Override
    public float getCoverage() {
        return 0.6f;
    }

    @Override
    public float getCeiling() {
        return 4;
    }

    public String[] obligatoryRiskCovered = {
            "Third party damage"
    };
}
