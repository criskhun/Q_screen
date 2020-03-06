/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q_screen;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Support
 */
public class Main extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    private static final String VOICENAME="kevin16";
    public Main() {
        initComponents();
        conn = (Connection) MySqlConnect.ConnectDB();
        currentdate();
        all_ref();
        auto_up();
        asse1_call();
        asse2_call();
        marn_call();
        term_call();
        cash1_call();
        cash2_call();
        enco1_call();   
	enco2_call();
        enco3_call();
        ad_call();
        fd_call();
        opm_call();
        psd_call();
        ppd_call();
        esd_call();
        Alarmtest ac=new Alarmtest();
        ac.checkAlarm(00,00);
    }
    
    public void all_ref(){
    dis_asse1_ref();
    dis_asse2_ref();
    dis_marn_ref();
    dis_term_ref();
    dis_cash1_ref();
    dis_cash2_ref();
    dis_enco1_ref();
    dis_enco2_ref();
    dis_enco3_ref();
    dis_esd_ref();
    dis_ppd_ref();
    dis_psd_ref();
    dis_opm_ref();
    dis_fd_ref();
    dis_ad_ref();
    exhange_ref();
    }
    
    public void currentdate(){
    new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("h:mm:ss aa");
                time1.setText(s.format(d));

                SimpleDateFormat st = new SimpleDateFormat("MM/dd/yyyy");
                date1.setText(st.format(d));
            }
        })
                .start();
    }
    
    public void auto_up(){
    Timer timer = new Timer(0, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
      all_ref();
        }
        });

        timer.setDelay(1000); // delay for 0.5 seconds
        timer.start();
    }    
    
    public void exhange_ref(){
    try {
            String sql = "SELECT * FROM exchange_tbl ORDER BY ID DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            exchange_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = exchange_tbl.getRowCount();
    
    if(rows>0){
    int column = 1;
    int row = 0;
    
    String value = exchange_tbl.getModel().getValueAt(row, column).toString();
    rate.setText(value);
    }
    else{
    rate.setText("0.00");
    }
    }

    public void dis_asse1_ref(){
    try {
            String sql = "SELECT Assessment_num FROM dis_asse1_tbl ORDER BY Assessment_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            ass1_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = ass1_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = ass1_tbl.getModel().getValueAt(row, column).toString();
    asse1dis.setText(value);
    asse1_seta.setText(value);
        if(asse1_seta.getText().equals(asse1_setb.getText())){
        
        }
        else{
            asse1_setb.setText(asse1_seta.getText());
            asse1_voice.setText("1");
        }
        
    }
    else{
    asse1dis.setText("------");
    }
    }
    
    public void dis_asse2_ref(){
    try {
            String sql = "SELECT Assessment_num FROM dis_asse2_tbl ORDER BY Assessment_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            ass2_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = ass2_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = ass2_tbl.getModel().getValueAt(row, column).toString();
    asse2dis.setText(value);
    asse2_seta.setText(value);
        if(asse2_seta.getText().equals(asse2_setb.getText())){
        
        }
        else{
            asse2_setb.setText(asse2_seta.getText());
            asse2_voice.setText("1");
        }
        
    }
    else{
    asse2dis.setText("------");
    }
    }
    
    public void dis_marn_ref(){
    try {
            String sql = "SELECT Marine_num FROM dis_marn_tbl ORDER BY Marine_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            marn_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = marn_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0; 
    
    String value = marn_tbl.getModel().getValueAt(row, column).toString();
    marndis.setText(value);
    marn_seta.setText(value);
        if(marn_seta.getText().equals(marn_setb.getText())){
        
        }
        else{
            marn_setb.setText(marn_seta.getText());
            marn_voice.setText("1");
        }
        
    }
    else{
    marndis.setText("------");
    }
    }
    
    public void dis_term_ref(){
    try {
            String sql = "SELECT Terminal_num FROM dis_term_tbl ORDER BY Terminal_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            term_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = term_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = term_tbl.getModel().getValueAt(row, column).toString();
    termdis.setText(value);
    term_seta.setText(value);
        if(term_seta.getText().equals(term_setb.getText())){
        
        }
        else{
            term_setb.setText(term_seta.getText());
            term_voice.setText("1");
        }
        
    }
    else{
    termdis.setText("------");
    }
    }
    
    public void dis_cash1_ref(){
    try {
            String sql = "SELECT Cashier_num FROM dis_cash1_tbl ORDER BY Cashier_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            cash1_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = cash1_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = cash1_tbl.getModel().getValueAt(row, column).toString();
    cash1dis.setText(value);
    cash1_seta.setText(value);
        if(cash1_seta.getText().equals(cash1_setb.getText())){
        
        }
        else{
            cash1_setb.setText(cash1_seta.getText());
            cash1_voice.setText("1");
        }
        
    }
    else{
    cash1dis.setText("------");
    }
    }
    
    public void dis_cash2_ref(){
    try {
            String sql = "SELECT Cashier_num FROM dis_cash2_tbl ORDER BY Cashier_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            cash2_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = cash2_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = cash2_tbl.getModel().getValueAt(row, column).toString();
    cash2dis.setText(value);
    cash2_seta.setText(value);
        if(cash2_seta.getText().equals(cash2_setb.getText())){
        
        }
        else{
            cash2_setb.setText(cash2_seta.getText());
            cash2_voice.setText("1");
        }
        
    }
    else{
    cash2dis.setText("------");
    }
    }
    
    public void dis_enco1_ref(){
    try {
            String sql = "SELECT Encoding_num FROM dis_enco1_tbl ORDER BY Encoding_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            enco1_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = enco1_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = enco1_tbl.getModel().getValueAt(row, column).toString();
    enco1dis.setText(value);
    enco1_seta.setText(value);
        if(enco1_seta.getText().equals(enco1_setb.getText())){
        
        }
        else{
            enco1_setb.setText(enco1_seta.getText());
            enco1_voice.setText("1");
        }
        
    }
    else{
    enco1dis.setText("------");
    }
    }
    
    public void dis_enco2_ref(){
    try {
            String sql = "SELECT Encoding_num FROM dis_enco2_tbl ORDER BY Encoding_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            enco2_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = enco2_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = enco2_tbl.getModel().getValueAt(row, column).toString();
    enco2dis.setText(value);
    enco2_seta.setText(value);
        if(enco2_seta.getText().equals(enco2_setb.getText())){
        
        }
        else{
            enco2_setb.setText(enco2_seta.getText());
            enco2_voice.setText("1");
        }
        
    }
    else{
    enco2dis.setText("------");
    }
    }
    
    public void dis_enco3_ref(){
    try {
            String sql = "SELECT Encoding_num FROM dis_enco3_tbl ORDER BY Encoding_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            enco3_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = enco3_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = enco3_tbl.getModel().getValueAt(row, column).toString();
    enco3dis.setText(value);
    enco3_seta.setText(value);
        if(enco3_seta.getText().equals(enco3_setb.getText())){
        
        }
        else{
            enco3_setb.setText(enco3_seta.getText());
            enco3_voice.setText("1");
        }
        
    }
    else{
    enco3dis.setText("------");
    }
    }
    
    public void dis_ad_ref(){
    try {
            String sql = "SELECT Ad_num FROM dis_ad_tbl ORDER BY Ad_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            ad_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = ad_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = ad_tbl.getModel().getValueAt(row, column).toString();
    ad_dis.setText(value);
    ad_seta.setText(value);
        if(ad_seta.getText().equals(ad_setb.getText())){
        
        }
        else{
            ad_setb.setText(ad_seta.getText());
            ad_voice.setText("1");
        }
        
    }
    else{
    ad_dis.setText("------");
    }
    }
    
    public void dis_fd_ref(){
    try {
            String sql = "SELECT Fd_num FROM dis_fd_tbl ORDER BY Fd_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            fd_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = fd_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = fd_tbl.getModel().getValueAt(row, column).toString();
    fd_dis.setText(value);
    fd_seta.setText(value);
        if(fd_seta.getText().equals(fd_setb.getText())){
        
        }
        else{
            fd_setb.setText(fd_seta.getText());
            fd_voice.setText("1");
        }
        
    }
    else{
    fd_dis.setText("------");
    }
    }
    
    public void dis_opm_ref(){
    try {
            String sql = "SELECT Opm_num FROM dis_opm_tbl ORDER BY Opm_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            opm_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = opm_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = opm_tbl.getModel().getValueAt(row, column).toString();
    opm_dis.setText(value);
    opm_seta.setText(value);
        if(opm_seta.getText().equals(opm_setb.getText())){
        
        }
        else{
            opm_setb.setText(opm_seta.getText());
            opm_voice.setText("1");
        }
        
    }
    else{
    opm_dis.setText("------");
    }
    }
    
    public void dis_psd_ref(){
    try {
            String sql = "SELECT Psd_num FROM dis_psd_tbl ORDER BY Psd_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            psd_tbl.setModel(DbUtils.resultSetToTableModel(rs));
           pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = psd_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = psd_tbl.getModel().getValueAt(row, column).toString();
    psd_dis.setText(value);
    psd_seta.setText(value);
        if(psd_seta.getText().equals(psd_setb.getText())){
        
        }
        else{
            psd_setb.setText(psd_seta.getText());
            psd_voice.setText("1");
        }
        
    }
    else{
    psd_dis.setText("------");
    }
    }
    
    public void dis_ppd_ref(){
    try {
            String sql = "SELECT Ppd_num FROM dis_ppd_tbl ORDER BY Ppd_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            ppd_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = ppd_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = ppd_tbl.getModel().getValueAt(row, column).toString();
    ppd_dis.setText(value);
    ppd_seta.setText(value);
        if(ppd_seta.getText().equals(ppd_setb.getText())){
        
        }
        else{
            ppd_setb.setText(ppd_seta.getText());
            ppd_voice.setText("1");
        }
        
    }
    else{
    ppd_dis.setText("------");
    }
    }
    
    public void dis_esd_ref(){
    try {
            String sql = "SELECT Esd_num FROM dis_esd_tbl ORDER BY Esd_num DESC";
            pst = (java.sql.PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();

            esd_tbl.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    int rows = esd_tbl.getRowCount();
        
    if(rows>0){
    int column = 0;
    int row = 0;
    
    String value = esd_tbl.getModel().getValueAt(row, column).toString();
    esd_dis.setText(value);
    esd_seta.setText(value);
        if(esd_seta.getText().equals(esd_setb.getText())){
        
        }
        else{
            esd_setb.setText(esd_seta.getText());
            esd_voice.setText("1");
        }
        
    }
    else{
    esd_dis.setText("------");
    }
    }
    
    public void asse1_call(){
        asse1_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {

        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+asse1dis.getText()+"Please proceed to Assessment 1");
    }
});   
    }
    
    public void asse2_call(){
        asse2_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+asse2dis.getText()+"Please proceed to Assessment 2");
    }
});   
    }
    
    public void marn_call(){
        marn_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+marndis.getText()+"Please proceed to Marine");
    }
});   
    }
    
    public void term_call(){
        term_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+termdis.getText()+"Please proceed to Terminal");
    }
});   
    }
    
    public void cash1_call(){
        cash1_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+cash1dis.getText()+"Please proceed to Cashier 1");
    }
});   
    }
    
    public void cash2_call(){
        cash2_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+cash2dis.getText()+"Please proceed to Cashier 2");
    }
});   
    }
    
    public void enco1_call(){
        enco1_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+enco1dis.getText()+"Please proceed to Encoder 1");
    }
});   
    }
    
    public void enco2_call(){
        enco2_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+enco2dis.getText()+"Please proceed to Encoder 2");
    }
});   
    }
    
    public void enco3_call(){
        enco3_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+enco3dis.getText()+"Please proceed to Encoder 3");
    }
});   
    }
    
    public void ad_call(){
        ad_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+ad_dis.getText()+"Please proceed to Admin Record");
    }
});   
    }
    
    public void fd_call(){
        fd_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+fd_dis.getText()+"Please proceed to Finance");
    }
});   
    }
    
    public void opm_call(){
        opm_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+opm_dis.getText()+"Please proceed to O.P.M.");
    }
});   
    }
    
    public void psd_call(){
        psd_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+psd_dis.getText()+"Please proceed to P.S.D.");
    }
});   
    }
    
    public void ppd_call(){
        ppd_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+ppd_dis.getText()+"Please proceed to P.P.D.");
    }
});   
    }
    
    public void esd_call(){
        esd_voice.getDocument().addDocumentListener(new SimpleDocumentListener() {
    @Override
    public void update(DocumentEvent e) {
        voice = vm.getVoice(VOICENAME);
     voice.allocate();
     voice.speak("Customer number "+esd_dis.getText()+"Please proceed to E.S.D.");
    }
});   
    }
    
    Voice voice;
     VoiceManager vm = VoiceManager.getInstance();

    @FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
       //update(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
       update(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        //update(e);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        display = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        date1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        asse1dis = new javax.swing.JTextField();
        asse2dis = new javax.swing.JTextField();
        termdis = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        marndis = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cash1dis = new javax.swing.JTextField();
        cash2dis = new javax.swing.JTextField();
        enco1dis = new javax.swing.JTextField();
        enco2dis = new javax.swing.JTextField();
        enco3dis = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ad_dis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        opm_dis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fd_dis = new javax.swing.JTextField();
        psd_dis = new javax.swing.JTextField();
        ppd_dis = new javax.swing.JTextField();
        esd_dis = new javax.swing.JTextField();
        tables_pico = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ass1_tbl = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ass2_tbl = new javax.swing.JTable();
        asse1_seta = new javax.swing.JTextField();
        asse1_setb = new javax.swing.JTextField();
        asse1_voice = new javax.swing.JTextField();
        asse2_seta = new javax.swing.JTextField();
        asse2_setb = new javax.swing.JTextField();
        asse2_voice = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        marn_tbl = new javax.swing.JTable();
        marn_seta = new javax.swing.JTextField();
        marn_setb = new javax.swing.JTextField();
        marn_voice = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        term_tbl = new javax.swing.JTable();
        term_seta = new javax.swing.JTextField();
        term_setb = new javax.swing.JTextField();
        term_voice = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cash1_tbl = new javax.swing.JTable();
        cash1_seta = new javax.swing.JTextField();
        cash1_setb = new javax.swing.JTextField();
        cash1_voice = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        cash2_tbl = new javax.swing.JTable();
        cash2_seta = new javax.swing.JTextField();
        cash2_setb = new javax.swing.JTextField();
        cash2_voice = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        enco1_tbl = new javax.swing.JTable();
        enco1_seta = new javax.swing.JTextField();
        enco1_setb = new javax.swing.JTextField();
        enco1_voice = new javax.swing.JTextField();
        enco2_seta = new javax.swing.JTextField();
        enco2_setb = new javax.swing.JTextField();
        enco2_voice = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        enco2_tbl = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        enco3_tbl = new javax.swing.JTable();
        enco3_seta = new javax.swing.JTextField();
        enco3_setb = new javax.swing.JTextField();
        enco3_voice = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        exchange_tbl = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        enco3_seta1 = new javax.swing.JTextField();
        enco3_setb1 = new javax.swing.JTextField();
        enco3_voice1 = new javax.swing.JTextField();
        division = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ad_tbl = new javax.swing.JTable();
        ad_seta = new javax.swing.JTextField();
        ad_setb = new javax.swing.JTextField();
        ad_voice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        fd_tbl = new javax.swing.JTable();
        fd_seta = new javax.swing.JTextField();
        fd_setb = new javax.swing.JTextField();
        fd_voice = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        opm_tbl = new javax.swing.JTable();
        opm_seta = new javax.swing.JTextField();
        opm_setb = new javax.swing.JTextField();
        opm_voice = new javax.swing.JTextField();
        psd_voice = new javax.swing.JTextField();
        psd_setb = new javax.swing.JTextField();
        psd_seta = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        psd_tbl = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ppd_tbl = new javax.swing.JTable();
        ppd_seta = new javax.swing.JTextField();
        ppd_setb = new javax.swing.JTextField();
        ppd_voice = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        esd_tbl = new javax.swing.JTable();
        esd_seta = new javax.swing.JTextField();
        esd_setb = new javax.swing.JTextField();
        esd_voice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(new java.awt.CardLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMaximumSize(new java.awt.Dimension(50000, 50000));

        date1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        date1.setForeground(new java.awt.Color(204, 0, 0));
        date1.setText("DATE:");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel11.setText("DATE:");

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel12.setText("PESO-DOLLAR Ex.:");

        time1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        time1.setForeground(new java.awt.Color(204, 0, 0));
        time1.setText("TIME");

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel14.setText("TIME:");

        rate.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        rate.setForeground(new java.awt.Color(204, 0, 0));
        rate.setText("TIME");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(date1)
                        .addComponent(time1))
                    .addComponent(rate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Assessment 1");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel2.setText("Terminal");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setText("Assessment 2");

        asse1dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        asse2dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        termdis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel17.setText("Cashier 2");

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel18.setText("Cashier 1");

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel19.setText("Marine");

        marndis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel20.setText("Encoding 3");

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel21.setText("Encoding 1");

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel22.setText("Encoding 2");

        cash1dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        cash2dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        enco1dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        enco2dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        enco3dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marndis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(termdis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                            .addComponent(asse2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(asse1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17))
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enco2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cash2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cash1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(52, 52, 52)
                        .addComponent(enco1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel20)
                        .addGap(35, 35, 35)
                        .addComponent(enco3dis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(asse1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(cash1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(enco3dis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(asse2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(cash2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(marndis, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(enco1dis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(termdis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enco2dis, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel4.setText("OPM-Permits");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        ad_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(ad_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 169, 52));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel5.setText("AD-Records");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        opm_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(opm_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 169, 57));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel6.setText("ESD");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setText("FD-Disbursement");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel8.setText("PPD");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel9.setText("PSD-Safety");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        fd_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(fd_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 170, 61));

        psd_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(psd_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 170, 61));

        ppd_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(ppd_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 170, 61));

        esd_dis.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel5.add(esd_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 170, 61));

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(display, "card2");

        ass1_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ass1_tbl);

        jLabel23.setText("assessment 1");

        jLabel24.setText("assessment 2");

        ass2_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(ass2_tbl);

        asse1_voice.setText("1");

        asse2_voice.setText("1");

        jLabel25.setText("marine");

        marn_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(marn_tbl);

        marn_voice.setText("1");

        jLabel26.setText("terminal");

        term_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(term_tbl);

        term_voice.setText("1");

        jLabel27.setText("cashier 1");

        cash1_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(cash1_tbl);

        cash1_voice.setText("1");

        jLabel28.setText("cashier 2");

        cash2_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(cash2_tbl);

        cash2_voice.setText("1");

        jLabel29.setText("encoding 1");

        enco1_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(enco1_tbl);

        enco1_voice.setText("1");

        enco2_voice.setText("1");

        enco2_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(enco2_tbl);

        jLabel30.setText("encoding 2");

        jLabel31.setText("encoding 3");

        enco3_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(enco3_tbl);

        enco3_voice.setText("1");

        exchange_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(exchange_tbl);

        jLabel32.setText("rate");

        enco3_voice1.setText("1");

        javax.swing.GroupLayout tables_picoLayout = new javax.swing.GroupLayout(tables_pico);
        tables_pico.setLayout(tables_picoLayout);
        tables_picoLayout.setHorizontalGroup(
            tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tables_picoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(asse1_voice, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(asse1_setb, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(asse1_seta)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(asse2_voice)
                                .addComponent(asse2_setb)
                                .addComponent(asse2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(marn_voice)
                                .addComponent(marn_setb)
                                .addComponent(marn_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(term_voice)
                                .addComponent(term_setb)
                                .addComponent(term_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cash1_voice)
                                .addComponent(cash1_setb)
                                .addComponent(cash1_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cash2_voice)
                                .addComponent(cash2_setb)
                                .addComponent(cash2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(enco1_voice)
                                .addComponent(enco1_setb)
                                .addComponent(enco1_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(enco2_voice)
                                .addComponent(enco2_setb)
                                .addComponent(enco2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(enco3_voice)
                                .addComponent(enco3_setb)
                                .addComponent(enco3_seta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(enco3_voice1)
                                    .addComponent(enco3_setb1)
                                    .addComponent(enco3_seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        tables_picoLayout.setVerticalGroup(
            tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tables_picoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(asse1_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asse1_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(asse1_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(asse2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asse2_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(asse2_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(marn_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marn_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(marn_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(term_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(term_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(term_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(cash1_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cash1_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cash1_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addComponent(cash2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cash2_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cash2_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tables_picoLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tables_picoLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(tables_picoLayout.createSequentialGroup()
                                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tables_picoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tables_picoLayout.createSequentialGroup()
                                .addComponent(enco1_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enco1_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enco1_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tables_picoLayout.createSequentialGroup()
                                .addComponent(enco2_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enco2_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enco2_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tables_picoLayout.createSequentialGroup()
                                .addComponent(enco3_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enco3_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enco3_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tables_picoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enco3_seta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enco3_setb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enco3_voice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(243, 243, 243))
        );

        jPanel4.add(tables_pico, "card3");

        jLabel33.setText("AD-Records");

        ad_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(ad_tbl);

        ad_voice.setText("1");

        jLabel34.setText("FD-Disbursement");

        fd_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(fd_tbl);

        fd_voice.setText("1");

        jLabel35.setText("OPM-Permits");

        opm_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(opm_tbl);

        opm_voice.setText("1");

        psd_voice.setText("1");

        psd_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(psd_tbl);

        jLabel36.setText("PSD-Safety");

        jLabel37.setText("PPD");

        ppd_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(ppd_tbl);

        ppd_voice.setText("1");

        jLabel38.setText("ESD");

        esd_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(esd_tbl);

        esd_voice.setText("1");

        javax.swing.GroupLayout divisionLayout = new javax.swing.GroupLayout(division);
        division.setLayout(divisionLayout);
        divisionLayout.setHorizontalGroup(
            divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divisionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ad_voice)
                    .addComponent(ad_setb)
                    .addComponent(ad_seta)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fd_voice)
                    .addComponent(fd_setb)
                    .addComponent(fd_seta)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(opm_voice)
                    .addComponent(opm_setb)
                    .addComponent(opm_seta)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(psd_voice)
                    .addComponent(psd_setb)
                    .addComponent(psd_seta)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ppd_voice)
                    .addComponent(ppd_setb)
                    .addComponent(ppd_seta)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(esd_voice)
                    .addComponent(esd_setb)
                    .addComponent(esd_seta)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        divisionLayout.setVerticalGroup(
            divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divisionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(divisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(esd_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(esd_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(esd_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ppd_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ppd_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ppd_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(psd_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psd_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(psd_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(opm_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opm_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(opm_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fd_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fd_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fd_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divisionLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ad_seta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ad_setb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ad_voice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(434, Short.MAX_VALUE))
        );

        jPanel4.add(division, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public class Alarmtest {
    public void checkAlarm(final int a, final int b){
        Thread t=new Thread(){
            public void run(){
                int wl=0;
                while(wl==0){
                    Calendar c=new GregorianCalendar();
                    int hour=c.get(Calendar.HOUR_OF_DAY);
                    int mins=c.get(Calendar.MINUTE);
                    if(a==hour&&b==mins){
                        System.exit(0);
                        break;
                    }
                }
            }
        };
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }
    }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_dis;
    private javax.swing.JTextField ad_seta;
    private javax.swing.JTextField ad_setb;
    private javax.swing.JTable ad_tbl;
    private javax.swing.JTextField ad_voice;
    private javax.swing.JTable ass1_tbl;
    private javax.swing.JTable ass2_tbl;
    private javax.swing.JTextField asse1_seta;
    private javax.swing.JTextField asse1_setb;
    private javax.swing.JTextField asse1_voice;
    private javax.swing.JTextField asse1dis;
    private javax.swing.JTextField asse2_seta;
    private javax.swing.JTextField asse2_setb;
    private javax.swing.JTextField asse2_voice;
    private javax.swing.JTextField asse2dis;
    private javax.swing.JTextField cash1_seta;
    private javax.swing.JTextField cash1_setb;
    private javax.swing.JTable cash1_tbl;
    private javax.swing.JTextField cash1_voice;
    private javax.swing.JTextField cash1dis;
    private javax.swing.JTextField cash2_seta;
    private javax.swing.JTextField cash2_setb;
    private javax.swing.JTable cash2_tbl;
    private javax.swing.JTextField cash2_voice;
    private javax.swing.JTextField cash2dis;
    private javax.swing.JLabel date1;
    private javax.swing.JPanel display;
    private javax.swing.JPanel division;
    private javax.swing.JTextField enco1_seta;
    private javax.swing.JTextField enco1_setb;
    private javax.swing.JTable enco1_tbl;
    private javax.swing.JTextField enco1_voice;
    private javax.swing.JTextField enco1dis;
    private javax.swing.JTextField enco2_seta;
    private javax.swing.JTextField enco2_setb;
    private javax.swing.JTable enco2_tbl;
    private javax.swing.JTextField enco2_voice;
    private javax.swing.JTextField enco2dis;
    private javax.swing.JTextField enco3_seta;
    private javax.swing.JTextField enco3_seta1;
    private javax.swing.JTextField enco3_setb;
    private javax.swing.JTextField enco3_setb1;
    private javax.swing.JTable enco3_tbl;
    private javax.swing.JTextField enco3_voice;
    private javax.swing.JTextField enco3_voice1;
    private javax.swing.JTextField enco3dis;
    private javax.swing.JTextField esd_dis;
    private javax.swing.JTextField esd_seta;
    private javax.swing.JTextField esd_setb;
    private javax.swing.JTable esd_tbl;
    private javax.swing.JTextField esd_voice;
    private javax.swing.JTable exchange_tbl;
    private javax.swing.JTextField fd_dis;
    private javax.swing.JTextField fd_seta;
    private javax.swing.JTextField fd_setb;
    private javax.swing.JTable fd_tbl;
    private javax.swing.JTextField fd_voice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField marn_seta;
    private javax.swing.JTextField marn_setb;
    private javax.swing.JTable marn_tbl;
    private javax.swing.JTextField marn_voice;
    private javax.swing.JTextField marndis;
    private javax.swing.JTextField opm_dis;
    private javax.swing.JTextField opm_seta;
    private javax.swing.JTextField opm_setb;
    private javax.swing.JTable opm_tbl;
    private javax.swing.JTextField opm_voice;
    private javax.swing.JTextField ppd_dis;
    private javax.swing.JTextField ppd_seta;
    private javax.swing.JTextField ppd_setb;
    private javax.swing.JTable ppd_tbl;
    private javax.swing.JTextField ppd_voice;
    private javax.swing.JTextField psd_dis;
    private javax.swing.JTextField psd_seta;
    private javax.swing.JTextField psd_setb;
    private javax.swing.JTable psd_tbl;
    private javax.swing.JTextField psd_voice;
    private javax.swing.JLabel rate;
    private javax.swing.JPanel tables_pico;
    private javax.swing.JTextField term_seta;
    private javax.swing.JTextField term_setb;
    private javax.swing.JTable term_tbl;
    private javax.swing.JTextField term_voice;
    private javax.swing.JTextField termdis;
    private javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
