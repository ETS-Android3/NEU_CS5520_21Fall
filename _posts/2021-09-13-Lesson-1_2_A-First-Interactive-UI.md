---
layout: post
title: "Lesson 1_2_A First Interactive UI"
date: 2021-09-13
---

Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_2) to my code.

### Output:
<p float="left">
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p1.png" width="300" />
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p2.png" width="300" /> 
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p3.png" width="300" />
</p>

P1: Output overview:  
P2: Click `TOAST` button to pop up a toast message.  
P3:Click `COUNT` button to increase the count in the text view.  


The main purpose of this lesson is to understand View, ViewGroup and layouts. :

- All UI elements are subclasses of the `View` class, they are resources that can have an id. The `findViewById` call use the ID of a `View` as its parameter and return the `View`. 
- Learn how to use layout editor to design and edit the activity page. We can edit by `Design` view or `Code` view.
- There are three ways to set `layout_width` and `layout_height`:
	- The `match_constraint`.
	- The `wrap_content`.
	- A fixed number of `dp`.
- We can use `Ectracting string resources` to avoied hardcoded text.
- Learn how to create an `onClick` event.
- Learn hwo to display a toast message.
