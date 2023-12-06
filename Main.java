import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main extends JFrame {

    private JPanel Panel;
    private JButton chooseBookButton;
    private JButton loadChaptersButton;
    private JButton pickChapterButton;
    private JTextArea textArea;
    private File read;

    Main(){
        setContentPane(Panel);
        setTitle("BookReader");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        chooseBookButton.addActionListener(this::chooseBook);
        loadChaptersButton.addActionListener(this::LoadChapters);
        pickChapterButton.addActionListener(this::pickChapterAction);
    }

    public void chooseBook(ActionEvent e) {
       JFileChooser fileChooser=new JFileChooser();

       fileChooser.setCurrentDirectory(new File("D:\\C++\\"));
       fileChooser.setAcceptAllFileFilterUsed(false);
       FileNameExtensionFilter filter=new FileNameExtensionFilter("Text File(.txt)","txt");
       fileChooser.addChoosableFileFilter(filter);
       int selection = fileChooser.showOpenDialog(getParent());

        if (selection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try{
            read=new File(selectedFile.getName());
            Scanner Reader=new Scanner(selectedFile);

            textArea.setText("FILE LOADED!!!\n");
            //to determine if we get the author or book name!
            boolean authorOrName=false;
            String value;
            while (Reader.hasNextLine()){
                value=Reader.nextLine().replaceAll("\\t","");
                if (!authorOrName){
                    if(value.trim().isEmpty()){
                        textArea.setText("Not a text file from chitanka.info");
                        break;
                    }else{
                    textArea.append("Author:"+value);
                    authorOrName=true;
                    }
                }else{
                    if(value.trim().isEmpty()){
                        textArea.setText("Not a text file from chitanka.info");
                    }else {
                        textArea.append("\nBook Name:" + value);
                    }
                    break;
                }
            }

            }catch (FileNotFoundException f){
                f.printStackTrace();
            }
        }

    }

    public void LoadChapters(ActionEvent e) {


    }

    public void pickChapterAction(ActionEvent e) {

    }


    public static void main(String[] args) {
        JFrame frame=new Main();
    }

}
