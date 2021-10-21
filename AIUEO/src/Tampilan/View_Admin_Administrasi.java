/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import Koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFrame;
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
public class View_Admin_Administrasi extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;
private Connection conn = new koneksi().connect();
private DefaultTableModel tableModel;
JasperReport jasrep;
JasperPrint jaspri;
JasperDesign jasdes;
Statement stat;
ResultSet result;
String url,pass,sql;
String ID =usernameSesion.getUser();
    /**
     * Creates new form View_Admin_Administrasi
     */
    public View_Admin_Administrasi() {
        initComponents();
        setDefaultCloseOperation(0);
        this.setTitle("ADMINISTRASI");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        dctglbayar.setLocale(new Locale("ID"));
        dctglbayar.setDateFormatString("dd MMMM yyyy");
        datatable();
        txtuser.setText(ID);
    }
    protected void aktif() {
        txtnis.setEnabled(true);
        txtnama.setEnabled(true);
        txtkelas.setEnabled(true);
        
        txttahunajaran.setEnabled(true);
        dctglbayar.setEnabled(true);
        cmbjenisbiaya.setEnabled(true);
        txtbiaya.setEnabled(true);
        txtidpetugas.setEnabled(true);
        txtnmpetugas.setEnabled(true);
        txtnis.requestFocus();
    }
    protected void kosong() {
       // txtnis.setText("");
        txtnama.setText("");
        txtkelas.setText("");
        ltotbyar.setText("");
        txtnis.setText("");
        txtdibayar.setText("");
        txtkembalian.setText("");
        txttahunajaran.setText("");
        dctglbayar.setCalendar(null);
        cmbjenisbiaya.setSelectedItem("PILIH");
        txtbiaya.setText("");
        txtidpetugas.setText("");
        txtnmpetugas.setText("");
        txtnis.requestFocus();
    }
    protected void datatable() {
        Object[] Baris = {"No", "NIS","Nama Siswa","Kelas","Tahun Ajaran","Tanggal Pembayaran","Jenis Pembayaran","Biaya","Id Petugas","Nama Petugas"};
        tableModel = new DefaultTableModel(null, Baris);
        tableadministrasi.setModel(tableModel);
        String sql = "select * from administrasi";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pembayaran = hasil.getString("no_pembayaran");
                String nis = hasil.getString("nis");
                String nama_siswa = hasil.getString("nama_siswa");
                String kelas = hasil.getString("kelas");
                
                String tahun_ajaran = hasil.getString("tahun_ajaran");
                Date tanggal_pembayaran = hasil.getDate("tanggal_pembayaran");
                String jenis_pembayaran = hasil.getString("jenis_pembayaran");
                String biaya = hasil.getString("biaya");
                String id_petugas = hasil.getString("id_petugas");
                String nama_petugas = hasil.getString("nama_petugas");
                String[] data = {no_pembayaran,nis,nama_siswa,kelas,tahun_ajaran,String.valueOf(tanggal_pembayaran),jenis_pembayaran,biaya,id_petugas,nama_petugas};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    protected void cari(){
     Object[] Baris = {"No", "NIS","Nama Siswa","Kelas","Tahun Ajaran","Tanggal Pembayaran","Jenis Pembayaran","Biaya","Id Petugas","Nama Petugas"};
        tableModel = new DefaultTableModel(null, Baris);
        tableadministrasi.setModel(tableModel);
        String sql = "select * from administrasi where nis= '"+txtcari.getText()+"' or nama_siswa = '"+txtcari.getText()+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pembayaran = hasil.getString("no_pembayaran");
                String nis = hasil.getString("nis");
                String nama_siswa = hasil.getString("nama_siswa");
                String kelas = hasil.getString("kelas");
                
                String tahun_ajaran = hasil.getString("tahun_ajaran");
                Date tanggal_pembayaran = hasil.getDate("tanggal_pembayaran");
                String jenis_pembayaran = hasil.getString("jenis_pembayaran");
                String biaya = hasil.getString("biaya");
                String id_petugas = hasil.getString("id_petugas");
                String nama_petugas = hasil.getString("nama_petugas");
                String[] data = {no_pembayaran,nis,nama_siswa,kelas,tahun_ajaran,String.valueOf(tanggal_pembayaran),jenis_pembayaran,biaya,id_petugas,nama_petugas};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        if(txtcari.getText().equals("")){
        datatable();
        }
    }
    private void kwitansi(){
     String sql2 = "select sum(biaya) from administrasi where nis like '%"+txtnis.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql2);
            while(hasil.next()){
                String b  = hasil.getString("sum(biaya)");
                ltotbyar.setText(b);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        
        if (txtnis.getText().equals("")){
        ltotbyar.setText("");
        }
        cicilan();
     }
    private void cicilan(){
//    String sql = "select nama_siswa,kelas,semester,tahun_ajaran,tanggal_pembayaran,jenis_pembayaran,biaya,id_petugas,nama_petugas,sisa_cicilan from cicilan where nis like '%"+txtnis.getText()+"%'";
//        try{
//            java.sql.Statement stat = conn.createStatement();
//            ResultSet hasil = stat.executeQuery(sql);
//            while(hasil.next()){
//                String nama  = hasil.getString("nama_siswa");
//                txtnama.setText(nama);
//                String kelas  = hasil.getString("kelas");
//                txtkelas.setText(kelas);
//                String semester  = hasil.getString("semester");
//                txtsemester.setText(semester);
//                String tahun_ajaran  = hasil.getString("tahun_ajaran");
//                txttahunajaran.setText(tahun_ajaran);
//                String tanggal_pembayaran  = hasil.getString("tanggal_pembayaran");
//                java.util.Date date = null;
//                date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_pembayaran);
//                dctglbayar.setDate(date);
//                String jenis_pembayaran  = hasil.getString("jenis_pembayaran");
//                 switch (jenis_pembayaran) {
//                case "Dana Pendidikan":
//                cmbjenisbiaya.setSelectedIndex(1);
//                break;
//                case "Uang Tahunan":
//                cmbjenisbiaya.setSelectedIndex(2);
//                break;
//                case "SPP Kelas 1":
//                cmbjenisbiaya.setSelectedIndex(3);
//                break;
//                case "SPP Kelas 2":
//                cmbjenisbiaya.setSelectedIndex(4);
//                break;
//                case "SPP Kelas 3":
//                cmbjenisbiaya.setSelectedIndex(5);
//                break;
//                case "SPP Kelas 4":
//                cmbjenisbiaya.setSelectedIndex(6);
//                break;
//                case "Biaya Jemputan":
//                cmbjenisbiaya.setSelectedIndex(7);
//                break;
//                case "Ekstrakurikuler (Menari)":
//                cmbjenisbiaya.setSelectedIndex(8);
//                break;
//                case "Ekstrakurikuler (Renang)":
//                cmbjenisbiaya.setSelectedIndex(9);
//                break;
//                case "Ekstrakurikuler (Robotic)":
//                cmbjenisbiaya.setSelectedIndex(10);
//                break;
//                case "Ekstrakurikuler (Memanah)":
//                cmbjenisbiaya.setSelectedIndex(11);
//                break;
//                case "Ekstrakurikuler (Taekwondo)":
//                cmbjenisbiaya.setSelectedIndex(12);
//                break;
//                case "Formulir Pendaftaran":
//                cmbjenisbiaya.setSelectedIndex(13);
//                break;
//        }
//                String biaya  = hasil.getString("biaya");
//                txtbiaya.setText(biaya);
//                String id_petugas  = hasil.getString("id_petugas");
//                txtidpetugas.setText(id_petugas);
//                String nama_petugas  = hasil.getString("nama_petugas");
//                txtnmpetugas.setText(nama_petugas);
//                String sisa_cicilan  = hasil.getString("sisa_cicilan");
//                ltotbyar.setText(sisa_cicilan);
//            }
//        }catch (Exception e){
//            System.err.println(e);
//        }
//     
     }
    protected void nyicil(){
//       try{
//            double cicilan = Double.parseDouble(txtcicilan.getText());
//            double sisacicilan = Double.parseDouble(ltotbyar.getText());
//            int cicilan_lagi = (int) (sisacicilan-cicilan);
//            txtsisacicilan.setText(cicilan_lagi+"");
//
//        }catch(Exception e){
//        }
//
//        if (txtcicilan.getText().equals("")){
//            txtsisacicilan.setText("");
//        }
    }
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtuser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtkelas = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txttahunajaran = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cmbjenisbiaya = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txtbiaya = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtidpetugas = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtnmpetugas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableadministrasi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        txtdibayar = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        ltotbyar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dctglbayar = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo2.png")).getImage());

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Menu Utama          ");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 32));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8_Logout_Rounded_Down_32px.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1305, 10, 40, 40));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logoAdmin.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 110));

        txtuser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/150 x 150.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 150, -1));

        jButton7.setBackground(new java.awt.Color(255, 153, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-home-page-20.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 180));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kembali Ke Menu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, -1));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel14.setText("                             Administrasi biMBA AIUEO");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("No. Peserta");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Nama Siswa");

        txtnis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnis.setOpaque(false);
        txtnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnisActionPerformed(evt);
            }
        });
        txtnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnisKeyReleased(evt);
            }
        });

        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(0, 0, 0)));

        txtnama.setEditable(false);
        txtnama.setBackground(new java.awt.Color(255, 255, 255));
        txtnama.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnama.setOpaque(false);
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setText("Program Belajar");

        txtkelas.setEditable(false);
        txtkelas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtkelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtkelas.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Tahun Ajaran");

        txttahunajaran.setEditable(false);
        txttahunajaran.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txttahunajaran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttahunajaran.setOpaque(false);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("Id Petugas");

        cmbjenisbiaya.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmbjenisbiaya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "SPP Intensif", "SPP Regular", "SPP PDM", "SPP PDS", "SPP PDD" }));
        cmbjenisbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjenisbiayaActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setText("Biaya");

        txtbiaya.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtbiaya.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtbiaya.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setText("RP");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setText("Jenis Pembayaran");

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Tambah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtidpetugas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtidpetugas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtidpetugas.setOpaque(false);
        txtidpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpetugasActionPerformed(evt);
            }
        });
        txtidpetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidpetugasKeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setText("Nama Petugas");

        txtnmpetugas.setEditable(false);
        txtnmpetugas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnmpetugas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnmpetugas.setOpaque(false);

        tableadministrasi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableadministrasi);

        jPanel4.setBackground(new java.awt.Color(247, 193, 12));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel32.setText("Kembalian");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel33.setText("Dibayar");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtkembalian.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 740, 40));

        txtdibayar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdibayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdibayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdibayarKeyTyped(evt);
            }
        });
        jPanel4.add(txtdibayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 740, 40));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel34.setText(":");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 40));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setText(":");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 40));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("Cetak");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 120, 60));

        jPanel5.setBackground(new java.awt.Color(247, 193, 12));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ltotbyar.setBackground(new java.awt.Color(255, 255, 255));
        ltotbyar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ltotbyar.setText("-----------");
        ltotbyar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ltotbyarAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(ltotbyar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Total Bayar");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 40));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel36.setText(":");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, 40));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("BERSIHKAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 140, 46));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Tanggal Pembayaran");

        txtcari.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcari.setOpaque(false);
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel6.setText("Cari Siswa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16)
                                .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addComponent(txtnis, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addComponent(txtkelas, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addComponent(txttahunajaran, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addComponent(dctglbayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel22))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel30)
                                            .addComponent(cmbjenisbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidpetugas, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(txtnmpetugas, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbjenisbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnmpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(dctglbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel18)
                                .addGap(13, 13, 13)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(13, 13, 13)
                                .addComponent(txttahunajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin Keluar ?", "Warning", 2);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.gc();
            java.awt.Window win[] = java.awt.Window.getWindows();
            for (int i = 0; i < win.length; i++) {
                win[i].dispose();
                win[i] = null;
            }
            new View_Loginn().setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtnisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnisKeyReleased
        String sql = "select nama,kelas,tahun_ajaran from siswa where nis like '%"+txtnis.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama  = hasil.getString("nama");
                txtnama.setText(nama);
                String kelas  = hasil.getString("kelas");
                txtkelas.setText(kelas);
                
                String tahun_ajaran  = hasil.getString("tahun_ajaran");
                txttahunajaran.setText(tahun_ajaran);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        if (txtnis.getText().equals("")){
            txtnama.setText("");
            txtkelas.setText("");
            
            txttahunajaran.setText("");
        }

        kwitansi();
    }//GEN-LAST:event_txtnisKeyReleased

    private void cmbjenisbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjenisbiayaActionPerformed
        int harga=0;
        if (cmbjenisbiaya.getSelectedItem() == "SPP Intensif"){
            harga=400000;
        } else if (cmbjenisbiaya.getSelectedItem() == "SPP Regular"){
            harga=350000;
        } else if (cmbjenisbiaya.getSelectedItem() == "SPP PDM"){
            harga=200000;
        } else if (cmbjenisbiaya.getSelectedItem() == "SPP PDS"){
            harga=100000;
        } else if (cmbjenisbiaya.getSelectedItem() == "SPP PDD"){
            harga=50000;
        }  else {
            harga=0;
        }
        txtbiaya.setText(String.valueOf(harga));
    }//GEN-LAST:event_cmbjenisbiayaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sql = "insert into administrasi(nis,nama_siswa,kelas,tahun_ajaran,tanggal_pembayaran,jenis_pembayaran,biaya,id_petugas,nama_petugas) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnis.getText());
            stat.setString(2, txtnama.getText());
            stat.setString(3, txtkelas.getText());
            
            stat.setString(4, txttahunajaran.getText());
            java.sql.Date tglbyar = new java.sql.Date(dctglbayar.getDate().getTime());
            stat.setDate(5, tglbyar);
            stat.setString(6, (String) cmbjenisbiaya.getSelectedItem());
            stat.setString(7, txtbiaya.getText());
            stat.setString(8, txtidpetugas.getText());
            stat.setString(9, txtnmpetugas.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            cmbjenisbiaya.setSelectedItem("PILIH");
            txtbiaya.setText("");
            cmbjenisbiaya.requestFocus();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
        kwitansi();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtidpetugasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidpetugasKeyReleased
        String sql = "select nama_petugas from user where id_user like '%"+txtidpetugas.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama_petugas  = hasil.getString("nama_petugas");
                txtnmpetugas.setText(nama_petugas);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        if (txtidpetugas.getText().equals("")){
            txtnmpetugas.setText("");
        }
    }//GEN-LAST:event_txtidpetugasKeyReleased

    private void txtdibayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdibayarKeyReleased
        try{
            double dibayar = Double.parseDouble(txtdibayar.getText());
            double totalharga = Double.parseDouble(ltotbyar.getText());
            int kembalian = (int) (dibayar-totalharga);
            txtkembalian.setText(kembalian+"");

        }catch(Exception e){
        }

        if (txtdibayar.getText().equals("")){
            txtkembalian.setText("");
        }
    }//GEN-LAST:event_txtdibayarKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Map hash= new HashMap();
        hash.put("nis",txtnis.getText());
        try {
            File file=new File("src/Laporan/struk_pembayaran.jrxml");
            InputStream is = getClass().getResourceAsStream("/Laporan/struk_pembayaran.jrxml");
            InputStream IMGInputStream = this.getClass().getResourceAsStream("logo2.png");
            hash.put("logo", IMGInputStream);
            jasdes=net.sf.jasperreports.engine.xml.JRXmlLoader.load(is);
            jasrep=net.sf.jasperreports.engine.JasperCompileManager.compileReport(jasdes);
            jaspri=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasrep,hash,conn);
            JasperViewer.viewReport(jaspri,false);

        }catch (Exception e) {
            e.printStackTrace();
        }
        //kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ltotbyarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ltotbyarAncestorAdded

    }//GEN-LAST:event_ltotbyarAncestorAdded

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Kembali Kemenu ?", "Warning", 2);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.gc();
            java.awt.Window win[] = java.awt.Window.getWindows();
            for (int i = 0; i < win.length; i++) {
                win[i].dispose();
                win[i] = null;
            }
            new View_Admin_Menu().setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtidpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpetugasActionPerformed

    private void txtnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnisActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        cari();
    }//GEN-LAST:event_txtcariKeyReleased

    private void txtdibayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdibayarKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtdibayarKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        kosong();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Admin_Administrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbjenisbiaya;
    private com.toedter.calendar.JDateChooser dctglbayar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel ltotbyar;
    private javax.swing.JTable tableadministrasi;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtdibayar;
    private javax.swing.JTextField txtidpetugas;
    private javax.swing.JTextField txtkelas;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txtnmpetugas;
    private javax.swing.JTextField txttahunajaran;
    private javax.swing.JLabel txtuser;
    // End of variables declaration//GEN-END:variables
}
