---
layout: post
title: "Lesson 2_2 Activity lifecycle and state"
date: 2021-09-20
---

Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson2_1) to my code. I finish this lesson base on the code from lesson 2_1, so the code of lesson 2_1 was been overwritten.

### Output:
<p float="left">
    <img src="https://raw.githubusercontent.com/BingfanTian96/NEU_CS5520_21Fall/gh-pages/res/2_2_1.png" width="600" />
</p>

The main purpose of this lesson is to learn the activity lifecycle.

- Each state in the  `Activity`  lifecycle has a corresponding callback method.
- The lifecycle methods are  `onCreate()`,  `onStart()`,  `onPause()`,  `onRestart()`,  `onResume()`,  `onStop()`,  `onDestroy()`.
- Device configuration changes such as rotation results in the  `Activity`  being destroyed and recreated as if it were new.
-   Save  `Activity`  instance state in the  `onSaveInstanceState()`  method.
-   Instance state data is stored as simple key/value pairs in a  `Bundle`. Use the  `Bundle`  methods to put data into and get data back out of the  `Bundle`.
-   Restore the instance state in  `onCreate()`, which is the preferred way, or  `onRestoreInstanceState()`.

### Homework: 
- **Build and run an app**
Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson2_2_HW) to my code.
	- Overview:
<p float="left">
	<img src="https://raw.githubusercontent.com/BingfanTian96/NEU_CS5520_21Fall/gh-pages/res/2_2_HW_1.png" width="300"/>
	<img src="https://raw.githubusercontent.com/BingfanTian96/NEU_CS5520_21Fall/gh-pages/res/2_2_HW_2.png" width="300"/>
	<img src="https://raw.githubusercontent.com/BingfanTian96/NEU_CS5520_21Fall/gh-pages/res/2_2_HW_3.png" width="500"/>
</p>

- **Question 1**: If you run the homework app before implementing `onSaveInstanceState()`, what happens if you rotate the device? Choose one:
	- The counter is reset to 0, but the contents of the  `EditText`  is preserved.
- **Question 2**: What `Activity` lifecycle methods are called when a device-configuration change (such as rotation) occurs? Choose one:
	-   Android shuts down your  `Activity`  by calling  `onPause()`,  `onStop()`, and  `onDestroy()`, and then starts it over again, calling  `onCreate()`,  `onStart()`, and  `onResume()`.
- **Question 3**: When in the `Activity` lifecycle is `onSaveInstanceState()` called? Choose one:
	-   `onSaveInstanceState()`  is called before the  `onStop()`  method.
- **Question 4**: Which `Activity` lifecycle methods are best to use for saving data before the `Activity` is finished or destroyed? Choose one:
	-   `onPause()`  or  `onStop()`
