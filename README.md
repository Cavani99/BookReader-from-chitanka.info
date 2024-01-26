# BookReader-from-chitanka.info

A Graphical program that reads a text file from <a href="https://chitanka.info/" target="_blank" >chitanka.info</a> ,splits it into chapters and allows you to pick a chapter to read.

---

# Installation steps/How to run:

* Install a newer version of Java, so it can run the program.Here is a link,if needed: <a href="https://www.oracle.com/java/technologies/downloads/" target="_blank" >https://www.oracle.com/java/technologies/downloads/</a>
* Create a <a href="https://chitanka.info/" target="_blank" >chitanka.info</a> profile ,if you dont have any. Here is a quick register <a href="https://chitanka.info/register" target="_blank" >link</a>. The site is in Bulgarian thought, just to inform you.
* Download the book you want in **txt.zip** format.Like the button pointed to in the image below: 

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/72fed7b0-b6f6-4398-ab63-89ae09c8bfd7)

* Unzip the txt file wherever you want, from the zip that you have downloaded!
* Download the <a href="https://github.com/Cavani99/BookReader-from-chitanka.info/tree/main/out/artifacts/BookReader_from_chitanka_info_jar" target="_blank" >jar</a> file somewhere in your computer.
* Run the jar file using your installed Java and you should be ready to go. When you have to choose a book,pick the text file that you have just unzipped. Enjoy the simple app ,which I really like ,because of my love to the books 💝📚

**If you have some problems with the app, you can write to me at my email: kristiian.donchev@abv.bg**

--- 
# Program short explanation

## Choose Book operation

A File Chooser Dialog opens up to choose the file you want to read.You can only open files with .txt extension.

When a correct text file is opened(from chitanka.info ,althought it is possible to recognize other text files as valid also),it prints the 
author`s name and the name of the book:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/9cfe2be5-6574-4270-ad15-c48095bb0c6e)



## Load Chapters

If a text file is opened you can load the chapters of the book.The chapters are split by comparing the amount of empty lines and the length of the current line of the text file,and also depending of the first letter of the line.The chapter spliting is not perfect thought and will not always split the chapters as desired ,depending on the book.After a chapter is recognized it`s name and start position in the text is saved in a LinkedHashMap,and after the whole text file is read ,the contents of the LinkedHashMap are printed.


Chapters for Crime and Punishment:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/aee8deba-0622-4fa2-bb83-9b0c26c71fee)



## Pick Chapter

You can pick a chapter to read using an InputDialog.You need to write the number of the chapter ,depending of the position in the LinkedHashMap.
I also use the splitLine method to shorten the length of the line,for better readability.

Part from Chapter II:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/04cbe420-a3c2-44fc-9216-aa701495afd7)


## Edit Menu Bar Options

The actions to pick a book,load chapters and read a chapter are also made available at the Menu Bar.

You have the option to change the color of the background and the color of the text!This is made using the JColorChooser Dialog.

Background changed to **Yellow** and text to **Red**:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/91aa36b3-34f4-4cdb-83a1-123f0670b159)


You can also change the maximum width of every line(that is the maximum amount of words)for more enjoyable reading experience.
Chapter with line width of **10**:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/96b59fd2-b9ae-4c8f-995e-db7576100ed7)

There is also an option to **print the whole book**,if you want to do that.You get a confirmation dialog at first to confirm 
that you really want to do this(because it can be kinda slow).

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/7154b4e1-3774-4ecf-b501-1354fea8bfa0)

There is finally a JMenuItem for exiting the program,which also comes with confirm dialog:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/e1c58ce9-0b72-45e5-8580-710e244ddf88)

---


### PS:The books are only in Bulgarian ,because the site is made for Bulgarians :) :) :P



