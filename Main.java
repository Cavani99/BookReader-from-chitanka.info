import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main extends JFrame {

    private JPanel Panel;
    private JButton chooseBookButton;
    private JButton loadChaptersButton;
    private JButton pickChapterButton;
    private JTextArea textArea;

    private JMenuBar menuBar;
    private JMenu changeColor;
    private JMenuItem BackgroundColorItem;
    private JMenuItem TextColorItem;
    private JMenu NewMenu;
    private JMenuItem newBook;
    private JMenu FileOperation;
    private JMenuItem LoadChapters;
    private JMenuItem PickChapter;
    private JMenuItem Exit;
    private JMenuItem ShowFullBook;
    private JMenuItem LineWidthItem;
    private File read;
    private LinkedHashMap<Integer,String> chapters;
    private LinkedHashMap<Integer,Integer>chapterStart;
    private int lineWidth=30;
    private int chapterNumber;

    Main(){
        setContentPane(Panel);
        setTitle("BookReader");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        chooseBookButton.addActionListener(this::chooseBook);
        loadChaptersButton.addActionListener(this::LoadChapters);
        pickChapterButton.addActionListener(this::pickChapterAction);


        BackgroundColorItem.addActionListener(this::setBackgroundColor);
        TextColorItem.addActionListener(this::setTextColor);
        newBook.addActionListener(this::chooseBook);
        LoadChapters.addActionListener(this::LoadChapters);
        PickChapter.addActionListener(this::pickChapterAction);
        Exit.addActionListener(this::exitProgram);
        ShowFullBook.addActionListener(this::printFullBook);
        LineWidthItem.addActionListener(this::changeLineWidth);
    }

    public void chooseBook(ActionEvent e) {
        chapterNumber= -100;
        JFileChooser fileChooser=new JFileChooser();

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Text File(.txt)","txt");
        fileChooser.addChoosableFileFilter(filter);
        int selection = fileChooser.showOpenDialog(getParent());

        if (selection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try{
                read=new File(selectedFile.toURI());
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
                            read=null;
                            break;
                        }else{
                            textArea.append("Author:"+value);
                            authorOrName=true;
                        }
                    }else{
                        if(value.trim().isEmpty()){
                            textArea.setText("Not a text file from chitanka.info");
                            read=null;
                        }else {
                            textArea.append("\nBook Name:" + value);
                        }
                        break;
                    }
                }

            }catch (FileNotFoundException f){
                JOptionPane.showMessageDialog(null,  f.toString() );
            }
        }
    }

    public void LoadChapters(ActionEvent e) {


        if(read!=null) {
            try {
                Scanner reader = new Scanner(read);

                String chapterName="";
                String currentLine;
                int chapterStartPage=0;
                int index=2;
                int numberOfChapter=1;
                boolean firstChapter=true;
                chapters=new LinkedHashMap<>();
                chapterStart=new LinkedHashMap<>();
                for (int i = 0; i < 2; i++) {
                    reader.nextLine();
                    reader.nextLine();
                }
                while (reader.hasNextLine()){
                    boolean EvenAmountOfEmptySpaces=false;
                    currentLine=reader.nextLine().replaceAll("\\t","");
                    index++;

                    if(currentLine.isEmpty() && reader.hasNextLine()){
                        currentLine=reader.nextLine().replaceAll("\\t","");
                        index++;
                        while (currentLine.isEmpty() && reader.hasNextLine()){
                            currentLine=reader.nextLine().replaceAll("\\t","");
                            index++;

                            EvenAmountOfEmptySpaces= !EvenAmountOfEmptySpaces;
                        }

                        //empty spaces are even amount
                        if(EvenAmountOfEmptySpaces && chapterStartPage!=0){
                            if(index-chapterStartPage>=20 && Character.isUpperCase(chapterName.charAt(0))
                                    && Character.isUpperCase(currentLine.charAt(0)) || Character.isDigit(currentLine.charAt(0))) {

                                if(currentLine.length()<=23) {

                                    if (firstChapter) {
                                        chapters.put(0, "Start of the Book");
                                        chapterStart.put(0, 2);
                                        firstChapter = false;
                                    }

                                    chapters.put(numberOfChapter, chapterName);
                                    chapterStart.put(numberOfChapter, chapterStartPage);
                                    numberOfChapter++;

                                    chapterStartPage = index;
                                    chapterName = currentLine;
                                }else {
                                    index++;
                                    if(reader.nextLine().replaceAll("\\t", "").isEmpty() && currentLine.split(" ").length<=5){
                                        if (firstChapter) {
                                            chapters.put(0, "Start of the Book");
                                            chapterStart.put(0, 2);
                                            firstChapter = false;
                                        }
                                        chapters.put(numberOfChapter, chapterName);
                                        chapterStart.put(numberOfChapter, chapterStartPage);
                                        numberOfChapter++;

                                        chapterStartPage = index;
                                        chapterName = currentLine;
                                    }
                                }
                            }
                        }else if(EvenAmountOfEmptySpaces && (Character.isUpperCase(currentLine.charAt(0)) || Character.isDigit(currentLine.charAt(0)))&& currentLine.length()<=23){

                            chapterStartPage = index;
                            chapterName = currentLine;
                        }else if(!EvenAmountOfEmptySpaces && currentLine.length()<=5 && Character.isDigit(currentLine.charAt(0))){
                            chapters.put(numberOfChapter, chapterName);
                            chapterStart.put(numberOfChapter, chapterStartPage);
                            numberOfChapter++;

                            chapterStartPage = index;
                            chapterName = currentLine;
                        }

                    }
                }

                chapters.put(numberOfChapter, chapterName);
                chapterStart.put(numberOfChapter, chapterStartPage);


                textArea.setText("");
                for (Map.Entry<Integer,String>entry:chapters.entrySet()) {
                    textArea.append(entry.getKey()+": "+entry.getValue()+"\n");
                }

                textArea.setCaretPosition(0);
                reader.close();

            } catch (FileNotFoundException f) {
                JOptionPane.showMessageDialog(null,  f.toString() );
            }
        }else textArea.setText("No text file opened!");

    }

    public void pickChapterAction(ActionEvent e) {

        if(read!=null) {
            try {
                int chapter = Integer.parseInt(JOptionPane.showInputDialog("Write the number of the chapter you want to read!"));
                Scanner reader = new Scanner(read);
                if(chapters.containsKey(chapter)){
                    textArea.setText("\n");
                    chapterNumber=chapter;
                    getToChapter(reader,chapterStart.get(chapter));

                    int startIndex=chapterStart.get(chapter);

                    if(chapterStart.containsKey(chapter+1)){
                        int endIndex=chapterStart.get(chapter+1);
                        while(reader.hasNextLine() && startIndex!=endIndex){
                            String next=reader.nextLine().replaceAll("\\t","");
                            if(next.length()>60){
                                splitLine(next,lineWidth);
                            }else {
                                textArea.append(next + "\n");
                            }
                            startIndex++;
                        }
                    }else{
                        while(reader.hasNextLine()){
                            String next=reader.nextLine().replaceAll("\\t","");
                            if(next.length()>60){
                                splitLine(next,lineWidth);
                            }else {
                                textArea.append(next+"\n");
                            }
                        }
                    }

                    textArea.setCaretPosition(0);
                    reader.close();
                }else JOptionPane.showMessageDialog(null,"This chapter does not exist");


            }catch (NumberFormatException | FileNotFoundException | NullPointerException n){
                JOptionPane.showMessageDialog(null,  n.toString() );

            }

        }else textArea.setText("No text file opened!");
    }

    public void getToChapter(Scanner reader,int index) {
        int currentPos=0;

        while (currentPos!=index){
            reader.nextLine();
            currentPos++;
        }

    }

    public void splitLine(String text,int lineWidth){
        String [] wordsArray=text.split(" ");
        int curr=0;
        int total=0;
        while(true){
            total+=lineWidth;

            if(total>=wordsArray.length){
                for (int i = curr; i < wordsArray.length; i++) {
                    textArea.append(wordsArray[i]+" ");
                }
                textArea.append("\n");
                break;
            }else{
                for (int i = curr; i < total; i++) {
                    textArea.append(wordsArray[i]+" ");
                }
                textArea.append("\n");
            }

            curr+=lineWidth;
        }
    }

    public void setBackgroundColor(ActionEvent e) {

        Color color=JColorChooser.showDialog(null, "Choose a color",textArea.getBackground());
        textArea.setBackground(Objects.requireNonNullElseGet(color, () -> new Color(5,13,12)));

    }

    public void setTextColor(ActionEvent e) {

        Color color=JColorChooser.showDialog(null, "Choose a color",textArea.getForeground());
        textArea.setForeground(Objects.requireNonNullElseGet(color, () -> new Color(235,235,235)));

    }

    public void exitProgram(ActionEvent e) {

    int confirm = JOptionPane.showConfirmDialog(null, "Exit?");

    if(confirm==0)
       System.exit(0);

    }

    public void printFullBook(ActionEvent e) {

        if(read!=null) {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to do this? It will be SLOW!");

                if (confirm == 0){
                    chapterNumber=99018;
                    try {
                        textArea.setText("\n");
                        Scanner reader = new Scanner(read);
                        while (reader.hasNextLine()) {
                            String next = reader.nextLine().replaceAll("\\t", "");
                            if (next.length() > 60) {
                                splitLine(next,lineWidth);
                            } else {
                                textArea.append(next + "\n");
                            }
                        }

                        textArea.setCaretPosition(0);
                        reader.close();

                    } catch (FileNotFoundException | NullPointerException n) {
                        JOptionPane.showMessageDialog(null,  n.toString() );
                    }

            }

        }else textArea.setText("No text file opened!");

    }

    public void changeLineWidth(ActionEvent e){

        lineWidth=Integer.parseInt(JOptionPane.showInputDialog("Write the maximum amount of words(width) in a line!"));


        if(read!=null && lineWidth>0) {
            try {
                textArea.setText("\n");
                Scanner reader = new Scanner(read);
                if(chapters!=null && chapters.containsKey(chapterNumber)){
                    getToChapter(reader,chapterStart.get(chapterNumber));

                    int startIndex=chapterStart.get(chapterNumber);

                    if(chapterStart.containsKey(chapterNumber+1)){
                        int endIndex=chapterStart.get(chapterNumber+1);
                        while(reader.hasNextLine() && startIndex!=endIndex){
                            String next=reader.nextLine().replaceAll("\\t","");
                            if(next.length()>60){
                                splitLine(next,lineWidth);
                            }else {
                                textArea.append(next + "\n");
                            }
                            startIndex++;
                        }
                    }else{
                        while(reader.hasNextLine()){
                            String next=reader.nextLine().replaceAll("\\t","");
                            if(next.length()>60){
                                splitLine(next,lineWidth);
                            }else {
                                textArea.append(next+"\n");
                            }
                        }
                    }

                    textArea.setCaretPosition(0);
                    reader.close();
                }else if(chapterNumber==99018){
                    textArea.setText("\n");
                    while (reader.hasNextLine()) {
                        String next = reader.nextLine().replaceAll("\\t", "");
                        if (next.length() > 60) {
                            splitLine(next,lineWidth);
                        } else {
                            textArea.append(next + "\n");
                        }
                    }

                    textArea.setCaretPosition(0);
                    reader.close();

                }


            }catch (NumberFormatException | FileNotFoundException | NullPointerException n){
                JOptionPane.showMessageDialog(null,  n.toString() );
            }
        }

    }


    public static void main(String[] args) {
        new Main();
    }

}
