import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;
import plan.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.xml.transform.dom.DOMLocator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {

    Font font = new Font("sansSerif", Font.BOLD,20);
    Color color = Color.GRAY;

    /********** PANEL 01 ************/
    JPanel p1;
    JTextField nameFLD;
    JTextField lastnameFLD;
    JTextField CityFLD;
    JTextField phoneFLD;
    JLabel nameLBL;
    JLabel lastnameLBL;
    JLabel CityLBL;
    JLabel phoneLBL;

    /********** PANEL 02 *************/
    JPanel p2;

    //text fields
    JTextField model;
    JTextField manufacturer;
    JTextField plateNB;
    JTextField estimatedV;

    //labels
    JLabel plateLBL;
    JLabel modelLBL;
    JLabel manufacturerLBL;
    JLabel estimatedLBL;
    JLabel spaceLBL;
    JLabel damageLBL;

    //buttons
    JRadioButton RBN1;
    JRadioButton RBN2;
    JRadioButton RBN3;
    JRadioButton RBN4;
    ButtonGroup G1;

    /**************** PANEL 03 **************/
    JPanel p3;
    JLabel packageLBL;
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assisCHKBX;

    /**************** PANEL 04 *************/
    JPanel p4;
    JLabel todayLBL;
    ButtonGroup G2;
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    int validityYear = 0;

    /*************** PANEL 05 ****************/
    JPanel p5;
    JButton saveBTN;
    JButton showBTN;
    JButton loadBTN;
    JButton newBTN;
    JTextField searchTXT;

    /************ PANEL 06 ************/
    JPanel p6;
    JTextArea risksTXT;
    Map<Integer, Customer> CustomerMap = new TreeMap<>();

    /************ PANEL 07 **********/
    JPanel p7;
    JTextArea policyTXT;

    /************ PANEL 08 ************/
    JPanel p8;
    JTextArea CustomerTXT;

    /************ PANEL 09 ************/
    JPanel p9;
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingFLD;
    JButton searchBTN;
    JButton confirmBTN;

    /************* PANEL 10 *************/
    JPanel p10;
    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL2;
    JTextArea claimingCustomerRisksCovered;
    JLabel claimingCustomervalidDateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    /************* PANEL 11 ***************/
    JPanel p11;
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    /************ PANEL 12 **************/
    JPanel p12;
    JTextArea settlementArea2;

    /******** arrays **********/
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRiskList = new ArrayList<>();
    Date currentDate = new Date();






    //constructor
    public MainScreen(){
        /*********** PANEL 01 ************/
        p1 = new JPanel();
        TitledBorder border1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Customer",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);

        p1.setBorder(border1);
        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(4,2));


        //the labels:
        nameLBL = new JLabel("first name ");
        lastnameLBL = new JLabel("last name ");
        CityLBL = new JLabel("City ");
        phoneLBL = new JLabel("Phone number ");

        //the text fields:
        nameFLD = new JTextField();             nameFLD.setOpaque(false);
        lastnameFLD = new JTextField();         lastnameFLD.setOpaque(false);
        CityFLD = new JTextField();             CityFLD.setOpaque(false);
        phoneFLD = new JTextField();            phoneFLD.setOpaque(false);

        //adding to panel 01 :
        p1.add(nameLBL);
        p1.add(nameFLD);
        p1.add(lastnameLBL);
        p1.add(lastnameFLD);
        p1.add(CityLBL);
        p1.add(CityFLD);
        p1.add(phoneLBL);
        p1.add(phoneFLD);



        /********** PANEL 02 ***********/
        p2 = new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Vehicle",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);

        p2.setBorder(border2);
        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));


        //labels
        plateLBL = new JLabel("Plate number :");
        modelLBL = new JLabel("Model Year : ");
        manufacturerLBL = new JLabel("Manufacturer : ");
        estimatedLBL = new JLabel("estimated Value : ");
        spaceLBL = new JLabel(" ");
        spaceLBL.setOpaque(false);
        damageLBL = new JLabel("Major Damage");

        //text fields :
        model = new JTextField();           model.setOpaque(false);
        manufacturer = new JTextField();    manufacturer.setOpaque(false);
        plateNB = new JTextField();         plateNB.setOpaque(false);
        estimatedV = new JTextField();      estimatedV.setOpaque(false);

        //the buttons :
        RBN1 = new JRadioButton();
        RBN1.setText("Motor");
        RBN2 = new JRadioButton();
        RBN2.setText("Wheels");
        RBN3 = new JRadioButton();
        RBN3.setText("Body");
        RBN4 = new JRadioButton();
        RBN4.setText("NONE ");
        //adding buttons to the group button
        G1 = new ButtonGroup();
        G1.add(RBN1);
        G1.add(RBN2);
        G1.add(RBN3);
        G1.add(RBN4);

        //adding to panel 02:
        p2.add(plateLBL);
        p2.add(plateNB);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimatedV);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(RBN1);
        p2.add(RBN2);
        p2.add(RBN3);
        p2.add(RBN4);

        /************* PANEL 03 *************/
        //the panel
        p3 = new JPanel();
        TitledBorder border3 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Plan",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p3.setBorder(border3);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        //the label:
        packageLBL = new JLabel("Please select your plan : ");

        //the checkboxes:
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risks");
        vDamageCHKBX = new JCheckBox("Vehicle damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        //method to get the chosen risks:
        getRisksCovered();

        //the lists:


        //add to the panel
        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assisCHKBX);


        /****************** PANEL 04 *******************/
        //the panel
        p4 = new JPanel();
        TitledBorder border4 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Validity Period",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p4.setBorder(border4);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));

        //the buttons :
        yearRadio = new JRadioButton();
        yearRadio.setText("1 Year");
        yearRadio2 = new JRadioButton();
        yearRadio2.setText("2 Years");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText("3 Years");

        //actions for the buttons :
        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 1;
            }
        });
        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 3;
            }
        });

        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);

        //time and date :
        todayLBL = new JLabel();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        todayLBL.setText("Today : " + df.format(currentDate));

        Font font1 = todayLBL.getFont();
        float size = font1.getSize() + 3.0f;
        todayLBL.setFont(font1.deriveFont(size));

        JLabel spaceLBL2 = new JLabel(" ");
        spaceLBL2.setOpaque(false);

        //adding to the panel 04:
        p4.add(spaceLBL2);
        p4.add(spaceLBL2);
        p4.add(todayLBL);
        p4.add(spaceLBL2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);

        /***************** PANEL 05 **************/
        //the panel:
        p5 = new JPanel();
        TitledBorder border5 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Actions",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p5.setBorder(border5);
        p5.setBounds(330,520,300,230);
        p5.setLayout(new GridLayout(7,1));

        //the buttons:
        saveBTN = new JButton("Save Customer");
        showBTN = new JButton("Show plan Details");
        loadBTN = new JButton("Load Customer");
        newBTN = new JButton("New Customer");

        searchTXT = new JTextField("Enter Car Plate Number");
        searchTXT.setOpaque(false);

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ADDING LATER
                try {
                    saveCustomerMap();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LATER
                String str = " ";
                for (int i = 0 ; i<coveredRisksList.size(); i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                risksTXT.setText(str);

                try {
                    policyTXT.setText(getPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //later
                searchByPhone();
            }
        });

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCustomer();
            }
        });


        JLabel spaceLBL3 = new JLabel(" ");
        spaceLBL3.setOpaque(false);

        JLabel spaceLBL4 = new JLabel(" ");
        spaceLBL4.setOpaque(false);
        //adding to the panel:
        p5.add(spaceLBL3);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spaceLBL4);
        p5.add(searchTXT);
        p5.add(loadBTN);

        /************* PANEL 06 *****************/
        //the panel
        p6 = new JPanel();
        TitledBorder border6 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Covered Risks",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);

        p6.setBorder(border6);
        p6.setBounds(645,15,300,200);
        p6.setLayout(new GridLayout(1,1));

        //the components:
        risksTXT = new JTextArea(7,1);
        risksTXT.setOpaque(false);
        risksTXT.setEditable(false);
        risksTXT.setLineWrap(true);

        //font:
        Font font2 = risksTXT.getFont();
        float size2 = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont(size2));

        //add to the panel:
        p6.add(risksTXT);

        /************** PANEL 07 *****************/
        //the panel
        p7 = new JPanel();
        TitledBorder border7 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Policy Details",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p7.setBorder(border7);
        p7.setBounds(645,250,300,250);
        p7.setLayout(new GridLayout(1,1));

        //the components
        policyTXT = new JTextArea(20,1);
        policyTXT.setLineWrap(true);
        policyTXT.setOpaque(false);
        policyTXT.setEditable(false);

        //font
        Font font3 = policyTXT.getFont();
        float size3 = font.getSize() + 3.0f;
        policyTXT.setFont(font.deriveFont(size3));

        //adding to the panel:
        p7.add(policyTXT);

        /*********** PANEL 08 ***********/
        //the panel:
        p8 = new JPanel();
        TitledBorder border8 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Customer Details",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p8.setBorder(border8);
        p8.setLayout(new GridLayout(1,1));
        p8.setBounds(645,520,300,230);

        //the components:
        CustomerTXT = new JTextArea(20,1);
        CustomerTXT.setLineWrap(true);
        CustomerTXT.setOpaque(false);
        CustomerTXT.setEditable(false);

        Font font4 = CustomerTXT.getFont();
        float size4 = font.getSize() + 3.0f;
        CustomerTXT.setFont(font.deriveFont(size4));

        //adding to the panel:
        p8.add(CustomerTXT);

        /*********** PANEL 09 *************/
        //the panel
        p9 = new JPanel();
        TitledBorder border9 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Claims",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p9.setBorder(border9);
        p9.setBounds(960,15,300,485);

        //the components
        claimingTXT = new JLabel("Enter Plate number for claiming");
        JLabel space9 = new JLabel("                                                ");
        claimingTXT2 = new JLabel("Select the type of damage or assistance");

        claimingFLD = new JTextField();
        claimingFLD.setPreferredSize(new Dimension(250,30));
        claimingFLD.setOpaque(false);

        String[] items = {"Fire","Robbery","transport", "Car replacement", "Vehicle damage", "Third party damage", "Driver Damage"};

        final JList claimList = new JList(items);

        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setOpaque(false);
        claimList.setPreferredSize(new Dimension(250,150));

        searchBTN = new JButton("search customer");
        List<String> coveredrisk = new ArrayList<>();

        searchBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //later
                cond1 = false;      //customer is registered
                cond2 = false;      //is the customer policy cover the claim
                cond3 = false;      //is the policy date still valid

                try {
                    coveredRisksList.clear();
                    Customer c = ClaimSearch();
                    claimingCustomerNameLBL.setText("Claiming Customer " + c.getfName() + " " + c.getLName());
                    cond1 = true;

                    String str7 = "";
                    for (int i = 0; i<c.getPolicy().getRisksCoveredList().size(); i++){
                        str7 += c.getPolicy().getRisksCoveredList().get(i) + "\n";
                        coveredrisk.add(c.getPolicy().getRisksCoveredList().get(i));
                    }

                    LocalDate v_validityOfPolicy = c.getPolicy().getPolicyDate();
                    int v_policyValidityYear = c.getPolicy().getValidityYear();

                    v_validityOfPolicy = v_validityOfPolicy.plusYears(v_policyValidityYear);

                    checkPolicyValidity(v_validityOfPolicy);

                    claimingCustomerRisksCovered.setText("Covered Risks : \n" + str7);
                    claimingCustomervalidDateLBL.setText("date Validity of Policy : \n" + v_validityOfPolicy + " OR " + checkPolicyValidity(v_validityOfPolicy));



                    if (c.getPolicy().getRisksCoveredList().size() >= 5){
                        cond2 = true;
                    }
                }catch (Exception ee){
                    claimingCustomerNameLBL.setText("Claiming Customer : Not found");
                }
            }
        });

        confirmBTN = new JButton("Confirm Claim ");
        confirmBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get index of all selected items
                int[] selectedIX = claimList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();

                if (claimList.getSelectedIndex() != -1){
                    for (int i = 0; i<selectedIX.length; i++){
                        String k = "" + claimList.getModel().getElementAt(selectedIX[i]) + "";
                        claimed_list.add("" + claimList.getModel().getElementAt(selectedIX[i]));
                        System.out.println("" + k);
                    }
                }

                //check for the included risks:
                if (cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksList);
                }

                ClaimIsValid();

                //display settlements :
                Customer c = ClaimSearch();
                if (ClaimIsValid()){
                    int claims_nb = claimed_list.size();
                    if (claimed_list.contains("Fire")){
                        settlementArea2.setText("Fire departmenet" + c.getPolicy().getVehicle().getEstimatedValue()*0.25 + "$");

                    }else if (claimed_list.contains("Robbery")){
                        settlementArea2.setText("Prosec company" + c.getPolicy().getVehicle().getEstimatedValue()+0.5 + "$" +
                                "Pay for customer : " + c.getPolicy().getVehicle().getEstimatedValue()*1 + "$");

                    }else if (claimed_list.contains("Third party damage")){
                        settlementArea2.setText("driver in another car : " + 2000 + "$" );

                    }else if (claimed_list.contains("Vehicle damage")){
                        settlementArea2.setText("pay for customer" + c.getPolicy().getVehicle().getEstimatedValue()*1 + "$");

                    }else if (claimed_list.contains("Driver Damage")){
                        settlementArea2.setText("Pay for customer : " + c.getPolicy().getVehicle().getEstimatedValue()*10 + "$");

                    }else if (claimed_list.contains("transport")){
                        settlementArea2.setText("Transpot company" + c.getPolicy().getVehicle().getEstimatedValue()*0.5 + "$");

                    }else if (claimed_list.contains("Car replacement")){
                        settlementArea2.setText("Car rental company" + c.getPolicy().getVehicle().getEstimatedValue()*0.2 + "$");

                    }else if (claims_nb > 2){
                        settlementArea2.setText("driver" + c.getPolicy().getVehicle().getEstimatedValue()*4 + "$" +
                                "Hospital " + c.getPolicy().getVehicle().getEstimatedValue()*4 + "$" +
                                "car rental company" + c.getPolicy().getVehicle().getEstimatedValue()*0.2 + "$"+
                                "third party driver" + c.getPolicy().getVehicle().getEstimatedValue()*2);
                    }


                }


            }
        });




        //adding to the panel
        p9.add(claimingTXT);
        p9.add(claimingFLD);
        p9.add(searchBTN);
        p9.add(space9);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmBTN);

        /************ PANEL 10 *************/
        //the panel:
        p10 = new JPanel();
        TitledBorder border10 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Claim status",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p10.setBorder(border10);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));

        //the labels:
        claimingCustomerNameLBL = new JLabel("Claiming Customer : ");
        claimingCustomervalidDateLBL = new JLabel("Date Validity of policy : ");
        claimStatusLBL2 = new JLabel("Claiming status : ");


        claimingCustomerRisksCovered = new JTextArea();
        JScrollPane picturescrollpan = new JScrollPane(claimingCustomerRisksCovered);
        claimingCustomerRisksCovered.setOpaque(false);

        //adding to the panel :
        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomervalidDateLBL);
        p10.add(picturescrollpan);
        p10.add(claimStatusLBL2);

        /************** PANEL 11 ****************/
        //the panel:
        p11 = new JPanel();
        TitledBorder border11 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "Payments",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p11.setBorder(border11);
        p11.setLayout(new GridLayout(2,1));
        p11.setBounds(1275,15,250,230);

        //the text field
        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        //increase the size of the text area
        Font font5 = settlementArea.getFont();
        float size5 = font.getSize() + 4.0f;
        settlementArea.setFont(font.deriveFont(size5));

        //adding to the panel
        p11.add(settlementArea);

        /************* PANEL 12 ************/
        //the panel
        p12 = new JPanel();
        TitledBorder border12 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1),
                "settlement",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font,color);
        p12.setBorder(border12);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        //the components:
        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);

        Font font6 = settlementArea2.getFont();
        float size6 = font.getSize() + 4.0f;
        settlementArea2.setFont(font.deriveFont(size6));

        p12.add(settlementArea2);


        /********* adding to the frame **********/
        setLayout(null);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
        add(p10);
        add(p11);
        add(p12);
    }


    /************************************** THE METHODS ****************************************/
    /*******************************************************************************************/

    //getting the customer's data
    public Customer GetCustomerData() throws ParseException{

        //new object
        Customer customer = new Customer(
                nameFLD.getText(),
                lastnameFLD.getText(),
                CityFLD.getText(),
                Integer.parseInt(phoneFLD.getText()),
                getPolicyData()
        );
        return customer;
    }

    //Getting the vehicle data :
    public Vehicle getVehicleData() throws ParseException{
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(plateNB.getText()),
                Integer.parseInt(model.getText()),
                manufacturer.getText(),
                Integer.parseInt(estimatedV.getText()),
                GetDamageState()
        );
        return vehicle;
    }




    //getting the policy data :
    public Policy getPolicyData() throws ParseException{
        currentDate = new Date();
        LocalDate now = LocalDate.now();

        Policy policy = new Policy(
                getVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRiskList,
                validityYear,
                now
        );
        return policy;
    }

    //Getting the damage data :
    public int GetDamageState(){
        if(RBN1.isSelected()){
            return 1;
        }else if (RBN2.isSelected()) {
            return 2;
        }else if (RBN3.isSelected()){
            return 3;
        }else return 0;
    }

    //get plan details:
    private void getRisksCovered() {
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
        VehicleRisk vehicleRisk = new VehicleRisk();

        //if user checked all risks then no need to check the other boxes
        allRiskCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obligatoryCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                dDamageCHKBX.setEnabled(false);
                assisCHKBX.setEnabled(false);

                //adding risk details to an array
                for (int i =0; i<allRisk.allRiskCovered.length; i++){
                    coveredRisksList.add(allRisk.allRiskCovered[i]);
                }
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRiskList.add(allRisk.getCeiling());

            }
        });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adding the risks to an array
                coveredRisksList.add(obligatoryRisk.obligatoryRiskCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
                coverageRisksList.add(obligatoryRisk.getCoverage());
                ceilingRiskList.add(obligatoryRisk.getCeiling());
            }
        });

        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coveredRisksList.add(vehicleRisk.vehicleRisksCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCoverage());
                ceilingRiskList.add(vehicleRisk.getCeiling());

            }
        });

        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();

                coveredRisksList.add(driverRisk.driverRiskCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageRisksList.add(driverRisk.getCoverage());
                ceilingRiskList.add(driverRisk.getCeiling());
            }
        });

        assisCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();

                for (int i =0; i<assistanceRisk.assistanceRiskCovered.length; i++){
                    coveredRisksList.add(assistanceRisk.assistanceRiskCovered[i]);
                }

                coverageRisksList.add(assistanceRisk.getCoverage());
                premiumRisksList.add(assistanceRisk.getPremium());
                ceilingRiskList.add(assistanceRisk.getCeiling());
            }
        });
    }

    //Saving data to the disk
    public void saveCustomerMap() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("C:\\Users\\pc\\OneDrive - Ecole des Sciences de l'Information\\Desktop\\myfile.dat");

        int plateNumber = Integer.parseInt(plateNB.getText());

        //create the file if it does not exist
        if (!file.exists()){
            System.out.println("not found");
            file.createNewFile();
            saveCustomerMapTofile(plateNumber,file);
        }else{
            TreeMap<Integer,Customer> newMapToSave = new TreeMap<>();

            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
            ois.close();
            is.close();

            //getting the old map
            for (Map.Entry<Integer,Customer> m : mapInFile.entrySet())
            {
                newMapToSave.put(m.getKey(), m.getValue());
            }

            //updating the map AKA adding new customer
            newMapToSave.put(plateNumber, GetCustomerData());

            //saving updates to the file :
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMapToSave);
            oos.flush();
            oos.close();

        }
    }

    private void saveCustomerMapTofile(int plateNumber, File file) throws ParseException, IOException {

        TreeMap<Integer, Customer> newMapToSave = new TreeMap<>();

        //adding new Customer to map:
        newMapToSave.put(plateNumber, GetCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMapToSave);
        oos.flush();
        oos.close();

    }


    //Resetting all the fields to empty ones
    private void newCustomer(){

        //clearing the lists:
        coveredRisksList.clear();
        premiumRisksList.clear();
        coverageRisksList.clear();
        ceilingRiskList.clear();
        cond1 = false;
        cond2 = false;
        cond3 = false;

        //clearing the text fields:
        nameFLD.setText("");
        lastnameFLD.setText("");
        CityFLD.setText("");
        phoneFLD.setText("");
        plateNB.setText("");
        model.setText("");
        manufacturer.setText("");
        estimatedV.setText("");

        //reset the buttons
        G1.clearSelection();
        G2.clearSelection();

        //reset the boxes
        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        obligatoryCHKBX.setEnabled(true);
        allRiskCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        dDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);



    }


    //searching for customer
    private void searchByPhone(){
        File file  = new File("C:\\Users\\pc\\OneDrive - Ecole des Sciences de l'Information\\Desktop\\myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile =  (TreeMap<Integer,Customer>) ois.readObject();
            ois.close();
            is.close();

            Customer c_find = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            CustomerTXT.setText(c_find.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    private Customer ClaimSearch(){
        Customer customer = new Customer();
        File file = new File("C:\\Users\\pc\\OneDrive - Ecole des Sciences de l'Information\\Desktop\\myfile.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
            ois.close();
            is.close();

            customer = mapInFile.get(Integer.parseInt(claimingFLD.getText()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }


    private boolean checkPolicyValidity(LocalDate v_validity){
        LocalDate now = LocalDate.now();

        if (now.isBefore(v_validity)){
            cond3=true;
            return true;
        }else {
            cond3 = false;
            return false;
        }
    }

    private boolean ClaimIsValid(){
        if (cond1 == true && cond2 == true && cond3 == true){
            claimStatusLBL2.setText("Claiming Status: You can Register a claim");
            return true;
        }else {
            claimStatusLBL2.setText("Claiming status: Not able ");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){
        for (int i = 0; i<premiumRisksList.size(); i++){
            totalPremium += premiumRisksList.get(i);
            totalCoverage += coverageRisksList.get(i);
            totalCeiling += ceilingRiskList.get(i);
        }

        settlementArea.setText("Total Premium : " + totalPremium*Integer.parseInt(estimatedV.getText()) + " $ \n" +
                    "Total Coverage : " + totalCoverage*Integer.parseInt(estimatedV.getText())*10 + " $ \n" +
                    "Max Ceiling : " + totalCeiling*Integer.parseInt(estimatedV.getText())+10000 + " $ \n");
    }


    public static void main(String[] args){
       MainScreen mainScreen = new MainScreen();

       mainScreen.setVisible(true);
       mainScreen.setDefaultCloseOperation(EXIT_ON_CLOSE);
       mainScreen.setTitle("Insurance System");
       mainScreen.setBounds(0,0,1920,1080);
    }


}
