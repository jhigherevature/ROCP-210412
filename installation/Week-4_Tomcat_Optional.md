# [Week 4 - Optional Download] - Install Apache Tomcat

**Please Note that this software is optional. We will briefly explore the use of Tomcat servers and Java Servlets in week 4, time permitting. You are NOT required to download this software to complete this program.**

In order to download Tomcat, please visit [Apache Tomcat's official website](http://tomcat.apache.org/).

Once you've navigated to the site, you should see the following screen:

![Tomcat Home](./images/tomcat-home.PNG)

Scroll down until you see the section labeled "Tomcat 8.5.56" as shown below. Click the "Download" link at the bottom of this section.

![Tomcat 8](./images/tomcat-8.PNG)

**Note**: At the time of this tutorial, the version of Tomcat 8 was 8.5.56. In the future, this will not be the case. That said, please choose any version of Tomcat 8 that is available. In other words, Tomcat 8.x.xx is a valid choice as well.

After you've clicked the "Download" link, you should be taken to yet another page. Scroll down until you see the following:

![Tomcat Distros](./images/tomcat-distros.PNG)

Click the "zip" option under the "Core" section. It should be the first option listed. You should see the following after you've clicked the link, after which you should opt to save the file.

![Save Tomcat](./images/save-tomcat.PNG)

Now go into your system's "Downloads" folder. You should see a folder that is labeled "apache-tomcat-8.x.xx".

![Tomcat Zip](./images/tomcat-zip.PNG)

Right click the folder. Once you do so, you should see a list of options. Choose the option that reads "Extract All...". You'll then be asked to select a destination for the extracted files. You may choose any location on your computer you wish to by hitting the "Browse" button, but for this tutorial, we will be choosing to place the extracted files in the "Program Files" folder.

**Note**: Please keep note of where you choose to place the extracted files as you'll need this information in the next step.

![Program Files](./images/program-files.PNG)

Once you've selected a destination, hit the "Extract" button at the bottom of the box.

After you've done so, wait for the files to be extracted. Then go the location where you specified the extracted files should be placed. In our case, we are navigating to the "Program Files" directory.

![Program Files Directory](./images/program-files-directory.PNG)

There you should see the files you just extracted in a folder called "apache-tomcat-8.x.xx". Go inside of this folder by double clicking it. Once inside, copy the path to it by clicking on the bar that shows your file path near the top of the box. It should be directly to the left of the search bar. In this example, the bar contains the text:

    Local Disk (C:) > Program Files > apache-tomcat-8.5.56

![Inside of Tomcat Folder](./images/inside-tomcat.PNG)

Once you've clicked on the bar, copy the address. In this example, the address is:

    C:\Program Files\apache-tomcat-8.5.56

**Note**: This next portion will only work if you are running Windows as the process for setting environment variables is different on different systems.

Now go into your search bar and type "Edit the System Environment Variables".

![Edit System Environment Variables](./images/JDK-SysEnv.jpg)

Then click on the "Environment Variables" button at the bottom of the box that appears.

![Edit Environment Variables](./images/JDK-SysProp.jpg)

A new box should pop up. At this point, you should click the "New" button at the  bottom of the box.

![New System Variable](./images/JDK-EnvVar.jpg)

Yet another box will then pop up. It will prompt you for a "Variable name" and "Variable value". Enter the following into these boxes:

![Catalina Home](./images/catalina_home.PNG)

The variable name MUST be exactly what is typed above. The variable value should equivalent to the path to your Tomcat folder you copied during the last step.

Once you've entered this information, hit "OK". You should then hit "OK" again on the remaining two boxes.

**Note**: If you do not hit OK on all three of the boxes, your environment variable will not be properly set!

In order to verify that your environment variable was properly set, please open your terminal (e.g. type "Command Prompt" into the Windows search bar) and type the following:

![Echo Catalina Home](./images/echo.PNG)

At this point, the value of the CATALINA_HOME environment variable should be displayed.