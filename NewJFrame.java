
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class NewJFrame extends JFrame {
    String curDir = System.getProperty("user.home");

    String os_name = System.getProperty("os.name");

    Runtime proc = Runtime.getRuntime();

    int i = 0;

    int firstClick = 0;

    private JMenuItem copy_tf;

    private JMenuItem cut_tf2;

    private JLabel d;

    private JTextField day;

    private JButton getde;

    private JButton jButton1;

    private JLabel jLabel1;

    private JPanel jPanel1;

    private JScrollPane jScrollPane1;

    private JLabel m;

    private JPopupMenu menu_tf;

    private JPopupMenu menu_tf2;

    private JTextField month;

    private JButton o;

    private JButton os;

    private JMenuItem paste_tf;

    private JMenuItem paste_tf2;

    private JLabel sa;

    private JButton ss;

    private JTextArea tf;

    private JTextField tf2;

    private JLabel y;

    private JTextField year;

    public void fileWrite(String s, File fil) throws FileNotFoundException, IOException {
        int j = 0;
        FileOutputStream fos = new FileOutputStream(fil, true);
        while (j < s.length()) {
            if (s.charAt(j) == '\n') {
                fos.write(13);
                fos.write(10);
                j++;
                continue;
            }
            fos.write(s.charAt(j++));
        }
        fos.close();
    }

    public int string_to_int(String str) {
        int value = 0;
        int l = str.length();
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) != ' ')
                value = value * 10 + str.charAt(i) - 48;
        }
        return value;
    }

    public String get_chars(String str) {
        String chars = "";
        int l = str.length();
        for (int j = 0; j < l; j++) {
            if (str.charAt(j) != ' ' && (
                    str.charAt(j) < '0' || str.charAt(j) > '9'))
                chars = chars + str.charAt(j);
        }
        System.out.println("" + chars);
        return chars;
    }

    public NewJFrame() {
        initComponents();
        this.getde.setVisible(false);
        this.day.setVisible(false);
        this.month.setVisible(false);
        this.year.setVisible(false);
        this.d.setVisible(false);
        this.m.setVisible(false);
        this.y.setVisible(false);
        System.out.print("  os is==" + this.os_name);
        this.tf.grabFocus();
        this.tf.setCaretColor(Color.blue);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width / 4 - 100, dim.height / 4 - 140);
        File fd = new File(this.curDir + "/txt-files");
        if (!fd.exists())
            fd.mkdir();
        this.curDir += "/txt-files";
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.menu_tf = new JPopupMenu();
        this.paste_tf = new JMenuItem();
        this.copy_tf = new JMenuItem();
        this.menu_tf2 = new JPopupMenu();
        this.paste_tf2 = new JMenuItem();
        this.cut_tf2 = new JMenuItem();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tf = new JTextArea();
        this.os = new JButton();
        this.o = new JButton();
        this.tf2 = new JTextField();
        this.ss = new JButton();
        this.jLabel1 = new JLabel();
        this.sa = new JLabel();
        this.getde = new JButton();
        this.day = new JTextField();
        this.d = new JLabel();
        this.m = new JLabel();
        this.month = new JTextField();
        this.y = new JLabel();
        this.year = new JTextField();
        this.jButton1.setText("jButton1");
        this.paste_tf.setBackground(new Color(204, 204, 255));
        this.paste_tf.setText("paste");
        this.paste_tf.setActionCommand("jMenuItem1");
        this.paste_tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.paste_tfActionPerformed(evt);
            }
        });
        this.menu_tf.add(this.paste_tf);
        this.copy_tf.setBackground(new Color(204, 204, 255));
        this.copy_tf.setText("copy");
        this.copy_tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.copy_tfActionPerformed(evt);
            }
        });
        this.menu_tf.add(this.copy_tf);
        this.paste_tf2.setBackground(new Color(204, 255, 204));
        this.paste_tf2.setText("paste");
        this.paste_tf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.paste_tf2ActionPerformed(evt);
            }
        });
        this.menu_tf2.add(this.paste_tf2);
        this.cut_tf2.setBackground(new Color(204, 255, 204));
        this.cut_tf2.setText("cut");
        this.cut_tf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.cut_tf2ActionPerformed(evt);
            }
        });
        this.menu_tf2.add(this.cut_tf2);
        setDefaultCloseOperation(3);
        setTitle("Auto_Saver..  by   @bh!....(cse09 - IIT(BHU), akiitbhu@gmail.com)");
        setMinimumSize(new Dimension(110, 74));
        this.jPanel1.setBackground(new Color(204, 204, 255));
        this.tf.setColumns(20);
        this.tf.setFont(new Font("Arial", 0, 14));
        this.tf.setRows(5);
        this.tf.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NewJFrame.this.tfMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                NewJFrame.this.tfMousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                NewJFrame.this.tfMouseReleased(evt);
            }
        });
        this.tf.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                NewJFrame.this.tfMouseMoved(evt);
            }
        });
        this.tf.addAncestorListener(new AncestorListener() {
            public void ancestorMoved(AncestorEvent evt) {}

            public void ancestorAdded(AncestorEvent evt) {
                NewJFrame.this.tfAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {}
        });
        this.jScrollPane1.setViewportView(this.tf);
        this.os.setBackground(new Color(255, 255, 204));
        this.os.setText("S");
        this.os.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.osActionPerformed(evt);
            }
        });
        this.o.setBackground(new Color(255, 204, 204));
        this.o.setText("o");
        this.o.setFocusPainted(false);
        this.o.setFocusable(false);
        this.o.setRequestFocusEnabled(false);
        this.o.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.oActionPerformed(evt);
            }
        });
        this.tf2.setText("save as(ex: abhi)    &    click  S");
        this.tf2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                NewJFrame.this.tf2MousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                NewJFrame.this.tf2MouseReleased(evt);
            }
        });
        this.tf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.tf2ActionPerformed(evt);
            }
        });
        this.ss.setBackground(new Color(204, 255, 204));
        this.ss.setText("ss");
        this.ss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.ssActionPerformed(evt);
            }
        });
        this.jLabel1.setText(" cs--");
        this.jLabel1.setToolTipText("clear screen");
        this.jLabel1.setCursor(new Cursor(12));
        this.jLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NewJFrame.this.jLabel1MouseClicked(evt);
            }
        });
        this.sa.setText("gday");
        this.sa.setToolTipText("get day of any date");
        this.sa.setCursor(new Cursor(12));
        this.sa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NewJFrame.this.saMouseClicked(evt);
            }
        });
        this.getde.setBackground(new Color(204, 255, 204));
        this.getde.setText("getDe");
        this.getde.setHorizontalTextPosition(2);
        this.getde.setMaximumSize(new Dimension(120, 23));
        this.getde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewJFrame.this.getdeActionPerformed(evt);
            }
        });
        this.d.setText("d");
        this.m.setText("m");
        this.y.setText("y");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 382, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.getde, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.d).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.day, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.m).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.month, -2, 21, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.y, -2, 6, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.year, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ss, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tf2, 0, 0, 32767).addGap(18, 18, 18).addComponent(this.sa, -2, 30, -2).addGap(12, 12, 12))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.o).addComponent(this.os).addComponent(this.jLabel1, -2, 27, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.getde, -2, 23, -2).addComponent(this.day, -2, -1, -2).addComponent(this.d).addComponent(this.m).addComponent(this.month, -2, -1, -2).addComponent(this.y).addComponent(this.year, -2, -1, -2).addComponent(this.ss, -2, 23, -2).addComponent(this.tf2, -2, 22, -2).addComponent(this.sa)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 172, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.o, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.os, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 9, -2))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        pack();
    }

    private void osActionPerformed(ActionEvent evt) {
        Calendar cal = Calendar.getInstance();
        String month = "", am_pm = "", time = "";
        int m = cal.get(2);
        int d = cal.get(5);
        int y = cal.get(1);
        int apm = cal.get(9);
        switch (m) {
            case 0:
                month = "Jan";
                break;
            case 1:
                month = "Feb";
                break;
            case 2:
                month = "Mar";
                break;
            case 3:
                month = "Apr";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "Aug";
                break;
            case 8:
                month = "Sept";
                break;
            case 9:
                month = "Oct";
                break;
            case 10:
                month = "Nov";
                break;
            case 11:
                month = "Dec";
                break;
        }
        switch (apm) {
            case 0:
                am_pm = "AM";
                break;
            case 1:
                am_pm = "PM";
                break;
        }
        String date = "\n**.........................................................**\n           Saved on -> " + month + " " + d + "," + y;
        time = "  # Time ->" + cal.get(10) + ":" + cal.get(12) + ":" + cal.get(13) + am_pm + "\n";
        date = date + time;
        String s = this.tf.getText();
        String s2 = this.tf2.getText();
        File f = new File(this.curDir + "/auto_saved.txt");
        File f2 = new File(this.curDir + "/" + s2 + ".txt");
        try {
            if (!s.equals("")) {
                if (s2.equals("") || !this.tf2.isVisible() || s2.equals("save as(ex: abhi)    &    click  S")) {
                    fileWrite(date, f);
                    fileWrite(s, f);
                    this.os.setBackground(Color.cyan);
                    setTitle("saved to::" + this.curDir + "/auto_saved.txt");
                } else {
                    fileWrite(date, f2);
                    fileWrite(s, f2);
                    this.os.setBackground(Color.cyan);
                    setTitle("saved to::" + this.curDir + "/" + s2 + ".txt");
                }
            } else {
                this.os.setBackground(Color.decode("#FFFFAA"));
                setTitle("write some text then save");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }

    private void tfAncestorAdded(AncestorEvent evt) {}

    private void oActionPerformed(ActionEvent evt) {
        try {
            String s = this.tf.getText();
            String s2 = this.tf2.getText();
            String path1 = this.curDir + "/auto_saved.txt";
            String path2 = this.curDir + "/" + s2 + ".txt";
            if (this.os_name.contains("Win") || this.os_name.contains("Vista")) {
                if (s2.equals("") || !this.tf2.isVisible() || s2.equals("save as(ex: abhi)    &    click  S")) {
                    if ((new File("C:/Program Files/Notepad++/notepad++.exe")).exists()) {
                        this.proc.exec("C:/Program Files/Notepad++/notepad++.exe " + path1);
                    } else if ((new File("C:/Program Files (x86)/Notepad++/notepad++.exe")).exists()) {
                        this.proc.exec("C:/Program Files (x86)/Notepad++/notepad++.exe " + path1);
                    } else {
                        this.proc.exec("notepad " + path1);
                    }
                    this.o.setBackground(Color.cyan);
                    setTitle("opened as::" + path1);
                } else {
                    if ((new File("C:/Program Files/Notepad++/notepad++.exe")).exists()) {
                        this.proc.exec("C:/Program Files/Notepad++/notepad++.exe " + path2);
                    } else if ((new File("C:/Program Files (x86)/Notepad++/notepad++.exe")).exists()) {
                        this.proc.exec("C:/Program Files (x86)/Notepad++/notepad++.exe " + path2);
                    } else {
                        this.proc.exec("notepad " + path2);
                    }
                    this.o.setBackground(Color.ORANGE);
                    setTitle("opened as::" + path2);
                }
            }// Mac
            else if (this.os_name.contains("Mac")){
                if (s2.equals("") || !this.tf2.isVisible() || s2.equals("save as(ex: abhi)    &    click  S")) {
                    this.proc.exec("open " + path1);
                    this.o.setBackground(Color.cyan);
                    setTitle("opened as::" + path1);
                }else{
                    this.proc.exec("open " + path2);
                    this.o.setBackground(Color.ORANGE);
                    setTitle("opened as::" + path2);
                }
            }//linux
            else if (s2.equals("") || !this.tf2.isVisible() || s2.equals("save as(ex: abhi)    &    click  S")) {
                this.proc.exec("gedit " + path1);
                this.o.setBackground(Color.cyan);
                setTitle("opened as::" + path1);
            } else {
                this.proc.exec("gedit " + path2);
                this.o.setBackground(Color.ORANGE);
                setTitle("opened as::" + path2);
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }

    private void tf2ActionPerformed(ActionEvent evt) {}

    private void tf2MousePressed(MouseEvent evt) {
        if (this.firstClick == 0) {
            this.tf2.setText("");
            this.firstClick = 1;
        }
        if (evt.isPopupTrigger())
            this.menu_tf2.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    private void ssActionPerformed(ActionEvent evt) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screen = toolkit.getScreenSize();
            Rectangle rect = new Rectangle(0, 0, screen.width, screen.height);
            Robot robot = new Robot();
            BufferedImage img = robot.createScreenCapture(rect);
            String s = this.tf2.getText();
            boolean fd = (new File(this.curDir + "/my-screen-shots")).mkdir();
            if (!s.equals("save as(ex: abhi)    &    click  S")) {
                try {
                    File file = new File(this.curDir + "/my-screen-shots/" + s + ".png");
                    if (file.exists()) {
                        String s2 = file.getName();
                        this.i++;
                        file = new File(this.curDir + "/my-screen-shots/" + s + "(" + this.i + ").png");
                        setTitle("img saved 2:" + this.curDir + "/my-screen-shots/" + s + "(" + this.i + ").png");
                    } else {
                        file = new File(this.curDir + "/my-screen-shots/" + s + ".png");
                        setTitle("img saved 2:" + this.curDir + "/my-screen-shots/" + s + ".png");
                        this.i = 0;
                    }
                    ImageIO.write(img, "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
                }
            } else {
                setTitle("enter name for Screen Shot(ss) n then click \"ss\"");
            }
        } catch (AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }

    private void tfMousePressed(MouseEvent evt) {
        if (evt.isPopupTrigger())
            this.menu_tf.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    private void tfMouseClicked(MouseEvent evt) {}

    private void jLabel1MouseClicked(MouseEvent evt) {
        this.tf.setText("");
        this.day.setText("");
        this.month.setText("");
        this.year.setText("");
        this.os.setBackground(Color.decode("#FFFFAA"));
        this.getde.setBackground(Color.decode("#C3FDB8"));
    }

    private void saMouseClicked(MouseEvent evt) {
        if (this.tf2.isVisible()) {
            this.tf2.setVisible(false);
            this.ss.setVisible(false);
            this.sa.setText("SA");
            this.sa.setToolTipText("switch to Save As mode");
            this.getde.setVisible(true);
            this.day.setVisible(true);
            this.month.setVisible(true);
            this.year.setVisible(true);
            this.d.setVisible(true);
            this.m.setVisible(true);
            this.y.setVisible(true);
        } else {
            this.tf2.setVisible(true);
            this.ss.setVisible(true);
            this.sa.setText("gday");
            this.sa.setToolTipText("get day of any date");
            this.getde.setVisible(false);
            this.day.setVisible(false);
            this.month.setVisible(false);
            this.year.setVisible(false);
            this.d.setVisible(false);
            this.m.setVisible(false);
            this.y.setVisible(false);
        }
    }

    private void getdeActionPerformed(ActionEvent evt) {
        String str_d = this.day.getText();
        String str_m = this.month.getText();
        String str_y = this.year.getText();
        this.day.grabFocus();
        boolean valid = true;
        int day1 = string_to_int(str_d);
        int month1 = string_to_int(str_m);
        int year1 = string_to_int(str_y);
        String invalid = "?? Invalid :-->";
        if (day1 <= 0 || day1 > 31 || str_d.equals("") || get_chars(str_d).length() > 0) {
            invalid = invalid + "Day(" + str_d + ")";
            valid = false;
        }
        if (month1 <= 0 || month1 > 12 || str_m.equals("") || get_chars(str_m).length() > 0) {
            invalid = invalid + " + Month(" + str_m + ")";
            valid = false;
        }
        if (year1 <= 0 || str_y.equals("") || get_chars(str_y).length() > 0) {
            invalid = invalid + " + Year(" + str_y + ")";
            valid = false;
        }
        if ((month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) && day1 == 31) {
            invalid = invalid + "\r\n  30 ka mhina hai ullu..:) ;) \r\n";
            valid = false;
        }
        if (month1 == 2 && day1 > 29) {
            valid = false;
            invalid = invalid + "\r\n this is February...ullu ;).";
        }
        if (month1 == 2)
            if (year1 % 100 == 0) {
                if (year1 % 400 != 0 && day1 > 28) {
                    valid = false;
                    invalid = invalid + "\r\n this century is not a Leap Year.";
                }
            } else if (year1 % 4 != 0 && day1 > 28) {
                valid = false;
                invalid = invalid + "\r\n this is February...n not Leap yr...  ;)";
            }
        if (valid) {
            this.getde.setBackground(Color.cyan);
            int a1 = (14 - month1) / 12;
            int m1 = month1 + 12 * a1 - 2;
            int y1 = year1 - a1;
            int d1 = y1 + day1 + y1 / 4 - y1 / 100 + y1 / 400 + 31 * m1 / 12;
            d1 %= 7;
            switch (d1) {
                case 0:
                    this.tf.setText("Sunday  <---  DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 1:
                    this.tf.setText("Monday  <---  DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 2:
                    this.tf.setText("Tuesday  <--- DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 3:
                    this.tf.setText("Wednesday  <--- DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 4:
                    this.tf.setText("Thursday  <--- DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 5:
                    this.tf.setText("Friday   <--- DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
                case 6:
                    this.tf.setText("Saturday   <--- DATE:- " + day1 + ":" + month1 + ":" + year1 + "  \n");
                    return;
            }
            this.tf.setText("something is wrong plz try again..ex:-   .\r\n  d-19 m-1 y-1990  ");
        } else {
            this.tf.setText(invalid);
            this.getde.setBackground(Color.pink);
        }
    }

    private void tfMouseMoved(MouseEvent evt) {}

    private void tfMouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger())
            this.menu_tf.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    private void paste_tfActionPerformed(ActionEvent evt) {
        this.tf.paste();
    }

    private void copy_tfActionPerformed(ActionEvent evt) {
        this.tf.copy();
    }

    private void tf2MouseReleased(MouseEvent evt) {
        if (evt.isPopupTrigger())
            this.menu_tf2.show(evt.getComponent(), evt.getX(), evt.getY());
    }

    private void paste_tf2ActionPerformed(ActionEvent evt) {
        this.tf2.paste();
    }

    private void cut_tf2ActionPerformed(ActionEvent evt) {
        this.tf2.cut();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new NewJFrame()).setVisible(true);
            }
        });
    }
}

