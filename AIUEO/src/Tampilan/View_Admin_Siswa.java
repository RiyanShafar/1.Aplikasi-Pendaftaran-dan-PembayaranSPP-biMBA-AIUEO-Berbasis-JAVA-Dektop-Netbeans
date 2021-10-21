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
public class View_Admin_Siswa extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;
private Connection conn = new koneksi().connect();
private DefaultTableModel tableModel;
String ID =usernameSesion.getUser();
    /**
     * Creates new form View_Admin_Siswa
     */
    public View_Admin_Siswa() {
        initComponents();
        setDefaultCloseOperation(0);
        this.setTitle("SISWA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        dctgllahir.setLocale(new Locale("ID"));
        dctgllahir.setDateFormatString("dd MMMM yyyy");
        datatable();
        txtuser.setText(ID);
    }
    protected void aktif() {
        txtnis.setEnabled(true);
        txtnma.setEnabled(true);
        txttempat.setEnabled(true);
        txtalamat.setEnabled(true);
        cmbkelas.setEnabled(true);
        txtagama.setEnabled(true);
        txttahunajaran.setEnabled(true);
        txtnis.requestFocus();
    }
    protected void kosong() {
        txtnis.setText("");
        txtnma.setText("");
        txttempat.setText("");
        dctgllahir.setCalendar(null);
        buttonGroup1.clearSelection();
        txtalamat.setText("");
        cmbkelas.setSelectedItem("PILIH");
        txtagama.setText("");
        txttahunajaran.setText("");
        txtnis.requestFocus();
    }
    protected void datatable() {
        Object[] Baris = {"No. Peserta", "Nama Siswa","Tempat Lahir","Tanggal Lahir","Jenis kelamin","Alamat","Kelas","Agama","Tahun Ajaran"};
        tableModel = new DefaultTableModel(null, Baris);
        tablesiswa.setModel(tableModel);
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
     Object[] Baris = {"No. Peserta", "Nama Siswa","Tempat Lahir","Tanggal Lahir","Jenis kelamin","Alamat","Kelas","Agama","Tahun Ajaran"};
        tableModel = new DefaultTableModel(null, Baris);
        tablesiswa.setModel(tableModel);
        String sql = "select * from siswa where nis= '"+txtcari.getText()+"' or nama = '"+txtcari.getText()+"'";
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
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtuser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtnma = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txttempat = new javax.swing.JTextField();
        dctgllahir = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        rblaki = new javax.swing.JRadioButton();
        rbpr = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        cmbkelas = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txttahunajaran = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablesiswa = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtagama = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

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
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 150, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-home-page-20.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, 180));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kembali Ke Menu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, -1));

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel16.setText("                                   Data Siswa biMBA AIUEO");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        txtnis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnis.setOpaque(false);
        txtnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnisKeyReleased(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setText("No.Peserta");

        txtnma.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnma.setOpaque(false);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Nama");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel40.setText("Tempat/Tanggal Lahir");

        txttempat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txttempat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttempat.setOpaque(false);

        dctgllahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel41.setText("Jenis Kelamin");

        buttonGroup1.add(rblaki);
        rblaki.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rblaki.setText("Laki-laki");

        buttonGroup1.add(rbpr);
        rbpr.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbpr.setText("Perempuan");
        rbpr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbprActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setText("Alamat");

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtalamat.setRows(5);
        txtalamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(txtalamat);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setText("Program Belajar");

        cmbkelas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmbkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "Intensif", "Regular", "PDM", "PDS", "PDD" }));
        cmbkelas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkelasActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel44.setText("Agama");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel45.setText("Tahun Ajaran");

        txttahunajaran.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txttahunajaran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttahunajaran.setOpaque(false);
        txttahunajaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttahunajaranKeyTyped(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Save_64px.png"))); // NOI18N
        jButton3.setText("Simpan");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Money Bag_64px.png"))); // NOI18N
        jButton6.setText("Bersihkan");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tablesiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablesiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesiswaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablesiswa);

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

        txtagama.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtagama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtagama.setOpaque(false);

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Edit_64px.png"))); // NOI18N
        jButton2.setText("Ubah");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Account_50px.png"))); // NOI18N
        jButton7.setText("Hapus");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(606, 606, 606)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtnis)
                                        .addComponent(jLabel38)
                                        .addComponent(txtnma)
                                        .addComponent(jLabel40)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(txttempat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(dctgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel41)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rblaki)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbpr))
                                        .addComponent(jLabel42)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel45)
                                        .addComponent(txttahunajaran)
                                        .addComponent(jLabel43)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(16, 16, 16)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(jLabel44)
                                    .addComponent(txtagama, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel37))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel38)
                        .addGap(11, 11, 11)
                        .addComponent(txtnma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel40)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttempat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dctgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rblaki)
                            .addComponent(rbpr))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(txtagama, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(cmbkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(txttahunajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
        String sql = "select nama_siswa,tempat_lahir,alamat,tanggal_lahir,agama,jk from pendaftaran where np like '%"+txtnis.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String nama_siswa  = hasil.getString("nama_siswa");
                txtnma.setText(nama_siswa);
                String tempat_lahir  = hasil.getString("tempat_lahir");
                txttempat.setText(tempat_lahir);
                String alamat  = hasil.getString("alamat");
                txtalamat.setText(alamat);
                String tanggal_lahir  = hasil.getString("tanggal_lahir");
                java.util.Date date = null;
                date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_lahir);
                dctgllahir.setDate(date);
                
                String jk  = hasil.getString("jk");
                if (jk.equals("Laki-Laki")) {
                    rblaki.setSelected(true);
                } else {
                    rbpr.setSelected(true);
                }
                
                String agama = hasil.getString("agama");
                txtagama.setText(agama);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        if (txtnis.getText().equals("")){
            txtnma.setText("");
            txttempat.setText("");
            txtalamat.setText("");
            txtagama.setText("");
            dctgllahir.setCalendar(null);
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_txtnisKeyReleased

    private void rbprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbprActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sql = "insert into siswa(nis,nama,tempat_lahir,tanggal_lahir,jk,alamat,kelas,agama,tahun_ajaran) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnis.getText());
            stat.setString(2, txtnma.getText());
            stat.setString(3, txttempat.getText());
            java.sql.Date tgllahir = new java.sql.Date(dctgllahir.getDate().getTime());
            stat.setDate(4, tgllahir);
            if (rblaki.isSelected()) {
                stat.setString(5, "Laki-Laki");
            }
            if (rbpr.isSelected()) {
                stat.setString(5, "Perempuan");
            }
            stat.setString(6, txtalamat.getText());
            stat.setString(7, (String) cmbkelas.getSelectedItem());
            stat.setString(8, (String) txtagama.getText());
            stat.setString(9, txttahunajaran.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            kosong();
            txtnis.requestFocus();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        kosong();
        txtcari.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tablesiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesiswaMouseClicked
        int bar = tablesiswa.getSelectedRow();
        String a = tableModel.getValueAt(bar, 0).toString();
        String b = tableModel.getValueAt(bar, 1).toString();
        String c = tableModel.getValueAt(bar, 2).toString();
        String d = tableModel.getValueAt(bar, 3).toString();
        String e = tableModel.getValueAt(bar, 4).toString();
        String f = tableModel.getValueAt(bar, 5).toString();
        String g = tableModel.getValueAt(bar, 6).toString();
        String h = tableModel.getValueAt(bar, 7).toString();
        String i = tableModel.getValueAt(bar, 8).toString();

        txtnis.setText(a);
        txtnma.setText(b);
        txttempat.setText(c);
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
        } catch (ParseException ex) {
            Logger.getLogger(View_Admin_Siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        dctgllahir.setDate(date);
        if (e.equals("Laki-Laki")) {
            rblaki.setSelected(true);
        } else {
            rbpr.setSelected(true);
        }
        txtalamat.setText(f);
        switch (g) {
            case "Intensif":
            cmbkelas.setSelectedIndex(1);
            break;
            case "Regular":
            cmbkelas.setSelectedIndex(2);
            break;
            case "PDM":
            cmbkelas.setSelectedIndex(3);
            break;
            case "PDS":
            cmbkelas.setSelectedIndex(4);
            break;
            case "PDD":
            cmbkelas.setSelectedIndex(5);
            break;
        }

        txtagama.setText(h); 
        txttahunajaran.setText(i);
    }//GEN-LAST:event_tablesiswaMouseClicked

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        cari();
    }//GEN-LAST:event_txtcariKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cmbkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbkelasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = "Update siswa set nama=?,tempat_lahir=?,tanggal_lahir=?,jk=?,alamat=?,kelas=?,agama=?,tahun_ajaran=?"
            + " where nis='" + txtnis.getText()+ "'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnma.getText());
            stat.setString(2, txttempat.getText());
            java.sql.Date tgllahir = new java.sql.Date(dctgllahir.getDate().getTime());
            stat.setDate(3, tgllahir);
            if (rblaki.isSelected()) {
                stat.setString(4, "Laki-Laki");
            }
            if (rbpr.isSelected()) {
                stat.setString(4, "Perempuan");
            }
            stat.setString(5, txtalamat.getText());
            stat.setString(6, (String) cmbkelas.getSelectedItem());
            stat.setString(7, txtagama.getText());
            stat.setString(8, txttahunajaran.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Diubah");
            kosong();
            txtnis.requestFocus();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0) {
            String sql = "delete from siswa where nis ='" + txtnis.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                txtnis.requestFocus();
                datatable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txttahunajaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunajaranKeyTyped
       FilterAngka(evt);
    }//GEN-LAST:event_txttahunajaranKeyTyped

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
            java.util.logging.Logger.getLogger(View_Admin_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Admin_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Admin_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbkelas;
    private com.toedter.calendar.JDateChooser dctgllahir;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JRadioButton rblaki;
    private javax.swing.JRadioButton rbpr;
    private javax.swing.JTable tablesiswa;
    private javax.swing.JTextField txtagama;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txtnma;
    private javax.swing.JTextField txttahunajaran;
    private javax.swing.JTextField txttempat;
    private javax.swing.JLabel txtuser;
    // End of variables declaration//GEN-END:variables
}
