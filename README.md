# Guru99DailyProject
This repository documents the process of an automation project, divided into days proposed by the web page guru 99.

Day 1: Project Kickoff

You are the Selenium automation engineer assigned to test the esteemed "Guru99 Bank" project.

Here is a link to the AUT - http://www.demo.guru99.com/V4/

The following test case needs to be automated
![1](https://github.com/angelastra/Guru99DailyProject/assets/31233049/74effcf8-6c93-43ac-b848-a07ffb7c31a8)


The client has requested you to use WebDriver (Firefox Driver) for the project. Go ahead and record the script in Webdriver


DAY 2: Enhancements in Script

There is a major flaw in the test case we created. There is no verification step.The script is no-good if it cannot produce Pass & Fail Status. Go ahead and modify the script

![2](https://github.com/angelastra/Guru99DailyProject/assets/31233049/2f04d8aa-0adb-4939-be71-3edfccba4731)

But WAIT!

There is another major flaw. The script is a rookie script & in not production ready.

Here is how you can make the script production ready

    1.-The code to setup and launch WebDriver (Firefox) should be improved to include Location   Firefox.exe    and a Firefox Profile must be created.
    2.-The amount of time the driver should wait when searching for a GUI element should be specified
    3.-The code to setup and launch Firefox should be created as a separate method.
    4.-All script initialization parameters like Location of Firefox , Base URL, User Name , Password etc should be stored in separate file say Util.java.  This helps in easy maintenance of script
