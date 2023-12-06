import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;


public class Main extends JFrame {

    private JPanel Panel;
    private JButton chooseBookButton;
    private JButton loadChaptersButton;
    private JButton pickChapterButton;
    private JTextArea textArea;

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

       fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
       fileChooser.setAcceptAllFileFilterUsed(false);
       FileNameExtensionFilter filter=new FileNameExtensionFilter("Text File","txt");
       fileChooser.addChoosableFileFilter(filter);
       int selection = fileChooser.showOpenDialog(getParent());

        if (selection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            textArea.setText("Selected file: " + selectedFile.getAbsolutePath());
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
