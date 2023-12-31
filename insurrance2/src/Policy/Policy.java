package Policy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Policy implements Serializable {

    static int policyNb;    // as class variable

    //object
    Vehicle vehicle;

    List<String> RisksCoveredList = new ArrayList<>();

    List<Float> premiumList = new ArrayList<>();
    List<Float> coverageList = new ArrayList<>();
    List<Float> ceilingList = new ArrayList<>();

    int validityYear;
    LocalDate policyDate;


    //constructor

    public Policy(Vehicle vehicle, List<String> risksCoveredList, List<Float> premiumList, List<Float> coverageList, List<Float> ceilingList, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        RisksCoveredList = risksCoveredList;
        this.premiumList = premiumList;
        this.coverageList = coverageList;
        this.ceilingList = ceilingList;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
        policyNb +=1;
    }


    public static int getPolicyNb() {
        return policyNb;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getRisksCoveredList() {
        return RisksCoveredList;
    }

    public List<Float> getPremiumList() {
        return premiumList;
    }

    public List<Float> getCoverageList() {
        return coverageList;
    }

    public List<Float> getCeilingList() {
        return ceilingList;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }


    @Override
    public String toString() {
        return "Policy number = " + policyNb +
                "\n vehicle=" + vehicle +
                "\n validityYear=" + validityYear
                ;
    }
}
