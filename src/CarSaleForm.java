import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarSaleForm extends JFrame {
    static CarSaleForm frame;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new CarSaleForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CarSaleForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 438, 414);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Sell Car");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(Color.GRAY);

        JLabel lblCarId = new JLabel("Car ID:");

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setColumns(10);

        JLabel lblBuyerName = new JLabel("Buyer name:");

        JLabel lblBuyerContact = new JLabel("Buyer contact:");

        JButton btnSellCar = new JButton("Sell Car");
        btnSellCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int car_id = Integer.parseInt(textField_1.getText());
                String buyer_name = textField_2.getText();
                String buyer_contact = textField_3.getText();
                //TODO: add price sold compared to real price
                if (RegisterCarSaleDao.checkCar(car_id)) {

                    int i = RegisterCarSaleDao.save(car_id, buyer_name, buyer_contact);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(CarSaleForm.this, "Car sold successfully!");
                        SellerSuccess.main(new String[]{});
                        frame.dispose();

                    } else {
                        JOptionPane.showMessageDialog(CarSaleForm.this, "Sorry, unable to sell!");
                    }//end of save if-else

                } else {
                    JOptionPane.showMessageDialog(CarSaleForm.this, "Sorry, Car ID doesn't exist!");
                }//end of check car if-else

            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SellerSuccess.main(new String[]{});
                frame.dispose();
            }
        });

        JLabel lblNewLabel_1 = new JLabel("Note: Please check Car ID Carefully before selling a car!");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setForeground(Color.RED);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblCarId)
                                                        .addComponent(lblCarId)
                                                        .addComponent(lblBuyerName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblBuyerContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                                .addGap(48))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addGap(20)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btnSellCar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47)
                                                                .addComponent(btnBack)))
                                                .addGap(100))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(146)
                                .addComponent(lblNewLabel)
                                .addContainerGap(235, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(37)
                                .addComponent(lblNewLabel)
                                .addGap(43)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCarId)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBuyerName)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBuyerContact)
                                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnSellCar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack))
                                .addGap(18)
                                .addComponent(lblNewLabel_1)
                                .addGap(25))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
