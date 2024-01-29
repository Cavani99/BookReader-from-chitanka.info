# BookReader-from-chitanka.info

A Graphical program that reads a text file from <a href="https://chitanka.info/" target="_blank" >chitanka.info</a> ,splits it into chapters and allows you to pick a chapter to read.

---
# Table of Contents

* [Installation steps/How to run](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#installation-stepshow-to-run)
* [Choose Book operation](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#choose-book-operation)
* [Load Chapters operation ](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#load-chapters-operation)
* [Pick Chapter operation](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#pick-chapter-operation)
* [Next Chapter and Previous Chapter buttons](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#next-chapter-and-previous-chapter-buttons)
* [Edit Menu Bar Options](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#edit-menu-bar-options)
    - [New Menu](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#new-menu)
    - [Edit Menu](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#edit-menu)
    - [File Menu](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#file-menu)
    - [Exit Menu](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#exit-menu)
* [Postscript](https://github.com/Cavani99/BookReader-from-chitanka.info?tab=readme-ov-file#psthe-books-are-only-in-bulgarian-because-the-site-is-made-for-bulgarians---p)
     
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

## [Choose Book](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L68) operation

A File Chooser Dialog opens up to choose the file you want to read.You can only open files with .txt extension.

When a correct text file is opened(from chitanka.info ,althought it is possible to recognize other text files as valid also),it prints the 
author`s name and the name of the book:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/5e7cdd28-96c4-4c82-90b2-106f9ac3fde1)




## [Load Chapters](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L124) operation

If a text file is opened you can load the chapters of the book.The chapters are split by comparing the amount of empty lines and the length of the current line of the text file,and also depending of the first letter of the line.The chapter spliting is not perfect thought and will not always split the chapters as desired ,depending on the book.After a chapter is recognized it`s name and start position in the text is saved in a LinkedHashMap,and after the whole text file is read ,the contents of the LinkedHashMap are printed.


Chapters for Crime and Punishment:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/55be3841-b2a2-42a6-a790-8f83fa02003a)





## [Pick Chapter](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L232) operation 

You can pick a chapter to read using an InputDialog.You need to write the number of the chapter ,depending of the position in the LinkedHashMap.I use the [getChapter](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L424) method to see if this chapter exists in the LinkedHashMap ,and when it does, we print its information.
I also use the [splitLine](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L269) method to shorten the length of the line,for better readability.

Part from Chapter II:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/30dfa640-86a8-4a2b-8b1b-c9eda96dd120)

## [Next Chapter](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L241) and [Previous Chapter](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L250) buttons

Simply used to get the Next or the Previous Chapter ,compared to the current chapter loaded for reading.This is what we get,if we try to get the previous chapter of the first one: 

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/9695aed1-0646-4c9d-b1db-9e4f4e3e0509)




## Edit Menu Bar Options

### New Menu

Currently it contains only the option to open a new book.It uses the same operation as the "Choose Book" button.

### Edit Menu

You have the option to change the color of the [background](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L293) and the color of the [text](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L300)!This is made using the JColorChooser Dialog.

Background changed to **Yellow** and text to **Red**:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/56c08ec9-8ca9-4355-a2e3-ed2afc027aaf)


You can also change the [maximum width](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L352) of every line(that is the maximum amount of words)for more enjoyable reading experience, using the "Change Line Width" Item.

Chapter with line width of **10**:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/c0f4d6f3-919a-4826-9009-c4c6ad840f18)

### File Menu

You get the options to Load the Chapters,Pick the Chapter and get the Previous or Next Chapter(the same operations from the buttons) in this menu aswell.
There is also an option to **[print the whole book](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L316)**,if you want to do that.You get a confirmation dialog at first to confirm that you really want to do this(because it can be kinda slow).

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/2a297cff-f21d-44f6-b83e-48f9dd3af68c)

### Exit Menu 

Used to [exit](https://github.com/Cavani99/BookReader-from-chitanka.info/blob/main/Main.java#L307) the program.It comes with a confirm dialog:

![image](https://github.com/Cavani99/BookReader-from-chitanka.info/assets/75423586/e1c58ce9-0b72-45e5-8580-710e244ddf88)

---


### PS:The books are only in Bulgarian ,because the site is made for Bulgarians :) :) :P



