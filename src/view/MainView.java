/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LangChanger;
import controller.TablePopulator;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import model.DataAccess;
import model.Operation;
import model.Product;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Linas
 */
public class MainView extends javax.swing.JFrame {

    DataAccess da;
    TablePopulator tp;
    LangChanger lc;

    JDatePickerImpl toDatePicker;
    JDatePickerImpl fromDatePicker;
    DefaultListModel dlm;
    JLabel fromDateLabel;
    JLabel toDateLabel;
    
    int pID;
    int fieldLength;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        this.setLocationRelativeTo(null);

        da = DataAccess.getInstance();
        tp = new TablePopulator();
        lc = new LangChanger();
        lc.toString();
        da.updateProductList();
        
        try {
            da.getProductList().isEmpty();
        } catch (NullPointerException npe) {
            showErrorDialog("No data received! \n Please check your internet connection. \n System will now exit.");
        }
        populateProductList();
        addDateChoosers();
        productList.setSelectedIndex(0);
        dataPanel.setDividerLocation(300);
        totalsPanel.setVisible(false);
        averageSalesPriceValue.setVisible(false);
        operationTable.setShowVerticalLines(true);
        operationTable.setShowHorizontalLines(true);
        operationTable.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList();
        dataPanel = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        operationTable = new javax.swing.JTable();
        totalsPanel = new javax.swing.JPanel();
        totalOperationsLabel = new javax.swing.JLabel();
        totalQuantityLabel = new javax.swing.JLabel();
        totalIncomeLabel = new javax.swing.JLabel();
        totalOperationsValue = new javax.swing.JLabel();
        totalQuantityValue = new javax.swing.JLabel();
        totalIncomeValue = new javax.swing.JLabel();
        averageSalesPriceLabel = new javax.swing.JLabel();
        averageSalesPriceValue = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        searchTextField = new javax.swing.JTextField();
        fromSplitPane = new javax.swing.JSplitPane();
        toSplitPane = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        refreshProductsMenuItem = new javax.swing.JMenuItem();
        languageMenu = new javax.swing.JMenu();
        langLTMenuItem = new javax.swing.JMenuItem();
        langENMenuItem = new javax.swing.JMenuItem();
        langRUMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        productList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(productList);

        dataPanel.setBorder(null);
        dataPanel.setDividerLocation(300);
        dataPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        operationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(operationTable);

        dataPanel.setLeftComponent(jScrollPane2);

        totalsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Totals"));

        totalOperationsLabel.setText("Operations:");

        totalQuantityLabel.setText("Quantity sold:");

        totalIncomeLabel.setText("Income:");

        totalOperationsValue.setText("jLabel1");

        totalQuantityValue.setText("jLabel1");

        totalIncomeValue.setText("jLabel1");

        averageSalesPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        averageSalesPriceLabel.setText("Average sales price:");

        averageSalesPriceValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        averageSalesPriceValue.setText("0");

        javax.swing.GroupLayout totalsPanelLayout = new javax.swing.GroupLayout(totalsPanel);
        totalsPanel.setLayout(totalsPanelLayout);
        totalsPanelLayout.setHorizontalGroup(
            totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(totalsPanelLayout.createSequentialGroup()
                        .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(totalsPanelLayout.createSequentialGroup()
                                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalIncomeLabel)
                                    .addComponent(totalQuantityLabel)
                                    .addComponent(totalOperationsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalOperationsValue)
                                    .addComponent(totalQuantityValue)
                                    .addComponent(totalIncomeValue)))
                            .addGroup(totalsPanelLayout.createSequentialGroup()
                                .addComponent(averageSalesPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(averageSalesPriceValue)))
                        .addGap(0, 340, Short.MAX_VALUE)))
                .addContainerGap())
        );
        totalsPanelLayout.setVerticalGroup(
            totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalsPanelLayout.createSequentialGroup()
                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalOperationsLabel)
                    .addComponent(totalOperationsValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQuantityLabel)
                    .addComponent(totalQuantityValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalIncomeLabel)
                    .addComponent(totalIncomeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(averageSalesPriceLabel)
                    .addComponent(averageSalesPriceValue))
                .addContainerGap())
        );

        dataPanel.setBottomComponent(totalsPanel);

        searchTextField.setForeground(new java.awt.Color(204, 204, 204));
        searchTextField.setText("Search...");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        fromSplitPane.setBorder(null);

        toSplitPane.setBorder(null);
        toSplitPane.setDividerSize(10);
        toSplitPane.setAutoscrolls(true);

        fileMenu.setText("File");

        refreshProductsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        refreshProductsMenuItem.setText("Refresh Product List");
        refreshProductsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshProductsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(refreshProductsMenuItem);

        menuBar.add(fileMenu);

        languageMenu.setText("Language");

        langLTMenuItem.setText("Lietuvių");
        langLTMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langLTMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(langLTMenuItem);

        langENMenuItem.setText("English");
        langENMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langENMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(langENMenuItem);

        langRUMenuItem.setText("Русский");
        langRUMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langRUMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(langRUMenuItem);

        menuBar.add(languageMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataPanel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fromSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(toSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        loadButtonAction();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void refreshProductsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshProductsMenuItemActionPerformed
        if (searchTextField.getText().isEmpty()) {
            da.updateProductList();
        } else {
            da.updateProductListByCrit(searchTextField.getText());
        }
        populateProductList();
    }//GEN-LAST:event_refreshProductsMenuItemActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        da.updateProductListByCrit(searchTextField.getText());
        populateProductList();

    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed

    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        if (searchTextField.getText().contains("...")) {
            searchTextField.setText("");
            searchTextField.setForeground(Color.black);
        } else {
            searchTextField.setSelectionStart(0);
            searchTextField.setSelectionEnd(searchTextField.getText().length());
        }
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void langLTMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langLTMenuItemActionPerformed
        changeLang("lang_lt");
        loadButtonAction();
    }//GEN-LAST:event_langLTMenuItemActionPerformed

    private void langENMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langENMenuItemActionPerformed
        changeLang("lang_en");
        loadButtonAction();
    }//GEN-LAST:event_langENMenuItemActionPerformed

    private void langRUMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langRUMenuItemActionPerformed
        changeLang("lang_ru");
        loadButtonAction();
    }//GEN-LAST:event_langRUMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);

            }
        });
    }
    /**
     * Gets the product ArrayList from the DataAccess class, creates a DefaultListModel and sets it on the JList.
     */
    public void populateProductList() {
        ArrayList<Product> pl = da.getProductList();
        dlm = new DefaultListModel();
        for (Product p : pl) {
            dlm.addElement(p.getCode() + " - " + p.getName());
        }
        productList.setModel(dlm);
    }

    public int getSelectedID() {
        String[] unsplit = productList.getSelectedValue().toString().split(" - ");
        String selection = unsplit[0];

        for (Product p : da.getProductList()) {
            if (p.getCode().contains(selection)) {
                pID = p.getId();
            }
        }
        return pID;
    }
    
    /**
     * Creates an error dialog,displays it and stops the JVM when user clicks OK.
     * @param message the error message to be displayed.
     */
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
        
        System.exit(0);
    }
    
    /**
     * Creates JDateChoosers, formats them and adds them to the GUI.
     */
    public void addDateChoosers() {
        Date curDate = new Date();
        SimpleDateFormat curY = new SimpleDateFormat("yyyy");
        SimpleDateFormat curM = new SimpleDateFormat("MM");
        SimpleDateFormat curD = new SimpleDateFormat("dd");
        int Y = Integer.valueOf(curY.format(curDate));
        int M = Integer.valueOf(curM.format(curDate));
        int D = Integer.valueOf(curD.format(curDate));

        UtilDateModel fromModel = new UtilDateModel();
        JDatePanelImpl fromDatePanel = new JDatePanelImpl(fromModel);
        fromModel.setDate(Y, M, D);
        fromDatePicker = new JDatePickerImpl(fromDatePanel, new DateLabelFormatter());
        fromModel.setSelected(true);

        UtilDateModel toModel = new UtilDateModel();
        JDatePanelImpl toDatePanel = new JDatePanelImpl(toModel);
        toModel.setDate(Y, M, D);
        toDatePicker = new JDatePickerImpl(toDatePanel, new DateLabelFormatter());
        toModel.setSelected(true);

        fromDateLabel = new JLabel("From:");
        toDateLabel = new JLabel("To:");

        fromSplitPane.setLeftComponent(fromDateLabel);
        fromSplitPane.setRightComponent(fromDatePicker);
        fromSplitPane.setDividerLocation(0.15);
        fromSplitPane.setEnabled(false);

        toSplitPane.setLeftComponent(toDateLabel);
        toSplitPane.setRightComponent(toDatePicker);
        toSplitPane.setDividerLocation(0.15);
        toSplitPane.setEnabled(false);

    }
    
    /**
     * Calculates the total values of the selected date range and displays them on the GUI.
     */
    public void calculateTotals(){
        int numberOfOps = 0;
        int totalIncome = 0;
        int totalQuantity = 0;
        for(Operation o: da.getOperationList()){
            numberOfOps++;
            totalIncome = totalIncome + (o.getQnt()*o.getPrice());
            totalQuantity = totalQuantity+ o.getQnt();
        }
        
        totalsPanel.setVisible(true);
        averageSalesPriceValue.setVisible(true);
        
        
        totalIncomeValue.setText(String.valueOf(totalIncome));
        totalOperationsValue.setText(String.valueOf(numberOfOps));
        totalQuantityValue.setText(String.valueOf(totalQuantity));
        try{
        averageSalesPriceValue.setText(String.valueOf(totalIncome/totalQuantity));
        }catch(ArithmeticException ae){
            // DO NOTHING.
        }
    }
    
    /**
     * Gets the String values of translated labels and sets them on the GUI.
     * @param lang the language to be displayed in ("lang_EN") format.
     */
    public void changeLang(String lang){
        lc.changeLang(lang);
        TreeMap tm = lc.getLabels();
        Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        String columns[] = {String.valueOf(tm.get("table_operationID")), 
                            String.valueOf(tm.get("table_invoiceID")), 
                            String.valueOf(tm.get("table_date")),
                            String.valueOf(tm.get("table_quantity")), 
                            String.valueOf(tm.get("table_price")), 
                            String.valueOf(tm.get("table_stockID"))};
        
        fileMenu.setText(String.valueOf(tm.get("menu_file")));
        refreshProductsMenuItem.setText(String.valueOf(tm.get("menu_file_refreshProductList")));
        languageMenu.setText(String.valueOf(tm.get("menu_language")));
        searchTextField.setText(String.valueOf(tm.get("search")));
        fromDateLabel.setText(String.valueOf(tm.get("from")));
        toDateLabel.setText(String.valueOf(tm.get("to")));
        tp.setColumns(columns);
        totalsPanel.setBorder(BorderFactory.createTitledBorder(loweredetched, String.valueOf(tm.get("totals"))));
        totalOperationsLabel.setText(String.valueOf(tm.get("totals_operations"))+":");
        totalQuantityLabel.setText(String.valueOf(tm.get("totals_quantity"))+":");
        totalIncomeLabel.setText(String.valueOf(tm.get("totals_income"))+":");
        averageSalesPriceLabel.setText(String.valueOf(tm.get("average_sales_price"))+": ");
        loadButton.setText(String.valueOf(tm.get("load")));
    }
    
    /**
     * LoadButtonActionPerformed in a separate method to be called explicitly.
     */
    public void loadButtonAction(){
        try {
            Date selFrom = (Date) fromDatePicker.getModel().getValue();
            Date selTo = (Date) toDatePicker.getModel().getValue();

            Long fromDate = da.toUnixTimeStamp(selFrom);
            Long toDate = da.toUnixTimeStamp(selTo);
            da.updateOperationList(fromDate, toDate, getSelectedID());
            tp.populateTable(operationTable);
            dataPanel.setDividerLocation(300);
            calculateTotals();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel averageSalesPriceLabel;
    private javax.swing.JLabel averageSalesPriceValue;
    private javax.swing.JSplitPane dataPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JSplitPane fromSplitPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem langENMenuItem;
    private javax.swing.JMenuItem langLTMenuItem;
    private javax.swing.JMenuItem langRUMenuItem;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JButton loadButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable operationTable;
    private javax.swing.JList productList;
    private javax.swing.JMenuItem refreshProductsMenuItem;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JSplitPane toSplitPane;
    private javax.swing.JLabel totalIncomeLabel;
    private javax.swing.JLabel totalIncomeValue;
    private javax.swing.JLabel totalOperationsLabel;
    private javax.swing.JLabel totalOperationsValue;
    private javax.swing.JLabel totalQuantityLabel;
    private javax.swing.JLabel totalQuantityValue;
    private javax.swing.JPanel totalsPanel;
    // End of variables declaration//GEN-END:variables
}