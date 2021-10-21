/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Satrio_Ganteng
 */
public class View_Admin_pendaftaran extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;
private Connection conn = new koneksi().connect();
private DefaultTableModel tableModel;
private String id;
String ID =usernameSesion.getUser();
    /**
     * Creates new form View_Admin_pendaftaran
     */
    public View_Admin_pendaftaran() {
        initComponents();
        setDefaultCloseOperation(0);
        datatable();
        dctgllahir.setLocale(new Locale("ID"));
        dctgllahir.setDateFormatString("dd MMMM yyyy");
        dctanggal.setLocale(new Locale("ID"));
        dctanggal.setDateFormatString("dd MMMM yyyy");
        this.setTitle("PENDAFTARAN");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        txtuser.setText(ID);
    }
     protected void aktif() {
        txtnma.setEnabled(true);
        txtnik.setEnabled(true);
        txttempat.setEnabled(true);
        dctgllahir.setEnabled(true);
        txtalamat.setEnabled(true);
        txtagama.setEnabled(true);
        txtberatbadan.setEnabled(true);
        txtayah.setEnabled(true);
        cbpendayah.setEnabled(true);
        cmbpekerjaanayah.setEnabled(true);
        agayah.setEnabled(true);
        txthpayah.setEnabled(true);
        txtnmibu.setEnabled(true);
        cbpendibu.setEnabled(true);
        cbpekerjaanibu.setEnabled(true);
        agma.setEnabled(true);
        txthpibu.setEnabled(true);
        dctanggal.requestFocus();
    }
     protected void kosong() {
        dctanggal.setCalendar(null);
        txtnma.setText("");
        buttonGroup1.clearSelection();
        txtnik.setText("");
        txttempat.setText("");
        dctgllahir.setCalendar(null);
        txtalamat.setText("");
        txtagama.setText("");
        txtberatbadan.setText("");
        txtayah.setText("");
        cbpendayah.setSelectedItem("PILIH");
        cmbpekerjaanayah.setSelectedItem("PILIH");
        agayah.setText("");
        txthpayah.setText("");
        txtnmibu.setText("");
        cbpendibu.setSelectedItem("PILIH");
        cbpekerjaanibu.setSelectedItem("PILIH");
        agma.setText("");
        txthpibu.setText("");
        dctanggal.requestFocus();
    }
     protected void datatable() {
        Object[] Baris = {"No", "Tanggal Daftar", "Nama Siswa", "Jenis Kelamin","No.Pendaftaran","Tempat Lahir","Tanggal Lahir","Alamat","Agama","Berat Tinggi","Nama Ayah","Pendidikan Ayah","Pekerjaan Ayah","Agama Ayah","HP Ayah","Nama Ibu","Pendidikan Ibu","Pekerjaan Ibu","Agama Ibu","HP Ibu"};
        tableModel = new DefaultTableModel(null, Baris);
        tablependaftaran.setModel(tableModel);
        String sql = "select * from pendaftaran";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no = hasil.getString("no");
                Date tgl_daftar = hasil.getDate("tgl_daftar");
                String nama_siswa = hasil.getString("nama_siswa");
                String jk = hasil.getString("jk");
                String np = hasil.getString("np");
                String tempat_lahir = hasil.getString("tempat_lahir");
                Date tanggal_lahir = hasil.getDate("tanggal_lahir");
                String alamat = hasil.getString("alamat");
                String agama = hasil.getString("agama");
                String berat_tinggi = hasil.getString("berat_tinggi");
                String nama_ayah = hasil.getString("nama_ayah");
                String pend_ayah = hasil.getString("pend_ayah");
                String pekerjaan_ayah = hasil.getString("pekerjaan_ayah");
                String agama_ayah = hasil.getString("agama_ayah");
                String no_hp_ayah = hasil.getString("no_hp_ayah");
                String nama_ibu = hasil.getString("nama_ibu");
                String pend_ibu = hasil.getString("pend_ibu");
                String pekerjaan_ibu = hasil.getString("pekerjaan_ibu");
                String agama_ibu = hasil.getString("agama_ibu");
                String no_hp_ibu = hasil.getString("no_hp_ibu");
                String[] data = {no, String.valueOf(tgl_daftar), nama_siswa,jk,np,tempat_lahir,String.valueOf(tanggal_lahir),alamat,agama,berat_tinggi,nama_ayah,pend_ayah,pekerjaan_ayah,agama_ayah,no_hp_ayah,nama_ibu,pend_ibu,pekerjaan_ibu,agama_ibu,no_hp_ibu};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
     protected void cari(){
     Object[] Baris = {"No", "Tanggal Daftar", "Nama Siswa", "Jenis Kelamin","No.Pendaftaran","Tempat Lahir","Tanggal Lahir","Alamat","Agama","Berat Tinggi","Nama Ayah","Pendidikan Ayah","Pekerjaan Ayah","Agama Ayah","HP Ayah","Nama Ibu","Pendidikan Ibu","Pekerjaan Ibu","Agama Ibu","HP Ibu"};
        tableModel = new DefaultTableModel(null, Baris);
        tablependaftaran.setModel(tableModel);
        String sql = "select * from pendaftaran where np= '"+txtcari.getText()+"' or nama_siswa = '"+txtcari.getText()+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no = hasil.getString("no");
                Date tgl_daftar = hasil.getDate("tgl_daftar");
                String nama_siswa = hasil.getString("nama_siswa");
                String jk = hasil.getString("jk");
                String np = hasil.getString("np");
                String tempat_lahir = hasil.getString("tempat_lahir");
                Date tanggal_lahir = hasil.getDate("tanggal_lahir");
                String alamat = hasil.getString("alamat");
                String agama = hasil.getString("agama");
                String berat_tinggi = hasil.getString("berat_tinggi");
                String nama_ayah = hasil.getString("nama_ayah");
                String pend_ayah = hasil.getString("pend_ayah");
                String pekerjaan_ayah = hasil.getString("pekerjaan_ayah");
                String agama_ayah = hasil.getString("agama_ayah");
                String no_hp_ayah = hasil.getString("no_hp_ayah");
                String nama_ibu = hasil.getString("nama_ibu");
                String pend_ibu = hasil.getString("pend_ibu");
                String pekerjaan_ibu = hasil.getString("pekerjaan_ibu");
                String agama_ibu = hasil.getString("agama_ibu");
                String no_hp_ibu = hasil.getString("no_hp_ibu");
                String[] data = {no, String.valueOf(tgl_daftar), nama_siswa,jk,np,tempat_lahir,String.valueOf(tanggal_lahir),alamat,agama,berat_tinggi,nama_ayah,pend_ayah,pekerjaan_ayah,agama_ayah,no_hp_ayah,nama_ibu,pend_ibu,pekerjaan_ibu,agama_ibu,no_hp_ibu};
                
                tableModel.addRow(data);

            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        if(txtcari.getText().equals("")){
        datatable();
        }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtuser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dctanggal = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        txtnma = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        rbpr = new javax.swing.JRadioButton();
        rblaki = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        txttempat = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtnik = new javax.swing.JTextField();
        dctgllahir = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        txtagama = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtberatbadan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtayah = new javax.swing.JTextField();
        cbpendayah = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        cmbpekerjaanayah = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtnmibu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        cbpendibu = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        cbpekerjaanibu = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txthpayah = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txthpibu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablependaftaran = new javax.swing.JTable();
        agayah = new javax.swing.JTextField();
        agma = new javax.swing.JTextField();
        txtcari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo2.png")).getImage());
        setSize(new java.awt.Dimension(0, 0));

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

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-home-page-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 180));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kembali Ke Menu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, -1));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Pendaftaran Siswa biMBA AIUEO");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Tanggal Daftar");

        dctanggal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Nama Lengkap");

        txtnma.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnma.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setText("Jenis Kelamin");

        buttonGroup1.add(rbpr);
        rbpr.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbpr.setText("Perempuan");
        rbpr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbprActionPerformed(evt);
            }
        });

        buttonGroup1.add(rblaki);
        rblaki.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rblaki.setText("Laki-laki");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("No. Pendaftaran");

        txttempat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txttempat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttempat.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Tempat & Tanggal Lahir");

        txtnik.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnik.setOpaque(false);

        dctgllahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Alamat");

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtalamat.setRows(5);
        txtalamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtalamat);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("Agama");

        txtagama.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtagama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtagama.setOpaque(false);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setText("Berat dan Tinggi Badan");

        txtberatbadan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtberatbadan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtberatbadan.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("Kg/Cm");

        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setText("Nama Ayah");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setText("Pendidikan Ayah");

        txtayah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtayah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtayah.setOpaque(false);

        cbpendayah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbpendayah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Tidak Sekolah", "Putus SD", "SD Sederajat", "SMP Sederajat", "SMA Sederajat", "D1", "D2", "D3", "S1", "S2", "S3 " }));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setText("Pekerjaan Ayah");

        cmbpekerjaanayah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmbpekerjaanayah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Tidak Bekerja", "Nelayan", "Petani", "Peternak", "PNS/POLRI/TNI", "Karyawan Swasta", "Pedagang Kecil", "Pedagang Besar", "Wiraswasta", "Wirausaha", "Buruh", "Pesiunan", "Lain-lain" }));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setText("Agama Ayah");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("Nama Ibu");

        txtnmibu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnmibu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnmibu.setOpaque(false);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setText("Pendidikan Ibu");

        cbpendibu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbpendibu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Tidak Sekolah", "Putus SD", "SD Sederajat", "SMP Sederajat", "SMA Sederajat", "D1", "D2", "D3", "S1", "S2", "S3 " }));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Pekerjaan Ibu");

        cbpekerjaanibu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbpekerjaanibu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Tidak Bekerja/Ibu Rumah Tangga", "Nelayan", "Petani", "Peternak", "PNS/POLRI/TNI", "Karyawan Swasta", "Pedagang Kecil", "Pedagang Besar", "Wiraswasta", "Wirausaha", "Buruh", "Pesiunan", "Lain-lain" }));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setText("Agama Ibu");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setText("Nomor HP Ayah");

        txthpayah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txthpayah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txthpayah.setOpaque(false);
        txthpayah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthpayahKeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Nomor HP Ibu");

        txthpibu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txthpibu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txthpibu.setOpaque(false);
        txthpibu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthpibuKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Save_64px.png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Money Bag_64px.png"))); // NOI18N
        jButton4.setText("Bersihkan");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tablependaftaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tablependaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablependaftaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablependaftaran);

        agayah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        agayah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        agma.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        agma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtcari.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcari.setOpaque(false);
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel5.setText("Cari Siswa");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 10)); // NOI18N
        jLabel4.setText("Ketik No. Pendaftaran / Nama");

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Edit_64px.png"))); // NOI18N
        jButton3.setText("Ubah");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Account_50px.png"))); // NOI18N
        jButton6.setText("Hapus");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel26)
                                    .addComponent(txtagama, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtberatbadan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27))
                                    .addComponent(jLabel22)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addComponent(txtnik)
                                        .addComponent(txtnma)
                                        .addComponent(dctanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txttempat, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(dctgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rblaki)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbpr)))))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txthpayah)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30)
                                            .addComponent(txtayah, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                            .addComponent(cbpendayah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel31)
                                            .addComponent(cmbpekerjaanayah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel37)
                                            .addComponent(agayah))
                                        .addGap(75, 75, 75)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel38)
                                            .addComponent(cbpendibu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel33)
                                            .addComponent(txtnmibu, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel35)
                                            .addComponent(cbpekerjaanibu, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel36)
                                            .addComponent(txthpibu)
                                            .addComponent(agma)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(29, 29, 29))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dctanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rblaki)
                                    .addComponent(rbpr))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttempat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dctgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtagama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtberatbadan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27)))
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(346, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnmibu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbpendayah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbpendibu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbpekerjaanayah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbpekerjaanibu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agayah)
                            .addComponent(agma, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthpayah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthpibu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton6))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268))))
        );

        jScrollPane3.setViewportView(jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Menu Pendaftaran");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 32));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8_Logout_Rounded_Down_32px.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1305, 10, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablependaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablependaftaranMouseClicked
        int bar = tablependaftaran.getSelectedRow();
        String a = tableModel.getValueAt(bar, 0).toString();
        String b = tableModel.getValueAt(bar, 1).toString();
        String c = tableModel.getValueAt(bar, 2).toString();
        String d = tableModel.getValueAt(bar, 3).toString();
        String e = tableModel.getValueAt(bar, 4).toString();
        String f = tableModel.getValueAt(bar, 5).toString();
        String g = tableModel.getValueAt(bar, 6).toString();
        String h = tableModel.getValueAt(bar, 7).toString();
        String i = tableModel.getValueAt(bar, 8).toString();
        String j = tableModel.getValueAt(bar, 9).toString();
        String k = tableModel.getValueAt(bar, 10).toString();
        String l = tableModel.getValueAt(bar, 11).toString();
        String m = tableModel.getValueAt(bar, 12).toString();
        String n = tableModel.getValueAt(bar, 13).toString();
        String o = tableModel.getValueAt(bar, 14).toString();
        String p = tableModel.getValueAt(bar, 15).toString();
        String q = tableModel.getValueAt(bar, 16).toString();
        String r = tableModel.getValueAt(bar, 17).toString();
        String s = tableModel.getValueAt(bar, 18).toString();
        String t = tableModel.getValueAt(bar, 19).toString();

        id= a;
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(b);
        } catch (ParseException ex) {
            Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        dctanggal.setDate(date);
        txtnma.setText(c);
        if (d.equals("Laki-Laki")) {
            rblaki.setSelected(true);
        } else {
            rbpr.setSelected(true);
        }
        txtnik.setText(e);
        txttempat.setText(f);
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(g);
        } catch (ParseException ex) {
            Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        dctgllahir.setDate(date);
        txtalamat.setText(h);
        txtagama.setText(i);
        txtberatbadan.setText(j);
        txtayah.setText(k);
        switch (l) {
            case "Tidak Sekolah":
            cbpendayah.setSelectedIndex(1);
            break;
            case "Putus SD":
            cbpendayah.setSelectedIndex(2);
            break;
            case "SD Sederajat":
            cbpendayah.setSelectedIndex(3);
            break;
            case "SMP Sederajat":
            cbpendayah.setSelectedIndex(4);
            break;
            case "SMA Sederajat":
            cbpendayah.setSelectedIndex(5);
            break;
            case "D1":
            cbpendayah.setSelectedIndex(6);
            break;
            case "D2":
            cbpendayah.setSelectedIndex(7);
            break;
            case "D3":
            cbpendayah.setSelectedIndex(8);
            break;
            case "S1":
            cbpendayah.setSelectedIndex(9);
            break;
            case "S2":
            cbpendayah.setSelectedIndex(10);
            break;
            case "S3":
            cbpendayah.setSelectedIndex(11);
            break;
        }

        switch (m) {
            case "Tidak Bekerja":
            cmbpekerjaanayah.setSelectedIndex(1);
            break;
            case "Nelayan":
            cmbpekerjaanayah.setSelectedIndex(2);
            break;
            case "Petani":
            cmbpekerjaanayah.setSelectedIndex(3);
            break;
            case "Peternak":
            cmbpekerjaanayah.setSelectedIndex(4);
            break;
            case "PNS/POLRI/TNI":
            cmbpekerjaanayah.setSelectedIndex(5);
            break;
            case "Karyawan Swasta":
            cmbpekerjaanayah.setSelectedIndex(6);
            break;
            case "Pedagang Kecil":
            cmbpekerjaanayah.setSelectedIndex(7);
            break;
            case "Pedagang Besar":
            cmbpekerjaanayah.setSelectedIndex(8);
            break;
            case "Wiraswasta":
            cmbpekerjaanayah.setSelectedIndex(9);
            break;
            case "Wirausaha":
            cmbpekerjaanayah.setSelectedIndex(10);
            break;
            case "Buruh":
            cmbpekerjaanayah.setSelectedIndex(11);
            break;
            case "Pesiunan":
            cmbpekerjaanayah.setSelectedIndex(12);
            break;
            case "Lain-lain":
            cmbpekerjaanayah.setSelectedIndex(13);
            break;
        }

        agayah.setText(n); 
        txthpayah.setText(o);
        txtnmibu.setText(p);
        switch (q) {
            case "Tidak Sekolah":
            cbpendibu.setSelectedIndex(1);
            break;
            case "Putus SD":
            cbpendibu.setSelectedIndex(2);
            break;
            case "SD Sederajat":
            cbpendibu.setSelectedIndex(3);
            break;
            case "SMP Sederajat":
            cbpendibu.setSelectedIndex(4);
            break;
            case "SMA Sederajat":
            cbpendibu.setSelectedIndex(5);
            break;
            case "D1":
            cbpendibu.setSelectedIndex(6);
            break;
            case "D2":
            cbpendibu.setSelectedIndex(7);
            break;
            case "D3":
            cbpendibu.setSelectedIndex(8);
            break;
            case "S1":
            cbpendibu.setSelectedIndex(9);
            break;
            case "S2":
            cbpendibu.setSelectedIndex(10);
            break;
            case "S3":
            cbpendibu.setSelectedIndex(11);
            break;
        }

        switch (r) {
            case "Tidak Bekerja/Ibu Rumah Tangga":
            cbpekerjaanibu.setSelectedIndex(1);
            break;
            case "Nelayan":
            cbpekerjaanibu.setSelectedIndex(2);
            break;
            case "Petani":
            cbpekerjaanibu.setSelectedIndex(3);
            break;
            case "Peternak":
            cbpekerjaanibu.setSelectedIndex(4);
            break;
            case "PNS/POLRI/TNI":
            cbpekerjaanibu.setSelectedIndex(5);
            break;
            case "Karyawan Swasta":
            cbpekerjaanibu.setSelectedIndex(6);
            break;
            case "Pedagang Kecil":
            cbpekerjaanibu.setSelectedIndex(7);
            break;
            case "Pedagang Besar":
            cbpekerjaanibu.setSelectedIndex(8);
            break;
            case "Wiraswasta":
            cbpekerjaanibu.setSelectedIndex(9);
            break;
            case "Wirausaha":
            cbpekerjaanibu.setSelectedIndex(10);
            break;
            case "Buruh":
            cbpekerjaanibu.setSelectedIndex(11);
            break;
            case "Pesiunan":
            cbpekerjaanibu.setSelectedIndex(12);
            break;
            case "Lain-lain":
            cbpekerjaanibu.setSelectedIndex(13);
            break;
        }
        agma.setText(s); 
        txthpibu.setText(t);
    }//GEN-LAST:event_tablependaftaranMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "insert into pendaftaran(tgl_daftar,nama_siswa,jk,np,tempat_lahir,tanggal_lahir,alamat,agama,berat_tinggi,nama_ayah,pend_ayah,pekerjaan_ayah,agama_ayah,no_hp_ayah,nama_ibu,pend_ibu,pekerjaan_ibu,agama_ibu,no_hp_ibu) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            java.sql.Date tgldaftar = new java.sql.Date(dctanggal.getDate().getTime());
            stat.setDate(1, tgldaftar);
            stat.setString(2, txtnma.getText());
            if (rblaki.isSelected()) {
                stat.setString(3, "Laki-Laki");
            }
            if (rbpr.isSelected()) {
                stat.setString(3, "Perempuan");
            }
            stat.setString(4, txtnik.getText());
            stat.setString(5, txttempat.getText());
            java.sql.Date tgllahir = new java.sql.Date(dctgllahir.getDate().getTime());
            stat.setDate(6, tgllahir);
            stat.setString(7, txtalamat.getText());
            stat.setString(8, txtagama.getText());
            stat.setString(9, txtberatbadan.getText());
            stat.setString(10, txtayah.getText());
            stat.setString(11, (String) cbpendayah.getSelectedItem());
            stat.setString(12, (String) cmbpekerjaanayah.getSelectedItem());
            stat.setString(13, (String) agayah.getText());
            stat.setString(14, txthpayah.getText());
            stat.setString(15, txtnmibu.getText());
            stat.setString(16, (String) cbpendibu.getSelectedItem());
            stat.setString(17, (String) cbpekerjaanibu.getSelectedItem());
            stat.setString(18, (String) agma.getText());
            stat.setString(19, txthpibu.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Terdaftar");
            kosong();
            txtnma.requestFocus();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbprActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        cari();
    }//GEN-LAST:event_txtcariKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String sql = "Update pendaftaran set tgl_daftar=?,nama_siswa=?,jk=?,np=?,tempat_lahir=?,tanggal_lahir=?,alamat=?,agama=?,berat_tinggi=?,nama_ayah=?,pend_ayah=?,pekerjaan_ayah=?,agama_ayah=?,no_hp_ayah=?,nama_ibu=?,pend_ibu=?,pekerjaan_ibu=?,agama_ibu=?,no_hp_ibu=?"
            + " where no='" + id + "'";
            PreparedStatement stat = conn.prepareStatement(sql);
            java.sql.Date tgldaftar = new java.sql.Date(dctanggal.getDate().getTime());
            stat.setDate(1, tgldaftar);
            stat.setString(2, txtnma.getText());
            if (rblaki.isSelected()) {
                stat.setString(3, "Laki-Laki");
            }
            if (rbpr.isSelected()) {
                stat.setString(3, "Perempuan");
            }
            stat.setString(4, txtnik.getText());
            stat.setString(5, txttempat.getText());
            java.sql.Date tgllahir = new java.sql.Date(dctgllahir.getDate().getTime());
            stat.setDate(6, tgllahir);
            stat.setString(7, txtalamat.getText());
            stat.setString(8, txtagama.getText());
            stat.setString(9, txtberatbadan.getText());
            stat.setString(10, txtayah.getText());
            stat.setString(11, (String) cbpendayah.getSelectedItem());
            stat.setString(12, (String) cmbpekerjaanayah.getSelectedItem());
            stat.setString(13, agayah.getText());
            stat.setString(14, txthpayah.getText());
            stat.setString(15, txtnmibu.getText());
            stat.setString(16, (String) cbpendibu.getSelectedItem());
            stat.setString(17, (String) cbpekerjaanibu.getSelectedItem());
            stat.setString(18, agma.getText());
            stat.setString(19, txthpibu.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Diubah");
            kosong();
            dctanggal.requestFocus();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0) {
            String sql = "delete from pendaftaran where no ='" + id + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Absen Berhasil Dihapus");
                kosong();
                txtnma.requestFocus();
                datatable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txthpayahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthpayahKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txthpayahKeyTyped

    private void txthpibuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthpibuKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txthpibuKeyTyped

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
            java.util.logging.Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Admin_pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Admin_pendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agayah;
    private javax.swing.JTextField agma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbpekerjaanibu;
    private javax.swing.JComboBox<String> cbpendayah;
    private javax.swing.JComboBox<String> cbpendibu;
    private javax.swing.JComboBox<String> cmbpekerjaanayah;
    private com.toedter.calendar.JDateChooser dctanggal;
    private com.toedter.calendar.JDateChooser dctgllahir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rblaki;
    private javax.swing.JRadioButton rbpr;
    private javax.swing.JTable tablependaftaran;
    private javax.swing.JTextField txtagama;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtayah;
    private javax.swing.JTextField txtberatbadan;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txthpayah;
    private javax.swing.JTextField txthpibu;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtnma;
    private javax.swing.JTextField txtnmibu;
    private javax.swing.JTextField txttempat;
    private javax.swing.JLabel txtuser;
    // End of variables declaration//GEN-END:variables
}
