# BookReader-from-chitanka.info
A Graphical program that reads a text file from chitanka.info,splits it into chapters and allows you to pick a chapter to read.

## Choose Book operation

A File Chooser Dialog opens up to choose the file you want to read.You can only open files with .txt extension.

When a correct text file is opened(from chitanka.info ,althought it is possible to recognize other text files as valid also),it prints the 
author`s name and the name of the book:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/26768fe0-41d6-4568-9544-b8744f12807b)

## Load Chapters

If a text file is opened you can load the chapters of the book.The chapters are split by comparing the amount of empty lines and the length of the current line of the text file,and also depending of the first letter of the line.The chapter spliting is not perfect thought and will not always split the chapters as desired ,depending on the book.After a chapter is recognized it`s name and start position in the text is saved in a LinkedHashMap,and after the whole text file is read ,the contents of the LinkedHashMap are printed.


Chapters for Crime and Punishment:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/0b7cfe52-22f4-4830-9fc6-e641ad5a2a19)

## Pick Chapter

You can pick a chapter to read using an InputDialog.You need to write the number of the chapter ,depending of the position in the LinkedHashMap.
I also use the splitLine method to shorten the length of the line,for better readability.

Part from Chapter II:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/6f66530a-0a21-4788-b6ea-971ee4c75b4c)

### PS:The books are only in Bulgarian ,because the site is made for Bulgarians :) :) :P



