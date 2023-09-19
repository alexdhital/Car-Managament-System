import javax.swing.*;  
import java.awt.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class GUI_Demo extends JFrame {

    private JPanel FuelCarUI,ElectricCarUI;  
    private JTextField carId, carName, carBrand, carPrice, fuelTextField, seatsTextField, mileageTextField, distTextField, transmissionTextField; 
    private JTextField carIdElectric, carNameElectric, carBrandElectric, carPriceElectric, batteryCapacityElectric, customerNameTextFieldElectric, batteryWarrentyTextFieldElectric, rangeTextFieldElectric, rechargeTimeTextFieldElectric;
    private JButton addButton, purchaseButton, displayButton, clearButton;
    private JButton addButtonElectricCar, buyButtonElectric, sellButtonElectric, displayElectricCarButton, clearElectricCarButton;
    private JComboBox yearComboBox,monthComboBox,dayComboBox;
    private JComboBox yearComboBoxEletric,monthComboBoxEletric,dayComboBoxEletric;
    private ArrayList<Car> fuelCars;
    private ArrayList<Car> electricCars;
    private int height, width;

    public GUI_Demo(){  
        height = 600;
        width = 700;
        fuelCars = new ArrayList<>();
        electricCars = new ArrayList<>();
        ImageIcon img = new ImageIcon("image/logo.jpg");

        setIconImage(img.getImage());
        FuelCarUI = new JPanel();   
        ElectricCarUI = new JPanel();
        FuelCarUI.setLayout(null); 
        ElectricCarUI.setLayout(null);   

        setSize(width,height);  
        this.setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTabPane(width,height);
        
        ElectricCarComponent();
        FuelCarComponent(); 
        
        fuelCarEvents();
        electricCarEvents();
        
        setVisible(true);  
        setLayout(null); 

    }

    public FuelCar getFuelCar() {
        return new FuelCar(Integer.parseInt(carId.getText()),carName.getText(),carBrand.getText(),carPrice.getText(),fuelTextField.getText(),Integer.parseInt(seatsTextField.getText()),Integer.parseInt(mileageTextField.getText()));

    }  

    public String getTodaysDate() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    public Car findCar(int carId) {

        for(Car f : fuelCars){
            if(f.getcarID() == carId){
                return f;
            }

        }
        return null;
    }

    public boolean addCar(Car car) {
        if(findCar(car.getcarID()) == null) {
            fuelCars.add(car);
            return true;
        } 
        return false;
    }
    public void fuelCarEvents() {
        addButton.addActionListener(e -> {
            try{

                boolean added = addCar(getFuelCar());
                if(added) {
                    JOptionPane.showMessageDialog(this,"Added");
                }else {
                    JOptionPane.showMessageDialog(this,"Please change id, it already has been allocated to another car");
                }

            }catch(Exception f) {
                JOptionPane.showMessageDialog(this,"Error Invalid INput");  
            }
        });


        purchaseButton.addActionListener(e -> {

            try{

                FuelCar gotFuelCar = (FuelCar)findCar(Integer.parseInt(carId.getText()));
                if(gotFuelCar != null ) {
                    gotFuelCar.setTransmission_Type(transmissionTextField.getText());
                    gotFuelCar.setDistributor_Name(distTextField.getText());
                    String date = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                    String gotinfo = gotFuelCar.purchase(getTodaysDate(),date);
                    if(gotinfo .equals("")) {
                        gotinfo = "purchased";
                    }
                    JOptionPane.showMessageDialog(this,gotinfo); 
                } else {

                    JOptionPane.showMessageDialog(this,"CarId not found");  

                }
                


            } catch(Exception f) {
                JOptionPane.showMessageDialog(this,"Error Invalid Input");
            }
        });

        displayButton.addActionListener(e -> {

            try{

                FuelCar f = (FuelCar)findCar(Integer.parseInt(carId.getText()));
                if(f != null ) {

                    JOptionPane.showMessageDialog(this,f.display()); 
                } else {

                    JOptionPane.showMessageDialog(this,"CarId not found");  

                }
            } catch (Exception f) {

                JOptionPane.showMessageDialog(this,"Error Invalid Input"); 
            }
        });

        clearButton.addActionListener(e -> {

            carId.setText("");
            carName.setText("");
            carBrand.setText("");
            carPrice.setText("");
            fuelTextField.setText("");
            seatsTextField.setText("");
            mileageTextField.setText("");
            distTextField.setText("");
            transmissionTextField.setText("");
        });
    } 

    public ElectricCar getElectricCar() {

        return new ElectricCar(Integer.parseInt(carIdElectric.getText()), carNameElectric.getText(), carBrandElectric.getText(), carPriceElectric.getText(), Integer.parseInt(batteryCapacityElectric.getText()));
    }

    public Car findElectricCar(int carId) {

        for(Car f: electricCars) {

            if(f.getcarID()  == carId) {

                return f;
            }
        }
        return null;
    }

    public boolean addElectricCar(Car car) {

        if(findElectricCar(car.getcarID()) != null) {

            electricCars.add(car);
            return true;
        }
        return false;
    }


    public void electricCarEvents() {
        //  , sellButtonElectric;
        addButtonElectricCar.addActionListener(e -> {
            try{

                boolean added = addCar(getElectricCar());
                if(added) {
                    JOptionPane.showMessageDialog(this,"Added");
                }else {
                    JOptionPane.showMessageDialog(this,"Please change id, it already has been allocated to another car");
                }

            }catch(Exception f) {
                JOptionPane.showMessageDialog(this,"Error Invalid Input");  
            }
        });

        displayElectricCarButton.addActionListener(e -> {

            try{
                ElectricCar f = (ElectricCar)findCar(Integer.parseInt(carIdElectric.getText()));
                if(f != null ) {
                    JOptionPane.showMessageDialog(this,f.display()); 
                } else {

                    JOptionPane.showMessageDialog(this,"CarId not found");

                }
            } catch (Exception f) {

                JOptionPane.showMessageDialog(this,"Error Invalid Input"); 
            }
        });

        buyButtonElectric.addActionListener(e -> {
            try{

                ElectricCar gotElectricCar = (ElectricCar)findCar(Integer.parseInt(carIdElectric.getText()));
                if(gotElectricCar != null ) {

                    
                    String date = yearComboBoxEletric.getSelectedItem() + "-" + monthComboBoxEletric.getSelectedItem() + "-" + dayComboBoxEletric.getSelectedItem();
                    if(gotElectricCar.getBought()){
                        JOptionPane.showMessageDialog(this,"Already Bought");  
                        return;
                    }
                    gotElectricCar.BuyElectricCar(customerNameTextFieldElectric.getText(), batteryCapacityElectric.getText(), date, rangeTextFieldElectric.getText(), rechargeTimeTextFieldElectric.getText());
                    JOptionPane.showMessageDialog(this,"Bought Successfully!!");  

                } else {
                    JOptionPane.showMessageDialog(this,"CarId not found");  
                }
                
            } catch(Exception f) {
                JOptionPane.showMessageDialog(this,"Error Invalid Input");
            }
        });

        sellButtonElectric.addActionListener(e -> {
            try{
                ElectricCar gotElectricCar = (ElectricCar)findCar(Integer.parseInt(carIdElectric.getText()));
                if(gotElectricCar != null ) {
                    if(gotElectricCar.getBought()){
                        JOptionPane.showMessageDialog(this,"The car is already sold");  
                        return;
                    }
                    gotElectricCar.sellElectricCar(customerNameTextFieldElectric.getText());
                    JOptionPane.showMessageDialog(this,"Bought Successfully!!");  
                } else {
                    JOptionPane.showMessageDialog(this,"CarId not found");  
                }
                
            } catch(Exception f) {
                JOptionPane.showMessageDialog(this,"Error Invalid Input");
            }
        });


        clearElectricCarButton.addActionListener(e -> {
            carIdElectric.setText("");
            carNameElectric.setText("");
            carBrandElectric.setText("");
            carPriceElectric.setText("");
            batteryCapacityElectric.setText("");
            customerNameTextFieldElectric.setText("");
            batteryWarrentyTextFieldElectric.setText("");
            rangeTextFieldElectric.setText("");
            rechargeTimeTextFieldElectric.setText("");
            
        });


    }


    public void createTabPane(int width, int height) {

        JTabbedPane tp = new JTabbedPane(); 
        tp.setBounds(0,0,width,height);  
        tp.add("FuelCar",FuelCarUI);  
        tp.add("ElectricCar",ElectricCarUI);      
        add(tp);  
    }

    public void FuelCarComponent() {

        JLabel carIdLabel = new JLabel("Car ID:");
        carIdLabel.setBounds(10,10,100,10);
        FuelCarUI.add(carIdLabel);

        carId = new JTextField();
        carId.setBounds(200, 10,100,15);
        FuelCarUI.add(carId);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel carNameLabel = new JLabel("Car Name:");
        carNameLabel.setBounds(10,40,100,10);
        carNameLabel.setForeground(Color.lightGray);
        FuelCarUI.add(carNameLabel);

        carName = new JTextField();
        carName.setBounds(200,40,100,15);
        FuelCarUI.add(carName);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel carBrandLabel = new JLabel("Car Brand:");
        carBrandLabel.setBounds(10,70,100,10);
        carBrandLabel.setForeground(Color.lightGray);
        FuelCarUI.add(carBrandLabel);

        carBrand = new JTextField();
        carBrand.setBounds(200,70,100,15);
        FuelCarUI.add(carBrand);
        FuelCarUI.validate();
        FuelCarUI.repaint(); /*hi*/

        JLabel carPriceLabel = new JLabel("Car Price:");
        carPriceLabel.setBounds(10,100,100,10);
        carPriceLabel.setForeground(Color.lightGray);
        FuelCarUI.add(carPriceLabel);

        carPrice = new JTextField();
        carPrice.setBounds(200,100,100,15);
        FuelCarUI.add(carPrice);
        FuelCarUI.validate();
        FuelCarUI.repaint(); /*hi*/

        JLabel fuelLabel = new JLabel("Fuel Type:");
        fuelLabel.setBounds(10,130,100,10);
        fuelLabel.setForeground(Color.lightGray);
        FuelCarUI.add(fuelLabel);

        fuelTextField = new JTextField();
        fuelTextField.setBounds(200,130,100,15);
        FuelCarUI.add(fuelTextField);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel seatsLabel = new JLabel("No of seats:");
        seatsLabel.setBounds(10,160,100,10);
        seatsLabel.setForeground(Color.lightGray);
        FuelCarUI.add(seatsLabel);

        seatsTextField = new JTextField();
        seatsTextField.setBounds(200,160,100,15);
        FuelCarUI.add(seatsTextField);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel mileageLabel = new JLabel("Mileage:");
        mileageLabel.setBounds(10,190,100,10);
        mileageLabel.setForeground(Color.lightGray);
        FuelCarUI.add(mileageLabel);

        mileageTextField = new JTextField();
        mileageTextField.setBounds(200,190,100,15);
        FuelCarUI.add(mileageTextField);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel transmissionTypeLabel = new JLabel("Transmission Type:");
        transmissionTypeLabel.setBounds(10,220,300,10);
        transmissionTypeLabel.setForeground(Color.lightGray);
        FuelCarUI.add(transmissionTypeLabel);

        transmissionTextField = new JTextField();
        transmissionTextField.setBounds(200,220,100,15);
        FuelCarUI.add(transmissionTextField);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel distLabel = new JLabel("Dist.Name:");
        distLabel.setBounds(10,250,100,10);
        distLabel.setForeground(Color.lightGray);
        FuelCarUI.add(distLabel);

        distTextField = new JTextField();
        distTextField.setBounds(200,250,100,15);
        FuelCarUI.add(distTextField);
        FuelCarUI.validate();
        FuelCarUI.repaint();

        JLabel bookedDateLabel = new JLabel("Booked Date:");
        bookedDateLabel.setBounds(10,280,100,10);
        bookedDateLabel.setForeground(Color.lightGray);
        FuelCarUI.add(bookedDateLabel);

        yearComboBox = new JComboBox();
        yearComboBox.setBounds(200,280,90,20);
        FuelCarUI.add(yearComboBox);

        for(int i=1950;i<=2022;i++){
            yearComboBox.addItem(i);
        }

        String months[] = {"Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        monthComboBox = new JComboBox();
        monthComboBox.setBounds(315,280,90,20);
        FuelCarUI.add(monthComboBox);

        for(int i = 0; i < months.length; i++) {
            monthComboBox.addItem(months[i]);
        }

        dayComboBox = new JComboBox();
        dayComboBox.setBounds(430,280,90,20);
        FuelCarUI.add(dayComboBox);

        for(int i = 1; i < 32; i++){
            dayComboBox.addItem(i);
        }

        addButton = changeColor(new JButton("Add"));
        addButton.setBounds(10,320,100,40);
        FuelCarUI.add(addButton);

        purchaseButton = changeColor(new JButton("Purchase"));
        purchaseButton.setBounds(120,320,100,40);
        FuelCarUI.add(purchaseButton);

        displayButton = changeColor(new JButton("Display"));
        displayButton.setBounds(240,320,100,40);
        FuelCarUI.add(displayButton);

        clearButton = changeColor(new JButton("Clear All"));
        clearButton.setBounds(350,380,100,70);
        FuelCarUI.add(clearButton);

        ImageIcon background=new ImageIcon("image/car1.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(this.width, this.height,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0, this.width, this.height);
        FuelCarUI.add(back); //ll

    }

    public JButton changeColor(JButton btn){
        btn.setBackground(Color.darkGray);
        btn.setForeground(Color.WHITE);
        return btn;
    }

    public void ElectricCarComponent() {

        JLabel carIdLabel = new JLabel("Car ID:");
        carIdLabel.setBounds(10,10,100,10);
        carIdLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(carIdLabel);

        carIdElectric = new JTextField();
        carIdElectric.setBounds(200,10,100,15);
        ElectricCarUI.add(carIdElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel carNameLabel = new JLabel("Car Name:");
        carNameLabel.setBounds(10,40,100,10);
        carNameLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(carNameLabel);

        carNameElectric = new JTextField();
        carNameElectric.setBounds(200,40,100,15);
        ElectricCarUI.add(carNameElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel carBrandLabel = new JLabel("Car Brand:");
        carBrandLabel.setBounds(10,70,100,10);
        carBrandLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(carBrandLabel);

        carBrandElectric = new JTextField();
        carBrandElectric.setBounds(200,70,100,15);
        ElectricCarUI.add(carBrandElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint(); /*hi*/

        JLabel carPriceLabel = new JLabel("Car Price:");
        carPriceLabel.setBounds(10,100,100,10);
        carPriceLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(carPriceLabel);

        carPriceElectric = new JTextField();
        carPriceElectric.setBounds(200,100,100,15);
        ElectricCarUI.add(carPriceElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint(); /*hi*/

        JLabel batteryCapacityLabel = new JLabel("Battery Capacity:");
        batteryCapacityLabel.setBounds(10,130,200,10);
        batteryCapacityLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(batteryCapacityLabel);

        batteryCapacityElectric = new JTextField();
        batteryCapacityElectric.setBounds(200,130,100,15);
        ElectricCarUI.add(batteryCapacityElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(10,160,200,10);
        customerNameLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(customerNameLabel);

        customerNameTextFieldElectric = new JTextField();
        customerNameTextFieldElectric.setBounds(200,160,100,15);
        ElectricCarUI.add(customerNameTextFieldElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel batteryWarrentyLabel = new JLabel("Battery Warrenty:");
        batteryWarrentyLabel.setBounds(10,190,200,10);
        batteryWarrentyLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(batteryWarrentyLabel);

        batteryWarrentyTextFieldElectric = new JTextField();
        batteryWarrentyTextFieldElectric.setBounds(200,190,100,15);
        ElectricCarUI.add(batteryWarrentyTextFieldElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel purchaseDateLabel = new JLabel("Purchase Date:");
        purchaseDateLabel.setBounds(10,220,200,10);
        purchaseDateLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(purchaseDateLabel);

        yearComboBoxEletric = new JComboBox();
        yearComboBoxEletric.setBounds(200,220,90,20);
        ElectricCarUI.add(yearComboBoxEletric);

        for(int i=1950;i<=2022;i++){
            yearComboBoxEletric.addItem(i);
        }

        String months[] = {"Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        monthComboBoxEletric = new JComboBox();
        monthComboBoxEletric.setBounds(300,220,90,20);
        ElectricCarUI.add(monthComboBoxEletric);

        for(int i = 0; i < months.length; i++) {
            monthComboBoxEletric.addItem(months[i]);
        }

        dayComboBoxEletric = new JComboBox();
        dayComboBoxEletric.setBounds(410,220,90,20);
        ElectricCarUI.add(dayComboBoxEletric);

        for(int i = 1; i < 32; i++){
            dayComboBoxEletric.addItem(i);
        }

        JLabel rangeLabel = new JLabel("Range:");
        rangeLabel.setBounds(10,250,100,10);
        rangeLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(rangeLabel);

        rangeTextFieldElectric = new JTextField();
        rangeTextFieldElectric.setBounds(200,250,100,15);
        ElectricCarUI.add(rangeTextFieldElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();

        JLabel rechargeTimeLabel = new JLabel("Recharge Time:");
        rechargeTimeLabel.setBounds(10,280,200,10);
        rechargeTimeLabel.setForeground(Color.lightGray);
        ElectricCarUI.add(rechargeTimeLabel);

        rechargeTimeTextFieldElectric = new JTextField();
        rechargeTimeTextFieldElectric.setBounds(200,280,100,15);
        ElectricCarUI.add(rechargeTimeTextFieldElectric);
        ElectricCarUI.validate();
        ElectricCarUI.repaint();


        buyButtonElectric = changeColor(new JButton("Buy"));
        buyButtonElectric.setBounds(10,320,100,40);
        ElectricCarUI.add(buyButtonElectric);

        sellButtonElectric = changeColor(new JButton("Sell"));
        sellButtonElectric.setBounds(120,320,100,40);
        ElectricCarUI.add(sellButtonElectric);

        displayElectricCarButton = changeColor(new JButton("Display"));
        displayElectricCarButton.setBounds(240,320,100,40);
        ElectricCarUI.add(displayElectricCarButton);

        addButtonElectricCar = changeColor(new JButton("Add"));
        addButtonElectricCar.setBounds(230,380,100,70);
        ElectricCarUI.add(addButtonElectricCar);

        clearElectricCarButton = changeColor(new JButton("Clear All"));
        clearElectricCarButton.setBounds(350,380,100,70);
        ElectricCarUI.add(clearElectricCarButton);

        ImageIcon background=new ImageIcon("image/car2.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0, this.width, this.height);
        ElectricCarUI.add(back);

    }

}
