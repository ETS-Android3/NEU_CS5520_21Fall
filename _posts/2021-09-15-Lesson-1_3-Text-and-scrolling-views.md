---
layout: post
title: "Lesson 1_3 Text and scrolling views"
date: 2021-09-15
---

Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_3) to my code.

### Output:
<p float="left">
    <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_3_p1.png" width="300" />
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_3_p2.png" width="300" /> 

</p>
P1: Top of scrolling views  
P2: Bottom of scrolling views 

The main purpose of this lesson is to learn how to use `ScrollView` to show its child `View` or `ViewGroup`:

- A `ScrollView` can hold only one child `View` or `ViewGroup`.
- We can se a `ViewGroup` such as `LinearLayout` as a child element.
- We can use HTML formatting tags to format the text in a `TextView`.
- Use the  `android:autoLink="web"`  attribute to make web links in the text clickable.

### Homework:
- **Change an app**
	- Overview:
	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_3_p3.png" width="300"/>

- **Question 1**: How many views can you use within a `ScrollView`? Choose one:
	-  One view or one view group
- **Question 2**: Which XML attribute do you use in a `LinearLayout` to show views side by side? Choose one:
	- `android:orientation="horizontal"`
- **Question 3**: Which XML attribute do you use to define the width of the `LinearLayout` inside the scrolling view? Choose one:
	-  `android:layout_width="match_parent"`
