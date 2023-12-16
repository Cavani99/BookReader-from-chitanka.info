# BookReader-from-chitanka.info
A Graphical program that reads a text file from chitanka.info,splits it into chapters and allows you to pick a chapter to read.

## Choose Book operation

A File Chooser Dialog opens up to choose the file you want to read.You can only open files with .txt extension.

When a correct text file is opened(from chitanka.info ,althought it is possible to recognize other text files as valid also),it prints the 
author`s name and the name of the book:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/25727692-6a65-403d-9208-de7b1577e949)


## Load Chapters

If a text file is opened you can load the chapters of the book.The chapters are split by comparing the amount of empty lines and the length of the current line of the text file,and also depending of the first letter of the line.The chapter spliting is not perfect thought and will not always split the chapters as desired ,depending on the book.After a chapter is recognized it`s name and start position in the text is saved in a LinkedHashMap,and after the whole text file is read ,the contents of the LinkedHashMap are printed.


Chapters for Crime and Punishment:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/14264815-4476-4921-b555-021f6375ca76)


## Pick Chapter

You can pick a chapter to read using an InputDialog.You need to write the number of the chapter ,depending of the position in the LinkedHashMap.
I also use the splitLine method to shorten the length of the line,for better readability.

Part from Chapter II:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/48ea122b-b4e0-4ae0-aa64-cedd2569b036)

## Edit Menu Bar Options

You have the option to change the color of the background and the color of the text!This is made using the JColorChooser Dialog.

Background changed to **Yellow** and text to **Red**:
![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/187d2278-71d2-49e0-b171-91d5ca50dde9)



### PS:The books are only in Bulgarian ,because the site is made for Bulgarians :) :) :P



