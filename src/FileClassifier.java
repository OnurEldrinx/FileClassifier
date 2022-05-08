import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileClassifier {

    private JButton chooseFileButton;
    private JList<String> list1,list2;
    private Label list1Label,list2Label;
    private DefaultListModel<String> listModel1,listModel2;

    public FileClassifier(){

        JFrame frame = new JFrame("Question 1");

        chooseFileButton = new JButton("Choose File");

        listModel1 = new DefaultListModel<>();
        listModel2 = new DefaultListModel<>();

        list1 = new JList<>(listModel1);
        list2 = new JList<>(listModel2);

        list1Label = new Label("Files that contain a number in the filename");
        list2Label = new Label("Files that are document (txt,pdf,doc,docx)");


        chooseFileButton.setBounds(250,50,200,50);
        chooseFileButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        chooseFileButton.setFocusPainted(false);

        list1.setBounds(25,200,300,200);
        list2.setBounds(365,200,300,200);

        list1Label.setBounds(25,175,300,25);
        list1Label.setFont(new Font("Times New Roman", Font.BOLD, 13));
        list2Label.setBounds(365,175,300,25);
        list2Label.setFont(new Font("Times New Roman", Font.BOLD, 13));

        chooseFileButton.addActionListener(e->chooseFileButtonAction(frame));

        frame.add(chooseFileButton);
        frame.add(list1);
        frame.add(list2);
        frame.add(list1Label);
        frame.add(list2Label);


        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    public void chooseFileButtonAction(Frame frame){

        String[] numbers = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        String[] extensions = new String[]{"txt","pdf","doc","docx"};

        boolean numberTest = false;
        boolean extensionTest = false;

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select a file to test");


            int returnValue = fc.showOpenDialog(frame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fc.getSelectedFile();


                for (int i=0;i<numbers.length;i++){

                    if(selectedFile.getName().contains(numbers[i])){

                        numberTest = true;
                        break;

                    }

                }

                for (int i=0;i<extensions.length;i++){

                    if(selectedFile.getPath().contains(extensions[i])){

                        extensionTest = true;
                        break;

                    }

                }

                if(numberTest && extensionTest){

                    listModel1.addElement(selectedFile.getName());
                    listModel2.addElement(selectedFile.getName());

                }else if (numberTest){

                    listModel1.addElement(selectedFile.getName());

                }else if (extensionTest){

                    listModel2.addElement(selectedFile.getName());

                }

                //textArea.setText(Files.readString(selectedFile.toPath()));
            }




    }


}
