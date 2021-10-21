/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import Koneksi.koneksi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Satrio_Ganteng
 */
public class View_Laporan_Siswa extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tableModel;
int x, y;
JasperReport jasrep;
JasperPrint jaspri;
JasperDesign jasdes;
Statement stat;
ResultSet result;
String url,pass,sql;
    /**
     * Creates new form View_Laporan_Siswa
     */
    public View_Laporan_Siswa() {
        initComponents();
        setDefaultCloseOperation(0);
        datatable();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
        this.setTitle("Cetak Laporan Siswa");
    }
protected void datatable() {
        Object[] Baris = {"No.Peserta", "Nama Siswa","Tempat Lahir","Tanggal Lahir","Jenis kelamin","Alamat","Kelas","Agama","Tahun Ajaran"};
        tableModel = new DefaultTableModel(null, Baris);
        cetaksiswa.setModel(tableModel);
        String sql = "select * from siswa";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String nis = hasil.getString("nis");
                String nama = hasil.getString("nama");
                String tempat_lahir = hasil.getString("tempat_lahir");
                Date tanggal_lahir = hasil.getDate("tanggal_lahir");
                String jk = hasil.getString("jk");
                String alamat = hasil.getString("alamat");
                String kelas = hasil.getString("kelas");
                String agama = hasil.getString("agama");
                String tahun_ajaran = hasil.getString("tahun_ajaran");
                String[] data = {nis,nama,tempat_lahir, String.valueOf(tanggal_lahir),jk,alamat,kelas,agama,tahun_ajaran};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
protected void cari(){
     Object[] Baris = {"Nis", "Nama Siswa","Tempat Lahir","Tanggal Lahir","Jenis kelamin","Alamat","Kelas","Agama","Tahun Ajaran"};
        tableModel = new DefaultTableModel(null, Baris);
        cetaksiswa.setModel(tableModel);
        String sql = "select * from siswa where kelas= '"+cmbkelas.getSelectedItem()+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String nis = hasil.getString("nis");
                String nama = hasil.getString("nama");
                String tempat_lahir = hasil.getString("tempat_lahir");
                Date tanggal_lahir = hasil.getDate("tanggal_lahir");
                String jk = hasil.getString("jk");
                String alamat = hasil.getString("alamat");
                String kelas = hasil.getString("kelas");
                String agama = hasil.getString("agama");
                String tahun_ajaran = hasil.getString("tahun_ajaran");
                String[] data = {nis,nama,tempat_lahir, String.valueOf(tanggal_lahir),jk,alamat,kelas,agama,tahun_ajaran};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cetaksiswa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbkelas = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo2.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cetaksiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(cetaksiswa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 183, 1040, 410));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cetak Laporan Data Siswa");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 1020, 70));

        cmbkelas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmbkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Intensif", "Regular", "PDM", "PDS", "PDD" }));
        cmbkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkelasActionPerformed(evt);
            }
        });
        jPanel1.add(cmbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 118, 220, 40));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Bersihkan");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 110, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cetak");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 80, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8_Logout_Rounded_Down_32px.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkelasActionPerformed
        cari();
    }//GEN-LAST:event_cmbkelasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cmbkelas.setSelectedItem("PILIH");
        datatable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Map hash= new HashMap();
        hash.put("kelas",cmbkelas.getSelectedItem());
        try {
            File file=new File("src/Laporan/lap_siswa.jrxml");
            InputStream is = getClass().getResourceAsStream("/Laporan/lap_siswa.jrxml");
            InputStream IMGInputStream = this.getClass().getResourceAsStream("logo2.png");
            hash.put("logo", IMGInputStream);
            jasdes=net.sf.jasperreports.engine.xml.JRXmlLoader.load(is);
            jasrep=net.sf.jasperreports.engine.JasperCompileManager.compileReport(jasdes);
            jaspri=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasrep,hash,conn);
            JasperViewer.viewReport(jaspri,false);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin Keluar ?", "Warning", 2);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.gc();
            java.awt.Window win[] = java.awt.Window.getWindows();
            for (int i = 0; i < win.length; i++) {
                win[i].dispose();
                win[i] = null;
            }
            new View_Admin_Menu().setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(View_Laporan_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Laporan_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Laporan_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Laporan_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Laporan_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cetaksiswa;
    private javax.swing.JComboBox<String> cmbkelas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}