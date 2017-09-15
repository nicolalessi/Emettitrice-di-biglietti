package gui.ticketmachine;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ticketmachine.TicketMachine;


public class MoneyTankSwingPanel extends JPanel implements Observer{
    private final JLabel twoHundred = new JLabel("200"),
                         oneHundred = new JLabel("100"),
                         fifty = new JLabel("50"),
                         twenty = new JLabel("20"),
                         ten = new JLabel("10"),
                         five = new JLabel("5"),
                         two = new JLabel("2"),
                         one = new JLabel("1"),
                         fiftyCents = new JLabel("0.5"),
                         twentyCents = new JLabel("0.2"),
                         tenCents = new JLabel("0.1"),
                         fiveCents = new JLabel("0.05");
    private JLabel labelTwoHundred, labelOneHundred, labelFifty, labelTwenty,
                   labelTen, labelFive, labelTwo, labelOne, labelFiftyCents,
                   labelTwentyCents, labelTenCents, labelFiveCents;
    private TicketMachine tMachine;
    
    public MoneyTankSwingPanel(TicketMachine tMachine) {
        super(new GridLayout(12,2));
        
        this.tMachine = tMachine;
        tMachine.addObserver(this);
        
        labelTwoHundred = new JLabel(tMachine.getAmountOf(200) + "");
        labelOneHundred = new JLabel(tMachine.getAmountOf(100) + "");
        labelFifty = new JLabel(tMachine.getAmountOf(50) + "");
        labelTwenty = new JLabel(tMachine.getAmountOf(20) + "");
        labelTen = new JLabel(tMachine.getAmountOf(10) + "");
        labelFive = new JLabel(tMachine.getAmountOf(5) + "");
        labelTwo = new JLabel(tMachine.getAmountOf(2) + "");
        labelOne = new JLabel(tMachine.getAmountOf(1) + "");
        labelFiftyCents = new JLabel(tMachine.getAmountOf(0.5f) + "");
        labelTwentyCents = new JLabel(tMachine.getAmountOf(0.2f) + "");
        labelTenCents = new JLabel(tMachine.getAmountOf(0.1f) + "");
        labelFiveCents = new JLabel(tMachine.getAmountOf(0.05f) + "");
        
        this.add(twoHundred);
        this.add(labelTwoHundred);
        this.add(oneHundred);
        this.add(labelOneHundred);
        this.add(fifty);
        this.add(labelFifty);
        this.add(twenty);
        this.add(labelTwenty);
        this.add(ten);
        this.add(labelTen);
        this.add(five);
        this.add(labelFive);
        this.add(two);
        this.add(labelTwo);
        this.add(one);
        this.add(labelOne);
        this.add(fiftyCents);
        this.add(labelFiftyCents);
        this.add(twentyCents);
        this.add(labelTwentyCents);
        this.add(tenCents);
        this.add(labelTenCents);
        this.add(fiveCents);
        this.add(labelFiveCents);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        labelTwoHundred.setText(Math.round(tMachine.getAmountByIndex(0)) + "");
        labelOneHundred.setText(tMachine.getAmountByIndex(1) + "");
        labelFifty.setText(tMachine.getAmountByIndex(2) + "");
        labelTwenty.setText(tMachine.getAmountByIndex(3) + "");
        labelTen.setText(tMachine.getAmountByIndex(4) + "");
        labelFive.setText(tMachine.getAmountByIndex(5) + "");
        labelTwo.setText(tMachine.getAmountByIndex(6) + "");
        labelOne.setText(tMachine.getAmountByIndex(7) + "");
        labelFiftyCents.setText(tMachine.getAmountByIndex(8) + "");
        labelTwentyCents.setText(tMachine.getAmountByIndex(9) + "");
        labelTenCents.setText(tMachine.getAmountByIndex(10) + "");
        labelFiveCents.setText(tMachine.getAmountByIndex(11) + "");
    }
}
