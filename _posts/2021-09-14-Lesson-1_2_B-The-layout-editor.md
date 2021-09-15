---
layout: post
title: "Lesson 1_2_B The layout editor"
date: 2021-09-14
---

Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_2) to my code.

### Output:
<p float="left">
	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p4.png" width="500"/>
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p5.png" width="500"/>
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p6.png" width="500"/>
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p7.png" width="300" />
  	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p8.png" width="300" /> 
</p>
P1: Horizontal Layout:<br>
P2: Layout variant for tablets.<br>
P3: Horizontal layout variant for tablets.<br>
P4: LinearLayout.<br>
P5: RelativeLayout.<br>
 
The main purpose of this lesson is to learn how to use layout editor and other two different layout :

- Learn how to create variant of the layout that is different for a horizontal orientation, and to create variant of the layout that is different for a tablet
- There are three different layouts:
	- The `ConstraintLayout`.
	- The `LinearLayout`, this layout is a `ViewGroup` that arranges its collection of views in a horizontal or vertical row.
	- The `RelativeLayout`,  this layout is a `ViewGroup` in which each view is positioned and aligned relative to other views within the group.

### Homework:
- **Change an app**
	- Overview:
		<p float="left">
			<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW1.png" width="300"/>
			<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW2.png" width="500"/>
		</p>
	- Function
		- <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW3.png" width="300"/>
		- Click `count` button, then number in textView will increase. `Zero` button will change background  color because it is not Zero now. `Count` button will change background color because the number is odd.
		- <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW4.png" width="300"/>
		- Click `count` button, then number in textView will increase. `Count` button will change background color because the number is even.
		- <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW5.png" width="300"/>
		- Click `zero` button, then number in textView will become 0. `Count` button will change background color. `Zero` button also change background color.

- **Question 1**: Which two layout constraint attributes on the **Zero** `Button` position it vertically equal distance between the other two `Button` elements?
	-  `android:layout_marginBottom="8dp"`
	-  `android:layout_marginTop="8dp"`
- **Question 2**: Which layout constraint attribute on the **Zero** `Button` positions it horizontally in alignment with the other two `Button` elements?
	-  `app:layout_constraintLeft_toLeftOf="parent"`
- **Question 3**: What is the correct signature for a method used with the `android:onClick` XML attribute?
	-   `public void callMethod(View view)`
- **Question 4**: You see the statement in the **Logcat** pane if the Log level menu is set to which of the following?
	- Use the  `view`  parameter that is passed to the click handler with `setBackgroundColor()`
