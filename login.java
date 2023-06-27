import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class Ticket
{
    String NAME,AGE,GENDER,Station1,Station2,TRAIN_NO,TRAIN_NAME,DAY,MONTH,YEAR,CLASSTYPE;
    int PNR;
    Ticket(){}
    void displayTerminal()
    {
        System.out.println("Name : "+NAME);
        System.out.println("Age : "+AGE);
        System.out.println("Gender : "+GENDER);
        System.out.println("From : "+Station1);
        System.out.println("To : "+Station2);
        System.out.println("Date : "+DAY+"/"+MONTH+"/"+YEAR);
        System.out.println("Train no : "+TRAIN_NO);
        System.out.println("Train name : "+TRAIN_NAME);
        System.out.println("Class type : "+CLASSTYPE);
        System.out.println("PNR : "+PNR);
    }
}
class Cancelling extends login implements ActionListener
{
    static int i,j=0;
    public void actionPerformed (ActionEvent e)
    {
        i-=j;
        for(i=0;i<CancelButtons.size();i++)
        {
            if(e.getSource().equals(CancelButtons.get(i)))
            {
                break;
            }
        }
        i-=j;
        j+=i;
        Ticket t=Tickets.get(i);
        t.displayTerminal();
        ImageIcon icon=new ImageIcon("train.png");
        Border border=BorderFactory.createLineBorder(new Color(0,0,0,90));
        Font font =new Font("Arial", Font.PLAIN, 15);
        Font font1 =new Font("Arial",Font.CENTER_BASELINE,15);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        JFrame CancelForm =new JFrame();
        CancelForm.setTitle("Cancellation");
        CancelForm.setResizable(false);
        CancelForm.setSize(600, 700);
        CancelForm.setLocationRelativeTo(null);
        CancelForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cCancelForm=CancelForm.getContentPane();
        cCancelForm.setBackground(new Color(80, 185, 254, 69));
        CancelForm.setIconImage(icon.getImage());


        cCancelForm.setLayout(null);

        JLabel nameLabel = new JLabel("Name of passenger : ");
        nameLabel.setBounds(50,25,200,25);
        nameLabel.setFont(font1);

        JTextField name= new JTextField();
        name.setBounds(250,25,200,25);
        name.setFont(font);
        name.setText(t.NAME);
        name.setEditable(false);

        JLabel ageLabel =new JLabel("Age : ");
        ageLabel.setBounds(50,60,200,25);
        ageLabel.setFont(font1);

        JTextField age = new JTextField();
        age.setBounds(250,60,200,25);
        age.setFont(font);
        age.setText(t.AGE);
        age.setEditable(false);

        JLabel GenderLabel =new JLabel("Gender : ");
        GenderLabel.setBounds(50,95,200,25);
        GenderLabel.setFont(font1);

        JRadioButton male=new JRadioButton("Male");
        male.setBounds(250,95,100,25);

        JRadioButton female=new JRadioButton("Female");
        female.setBounds(350,95,100,25);

        if(t.GENDER.equals("Male"))
        {
            male.setSelected(true);

        }
        else
        {
            female.setSelected(true);

        }
        male.setEnabled(false);
        female.setEnabled(false);
        ButtonGroup Gender=new ButtonGroup();
        Gender.add(male);
        Gender.add(female);

        JLabel station1Label =new JLabel("From : ");
        station1Label.setBounds(50,25,200,25);
        station1Label.setFont(font1);


        JTextField station1=new JTextField();
        station1.setBounds(250,25,200,25);
        station1.setFont(font);
        station1.setText(t.Station1);
        station1.setEditable(false);

        JLabel station2Label =new JLabel("To : ");
        station2Label.setBounds(50,60,200,25);
        station2Label.setFont(font1);
        
        JTextField station2=new JTextField();
        station2.setBounds(250,60,200,25);
        station2.setFont(font);
        station2.setText(t.Station2);
        station2.setEditable(false);
        
        JLabel Train_noLabel=new JLabel("Train no : ");
        Train_noLabel.setBounds(50,95,200,25);
        Train_noLabel.setFont(font1);

        JTextField Train_no=new JTextField();
        Train_no.setBounds(250,95,200,25);
        Train_no.setFont(font);
        Train_no.setText(t.TRAIN_NO);
        Train_no.setEditable(false);
        
        JLabel Train_nameLabel=new JLabel("Train name : ");
        Train_nameLabel.setBounds(50, 130, 200, 25);   
        Train_nameLabel.setFont(font1);

        JTextField Train_name=new JTextField();
        Train_name.setBounds(250,130,200,25);
        Train_name.setFont(font);
        Train_name.setText(t.TRAIN_NAME);
        Train_name.setEditable(false);
        
        JLabel ClassTypeLabel=new JLabel("Class type : ");
        ClassTypeLabel.setBounds(50,170,300,25);
        ClassTypeLabel.setFont(font1);

        JTextField Class =new JTextField();
        Class.setBounds(250,170,200,25);
        Class.setFont(font);
        Class.setText(t.CLASSTYPE);
        Class.setEditable(false);

        JLabel dateLabel=new JLabel("Date of Journey : ");
        dateLabel.setBounds(50,200,300,25);
        dateLabel.setFont(font1);

        JTextField date =new JTextField();
        date.setBounds(250,200,200,25);
        date.setFont(font);
        date.setText(t.DAY+"/"+t.MONTH+"/"+t.YEAR);
        date.setEditable(false);

        JButton OK= new JButton("OK");
        OK.setBounds(230,500,100,25);
        OK.setCursor(cursor);
        OK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Tickets.remove(i);
                CancelButtons.remove(i);
                CancelForm.dispose();
                bookings.removeAll();
                v=0;
                for(int i=0;i<Tickets.size();i++)
                {
                    makePanel(Tickets.get(i),v);
                    v+=105;
                }
                mainFrame.setVisible(false);
                mainFrame.setVisible(true);

            }
        });

        JPanel basic=new JPanel();
        basic.setBounds(50,50,485,150);
        basic.setLayout(null);
        basic.setBackground(new Color(80, 185, 254, 69));
        basic.setBorder(border);  

        JPanel Train_details= new JPanel();
        Train_details.setBounds(50,210,485,260);
        Train_details.setLayout(null);
        Train_details.setBackground(new Color(80, 185, 254, 69));
        Train_details.setBorder(border);

        basic.add(nameLabel);
        basic.add(ageLabel);
        basic.add(GenderLabel);
        basic.add(name);
        basic.add(age);
        basic.add(male);
        basic.add(female);
        Train_details.add(station1Label);
        Train_details.add(station2Label);
        Train_details.add(dateLabel);
        Train_details.add(Train_noLabel);
        Train_details.add(Train_nameLabel);
        Train_details.add(ClassTypeLabel);
        Train_details.add(station1);
        Train_details.add(station2);
        Train_details.add(date);
        Train_details.add(Class);
        Train_details.add(Train_name);
        Train_details.add(Train_no);
        
        CancelForm.add(basic);
        CancelForm.add(Train_details);
        CancelForm.add(OK);
        CancelForm.setVisible(true);

    }
}
public class login
{
    static void makePanel(Ticket t,int v)
    {
        
        ImageIcon icon=new ImageIcon("train.png");
        Border border=BorderFactory.createLineBorder(new Color(0,0,0,90));
        Font font =new Font("Arial", Font.PLAIN, 15);
        Font font1 =new Font("Arial",Font.CENTER_BASELINE,15);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    
        JPanel branch = new JPanel();
        branch.setBounds(0,0+v,495,100);
        branch.setBorder(border);
        branch.setLayout(null);

        JLabel pnr=new JLabel("PNR : "+t.PNR);
        pnr.setBounds(10,0,200,50);
        pnr.setFont(new Font("sans-serif",Font.BOLD,25));
        branch.add(pnr);

        JLabel number=new JLabel("Train no : ("+t.TRAIN_NO+")");
        number.setBounds(350,12,200,25);
        number.setFont(font1);
        branch.add(number);

        JLabel From =new JLabel();
        From.setText(t.Station1);
        From.setBounds(75,65,100,25);
        From.setFont(font1);
        branch.add(From);

        JLabel arrow=new JLabel("--->");
        arrow.setBounds(175,65,100,25);
        branch.add(arrow);

        JLabel To=new JLabel();
        To.setText(t.Station2);
        To.setBounds(225,65,100,25);
        To.setFont(font1);
        branch.add(To);

        JButton cancel=new JButton("Cancel Ticket");
        cancel.setBounds(370,65,120,25);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.setCursor(cursor);
        cancel.addActionListener(new Cancelling());
        CancelButtons.add(cancel);
        
        branch.add(cancel);

        bookings.add(branch);
                
    }
    static String USER="",PASS="";
    static int v=0;
    static ArrayList<Ticket> Tickets;
    static ArrayList<JButton> CancelButtons;
    static Container bookings;
    static JFrame mainFrame;
    public static void main(String[] args) {
        //extras
        ImageIcon icon=new ImageIcon("hd.jpg");
        Border border=BorderFactory.createLineBorder(new Color(0,0,0,90));
        Font font =new Font("Arial", Font.PLAIN, 15);
        Font font1 =new Font("Arial",Font.CENTER_BASELINE,15);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

       
        //login 
        JFrame login = new JFrame();
        Container cLogin=login.getContentPane();
        JLabel userlabel,passlabel,incorretlabel;
        JTextField user;
        JPasswordField pass;
        JButton submitLogin;
        cLogin.setBackground(new Color(80, 185, 254, 69));
        // cLogin.setBackground(new Color(123,50,250,80));
        login.setTitle("Online Reservation System");
        login.setResizable(false);
        login.setSize(400, 400);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cLogin.setLayout(null);
        userlabel=new JLabel("Username : ");
        passlabel=new JLabel("Password : ");
        userlabel.setBounds(90, 50, 100, 50);
        passlabel.setBounds(90, 150, 100, 50);
        user=new JTextField();
        user.setBounds(90, 100, 200, 25);
        pass=new JPasswordField();
        user.setBorder(border);
        pass.setBorder(border);
        user.setFont(font);
        pass.setBounds(90, 200, 200,25);
        incorretlabel=new JLabel("Username or password is incorrect!!!");
        incorretlabel.setForeground(Color.red);
        submitLogin=new JButton("Submit");
        submitLogin.setBounds(140,250,100,25);
        submitLogin.setCursor(cursor);
        cLogin.add(userlabel);
        cLogin.add(passlabel);
        cLogin.add(user);
        cLogin.add(pass);
        cLogin.add(incorretlabel);
        cLogin.add(submitLogin);
        login.setIconImage(icon.getImage());
        // login.setVisible(true);


        //Home 

        mainFrame=new JFrame();
        Container cmain=mainFrame.getContentPane();
        cmain.setBackground(new Color(80, 185, 254, 69));
        mainFrame.setTitle("Home");
        mainFrame.setResizable(false);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(icon.getImage());
        cmain.setLayout(null);
        JPanel head=new JPanel();
        head.setLayout(null);
        head.setBounds(5, 5, 495, 50);
        head.setBackground(new Color(39, 123, 179,200));
        head.setBorder(border);
        cmain.add(head);
        
        JPanel sideBar=new JPanel();
        sideBar.setLayout(null);
        sideBar.setBounds(505, 5, 275, 550);
        sideBar.setBackground(new Color(230, 230, 230));
        // sideBar.setBackground(new Color(80, 185, 254, 69));
        sideBar.setBorder(border);
        ImageIcon img=new ImageIcon("profile.png");
        JLabel profile=new JLabel(img);
        profile.setBounds(25,1,img.getIconWidth(),img.getIconHeight());
        sideBar.add(profile);
        JButton newreg =new JButton("Book Ticket");
        newreg.setBounds(40,250,200,25);
        newreg.setCursor(cursor);
        sideBar.add(newreg);

        JButton logout =new JButton("Logout");
        logout.setBounds(90,300,100,25);
        logout.setBackground(new Color(255,0,0));
        logout.setForeground(Color.white);
        logout.setCursor(cursor);
        sideBar.add(logout);
        cmain.add(sideBar);

        JLabel heading = new JLabel("Upcoming Journeys");
        heading.setBounds(140, 5, 300, 40);;
        heading.setFont(new Font("Times new roman",Font.LAYOUT_LEFT_TO_RIGHT,25));
        heading.setForeground(new Color(255,255,255));
        head.add(heading);
        // cmain.setBackground(new Color(123,50,250));
        bookings=new Container();

        bookings.setBounds(5,60,495,495);
        bookings.setBackground(new Color(80, 185, 254, 69));
        cmain.add(bookings);

        // Reservation form

        JFrame register =new JFrame();
        register.setTitle("Reservation Form");
        register.setResizable(false);
        register.setSize(600, 700);
        register.setLocationRelativeTo(null);
        register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container cregister=register.getContentPane();
        cregister.setBackground(new Color(80, 185, 254, 69));
        register.setIconImage(icon.getImage());


        cregister.setLayout(null);

        JLabel nameLabel = new JLabel("Name of passenger : ");
        nameLabel.setBounds(50,25,200,25);
        nameLabel.setFont(font1);

        JTextField name= new JTextField();
        name.setBounds(250,25,200,25);
        name.setFont(font);

        JLabel ageLabel =new JLabel("Age : ");
        ageLabel.setBounds(50,60,200,25);
        ageLabel.setFont(font1);

        JTextField age = new JTextField();
        age.setBounds(250,60,200,25);
        age.setFont(font);

        JLabel GenderLabel =new JLabel("Gender : ");
        GenderLabel.setBounds(50,95,200,25);
        GenderLabel.setFont(font1);

        JRadioButton male=new JRadioButton("Male");
        male.setBounds(250,95,100,25);
        male.setSelected(true);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(350,95,100,25);

        ButtonGroup Gender=new ButtonGroup();
        Gender.add(male);
        Gender.add(female);
        JLabel station1Label =new JLabel("From : ");
        station1Label.setBounds(50,25,200,25);
        station1Label.setFont(font1);

        JTextField station1=new JTextField();
        station1.setBounds(250,25,200,25);
        station1.setFont(font);

        JLabel station2Label =new JLabel("To : ");
        station2Label.setBounds(50,60,200,25);
        station2Label.setFont(font1);
        
        JTextField station2=new JTextField();
        station2.setBounds(250,60,200,25);
        station2.setFont(font);
        
        JLabel Train_noLabel=new JLabel("Train no : ");
        Train_noLabel.setBounds(50,95,200,25);
        Train_noLabel.setFont(font1);

        JTextField Train_no=new JTextField();
        Train_no.setBounds(250,95,200,25);
        Train_no.setFont(font);
        
        JLabel Train_nameLabel=new JLabel("Train name : ");
        Train_nameLabel.setBounds(50, 130, 200, 25);   
        Train_nameLabel.setFont(font1);

        JTextField Train_name=new JTextField();
        Train_name.setBounds(250,130,200,25);
        Train_name.setFont(font);
        
        JLabel dateLabel=new JLabel("Date Of Journey : ");
        dateLabel.setBounds(50,175,200,25);
        dateLabel.setFont(font1);
        String[] days={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String[] months={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        String[] years={"2022","2023","2024"};
        JComboBox day=new JComboBox(days);
        day.setBounds(250,175,60,25);
        JComboBox mon=new JComboBox(months);
        mon.setBounds(310,175,65,25);
        JComboBox year=new JComboBox(years);
        year.setBounds(375,175,65,25);

        JLabel ClassTypeLabel =new JLabel("Class Type : ");
        ClassTypeLabel.setBounds(50,210,200,25);
        ClassTypeLabel.setFont(font1);
        String[] Class={"Second Sitting (2S)","Sleeper (SL)","AC 3 tier (3A)","AC 2 tier (2A)","AC First Class (1A)"};
        JComboBox ClassType=new JComboBox(Class);
        ClassType.setBounds(250,210,200,25);
        
        JLabel interrupt=new JLabel("*Please fill all Details");
        interrupt.setForeground(Color.red);
        interrupt.setBounds(211,500,300,25);
        interrupt.setFont(font1);
        interrupt.setVisible(false);

        JButton insert = new JButton("Insert");
        insert.setBounds(190,550,200,25);
        insert.setCursor(cursor);

        JPanel basic=new JPanel();
        basic.setBounds(50,50,485,150);
        basic.setLayout(null);
        basic.setBackground(new Color(80, 185, 254, 69));
        basic.setBorder(border);  

        JPanel Train_details= new JPanel();
        Train_details.setBounds(50,210,485,260);
        Train_details.setLayout(null);
        Train_details.setBackground(new Color(80, 185, 254, 69));
        Train_details.setBorder(border);

        basic.add(nameLabel);
        basic.add(ageLabel);
        basic.add(GenderLabel);
        basic.add(name);
        basic.add(age);
        basic.add(male);
        basic.add(female);
        Train_details.add(station1Label);
        Train_details.add(station2Label);
        Train_details.add(dateLabel);
        Train_details.add(Train_noLabel);
        Train_details.add(Train_nameLabel); 
        Train_details.add(ClassTypeLabel);
        Train_details.add(station1);
        Train_details.add(station2);
        Train_details.add(day);
        Train_details.add(mon);
        Train_details.add(year);
        Train_details.add(ClassType);
        Train_details.add(Train_name);
        Train_details.add(Train_no);
        
        register.add(basic);
        register.add(Train_details);
        register.add(interrupt);
        register.add(insert);
        // register.setVisible(true);
    
        bookings.setLayout(null);
        // bookings.setLayout(null);
        
        //Banner
        JFrame banner = new JFrame("Online Reservation form");
        banner.setIconImage(icon.getImage());
        banner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon originalIcon = new ImageIcon("hd.jpg");
        Image originalImage = originalIcon.getImage();
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();
        int newWidth = originalWidth / 6;    
        int newHeight = originalHeight / 6;  
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);

        banner.getContentPane().add(imageLabel);
        banner.pack();
        banner.setResizable(false);
        banner.setLocationRelativeTo(null);

        banner.setVisible(true);
        banner.addMouseListener(new MouseListener() {
                @Override
    public void mouseClicked(MouseEvent e) {
        banner.setVisible(false);
        login.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
       }

    @Override
    public void mouseReleased(MouseEvent e) {
         }

    @Override
    public void mouseEntered(MouseEvent e) {
         }

    @Override
    public void mouseExited(MouseEvent e) {
       }
        });
        Tickets=new ArrayList<Ticket>();
        CancelButtons=new ArrayList<JButton>();
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Ticket t=new Ticket();
                // branch.setBackground(Color.red);
                t.NAME=name.getText();
                t.AGE=age.getText();
                t.GENDER="Male";
                if(female.isSelected())
                {
                    t.GENDER="Female";
                }
                t.Station1=station1.getText();
                t.Station2=station2.getText();
                t.TRAIN_NO=Train_no.getText();
                t.TRAIN_NAME=Train_name.getText();
                t.DAY=day.getSelectedItem().toString();
                t.MONTH=mon.getSelectedItem().toString();
                t.YEAR=year.getSelectedItem().toString();
                t.CLASSTYPE=ClassType.getSelectedItem().toString();
                t.PNR=(int)Math.floor(Math.random() *(999999999 - 100000000 + 1) + 100000000);
                if(t.NAME.equals("")||t.AGE.equals("")||t.Station1.equals("")||t.Station2.equals("")||t.TRAIN_NAME.equals("")||t.TRAIN_NO.equals(""))
                {
                    interrupt.setVisible(true);
                    register.setVisible(false);
                    register.setVisible(true);
                }
                else
                {
                    interrupt.setVisible(false);
                    Tickets.add(t);
                    name.setText("");
                    age.setText("");
                    male.setSelected(true);
                    station1.setText("");
                    station2.setText("");
                    Train_no.setText("");
                    Train_name.setText("");
                    day.setSelectedIndex(0);
                    mon.setSelectedIndex(0);
                    year.setSelectedIndex(0);
                    ClassType.setSelectedIndex(0);
                    makePanel(t,v);
                    v+=105;
                    register.dispose();
                    mainFrame.setVisible(true);
                }
            }
        });
        newreg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.setVisible(false);
                register.setVisible(true);
            }
        });
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.setVisible(false);
                login.setVisible(true);
            }
        });
        
        submitLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                USER=user.getText();
                PASS=pass.getText();
                user.setText("");
                pass.setText("");
                System.out.println(USER +"\n"+PASS);
                if(USER.equals("Aniket") && PASS.equals("password"))
                {
                    System.out.println("LOGIN SUCCESSFULL");
                    mainFrame.setVisible(true);
                    login.dispose();
                    incorretlabel.setVisible(false);
                }
                else
                {
                    System.out.println("LOGIN UNSUCCESSFULL");
                    incorretlabel.setBounds(90, 250, 300,25);

                    submitLogin.setBounds(140, 300, 100, 25);
                    login.setSize(400,405);
                }
            }
        });
    }
}
